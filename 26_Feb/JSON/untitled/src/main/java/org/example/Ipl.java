package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.commons.csv.*;

import java.io.*;
import java.util.*;

public class Ipl {
    public static void main(String[] args) throws Exception {
        processJSON("ipl_data.json", "ipl_censored.json");
        processCSV("ipl_data.csv", "ipl_censored.csv");
    }

    public static void processJSON(String inputFile, String outputFile) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File(inputFile));

        if (root.isArray()) {
            ArrayNode modifiedData = mapper.createArrayNode();
            for (JsonNode match : root) {
                ObjectNode modifiedMatch = ((ObjectNode) match);
                modifyData(modifiedMatch);
                modifiedData.add(modifiedMatch);
            }
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputFile), modifiedData);
            System.out.println("Censored JSON file saved: " + outputFile);
        }
    }

    public static void processCSV(String inputFile, String outputFile) throws Exception {
        Reader reader = new FileReader(inputFile);
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
        List<String> headers = csvParser.getHeaderNames();

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(headers.toArray(new String[0])));

        for (CSVRecord record : csvParser) {
            List<String> row = new ArrayList<>();
            for (String header : headers) {
                String value = modifyField(header, record.get(header));
                row.add(value);
            }
            csvPrinter.printRecord(row);
        }

        csvParser.close();
        csvPrinter.flush();
        csvPrinter.close();
        System.out.println("Censored CSV file saved: " + outputFile);
    }

    private static void modifyData(ObjectNode node) {
        if (node.has("team1")) node.put("team1", maskTeamName(node.get("team1").asText()));
        if (node.has("team2")) node.put("team2", maskTeamName(node.get("team2").asText()));
        if (node.has("player_of_match")) node.put("player_of_match", "REDACTED");
    }

    private static String modifyField(String field, String value) {
        if (field.equalsIgnoreCase("team1") || field.equalsIgnoreCase("team2")) {
            return maskTeamName(value);
        } else if (field.equalsIgnoreCase("player_of_match")) {
            return "REDACTED";
        }
        return value;
    }

    private static String maskTeamName(String teamName) {
        String[] words = teamName.split(" ");
        return words.length > 1 ? words[0] + " ***" : "***";
    }
}
