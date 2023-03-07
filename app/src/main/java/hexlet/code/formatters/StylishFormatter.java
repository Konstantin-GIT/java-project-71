package hexlet.code.formatters;

import hexlet.code.DataDifferences;

import java.util.List;

public class StylishFormatter {

    public static String outputDifferencesStylish(List<DataDifferences> dataDifferences) {
        StringBuilder differJso1AndJson2 = new StringBuilder();
        differJso1AndJson2.append("{\n");
        for (DataDifferences item : dataDifferences) {
            switch (item.getChangeStatus()) {
                case "added":
                    differJso1AndJson2.append(" ".repeat(2)
                            + "+ " + item.getKey() + ": " + item.getUpdatedValue() + "\n");
                    break;
                case "deleted":
                    differJso1AndJson2.append(" ".repeat(2)
                            + "- " + item.getKey() + ": " + item.getInitialValue() + "\n");
                    break;
                case "unchanged":
                    differJso1AndJson2.append(" ".repeat(4) + item.getKey() + ": " + item.getInitialValue() + "\n");
                    break;
                case "changed":
                    differJso1AndJson2.append(" ".repeat(2)
                            + "- " + item.getKey() + ": " + item.getInitialValue() + "\n");
                    differJso1AndJson2.append(" ".repeat(2)
                            + "+ " + item.getKey() + ": " + item.getUpdatedValue() + "\n");
                    break;
                default:
                    throw new RuntimeException("The value in the method "
                            + "outputDifferencesStylish in the operator switch is incorrect.");
            }
        }
        differJso1AndJson2.append("}");
        return differJso1AndJson2.toString();
    }
}
