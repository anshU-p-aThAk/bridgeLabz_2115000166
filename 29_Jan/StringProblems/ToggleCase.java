import java.util.Scanner;

public class ToggleCase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        scanner.close();

        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] -= 32;
            } else if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] += 32;
            }
        }

        System.out.println("Modified String: " + new String(arr));
    }
}
