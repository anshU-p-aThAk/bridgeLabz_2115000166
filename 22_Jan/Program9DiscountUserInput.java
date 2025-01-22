
// Program 2: Student Fee and University Discount (user input)
import java.util.Scanner;

public class Program9DiscountUserInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double fee = input.nextDouble();
        double discountPercent = input.nextDouble();
        double discount = (fee * discountPercent) / 100;
        double finalFee = fee - discount;
        System.out.println(discount);
        System.out.println(finalFee);
    }
}
