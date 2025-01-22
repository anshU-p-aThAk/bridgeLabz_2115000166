import java.util.Scanner;

class AthleteRounds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int side1 = sc.nextInt();
        int side2 = sc.nextInt();
        int side3 = sc.nextInt();

        int perimeter = side1 + side2 + side3;
        double rounds = 5000.0 / perimeter;
        System.out.println("The total number of rounds the athlete will run is " + rounds);
    }
}
