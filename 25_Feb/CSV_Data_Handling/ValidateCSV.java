import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("users.csv"));
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Pattern phonePattern = Pattern.compile("\\d{10}");
        String line;
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (!emailPattern.matcher(data[1]).matches() || !phonePattern.matcher(data[2]).matches()) {
                System.out.println("Invalid row: " + line);
            }
        }
        br.close();
    }
}
