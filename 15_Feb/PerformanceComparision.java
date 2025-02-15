import java.io.*;

public class PerformanceComparision {
    public static void main(String[] args) {
        compareStringBuilderVsStringBuffer();
        countWordsUsingFileReader("input.txt");  
        countWordsUsingInputStreamReader("input.txt");
    }

    
    public static void compareStringBuilderVsStringBuffer() {
        int iterations = 1_000_000;
        String text = "Hello";

        
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("StringBuilder Time: " + (endTime - startTime) + "ms");

        
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer Time: " + (endTime - startTime) + "ms");
    }

    
    public static void countWordsUsingFileReader(String fileName) {
        int wordCount = 0;

        try {
            FileReader file = new FileReader(fileName);
            BufferedReader reader = new BufferedReader(file);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); 
                wordCount += words.length;
            }

            reader.close();
            System.out.println("Total words (FileReader): " + wordCount);
        } catch (IOException e) {
            System.out.println("Error reading file!");
            e.printStackTrace();
        }
    }

    
    public static void countWordsUsingInputStreamReader(String fileName) {
        int wordCount = 0;

        try {
            FileInputStream file = new FileInputStream(fileName);
            InputStreamReader reader = new InputStreamReader(file, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\s+"); 
                wordCount += words.length;
            }

            bufferedReader.close();
            System.out.println("Total words (InputStreamReader): " + wordCount);
        } catch (IOException e) {
            System.out.println("Error reading file!");
            e.printStackTrace();
        }
    }
}
