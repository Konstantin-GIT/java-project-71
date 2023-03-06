package hexlet.code;

import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.List;

public class Formatter {

    public static String outputDifferences(List<DataDifferences>  dataDifferences, String format) {
        if (format.equals("plain")) {
            return PlainFormatter.outputDifferencesPlain(dataDifferences);
        } else {
            return StylishFormatter.outputDifferencesStylish(dataDifferences);
        }
    }



//    public static String outputDifferencesPlain(List<DataDifferences> dataDifferences) {
//        StringBuilder differJso1AndJson2 = new StringBuilder();
//        for (DataDifferences item : dataDifferences) {
//            switch (item.getChangeStatus()) {
//                case "added":
//                    differJso1AndJson2.append("Property " + convertToPlainFormat(item.getKey())
//                            + " was added with value: " + convertToPlainFormat(item.getUpdatedValue()) + "\n");
//                    break;
//                case "deleted":
//                    differJso1AndJson2.append("Property " + convertToPlainFormat(item.getKey()) + " was removed\n");
//                    break;
//                case "unchanged":
//                    break;
//                case "changed":
//                    differJso1AndJson2.append("Property " + convertToPlainFormat(item.getKey())
//                            + " was update. From " + convertToPlainFormat(item.getInitialValue())
//                            + " to " + convertToPlainFormat(item.getUpdatedValue()) + "\n");
//                    break;
//                default:
//                    throw new RuntimeException("The value in "
//                            + "the method outputDifferencesStylish in the operator switch is incorrect.");
//            }
//        }
//        System.out.println(differJso1AndJson2);
//        return differJso1AndJson2.toString();
//    }
//    public static String convertToPlainFormat(Object data) {
//        if (data == null) {
//            return "null";
//        }
//        if (data instanceof String) {
//            return "'" + data + "'";
//        } else if (data instanceof Boolean) {
//            return data.toString();
//        } else if (data instanceof Integer) {
//            return data.toString();
//        } else if (data instanceof Map<?, ?> || data instanceof List<?>) {
//            return data.toString();
//        } else {
//            return data.toString();
//        }
//    }

}
