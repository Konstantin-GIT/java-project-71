package hexlet.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static hexlet.code.Parser.jsonToMapParsing;

public class Differ {

    public static String generate(String filePath1, String filePath2) throws IOException {
        File file1 = getFileByPath(filePath1);
        File file2 = getFileByPath(filePath2);

        Map<String, Object> jsonToParse1 = jsonToMapParsing(file1);
        Map<String, Object> jsonToParse2 = jsonToMapParsing(file2);

        return getDifferences(jsonToParse1, jsonToParse2);
    }
    public static File getFileByPath(String filePath) {
        Path fullPath = Paths.get(filePath).toAbsolutePath().normalize();
        return fullPath.toFile();
    }

    public static String getDifferences(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());
        StringBuilder differJso1AndJson2 = new StringBuilder();
        differJso1AndJson2.append("{\n");
        for (String key: keys) {
            if (!data1.containsKey(key)) {
                differJso1AndJson2.append("  + " +  key + ": " + data2.get(key) + "\n");
            } else if (!data2.containsKey(key)) {
                differJso1AndJson2.append("  - " +  key + ": " + data1.get(key) + "\n");
            } else if (data1.get(key).equals(data2.get(key))) {
                differJso1AndJson2.append("    " +  key + ": " + data1.get(key) + "\n");
            } else {
                differJso1AndJson2.append("  - " +  key + ": " + data1.get(key) + "\n");
                differJso1AndJson2.append("  + " +  key + ": " + data2.get(key) + "\n");
            }
        }
        differJso1AndJson2.append("}");
        System.out.println(differJso1AndJson2);
        return differJso1AndJson2.toString();
    }
}
