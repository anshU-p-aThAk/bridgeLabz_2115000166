import java.util.Scanner;

public class OddEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num <= 0) {
            System.out.println("Not a natural number.");
            return;
        }

        int[] odd = new int[num / 2 + 1];
        int[] even = new int[num / 2 + 1];
        int oddIndex = 0, evenIndex = 0;

        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                even[evenIndex++] = i;
            } else {
                odd[oddIndex++] = i;
            }
        }

        for (int i = 0; i < oddIndex; i++) {
            System.out.print(odd[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < evenIndex; i++) {
            System.out.print(even[i] + " ");
        }
    }
}
