import java.util.Random;
import java.util.Scanner;

public class StudentScores {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();

        int[][] scores = generateScores(numStudents);
        double[][] results = calculateResults(scores);
        displayScoreCard(results, scores);
    }

    public static int[][] generateScores(int numStudents) {
        Random rand = new Random();
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = rand.nextInt(100) + 1;
            }
        }
        return scores;
    }

    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][4];
        for (int i = 0; i < scores.length; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                total += scores[i][j];
            }
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;
            results[i][0] = total;
            results[i][1] = average;
            results[i][2] = Math.round(average * 100.0) / 100.0;
            results[i][3] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    public static void displayScoreCard(double[][] results, int[][] scores) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");
        for (int i = 0; i < scores.length; i++) {
            System.out.print("Student " + (i + 1) + "\t");
            for (int j = 0; j < 3; j++) {
                System.out.print(scores[i][j] + "\t");
            }
            System.out.print(results[i][0] + "\t");
            System.out.print(results[i][1] + "\t");
            System.out.println(results[i][3]);
        }
    }
}
