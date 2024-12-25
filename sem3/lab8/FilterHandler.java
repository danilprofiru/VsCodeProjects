package lab8;

import java.util.List;
import java.util.stream.Collectors;

// Обработчик для фильтрации данных (оставляет строки длиной > 3)
public class FilterHandler implements DataHandler {

    @Override
    @DataProcessor
    public List<String> process(List<String> data) {
        return data.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.toList());
    }
}
