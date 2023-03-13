package hexlet.code;

import org.apache.commons.io.FilenameUtils;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.List;
import static hexlet.code.Differences.getDifferences;
import static hexlet.code.Parser.getData;

public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        String fileExtension1 = getExtensionFile(filePath1);
        String fileExtension2 = getExtensionFile(filePath2);

        String dataByFile1 = readFile(filePath1, StandardCharsets.UTF_8);
        String dataByFile2 = readFile(filePath2, StandardCharsets.UTF_8);

        Map<String, Object> data1 = getData(dataByFile1, fileExtension1);
        Map<String, Object> data2 = getData(dataByFile2, fileExtension2);

        List<DataDifferences>  dataDifferences = getDifferences(data1, data2);

        return Formatter.outputDifferences(dataDifferences, format);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }

    private static String readFile(String path, Charset encoding) throws IOException {
        Path fullPath = Paths.get(path).toAbsolutePath().normalize();
        return Files.readString(fullPath, encoding);
    }


    public static String getExtensionFile(String filename) {
        return FilenameUtils.getExtension(filename);
    }

}
