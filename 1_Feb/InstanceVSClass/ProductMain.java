import java.util.*;

class Product {
    private String productName;
    private int price;
    static int totalProducts;

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;

    }

    public void displayProductDetails() {
        System.out.println("Product Name: " + this.productName);
        System.out.println("Product Price: " + this.price);
    }

    public static void displayTotalProducts() {
        System.out.println("Total number of products: " + totalProducts);
    }
}

public class ProductMain {
    public static void main(String[] args) {

        Product product1 = new Product("Product 1", 100);
        Product product2 = new Product("Product 2", 200);

        product1.displayProductDetails();
        product2.displayProductDetails();

        Product.displayTotalProducts();
    }

}