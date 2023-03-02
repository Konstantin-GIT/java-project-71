package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.apache.commons.io.FilenameUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    public static Map<String, Object> getData(String filePath) throws IOException {
        ObjectMapper mapperForFile = getDataMapper(filePath);
        File file = getFileByPath(filePath);
        Map<String, Object> result = mapperForFile.readValue(file, new TypeReference<Map<String, Object>>() { });
        return result;
    }

    public static ObjectMapper getDataMapper(String filePath) {
        if (getExtensionFile(filePath).equals("json")) {
            return new ObjectMapper();
        } else if (getExtensionFile(filePath).equals("yaml")) {
            return new YAMLMapper();
        } else {
            System.out.println("Error: invalid file format.");
        }
        return new ObjectMapper();
    }

    public static File getFileByPath(String filePath) {
        Path fullPath = Paths.get(filePath).toAbsolutePath().normalize();
        return fullPath.toFile();
    }

    public static String getExtensionFile(String filename) {
        return FilenameUtils.getExtension(filename);
    }



}
