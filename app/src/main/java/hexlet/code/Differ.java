package hexlet.code;

import java.io.IOException;
import java.util.Map;
import java.util.List;
import static hexlet.code.Differences.getDifferences;
import static hexlet.code.Parser.getData;

public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        Map<String, Object> dataOfFile1 = getData(filePath1);
        Map<String, Object> dataOfFile2 = getData(filePath2);

        List<DataDifferences>  dataDifferences = getDifferences(dataOfFile1, dataOfFile2);

        return Formatter.outputDifferences(dataDifferences, format);
    }

    public static String generate(String filePath1, String filePath2) throws IOException {
        return generate(filePath1, filePath2, "stylish");
    }
}
