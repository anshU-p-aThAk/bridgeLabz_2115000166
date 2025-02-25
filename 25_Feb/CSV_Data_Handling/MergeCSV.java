import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) throws Exception {
        Map<String, String> studentData = new HashMap<>();
        BufferedReader br1 = new BufferedReader(new FileReader("students1.csv"));
        BufferedReader br2 = new BufferedReader(new FileReader("students2.csv"));
        br1.readLine();
        br2.readLine();
        String line;
        while ((line = br1.readLine()) != null) {
            studentData.put(line.split(",")[0], line);
        }
        FileWriter writer = new FileWriter("merged_students.csv");
        while ((line = br2.readLine()) != null) {
            String[] data = line.split(",");
            writer.append(studentData.get(data[0]) + "," + data[1] + "," + data[2] + "\n");
        }
        br1.close();
        br2.close();
        writer.close();
    }
}
