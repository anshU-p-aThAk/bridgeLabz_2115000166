import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of people: ");
        int numPeople = sc.nextInt();

        for (int i = 0; i < numPeople; i++) {
            System.out.println("\nPerson " + (i + 1) + ":");

            System.out.print("Enter height: ");
            double height = sc.nextDouble();

            System.out.print("Enter weight: ");
            double weight = sc.nextDouble();

            double bmi = weight / (height * height);
            String status;

            if (bmi < 18.5) {
                status = "Underweight";
            } else if (bmi >= 18.5 && bmi < 24.9) {
                status = "Normal weight";
            } else if (bmi >= 25 && bmi < 39.9) {
                status = "Overweight";
            } else {
                status = "Obesity";
            }

            System.out.println("Height: " + height + " m");
            System.out.println("Weight: " + weight + " kg");
            System.out.println("BMI: " + bmi);
            System.out.println("Status: " + status);
        }
    }
}