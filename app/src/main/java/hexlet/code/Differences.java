package hexlet.code;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Map;
import java.util.Objects;



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
            } else if (!Objects.equals(data1.get(key), data2.get(key))) {
                itemDataDifference.setChangeStatus("changed")
                        .setKey(key)
                        .setInitialValue(data1.get(key))
                        .setUpdatedValue(data2.get(key));
                dataDifferences.add(itemDataDifference);
            } else {
                itemDataDifference.setChangeStatus("unchanged")
                        .setKey(key)
                        .setInitialValue(data1.get(key));
                dataDifferences.add(itemDataDifference);
            }
        }
        //System.out.println(dataDifferences);
        return dataDifferences;
    }
}
