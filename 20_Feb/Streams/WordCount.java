import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("textfile.txt"));
        Map<String, Integer> wordMap = new HashMap<>();
        String line;
        while ((line = br.readLine()) != null) {
            for (String word : line.toLowerCase().split("\\W+")) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }
        br.close();

        wordMap.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(5)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
