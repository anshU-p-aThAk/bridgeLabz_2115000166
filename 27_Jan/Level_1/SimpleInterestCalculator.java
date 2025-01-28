import java.util.Scanner;

public class SimpleInterestCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Principal:");
        double principal = sc.nextDouble();
        System.out.println("Enter Rate of Interest:");
        double rate = sc.nextDouble();
        System.out.println("Enter Time (in years):");
        double time = sc.nextDouble();
        double simpleInterest = (principal * rate * time) / 100;
        System.out.println("The Simple Interest is " + simpleInterest + " for Principal " + principal
                + ", Rate of Interest " + rate + "%, and Time " + time + " years.");
        sc.close();
    }
}
