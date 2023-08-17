package xml.xsd;

public class Info {
    private String key;

    public Info(String key, String value) {
        this.key = key;
        this.value = value;
    }

    private String  value;

    public String toStringForKey() {
        return key;
    }
    public String toStringForValue() {
        return value;
    }
}
