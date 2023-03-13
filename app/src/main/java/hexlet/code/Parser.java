package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> getData(String data, String formatData) throws IOException {
        ObjectMapper dataMapper = getDataMapper(formatData);
        Map<String, Object> result = dataMapper.readValue(data, new TypeReference<Map<String, Object>>() { });
        return result;
    }

    public static ObjectMapper getDataMapper(String formatData) {
        switch (formatData) {
            case "json":
                return new ObjectMapper();
            case "yml":
                return new YAMLMapper();
            default:
                System.out.println("Error: invalid file format.");
                return new ObjectMapper();
        }
    }





}
