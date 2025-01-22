
// Program 6: Find the side of a square given the perimeter
import java.util.Scanner;

public class Program13SquareSide {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double perimeter = input.nextDouble();
        double side = perimeter / 4;
        System.out.println(side);
    }
}
