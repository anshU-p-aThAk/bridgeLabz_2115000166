import java.io.*;

public class ReadUserInputToFile {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fileWriter = new FileWriter("output.txt");

            System.out.println("Enter text (type 'exit' to stop):");

            String line;
            while (!(line = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                fileWriter.write(line + "\n");
            }

            bufferedReader.close();
            fileWriter.close();
            System.out.println("Input saved to output.txt");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
