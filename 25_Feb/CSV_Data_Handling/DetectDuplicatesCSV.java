import java.io.*;
import java.util.*;

public class DetectDuplicatesCSV {
    public static void main(String[] args) throws Exception {
        Set<String> ids = new HashSet<>();
        BufferedReader br = new BufferedReader(new FileReader("data.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            String id = line.split(",")[0];
            if (!ids.add(id)) {
                System.out.println("Duplicate: " + line);
            }
        }
        br.close();
    }
}
