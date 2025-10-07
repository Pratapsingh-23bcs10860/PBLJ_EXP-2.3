import java.util.*;
import java.util.stream.*;
import java.util.Map.Entry;

class Product {
    String name;
    double price;
    String category;

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public String toString() {
        return name + " (₹" + price + ")";
    }
}

public class ProductStreamOperations {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 65000, "Electronics"),
            new Product("Smartphone", 45000, "Electronics"),
            new Product("Refrigerator", 30000, "Appliances"),
            new Product("Washing Machine", 25000, "Appliances"),
            new Product("Sofa", 15000, "Furniture"),
            new Product("Table", 8000, "Furniture")
        );

        // Group products by category
        System.out.println("Products Grouped by Category:");
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(p -> p.category));
        grouped.forEach((cat, list) -> System.out.println(cat + " : " + list));

        // Find most expensive product in each category
        System.out.println("\nMost Expensive Product in Each Category:");
        Map<String, Optional<Product>> maxPriceByCat = products.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
                ));
        maxPriceByCat.forEach((cat, prod) ->
                System.out.println(cat + " : " + prod.get().name + " (₹" + prod.get().price + ")"));

        // Calculate average price
        double avgPrice = products.stream()
                .collect(Collectors.averagingDouble(p -> p.price));
        System.out.println("\nAverage Price of All Products: ₹" + avgPrice);
    }
}
