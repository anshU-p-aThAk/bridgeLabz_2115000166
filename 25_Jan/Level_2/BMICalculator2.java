
import java.util.Scanner;

public class BMICalculator2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of people ");
        int numPeople = sc.nextInt();

        double[][] personData = new double[numPeople][3];
        String[] weightStatus = new String[numPeople];

        for (int i = 0; i < numPeople; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");

            System.out.print("Enter height");
            double height = sc.nextDouble();

            System.out.print("Enter weight");
            double weight = sc.nextDouble();

            personData[i][0] = weight;
            personData[i][1] = height;

            double bmi = weight / (height * height);
            personData[i][2] = bmi;

            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (bmi >= 25 && bmi < 39.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obesity";
            }
        }

        System.out.println("\nSummary:");
        for (int i = 0; i < numPeople; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");
            System.out.println("Height: " + personData[i][1] + " m");
            System.out.println("Weight: " + personData[i][0] + " kg");
            System.out.println("BMI: " + personData[i][2]);
            System.out.println("Status: " + weightStatus[i]);
        }
    }
}
