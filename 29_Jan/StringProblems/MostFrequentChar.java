import java.util.Scanner;

public class MostFrequentChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        scanner.close();

        int[] freq = new int[256];

        for (int i = 0; i < input.length(); i++) {
            freq[input.charAt(i)]++;
        }

        char mostFrequent = ' ';
        int maxCount = 0;

        for (int i = 0; i < input.length(); i++) {
            if (freq[input.charAt(i)] > maxCount) {
                maxCount = freq[input.charAt(i)];
                mostFrequent = input.charAt(i);
            }
        }

        System.out.println("Most Frequent Character: " + mostFrequent);
    }
}
