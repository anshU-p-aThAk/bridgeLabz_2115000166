package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import java.io.File;
public class ValidateEmail {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode schemaNode = mapper.readTree(new File("emailSchema.json"));
        JsonSchema schema = JsonSchemaFactory.byDefault().getJsonSchema(schemaNode);
        JsonNode jsonData = mapper.readTree(new File("user.json"));
        System.out.println(schema.validate(jsonData).isSuccess() ? "Valid" : "Invalid");
    }
}
