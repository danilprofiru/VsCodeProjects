package lab4;

public class ArrayAverage {
    public static void main(String[] args) {
        String[] arr = { "1", "sar", "3", "4", "5" };
        int sum = 0;
        double average = 0.0;

        try {
            for (int i = 0; i < arr.length; i++) {
                sum += Integer.parseInt(arr[i]);
            }
            average = (double) sum / arr.length;
            System.out.println("Среднее арифметическое: " + average);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Неверный формат данных в массиве.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Выход за пределы массива.");
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}