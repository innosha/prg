import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Menu {
    private List<MenuItem> items;

    public Menu() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public List<MenuItem> filterByCategory(String category) {
        List<MenuItem> filtered = new ArrayList<>();
        for (MenuItem item : items) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                filtered.add(item);
            }
        }
        return filtered;
    }

    public void sortByPrice() {
        Collections.sort(items, Comparator.comparingDouble(MenuItem::getPrice));
    }

    public void sortByPopularity() {
        Collections.sort(items, Comparator.comparingInt(MenuItem::getPopularity).reversed());
    }
}
