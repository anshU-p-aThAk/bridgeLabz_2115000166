import java.io.*;

public class UpperToLower {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        int c;
        while ((c = br.read()) != -1) {
            bw.write(Character.toLowerCase(c));
        }
        br.close();
        bw.close();
    }
}
