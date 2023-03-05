package hexlet.code;

import java.util.List;
import java.util.Map;

public class Formater {

    public static String outputDifferencesStylish(List<DataDifferences> dataDifferences) {
        StringBuilder differJso1AndJson2 = new StringBuilder();
            differJso1AndJson2.append("{\n");
            for (DataDifferences item : dataDifferences) {
                switch (item.getChangeStatus()) {
                    case "added": {
                        differJso1AndJson2.append("  + " + item.getKey() + ": " + item.getValue2() + "\n");
                        break;
                    }
                    case "deleted": {
                        differJso1AndJson2.append("  - " + item.getKey() + ": " + item.getValue1() + "\n");
                        break;
                    }
                    case "unchanged": {
                        differJso1AndJson2.append("    " + item.getKey() + ": " + item.getValue1() + "\n");
                        break;
                    }
                    case "changed": {
                        differJso1AndJson2.append("  - " + item.getKey() + ": " + item.getValue1() + "\n");
                        differJso1AndJson2.append("  + " + item.getKey() + ": " + item.getValue2() + "\n");
                        break;
                    }
                    default:
                        throw new RuntimeException("The value in the method outputDifferencesStylish in the operator switch is incorrect.");
                }
        }
        differJso1AndJson2.append("}");
        System.out.println(differJso1AndJson2);
        return differJso1AndJson2.toString();
    }

    public static String outputDifferencesPlain(List<DataDifferences> dataDifferences) {
        StringBuilder differJso1AndJson2 = new StringBuilder();
        for (DataDifferences item : dataDifferences) {
            switch (item.getChangeStatus()) {
                case "added": {
                    differJso1AndJson2.append("Property " + convertToPlainFormat(item.getKey()) + " was added with value: " + convertToPlainFormat(item.getValue2()) + "\n");
                    break;
                }
                case "deleted": {
                    differJso1AndJson2.append("Property " + convertToPlainFormat(item.getKey()) + " was removed\n");
                    break;
                }
                case "unchanged": {
                    break;
                }
                case "changed": {
                    differJso1AndJson2.append("Property " + convertToPlainFormat(item.getKey()) + " was update. From "
                            + convertToPlainFormat(item.getValue1()) + " to " + convertToPlainFormat(item.getValue2()) + "\n");
                    break;
                }
                default:
                    throw new RuntimeException("The value in the method outputDifferencesStylish in the operator switch is incorrect.");
            }
        }
        System.out.println(differJso1AndJson2);
        return differJso1AndJson2.toString();
    }
    public static String convertToPlainFormat(Object data) {
        if (data == null) return "null";
        if (data instanceof String) {
            return "'" + data + "'";
        } else if (data instanceof Boolean) {
            return data.toString();
        } else if (data instanceof Integer) {
            return data.toString();
        } else if (data instanceof Map<?, ?> || data instanceof List<?>) {
            return data.toString();
        } else {
            return data.toString();
        }
    }

}
