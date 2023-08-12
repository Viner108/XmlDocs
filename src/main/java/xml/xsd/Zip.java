package xml.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
public class Zip {
    @XmlAttribute
    public String country;
    @XmlValue
    public String value;

    public Zip(String s) {
        value = s;
    }
}
