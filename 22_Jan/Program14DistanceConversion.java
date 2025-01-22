
// Program 7: Convert feet to yards and miles
import java.util.Scanner;

public class Program14DistanceConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double feet = input.nextDouble();

        double yards = feet / 3;
        double miles = feet / 5280;

        System.out.println(yards);
        System.out.println(miles);
    }
}
