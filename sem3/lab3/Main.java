package lab3;

import java.util.Arrays;;

public class Main {
    public static void main(String[] args) {

        HashTable<String, Order> ordersTable = new HashTable<>(10);
        System.out.println("Table " + ordersTable);

        Order order1 = new Order("2024-10-01", Arrays.asList("Laptop", "Mouse"), "Pending");
        Order order2 = new Order("2024-10-02", Arrays.asList("Phone", "Charger"), "Shipped");

        ordersTable.put("ORD123", order1);
        ordersTable.put("ORD124", order2);

        System.out.println("Order ORD123: " + ordersTable.get("ORD123"));

        ordersTable.remove("ORD124");
        System.out.println("Order ORD124 after deletion: " + ordersTable.get("ORD124"));

        System.out.println("Table size: " + ordersTable.size());
    }
}
