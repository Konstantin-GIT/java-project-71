package hexlet.code;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Map;

public class Differences {

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
