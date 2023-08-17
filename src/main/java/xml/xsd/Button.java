package xml.xsd;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Button {
    @XmlAttribute(name = "Action")
    private String action;
    @XmlAttribute(name = "Color")
    private String color;
    @XmlAttribute(name = "Condition")
    private String condition;
    @XmlElement(name = "T")
    private String t;
}
