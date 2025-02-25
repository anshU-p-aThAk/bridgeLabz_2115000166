import java.io.*;
import java.util.Base64;

public class EncryptDecryptCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("data.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("encrypted.csv"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            parts[3] = Base64.getEncoder().encodeToString(parts[3].getBytes());
            bw.write(String.join(",", parts));
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
