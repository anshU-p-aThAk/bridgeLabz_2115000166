
// Program 9: Maximum number of handshakes among N students
import java.util.Scanner;

public class Program16Handshakes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int handshakes = (n * (n - 1)) / 2;
        System.out.println(handshakes);
    }
}
