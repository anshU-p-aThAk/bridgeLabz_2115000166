import java.util.*;

public class BMI {
    public static double calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100;
        return weight / (heightM * heightM);
    }

    public static String getBMIStatus(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        if (bmi < 24.9)
            return "Normal weight";
        if (bmi < 29.9)
            return "Overweight";
        return "Obese";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][3];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            data[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            data[i][1] = sc.nextDouble();
            data[i][2] = calculateBMI(data[i][0], data[i][1]);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) + " BMI: " + data[i][2] + ", Status: " + getBMIStatus(data[i][2]));
        }
    }
}
