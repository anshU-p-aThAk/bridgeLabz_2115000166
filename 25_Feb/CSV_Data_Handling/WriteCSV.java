import java.io.FileWriter;

public class WriteCSV {
    public static void main(String[] args) throws Exception {
        FileWriter writer = new FileWriter("employees.csv");
        writer.append("ID,Name,Department,Salary\n");
        writer.append("1,John,IT,60000\n");
        writer.append("2,Alice,HR,55000\n");
        writer.append("3,Bob,Finance,70000\n");
        writer.append("4,David,IT,65000\n");
        writer.append("5,Susan,Marketing,62000\n");
        writer.close();
    }
}
