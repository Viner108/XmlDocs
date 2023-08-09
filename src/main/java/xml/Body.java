package xml;

import java.util.HashMap;

public class Body {
    private HashMap<String, String> attributes  = new HashMap<>();
    private String type;

    public void setAttributes(HashMap<String, String> attributes) {
        this.attributes = attributes;
    }

    public void setType(String type) {
        this.type = type;
    }

    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public String getType() {
        return type;
    }
}
