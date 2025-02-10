import java.util.*;

interface Taxable {
    double calculateTax();

    String getTaxDetails();
}

abstract class Product {
    private final int productId;
    private final String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public abstract double calculateDiscount();

    public abstract void displayFinalPrice();

    public void displayDetails() {
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: ₹" + price);
    }
}

class Electronics extends Product implements Taxable {
    private static final double DISCOUNT_RATE = 0.10;
    private static final double TAX_RATE = 0.18;

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * DISCOUNT_RATE;
    }

    @Override
    public double calculateTax() {
        return getPrice() * TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: " + (TAX_RATE * 100) + "%";
    }

    @Override
    public void displayFinalPrice() {
        double finalPrice = getPrice() + calculateTax() - calculateDiscount();
        displayDetails();
        System.out.println(getTaxDetails());
        System.out.println("Tax: " + calculateTax());
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Final Price: " + finalPrice);
        System.out.println();
    }
}

class Clothing extends Product implements Taxable {
    private static final double DISCOUNT_RATE = 0.15;
    private static final double TAX_RATE = 0.05;

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * DISCOUNT_RATE;
    }

    @Override
    public double calculateTax() {
        return getPrice() * TAX_RATE;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: " + (TAX_RATE * 100) + "%";
    }

    @Override
    public void displayFinalPrice() {
        double finalPrice = getPrice() + calculateTax() - calculateDiscount();
        displayDetails();
        System.out.println(getTaxDetails());
        System.out.println("Tax: " + calculateTax());
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Final Price: " + finalPrice);
        System.out.println();
    }
}

class Groceries extends Product {
    private static final double DISCOUNT_RATE = 0.05;

    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * DISCOUNT_RATE;
    }

    @Override
    public void displayFinalPrice() {
        double finalPrice = getPrice() - calculateDiscount();
        displayDetails();
        System.out.println("Discount: " + calculateDiscount());
        System.out.println("Final Price: " + finalPrice);
        System.out.println();
    }
}

public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Electronics(101, "Laptop", 50000));
        products.add(new Clothing(102, "T-Shirt", 1000));
        products.add(new Groceries(103, "Rice", 500));

        for (Product product : products) {
            product.displayFinalPrice();
        }
    }
}
