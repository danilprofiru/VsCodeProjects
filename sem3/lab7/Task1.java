package lab7;

public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1; // Заполнение массива числами от 1 до 100
        }

        ArraySumTask task1 = new ArraySumTask(array, 0, array.length / 2);
        ArraySumTask task2 = new ArraySumTask(array, array.length / 2, array.length);

        task1.start();
        task2.start();

        try {
            task1.join();
            task2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalSum = task1.getSum() + task2.getSum();
        System.out.println("Сумма элементов массива: " + totalSum);
    }
}