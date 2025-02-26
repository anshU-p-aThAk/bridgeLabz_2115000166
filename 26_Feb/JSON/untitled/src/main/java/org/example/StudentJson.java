package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

public class StudentJson {
    public static void main(String[] args) {
        JSONObject student = new JSONObject();
        student.put("name", "John Doe");
        student.put("age", 20);
        student.put("subjects", new JSONArray().put("Math").put("Science").put("English"));
        System.out.println(student.toString(4));
    }
}
