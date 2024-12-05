package lab7;

public class Task2 {
    public static void main(String[] args) {
        int[][] matrix = {
                { 3, 5, 2 },
                { 7, 1, 9 },
                { 4, 8, 6 }
        };

        MaxElementTask[] tasks = new MaxElementTask[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            tasks[i] = new MaxElementTask(matrix[i]);
            tasks[i].start();
        }

        int globalMax = Integer.MIN_VALUE;

        for (MaxElementTask task : tasks) {
            try {
                task.join();
                if (task.getMax() > globalMax) {
                    globalMax = task.getMax();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Максимальный элемент в матрице: " + globalMax);
    }
}
