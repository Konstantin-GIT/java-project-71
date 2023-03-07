package hexlet.code.formatters;

import hexlet.code.DataDifferences;

import java.util.List;
import java.util.Map;

public class PlainFormatter {

    public static String outputDifferencesPlain(List<DataDifferences> dataDifferences) {
        StringBuilder differJso1AndJson2 = new StringBuilder();
        int lastLinePosition = dataDifferences.size() - 1;
        for (int i = 0; i < dataDifferences.size(); i++) {
            switch (dataDifferences.get(i).getChangeStatus()) {
                case "added":
                    differJso1AndJson2.append("Property " + convertToPlainFormat(dataDifferences.get(i).getKey())
                            + " was added with value: "
                            + convertToPlainFormat(dataDifferences.get(i).getUpdatedValue()));
                    if (lastLinePosition != i) {
                        differJso1AndJson2.append("\n");
                    }
                    break;
                case "deleted":
                    differJso1AndJson2.append("Property "
                            + convertToPlainFormat(dataDifferences.get(i).getKey()) + " was removed");
                    if (lastLinePosition != i) {
                        differJso1AndJson2.append("\n");
                    }
                    break;
                case "unchanged":
                    break;
                case "changed":
                    differJso1AndJson2.append("Property " + convertToPlainFormat(dataDifferences.get(i).getKey())
                            + " was updated. From " + convertToPlainFormat(dataDifferences.get(i).getInitialValue())
                            + " to " + convertToPlainFormat(dataDifferences.get(i).getUpdatedValue()));
                    if (lastLinePosition != i) {
                        differJso1AndJson2.append("\n");
                    }
                    break;
                default:
                    throw new RuntimeException("The value in "
                            + "the method outputDifferencesStylish in the operator switch is incorrect.");
            }
        }
        return differJso1AndJson2.toString();
    }
    public static String convertToPlainFormat(Object data) {
        if (data == null) {
            return "null";
        }
        if (data instanceof String) {
            return "'" + data + "'";
        } else if (data instanceof Boolean) {
            return data.toString();
        } else if (data instanceof Integer) {
            return data.toString();
        } else if (data instanceof Map<?, ?> || data instanceof List<?>) {
            return "[complex value]";
        } else {
            return data.toString();
        }
    }

}
