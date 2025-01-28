import java.util.Scanner;

public class SmallestAndLargest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        System.out.print("Enter third number: ");
        int num3 = scanner.nextInt();

        int[] result = findSmallestAndLargest(num1, num2, num3);

        System.out.println("The largest number is: " + result[1]);
        System.out.println("The smallest number is: " + result[0]);
    }

    public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = number1;
        int largest = number1;

        if (number2 > largest)
            largest = number2;
        if (number3 > largest)
            largest = number3;

        if (number2 < smallest)
            smallest = number2;
        if (number3 < smallest)
            smallest = number3;

        return new int[] { smallest, largest };
    }
}
