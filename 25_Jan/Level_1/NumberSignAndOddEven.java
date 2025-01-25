import java.util.Scanner;

public class NumberSignAndOddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[5];

        for (int i = 0; i < num.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            num[i] = sc.nextInt();

            if (num[i] > 0) {
                if (num[i] % 2 == 0) {
                    System.out.println("Positive Even");
                } else {
                    System.out.println("Positive Odd");
                }
            } else if (num[i] < 0) {
                System.out.println("Negative");
            } else {
                System.out.println("Zero");
            }
        }

        if (num[0] == num[num.length - 1]) {
            System.out.println("Equal");
        } else if (num[0] > num[num.length - 1]) {
            System.out.println("First greater");
        } else {
            System.out.println("Last greater");
        }
    }
}
