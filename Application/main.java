package Application;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class main {
    private static List<Product> products = new ArrayList<>();
    private static List<Order> orders = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeProducts();
        
        while (true) {
            displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    manageProducts();
                    break;
                case 2:
                    manageOrders();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n=== Product & Order Management ===");
        System.out.println("1. Manage Products");
        System.out.println("2. Manage Orders");
        System.out.println("3. Exit");
        System.out.print("Enter choice: ");
    }

    private static void manageProducts() {
        while (true) {
            System.out.println("\n=== Products Menu ===");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void manageOrders() {
        while (true) {
            System.out.println("\n=== Orders Menu ===");
            System.out.println("1. Create Order");
            System.out.println("2. View Orders");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    createOrder();
                    break;
                case 2:
                    viewOrders();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        
        products.add(new Product(name, price, quantity));
        System.out.println("Product added successfully!");
    }

    private static void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("\n=== All Products ===");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i));
        }
    }

    private static void createOrder() {
        if (products.isEmpty()) {
            System.out.println("No products available to order.");
            return;
        }
        viewProducts();
        System.out.print("Select product number: ");
        int productIndex = scanner.nextInt() - 1;
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        
        if (productIndex >= 0 && productIndex < products.size()) {
            orders.add(new Order(products.get(productIndex), quantity));
            System.out.println("Order created successfully!");
        }
    }

    private static void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders yet.");
            return;
        }
        System.out.println("\n=== All Orders ===");
        for (int i = 0; i < orders.size(); i++) {
            System.out.println((i + 1) + ". " + orders.get(i));
        }
    }

    private static void initializeProducts() {
        products.add(new Product("Laptop", 999.99, 10));
        products.add(new Product("Mouse", 29.99, 50));
        products.add(new Product("Keyboard", 79.99, 30));
    }
}

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name + " - $" + price + " (Qty: " + quantity + ")";
    }
}

class Order {
    private Product product;
    private int quantity;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return product.toString() + " - Order Quantity: " + quantity;
    }
}