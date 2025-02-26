package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class JsonReport {
    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:yourdb://localhost:3306/yourdatabase", "username", "password");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name, age FROM users");
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode array = mapper.createArrayNode();
        while(rs.next()){
            ObjectNode node = mapper.createObjectNode();
            node.put("id", rs.getInt("id"));
            node.put("name", rs.getString("name"));
            node.put("age", rs.getInt("age"));
            array.add(node);
        }
        System.out.println(mapper.writeValueAsString(array));
        rs.close();
        stmt.close();
        conn.close();
    }
}
