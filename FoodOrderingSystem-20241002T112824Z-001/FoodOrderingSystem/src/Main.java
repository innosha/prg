import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        // Add some menu items
        menu.addItem(new MenuItem("Burger", 5.99, "Food", 10));
        menu.addItem(new MenuItem("Pizza", 8.99, "Food", 8));
        menu.addItem(new MenuItem("Soda", 1.99, "Beverage", 15));
        menu.addItem(new MenuItem("Salad", 4.99, "Food", 5));

        Order order = new Order();
        Scanner scanner = new Scanner(System.in);

        // Main interaction loop
        while (true) {
            System.out.println("\nMenu:");
            for (int i = 0; i < menu.getItems().size(); i++) {
                System.out.println(i + ": " + menu.getItems().get(i));
            }

            System.out.println("Options:");
            System.out.println("1. Add item to order");
            System.out.println("2. Remove item from order");
            System.out.println("3. View current order");
            System.out.println("4. Finalize order");
            System.out.println("5. Filter by category");
            System.out.println("6. Sort menu by price");
            System.out.println("7. Sort menu by popularity");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter item index to add to order: ");
                    int index = scanner.nextInt();
                    System.out.println("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    order.addItem(menu.getItems().get(index), quantity);
                    break;
                case 2:
                    System.out.println("Enter item name to remove: ");
                    scanner.nextLine(); // Clear the buffer
                    String itemName = scanner.nextLine();
                    if (order.removeItem(itemName)) {
                        System.out.println(itemName + " removed from order.");
                    } else {
                        System.out.println("Item not found in order.");
                    }
                    break;
                case 3:
                    System.out.println("Your order:");
                    for (OrderItem item : order.getItems()) {
                        System.out.println(item);
                    }
                    System.out.println("Total: $" + order.getTotalCost());
                    break;
                case 4:
                    System.out.println("Finalizing order...");
                    Payment payment = new Payment();
                    payment.processPayment(order.getTotalCost());
                    return; // Exit the program after payment
                case 5:
                    System.out.println("Enter category to filter by: ");
                    scanner.nextLine(); // Clear the buffer
                    String category = scanner.nextLine();
                    List<MenuItem> filtered = menu.filterByCategory(category);
                    System.out.println("Filtered menu:");
                    for (MenuItem item : filtered) {
                        System.out.println(item);
                    }
                    break;
                case 6:
                    menu.sortByPrice();
                    System.out.println("Menu sorted by price.");
                    break;
                case 7:
                    menu.sortByPopularity();
                    System.out.println("Menu sorted by popularity.");
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return; // Exit the program
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
