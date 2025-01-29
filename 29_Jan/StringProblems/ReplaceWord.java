import java.util.Scanner;

public class ReplaceWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence = scanner.nextLine();
        System.out.println("Enter the word to replace:");
        String target = scanner.nextLine();
        System.out.println("Enter the replacement word:");
        String replacement = scanner.nextLine();
        scanner.close();

        String modifiedSentence = "";
        String word = "";

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == ' ' || i == sentence.length() - 1) {
                if (i == sentence.length() - 1)
                    word += ch;
                if (word.equals(target))
                    modifiedSentence += replacement + " ";
                else
                    modifiedSentence += word + " ";
                word = "";
            } else {
                word += ch;
            }
        }

        System.out.println("Modified Sentence: " + modifiedSentence.trim());
    }
}
