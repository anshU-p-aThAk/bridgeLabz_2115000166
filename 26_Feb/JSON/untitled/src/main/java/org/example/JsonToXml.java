package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
public class JsonToXml {
    public static void main(String[] args) throws Exception {
        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode node = jsonMapper.readTree(new File("input.json"));
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(node);
        System.out.println(xml);
    }
}
