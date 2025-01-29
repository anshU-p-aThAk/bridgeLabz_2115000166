import java.util.Scanner;

public class CheckAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String 1:");
        String str1 = scanner.nextLine().replaceAll("\\s", "").toLowerCase();
        System.out.println("Enter String 2:");
        String str2 = scanner.nextLine().replaceAll("\\s", "").toLowerCase();
        scanner.close();

        if (str1.length() != str2.length()) {
            System.out.println("The strings are not anagrams.");
            return;
        }

        int[] freq = new int[256];

        for (int i = 0; i < str1.length(); i++) {
            freq[str1.charAt(i)]++;
            freq[str2.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (freq[i] != 0) {
                System.out.println("The strings are not anagrams.");
                return;
            }
        }

        System.out.println("The strings are anagrams.");
    }
}
