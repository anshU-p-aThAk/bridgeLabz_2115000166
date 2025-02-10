import java.util.*;

abstract class FoodItem {
    private final String itemName;
    private final double price;
    private final int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public abstract double calculateTotalPrice();

    public double getDiscount() {
        return 0;
    }

    public void displayDetails() {
        System.out.println("Item: " + itemName + " | Price: ₹" + price + " | Quantity: " + quantity);
    }
}

class VegItem extends FoodItem {
    private static final double DISCOUNT_RATE = 0.10;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double getDiscount() {
        return calculateTotalPrice() * DISCOUNT_RATE;
    }
}

class NonVegItem extends FoodItem {
    private static final double ADDITIONAL_CHARGE = 50;
    private static final double DISCOUNT_RATE = 0.05;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + ADDITIONAL_CHARGE;
    }

    @Override
    public double getDiscount() {
        return calculateTotalPrice() * DISCOUNT_RATE;
    }
}

public class OnlineFoodDelivery {
    public static void main(String[] args) {
        List<FoodItem> order = List.of(
                new VegItem("Paneer Butter Masala", 250, 2),
                new NonVegItem("Chicken Biryani", 300, 1));

        for (FoodItem item : order) {
            item.displayDetails();
            double totalPrice = item.calculateTotalPrice();
            double discount = item.getDiscount();
            double finalPrice = totalPrice - discount;

            System.out.println("Discount: ₹" + discount);
            System.out.println("Final Price after Discount: ₹" + finalPrice);
            System.out.println();
        }
    }
}
