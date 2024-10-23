package lab4;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourcePath = "source.txt";
        String destPath = "destination.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(destPath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Копирование завершено.");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: Файл не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка: Проблема с чтением/записью файла.");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}