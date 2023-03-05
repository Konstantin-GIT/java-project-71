package hexlet.code;

public class DataDifferences {
    private String changeStatus;
    private String key;
    private Object value1;
    private Object value2;


    public String getChangeStatus() {
        return changeStatus;
    }

    public DataDifferences setChangeStatus(String changeStatus) {
        this.changeStatus = changeStatus;
        return this;
    }

    public String getKey() {
        return key;
    }

    public DataDifferences setKey(String key) {
        this.key = key;
        return this;
    }

    public Object getValue1() {
        return value1;
    }

    public DataDifferences setValue1(Object value1) {
        this.value1 = value1;
        return this;
    }

    public Object getValue2() {
        return value2;
    }

    public DataDifferences setValue2(Object value2) {
        this.value2 = value2;
        return this;
    }

    public String toString() {
        return "\nchangeStatus: " + changeStatus + ",\n"
                + "key: " + key +  ",\n" +"value1: " + value1  + ",\n" + "value2: " + value2 +"\n";
    }
}
