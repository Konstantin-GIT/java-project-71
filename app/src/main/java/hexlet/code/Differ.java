package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {

    public static String generate(String filePath1, String filePath2) throws IOException {
        File file1 = getFileByPath(filePath1);
        File file2 = getFileByPath(filePath2);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonToParse1 =
                objectMapper.readValue(file1, new TypeReference<Map<String, Object>>() { });
        Map<String, Object> jsonToParse2 =
                objectMapper.readValue(file2, new TypeReference<Map<String, Object>>() { });
        Set<String> keys = new TreeSet<>(jsonToParse1.keySet());
        keys.addAll(jsonToParse2.keySet());
        StringBuilder differJso1AndJson2 = new StringBuilder();
        differJso1AndJson2.append("{\n");
        for (String key: keys) {
            if (!jsonToParse1.containsKey(key)) {
                differJso1AndJson2.append("  + " +  key + ": " + jsonToParse2.get(key) + "\n");
            } else if (!jsonToParse2.containsKey(key)) {
                differJso1AndJson2.append("  - " +  key + ": " + jsonToParse1.get(key) + "\n");
            } else if (jsonToParse1.get(key).equals(jsonToParse2.get(key))) {
                differJso1AndJson2.append("    " +  key + ": " + jsonToParse1.get(key) + "\n");
            } else {
                differJso1AndJson2.append("  - " +  key + ": " + jsonToParse1.get(key) + "\n");
                differJso1AndJson2.append("  + " +  key + ": " + jsonToParse2.get(key) + "\n");
            }
        }
        differJso1AndJson2.append("}");
        System.out.println(differJso1AndJson2.toString());
        return differJso1AndJson2.toString();
    }
    public static File getFileByPath(String filePath) {
        Path fullPath = Paths.get(filePath).toAbsolutePath().normalize();
        return fullPath.toFile();
    }
}
