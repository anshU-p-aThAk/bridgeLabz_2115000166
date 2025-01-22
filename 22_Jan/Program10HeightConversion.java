
// Program 3: Convert height in centimeters to feet and inches
import java.util.Scanner;

public class Program10HeightConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double heightCm = input.nextDouble();
        int feet = (int) (heightCm / 2.54) / 12;
        int inches = (int) (heightCm / 2.54) % 12;
        System.out.println(feet);
        System.out.println(inches);
    }
}
