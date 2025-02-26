package org.example;

import org.json.JSONObject;

public class Merge{
    public static void main(String[] args) {
        JSONObject obj1 = new JSONObject().put("name", "Alice").put("age", 25);
        JSONObject obj2 = new JSONObject().put("email", "alice@example.com").put("city", "New York");

        JSONObject merged = new JSONObject(obj1, JSONObject.getNames(obj1));
        for (String key : JSONObject.getNames(obj2)) {
            merged.put(key, obj2.get(key));
        }
        System.out.println(merged.toString(4));
    }
}
