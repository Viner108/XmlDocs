package xml.xsd;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

@NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Zip {
    @XmlAttribute
    public String country;
    @XmlValue
    public String value;

    public Zip(String country, String s) {
        this.country=country;
        this.value = s;
    }

    public String toStringForCountry() {
        return country;
    }
    public String toStringForValue() {
        return  value;
    }
}
