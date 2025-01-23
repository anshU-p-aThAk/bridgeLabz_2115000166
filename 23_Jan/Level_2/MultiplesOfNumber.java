import java.util.Scanner;

public class MultiplesOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        System.out.println("Multiples of " + num + " below 100 are: ");
        for (int i = 100; i >= 1; i--) {
            if (i % num == 0) {
                System.out.println(i);
            }
        }
    }
}
