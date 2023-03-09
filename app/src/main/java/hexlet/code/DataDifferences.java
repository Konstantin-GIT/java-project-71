package hexlet.code;

public final class DataDifferences {
    private String changeStatus;
    private String key;
    private Object initialValue;
    private Object updatedValue;


    public String getChangeStatus() {
        return changeStatus;
    }

    public DataDifferences setChangeStatus(String status) {
        this.changeStatus = status;
        return this;
    }

    public String getKey() {
        return key;
    }

    public DataDifferences setKey(String keyValue) {
        this.key = keyValue;
        return this;
    }

    public Object getInitialValue() {
        return initialValue;
    }

    public DataDifferences setInitialValue(Object value) {
        this.initialValue = value;
        return this;
    }

    public Object getUpdatedValue() {
        return updatedValue;
    }

    public DataDifferences setUpdatedValue(Object value) {
        this.updatedValue = value;
        return this;
    }

    public String toString() {
        return "\nchangeStatus: " + changeStatus + ",\n"
                + "key: " + key + ",\n" + "initialValue: "
                + initialValue + ",\n" + "updatedValue: " + updatedValue + "\n";
    }
}
