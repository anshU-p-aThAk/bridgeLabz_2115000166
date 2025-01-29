import java.util.Scanner;

public class FibonacciSequenceGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, first = 0, second = 1, next;

        System.out.print("Enter the number of terms you want to generate: ");
        n = scanner.nextInt();

        System.out.print("The first " + n + " terms of the Fibonacci sequence are: ");
        generateFibonacciSequence(n, first, second);
        scanner.close();
    }

    public static void generateFibonacciSequence(int n, int first, int second) {
        int next;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                System.out.print(first + " ");
                continue;
            }
            if (i == 2) {
                System.out.print(second + " ");
                continue;
            }
            next = first + second;
            first = second;
            second = next;
            System.out.print(next + " ");
        }
    }
}