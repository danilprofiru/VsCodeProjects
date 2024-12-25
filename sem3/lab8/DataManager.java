package lab8;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class DataManager {
    private final List<Object> processors = new ArrayList<>();
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);
    private List<String> data;

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
    }

    public void loadData(String source) throws IOException {
        data = Files.lines(Path.of(source))
                .collect(Collectors.toList());
        System.out.println("Data loaded: " + data);
    }

    public void processData() {
        for (Object processor : processors) {
            for (Method method : processor.getClass().getMethods()) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    executorService.submit(() -> {
                        try {
                            @SuppressWarnings("unchecked")
                            List<String> result = (List<String>) method.invoke(processor, data);
                            synchronized (this) {
                                data = result;
                                System.out.println("Processed data: " + data);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        }
        executorService.shutdown();
    }

    public void saveData(String destination) throws IOException {
        Files.write(Path.of(destination), data);
        System.out.println("Data saved to " + destination);
    }

    public ExecutorService getExecutorService() {
        return executorService;
    }
}