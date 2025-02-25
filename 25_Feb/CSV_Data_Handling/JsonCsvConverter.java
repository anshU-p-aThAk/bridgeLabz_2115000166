import org.json.*;
import java.io.*;
import java.util.*;

public class JsonCsvConverter {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("students.json"));
        String jsonText = br.readLine();
        JSONArray jsonArray = new JSONArray(jsonText);
        BufferedWriter bw = new BufferedWriter(new FileWriter("students.csv"));
        bw.write("ID,Name,Age");
        bw.newLine();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            bw.write(obj.getInt("ID") + "," + obj.getString("Name") + "," + obj.getInt("Age"));
            bw.newLine();
        }
        bw.close();
    }
}
