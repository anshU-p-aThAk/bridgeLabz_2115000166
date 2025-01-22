import java.util.Scanner;

class SampleProgram2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String fromCity = sc.nextLine();
        String viaCity = sc.nextLine();
        String toCity = sc.nextLine();
        int fromToVia = sc.nextInt();
        int viaToFinalCity = sc.nextInt();
        int timeTaken = sc.nextInt();

        System.out.println("The distance from " + fromCity + " to " + viaCity + " is " + fromToVia + " miles, " +
                "and the distance from " + viaCity + " to " + toCity + " is " + viaToFinalCity + " miles. " +
                "The total distance is " + (fromToVia + viaToFinalCity) + " miles. " +
                "The time taken is " + timeTaken + " hours.");
    }
}
