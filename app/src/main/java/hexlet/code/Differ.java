package hexlet.code;

import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.TreeSet;



import static hexlet.code.Parser.getData;

public class Differ {

    public static String generate(String filePath1, String filePath2, String format) throws IOException {
        Map<String, Object> dataOfFile1 = getData(filePath1);
        Map<String, Object> dataOfFile2 = getData(filePath2);
        //System.out.println(dataOfFile1);
        //System.out.println(dataOfFile2);
        List<DataDifferences>  dataDifferences = getDifferences(dataOfFile1, dataOfFile2);
        if (format.equals("plain")) {
            return Formater.outputDifferencesPlain(dataDifferences);
        } else {
            return Formater.outputDifferencesStylish(dataDifferences);
        }
    }

    public static List<DataDifferences> getDifferences(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());
        List<DataDifferences> dataDifferences = new ArrayList<DataDifferences>();
        for (String key: keys) {
            DataDifferences itemDataDifference = new DataDifferences();
            if (!data1.containsKey(key)) {
                itemDataDifference.setChangeStatus("added")
                        .setKey(key)
                        .setUpdatedValue(data2.get(key));
                dataDifferences.add(itemDataDifference);
            } else if (!data2.containsKey(key)) {
                itemDataDifference.setChangeStatus("deleted")
                            .setKey(key)
                            .setInitialValue(data1.get(key));
                dataDifferences.add(itemDataDifference);
            } else if (data1.get(key) == null && data2.get(key) == null) {
                itemDataDifference.setChangeStatus("unchanged")
                        .setKey(key)
                        .setInitialValue(null);
                dataDifferences.add(itemDataDifference);
            } else if (data1.get(key) == null && data2.get(key) != null) {
                itemDataDifference.setChangeStatus("changed")
                        .setKey(key)
                        .setInitialValue(null)
                        .setUpdatedValue(data2.get(key));
                dataDifferences.add(itemDataDifference);
            } else if (data1.get(key) != null && data2.get(key) == null) {
                itemDataDifference.setChangeStatus("changed")
                        .setKey(key)
                        .setInitialValue(data1.get(key))
                        .setUpdatedValue(null);
                dataDifferences.add(itemDataDifference);
            } else if (data1.get(key).equals(data2.get(key))) {
                itemDataDifference.setChangeStatus("unchanged")
                        .setKey(key)
                        .setInitialValue(data1.get(key));
                dataDifferences.add(itemDataDifference);
            } else {
                itemDataDifference.setChangeStatus("changed")
                                    .setKey(key)
                                    .setInitialValue(data1.get(key))
                                    .setUpdatedValue(data2.get(key));
                dataDifferences.add(itemDataDifference);
            }
        }
        //System.out.println(dataDifferences);
        return dataDifferences;
    }
}
