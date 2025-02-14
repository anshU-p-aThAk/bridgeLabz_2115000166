import java.util.Arrays;

public class SelectionSortScores {
    public static void main(String[] args) {
        int[] scores = { 85, 72, 90, 66, 88, 79 };
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }

        System.out.println("Sorted scores");
        for (int score : scores) {
            System.out.print(score + " ");
        }
    }
}
