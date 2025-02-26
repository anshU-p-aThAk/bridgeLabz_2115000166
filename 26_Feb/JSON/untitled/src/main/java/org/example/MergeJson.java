package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
public class MergeJson {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json1 = (ObjectNode) mapper.readTree(new File("file1.json"));
        ObjectNode json2 = (ObjectNode) mapper.readTree(new File("file2.json"));
        json2.fieldNames().forEachRemaining(field -> json1.set(field, json2.get(field)));
        System.out.println(json1.toString());
    }
}
