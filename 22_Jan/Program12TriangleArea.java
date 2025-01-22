
// Program 5: Area of a triangle (in square inches and square centimeters)
import java.util.Scanner;

public class Program12TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double base = input.nextDouble();
        double height = input.nextDouble();

        double areaInches = 0.5 * base * height;
        double areaCm = areaInches * 6.4516;

        System.out.println(areaInches);
        System.out.println(areaCm);
    }
}
