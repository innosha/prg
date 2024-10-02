public class MenuItem {
    private String name;
    private double price;
    private String category;
    private int popularity;

    // Constructor
    public MenuItem(String name, double price, String category, int popularity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.popularity = popularity;
    }

    // Getters and Setters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getPopularity() { return popularity; }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}
