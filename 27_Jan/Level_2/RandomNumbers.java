import java.util.*;

public class RandomNumbers {
    public static int[] generate4DigitRandomArray(int size) {
        Random rand = new Random();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = 1000 + rand.nextInt(9000);
        }
        return numbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        double avg = Arrays.stream(numbers).average().getAsDouble();
        int min = Arrays.stream(numbers).min().getAsInt();
        int max = Arrays.stream(numbers).max().getAsInt();
        return new double[] { avg, min, max };
    }

    public static void main(String[] args) {
        int[] numbers = generate4DigitRandomArray(5);
        double[] stats = findAverageMinMax(numbers);
        System.out.println("Average: " + stats[0] + ", Min: " + stats[1] + ", Max: " + stats[2]);
    }
}
