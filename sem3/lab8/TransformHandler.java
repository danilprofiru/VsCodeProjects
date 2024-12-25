package lab8;

import java.util.List;
import java.util.stream.Collectors;

// Обработчик для трансформации данных (преобразует строки в верхний регистр)
public class TransformHandler implements DataHandler {

    @Override
    @DataProcessor
    public List<String> process(List<String> data) {
        return data.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
