
// Program 1: Convert distance in kilometers to miles
import java.util.Scanner;

public class Program8KmToMilesUserInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double km = input.nextDouble();
        double miles = km * 1.6;
        System.out.println(miles);
    }
}
