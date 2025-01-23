import java.util.Scanner;

public class YoungestTallestFriend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age of Amar: ");
        int amarAge = sc.nextInt();
        System.out.print("Enter height of Amar: ");
        double amarHeight = sc.nextDouble();

        System.out.print("Enter age of Akbar: ");
        int akbarAge = sc.nextInt();
        System.out.print("Enter height of Akbar: ");
        double akbarHeight = sc.nextDouble();

        System.out.print("Enter age of Anthony: ");
        int anthonyAge = sc.nextInt();
        System.out.print("Enter height of Anthony: ");
        double anthonyHeight = sc.nextDouble();

        int youngestAge = Math.min(amarAge, Math.min(akbarAge, anthonyAge));
        double tallestHeight = Math.max(amarHeight, Math.max(akbarHeight, anthonyHeight));

        System.out.println("Youngest friend is: ");
        if (youngestAge == amarAge) {
            System.out.println("Amar");
        } else if (youngestAge == akbarAge) {
            System.out.println("Akbar");
        } else {
            System.out.println("Anthony");
        }

        System.out.println("Tallest friend is: ");
        if (tallestHeight == amarHeight) {
            System.out.println("Amar");
        } else if (tallestHeight == akbarHeight) {
            System.out.println("Akbar");
        } else {
            System.out.println("Anthony");
        }
    }
}
