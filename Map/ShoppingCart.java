import java.util.*;

class ShoppingCart {

    private static Map<String, Double> productPrices = new HashMap<>();
    private static Map<String, Double> cartOrder = new LinkedHashMap<>();
    private static Map<String, Double> sortedByPrice = new TreeMap<>(Comparator.comparing(cartOrder::get));

    public static void addProduct(String product, double price) {
        productPrices.put(product, price);
        cartOrder.put(product, price);
        sortedByPrice.put(product, price);
    }

    public static void displayProductsInHashMap() {
        System.out.println("Products in HashMap (No order): ");
        productPrices.forEach((product, price) -> System.out.println(product + ": $" + price));
    }

    public static void displayProductsInLinkedHashMap() {
        System.out.println("Products in LinkedHashMap (Insertion order): ");
        cartOrder.forEach((product, price) -> System.out.println(product + ": $" + price));
    }

    public static void displayProductsSortedByPrice() {
        System.out.println("Products in TreeMap (Sorted by price): ");
        sortedByPrice.forEach((product, price) -> System.out.println(product + ": $" + price));
    }

    public static void main(String[] args) {
        addProduct("Apple", 1.99);
        addProduct("Banana", 0.99);
        addProduct("Orange", 1.49);
        addProduct("Grapes", 2.99);

        displayProductsInHashMap();
        displayProductsInLinkedHashMap();
        displayProductsSortedByPrice();
    }
}
