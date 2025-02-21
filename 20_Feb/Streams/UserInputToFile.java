import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = new FileWriter("userinfo.txt");
        System.out.print("Name: ");
        fw.write("Name: " + br.readLine() + "\n");
        System.out.print("Age: ");
        fw.write("Age: " + br.readLine() + "\n");
        System.out.print("Favorite Language: ");
        fw.write("Language: " + br.readLine() + "\n");
        fw.close();
    }
}
