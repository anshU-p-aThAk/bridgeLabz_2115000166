
// Program 4: Basic calculator (addition, subtraction, multiplication, and division)
import java.util.Scanner;

public class Program11BasicCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double num1 = input.nextDouble();
        double num2 = input.nextDouble();

        double addition = num1 + num2;
        double subtraction = num1 - num2;
        double multiplication = num1 * num2;
        double division = num1 / num2;

        System.out.println(addition);
        System.out.println(subtraction);
        System.out.println(multiplication);
        System.out.println(division);
    }
}
