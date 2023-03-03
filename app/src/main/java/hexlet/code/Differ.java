package hexlet.code;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static hexlet.code.Parser.getData;

public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        Map<String, Object> dataOfFile1 = getData(filePath1);
        Map<String, Object> dataOfFile2 = getData(filePath2);

        return getDifferences(dataOfFile1, dataOfFile2, format);
    }


    public static String getDifferences(Map<String, Object> data1, Map<String, Object> data2, String format) {
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());
        StringBuilder differJso1AndJson2 = new StringBuilder();

        if (format.equals("plain")) {
            for (String key : keys) {
                if (!data1.containsKey(key)) {
                    differJso1AndJson2.append("Property '" + key
                            + "' was added with value: " + convertToPlainFormat(data2.get(key)) + "\n");
                } else if (!data2.containsKey(key)) {
                    differJso1AndJson2.append("Property '" + key + "' was removed\n");
                } else if (data1.get(key).equals(data2.get(key))) {
                    differJso1AndJson2.append("Property '" + key + "' was update. From "
                            + convertToPlainFormat(data1.get(key)) + " to "
                            + convertToPlainFormat(data2.get(key)) + "\n");
                }
            }
            System.out.println(differJso1AndJson2);
        } else if (format.equals("stylish")) {
            differJso1AndJson2.append("{\n");
            for (String key : keys) {
                if (!data1.containsKey(key)) {
                    differJso1AndJson2.append("  + " + key + ": " + data2.get(key) + "\n");
                } else if (!data2.containsKey(key)) {
                    differJso1AndJson2.append("  - " + key + ": " + data1.get(key) + "\n");
                } else if (data1.get(key).equals(data2.get(key))) {
                    differJso1AndJson2.append("    " + key + ": " + data1.get(key) + "\n");
                } else {
                    differJso1AndJson2.append("  - " + key + ": " + data1.get(key) + "\n");
                    differJso1AndJson2.append("  + " + key + ": " + data2.get(key) + "\n");
                }
            }
            differJso1AndJson2.append("}");
            System.out.println(differJso1AndJson2);
        }
        return differJso1AndJson2.toString();
    }

    public static String convertToPlainFormat(Object data) {
        if (data instanceof String) {
            return "'" + data + "'";
        } else if (data instanceof Boolean) {
            return data.toString();
        } else if (data instanceof Integer) {
            return data.toString();
        } else if (data instanceof Map<?, ?> || data instanceof List<?>) {
            return "[" + data + "]";
        } else {
            return data.toString();
        }
    }


}
