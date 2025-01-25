import java.util.Scanner;

public class MultiplicationTables6to9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] result = new int[40];
        int index = 0;

        for (int i = 6; i <= 9; i++) {
            for (int j = 1; j <= 10; j++) {
                result[index] = i * j;
                System.out.println(i + " * " + j + " = " + result[index]);
                index++;
            }
        }
    }
}
