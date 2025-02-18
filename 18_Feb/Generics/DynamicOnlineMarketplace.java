import java.util.ArrayList;
import java.util.List;

abstract class Category {
}

class BookCategory extends Category {
    private String genre;

    public BookCategory(String genre) {
        this.genre = genre;
    }

    public String toString() {
        return "Book - " + genre;
    }
}

class ClothingCategory extends Category {
    private String type;

    public ClothingCategory(String type) {
        this.type = type;
    }

    public String toString() {
        return "Clothing - " + type;
    }
}

class GadgetCategory extends Category {
    private String technology;

    public GadgetCategory(String technology) {
        this.technology = technology;
    }

    public String toString() {
        return "Gadget - " + technology;
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return name + " (" + category + ") - $" + price;
    }
}

class Catalog {
    private List<Product<? extends Category>> products = new ArrayList<>();

    public void addProduct(Product<? extends Category> product) {
        products.add(product);
    }

    public void displayProducts() {
        for (Product<? extends Category> product : products) {
            System.out.println(product);
        }
    }
}

class MarketplaceUtils {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.setPrice(product.getPrice() - (product.getPrice() * percentage / 100));
    }
}

public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        Catalog catalog = new Catalog();

        Product<BookCategory> book = new Product<>("Java Programming", 50.0, new BookCategory("Educational"));
        Product<ClothingCategory> tshirt = new Product<>("T-shirt", 20.0, new ClothingCategory("Men's Wear"));
        Product<GadgetCategory> smartphone = new Product<>("Smartphone", 300.0, new GadgetCategory("Electronics"));

        catalog.addProduct(book);
        catalog.addProduct(tshirt);
        catalog.addProduct(smartphone);

        System.out.println("Catalog before discount:");
        catalog.displayProducts();

        MarketplaceUtils.applyDiscount(book, 10);
        MarketplaceUtils.applyDiscount(tshirt, 15);
        MarketplaceUtils.applyDiscount(smartphone, 5);

        System.out.println("\nCatalog after discount:");
        catalog.displayProducts();
    }
}
