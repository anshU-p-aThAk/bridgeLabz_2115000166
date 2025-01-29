import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        System.out.println("Enter the character to remove:");
        char removeChar = scanner.next().charAt(0);
        scanner.close();

        String modifiedString = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != removeChar) {
                modifiedString += input.charAt(i);
            }
        }

        System.out.println("Modified String: " + modifiedString);
    }
}
