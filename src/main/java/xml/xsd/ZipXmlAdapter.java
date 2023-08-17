package xml.xsd;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ZipXmlAdapter extends XmlAdapter<String, Zip> {
    @Override
    public Zip unmarshal(String s) throws Exception {
        return new Zip(s,"sd");
    }

    @Override
    public String marshal(Zip localDate) throws Exception {
        return localDate.value;
    }
}
