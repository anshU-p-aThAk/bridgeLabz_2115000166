import java.util.Scanner;

class WeightConversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double weight = sc.nextDouble();

        double weightInKg = weight * 2.2;
        System.out.println("The weight of the person in pound is " + weight + " and in kg is " + weightInKg);
    }
}
