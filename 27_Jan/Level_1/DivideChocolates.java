import java.util.Scanner;

public class DivideChocolates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("chocolates: ");
        int numberOfChocolates = scanner.nextInt();

        System.out.print("children: ");
        int numberOfChildren = scanner.nextInt();

        int[] result = findRemainderAndQuotient(numberOfChocolates, numberOfChildren);

        System.out.println("Each child will get: " + result[0] + " chocolates");
        System.out.println("Remaining chocolates: " + result[1]);
    }

    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int chocolatesPerChild = number / divisor;
        int remainingChocolates = number % divisor;
        return new int[] { chocolatesPerChild, remainingChocolates };
    }
}
