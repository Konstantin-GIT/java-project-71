package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.List;

public class Formatter {

    public static String outputDifferences(List<DataDifferences>  dataDifferences, String format)
            throws JsonProcessingException {
        if (format.equals("plain")) {
            return PlainFormatter.outputDifferencesPlain(dataDifferences);
        } else if (format.equals("json")) {
            return JsonFormatter.outputDifferencesJson(dataDifferences);
        } else {
            return StylishFormatter.outputDifferencesStylish(dataDifferences);
        }
    }
}
