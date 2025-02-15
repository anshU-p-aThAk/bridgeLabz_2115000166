import java.io.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String targetWord = "hello";
        int count = 0;

        FileReader fr = new FileReader("sample.txt");
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.equalsIgnoreCase(targetWord)) {
                    count++;
                }
            }
        }

        br.close();
        fr.close();

        System.out.println("The word '" + targetWord + "' appears " + count + " times in the file.");
    }
}
