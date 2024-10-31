package lab4;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        File sourcePath = new File("C:\\Users\\danil\\VsCodeProjects\\sem3\\lab4\\source.txt");
        File destPath = new File("C:\\Users\\danil\\VsCodeProjects\\sem3\\lab4\\destination.txt");
        ErrorLogger errorLogger = new ErrorLogger("C:\\Users\\danil\\VsCodeProjects\\sem3\\lab4\\error_log.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destPath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.close();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Копирование завершено.");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден.");
            errorLogger.logError("Ошибка: Файл не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка: Проблема с чтением/записью файла.");
            errorLogger.logError("Ошибка: Проблема с чтением/записью файла.");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
            errorLogger.logError("Произошла ошибка: " + e.getMessage());
        }
    }
}