import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "programming";
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char ch : str.toCharArray()) {
            if (!seen.contains(ch)) {
                sb.append(ch);
                seen.add(ch);
            }
        }

        String result = sb.toString();
        System.out.println(result);
    }
}
