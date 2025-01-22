
// Program 8: Total purchase price (user input)
import java.util.Scanner;

public class Program15PurchasePrice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double unitPrice = input.nextDouble();
        int quantity = input.nextInt();

        double totalPrice = unitPrice * quantity;
        System.out.println(totalPrice);
    }
}
