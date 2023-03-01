package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> jsonToMapParsing(File file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> result = objectMapper.readValue(file, new TypeReference<Map<String, Object>>() { });
        return result;
    }

   // public static Map<String, Object> yamlToMapParsing(File file) {
  //  }

}
