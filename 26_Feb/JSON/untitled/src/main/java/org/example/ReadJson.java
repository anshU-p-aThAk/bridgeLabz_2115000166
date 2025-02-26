package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
public class ReadJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("input.json"));
        Iterator<String> fields = root.fieldNames();
        while(fields.hasNext()){
            String field = fields.next();
            System.out.println(field + " : " + root.get(field).toString());
        }
    }
}
