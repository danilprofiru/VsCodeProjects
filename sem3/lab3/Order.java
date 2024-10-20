package lab3;

import java.util.List;

public class Order<K, V> {
    private String orderDate;
    private List<String> items;
    private String status;

    public Order(String orderDate, List<String> items, String status) {
        this.orderDate = orderDate;
        this.items = items;
        this.status = status;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public List<String> getItems() {
        return items;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order Date: " + orderDate + ", Items: " + items + ", Status: " + status;
    }
}
