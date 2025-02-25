import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class SearchCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String name = sc.nextLine();
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data[1].equalsIgnoreCase(name)) {
                System.out.println("Department: " + data[2] + ", Salary: " + data[3]);
                break;
            }
        }
        br.close();
        sc.close();
    }
}
