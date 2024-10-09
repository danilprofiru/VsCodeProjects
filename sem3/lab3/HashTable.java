package lab3;

import java.util.LinkedList;

public class HashTable {
    private class Entry {
        private String key;
        private Order value;

        public Entry(String key, Order value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public Order getValue() {
            return value;
        }

        public void setValue(Order value) {
            this.value = value;
        }
    }

    private LinkedList<Entry>[] table;
    private int size;

    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        size = 0;
    }

    private int hash(String key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    public void put(String key, Order value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry(key, value));
        size++;
    }

    public Order get(String key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(String key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    table[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    public void changeOrderStatus(String key, String newStatus) {
        Order order = get(key);
        if (order != null) {
            order.setStatus(newStatus);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
