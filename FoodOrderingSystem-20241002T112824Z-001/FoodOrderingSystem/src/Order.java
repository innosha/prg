import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items;
    private OrderItem lastRemovedItem;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem menuItem, int quantity) {
        items.add(new OrderItem(menuItem, quantity));
    }

    public boolean removeItem(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).toString().contains(itemName)) {
                lastRemovedItem = items.remove(i);
                return true; // Item found and removed
            }
        }
        return false; // Item not found
    }

    public void undoRemove() {
        if (lastRemovedItem != null) {
            items.add(lastRemovedItem);
            lastRemovedItem = null; // Clear last removed
        }
    }

    public double getTotalCost() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public List<OrderItem> getItems() {
        return items;
    }
}
