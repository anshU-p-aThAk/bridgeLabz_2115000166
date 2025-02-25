import java.io.*;
import java.util.*;

public class UpdateCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        List<String[]> records = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data[2].equalsIgnoreCase("IT")) {
                data[3] = String.valueOf((int) (Integer.parseInt(data[3]) * 1.1));
            }
            records.add(data);
        }
        br.close();
        FileWriter writer = new FileWriter("updated_employees.csv");
        for (String[] record : records) {
            writer.append(String.join(",", record)).append("\n");
        }
        writer.close();
    }
}
