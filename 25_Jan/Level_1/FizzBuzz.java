import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        String[] result = new String[num];

        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result[i - 1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                result[i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                result[i - 1] = "Buzz";
            } else {
                result[i - 1] = Integer.toString(i);
            }
        }

        for (int i = 0; i < num; i++) {
            System.out.println(result[i]);
        }
    }
}
