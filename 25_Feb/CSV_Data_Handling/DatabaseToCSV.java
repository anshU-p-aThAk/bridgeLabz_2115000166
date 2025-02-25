import java.sql.*;
import java.io.*;

public class DatabaseToCSV {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
        BufferedWriter bw = new BufferedWriter(new FileWriter("employees.csv"));
        bw.write("Employee ID,Name,Department,Salary");
        bw.newLine();
        while (rs.next()) {
            bw.write(rs.getInt(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getInt(4));
            bw.newLine();
        }
        bw.close();
        conn.close();
    }
}
