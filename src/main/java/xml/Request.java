package xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Request {
    public HashMap<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StartRow getStartRow() {
        return startRow;
    }

    public void setStartRow(StartRow startRow) {
        this.startRow = startRow;
    }

    public List<Hearer> getHearers() {
        return hearers;
    }

    public void setHearers(List<Hearer> hearers) {
        this.hearers = hearers;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    private HashMap<String, String> attributes  = new HashMap<>();

    private String id;
    private StartRow startRow;
    private List<Hearer> hearers=new ArrayList<>();
    private Body body;
}


