import java.util.Scanner;

public class BasicCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1, num2, result;
        char operator;

        System.out.println("Welcome to the Basic Calculator!");
        System.out.print("Enter the first number: ");
        num1 = scanner.nextDouble();
        System.out.print("Enter an operator (+, -, *, /): ");
        operator = scanner.next().charAt(0);
        System.out.print("Enter the second number: ");
        num2 = scanner.nextDouble();

        switch (operator) {
            case '+':
                result = num1 + num2;
                System.out.println("The sum of " + num1 + " and " + num2 + " is " + result + ".");
                break;
            case '-':
                result = num1 - num2;
                System.out.println("The difference between " + num1 + " and " + num2 + " is " + result + ".");
                break;
            case '*':
                result = num1 * num2;
                System.out.println("The product of " + num1 + " and " + num2 + " is " + result + ".");
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero.");
                } else {
                    result = num1 / num2;
                    System.out.println("The quotient of " + num1 + " and " + num2 + " is " + result + ".");
                }
                break;
            default:
                System.out.println("Invalid operator.");
        }

        scanner.close();
    }
}