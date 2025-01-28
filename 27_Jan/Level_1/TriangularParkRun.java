import java.util.Scanner;

public class TriangularParkRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of side a");
        double a = scanner.nextDouble();
        System.out.print("Enter the length of side b");
        double b = scanner.nextDouble();
        System.out.print("Enter the length of side c");
        double c = scanner.nextDouble();

        double perimeter = a + b + c;
        double targetDistance = 5000;
        double rounds = targetDistance / perimeter;

        System.out.println("Rounds: " + Math.ceil(rounds));
    }
}
