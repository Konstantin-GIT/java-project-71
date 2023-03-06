package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DataDifferences;

import java.util.List;

public class JsonFormatter {
    public static String outputDifferencesJson(List<DataDifferences> dataDifferences) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = "";
        result = objectMapper.writeValueAsString(dataDifferences);
        System.out.println(result);
        return result;
    }
}
