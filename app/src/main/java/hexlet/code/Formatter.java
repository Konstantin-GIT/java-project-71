package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.JsonFormatter;
import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.List;

public class Formatter {

    public static String outputDifferences(List<DataDifferences>  dataDifferences, String formatOutput)
            throws JsonProcessingException {
        switch (formatOutput) {
            case "plain":
                return PlainFormatter.outputDifferencesPlain(dataDifferences);
            case "json":
                return JsonFormatter.outputDifferencesJson(dataDifferences);
            case "stylish":
                return StylishFormatter.outputDifferencesStylish(dataDifferences);
            default:
                return "Invalid format specified. The format cannot be equal to <" + formatOutput + ">.";
        }
    }
}
