package lab7;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Warehouse {
    private int currentWeight = 0;
    private final int maxWeight = 150;
    private final Lock lock = new ReentrantLock();
    private final Condition fullLoad = lock.newCondition();

    public void addItem(int weight) throws InterruptedException {
        lock.lock();
        try {
            while (currentWeight + weight > maxWeight) {
                fullLoad.await(); // Ждём разгрузки
            }
            currentWeight += weight;
            System.out.println("Добавлено " + weight + " кг. Текущий вес: " + currentWeight + " кг.");
            if (currentWeight == maxWeight) {
                unload();
            }
        } finally {
            lock.unlock();
        }
    }

    private void unload() throws InterruptedException {
        System.out.println("Склад полон! Разгрузка...");
        Thread.sleep(1000);
        currentWeight = 0;
        fullLoad.signalAll(); // Уведомляем всех грузчиков
    }
}

class Worker extends Thread {
    private Warehouse warehouse;
    private int[] items;

    public Worker(Warehouse warehouse, int[] items) {
        this.warehouse = warehouse;
        this.items = items;
    }

    @Override
    public void run() {
        for (int weight : items) {
            try {
                warehouse.addItem(weight);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
