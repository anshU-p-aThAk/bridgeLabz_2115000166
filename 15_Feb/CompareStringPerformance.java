
import java.util.Scanner;

public class CompareStringPerformance {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        String[] originalString = new String[size];

        for (int i = 0; i < size; i++) {
            originalString[i] = input.next();
        }

        calculateStringBuilderPerformance(originalString);
        calculateStringBufferPerformance(originalString);
    }

    public static void calculateStringBuilderPerformance(String[] originalString) {
        long startTime = System.nanoTime();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < originalString.length; i++) {
            str.append(originalString[i]);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("StringBuilder Performance: " + duration + " nanoseconds");
    }

    public static void calculateStringBufferPerformance(String[] originalString) {
        long startTime = System.nanoTime();
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < originalString.length; i++) {
            str.append(originalString[i]);
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("StringBuffer Performance: " + duration + " nanoseconds");
    }
}
