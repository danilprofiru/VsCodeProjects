package lab4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ErrorLogger {
    private File logFile;

    public ErrorLogger(String filePath) {
        logFile = new File(filePath);
    }

    public void logError(String errorMessage) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) { // append mode
            writer.write(errorMessage);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл лога ошибок: " + e.getMessage());
        }
    }
}