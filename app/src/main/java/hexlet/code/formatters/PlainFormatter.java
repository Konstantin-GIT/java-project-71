package hexlet.code.formatters;

import hexlet.code.DataDifferences;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class PlainFormatter {

    public static String outputDifferencesPlain(List<DataDifferences> dataDifferences) {
        StringJoiner differJso1AndJson2 = new StringJoiner("\n");
        for (DataDifferences dataDifference : dataDifferences) {
            switch (dataDifference.getChangeStatus()) {
                case "added":
                    differJso1AndJson2.add("Property " + convertToPlainFormat(dataDifference.getKey())
                            + " was added with value: "
                            + convertToPlainFormat(dataDifference.getUpdatedValue()));
                    break;
                case "deleted":
                    differJso1AndJson2.add("Property "
                            + convertToPlainFormat(dataDifference.getKey()) + " was removed");
                    break;
                case "unchanged":
                    break;
                case "changed":
                    differJso1AndJson2.add("Property " + convertToPlainFormat(dataDifference.getKey())
                            + " was updated. From " + convertToPlainFormat(dataDifference.getInitialValue())
                            + " to " + convertToPlainFormat(dataDifference.getUpdatedValue()));
                    break;
                default:
                    throw new RuntimeException("The value in "
                            + "the method outputDifferencesStylish in the operator switch is incorrect.");
            }
        }
        return differJso1AndJson2.toString();
    }
    private static String convertToPlainFormat(Object data) {
        if (data == null) {
            return "null";
        }
        if (data instanceof String) {
            return "'" + data + "'";
        } else if (data instanceof Map<?, ?> || data instanceof List<?>) {
            return "[complex value]";
        }
        return data.toString();
    }
}
