package lab6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesTracker {
    private List<String> soldItems;

    public SalesTracker() {
        soldItems = new ArrayList<>();
    }

    public void addItem(String item) {
        soldItems.add(item);
    }

    public void displayItems() {
        System.out.println("Список проданных товаров:");
        for (String item : soldItems) {
            System.out.println(item);
        }
    }

    public double calculateTotal(Map<String, Double> priceList) {
        double total = 0;
        for (String item : soldItems) {
            total += priceList.getOrDefault(item, 0.0);
        }
        return total;
    }

    public String findMostPopularItem() {
        Map<String, Integer> itemCount = new HashMap<>();

        for (String item : soldItems) {
            itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
        }

        String mostPopular = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : itemCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostPopular = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostPopular;
    }

    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();

        tracker.addItem("Apple");
        tracker.addItem("Banana");
        tracker.addItem("Orange");
        tracker.addItem("Apple");
        tracker.addItem("Banana");
        tracker.addItem("Apple");

        tracker.displayItems();

        Map<String, Double> priceList = new HashMap<>();
        priceList.put("Apple", 1.0);
        priceList.put("Banana", 0.5);
        priceList.put("Orange", 0.8);

        System.out.println("Общая сумма продаж: $" + tracker.calculateTotal(priceList));

        System.out.println("Самый популярный товар: " + tracker.findMostPopularItem());
    }
}
