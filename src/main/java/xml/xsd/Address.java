package xml.xsd;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.List;

@XmlRootElement
public class Address {
    @XmlElementWrapper(name="Buttons")
    @XmlElement(name="Button")
    public List<Button> buttonList;
    private String version;

    public String getVersion() {
        return version;
    }

    @XmlAttribute
    public void setVersion(String version) {
        this.version = version;
    }

    private Zip zip;
    private String city;
    @XmlJavaTypeAdapter(ZipXmlAdapter.class)
    public Zip date;

    public Zip getZip() {
        return zip;
    }

    @XmlElement
    public void setZip(Zip zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    @XmlElement
    public void setCity(String city) {
        this.city = city;
    }
}
