import java.util.Scanner;

public class TrigonometricFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the angle in degrees: ");
        double angle = scanner.nextDouble();

        double[] trigonometricValues = calculateTrigonometricFunctions(angle);

        System.out.println("Sine of the angle: " + trigonometricValues[0]);
        System.out.println("Cosine of the angle: " + trigonometricValues[1]);
        System.out.println("Tangent of the angle: " + trigonometricValues[2]);
    }

    public static double[] calculateTrigonometricFunctions(double angle) {

        double radians = Math.toRadians(angle);
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);

        return new double[] { sine, cosine, tangent };
    }
}