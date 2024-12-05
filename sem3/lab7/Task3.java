package lab7;

public class Task3 {
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();

        int[] items1 = { 30, 40, 50, 30 };
        int[] items2 = { 20, 30, 40, 50 };
        int[] items3 = { 50, 50, 20, 30 };

        Worker worker1 = new Worker(warehouse, items1);
        Worker worker2 = new Worker(warehouse, items2);
        Worker worker3 = new Worker(warehouse, items3);

        worker1.start();
        worker2.start();
        worker3.start();
    }
}