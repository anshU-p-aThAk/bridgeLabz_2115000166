import java.util.*;

public class NaturalNumbers {
    public static int sumRecursive(int n) {
        if (n <= 0)
            return 0;
        return n + sumRecursive(n - 1);
    }

    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Not a natural number");
            return;
        }

        int sumRec = sumRecursive(n);
        int sumFor = sumFormula(n);

        System.out.println("Sum using recursion: " + sumRec);
        System.out.println("Sum using formula: " + sumFor);
        System.out.println(sumRec == sumFor ? "Both are correct!" : "There is a mismatch.");
    }
}
