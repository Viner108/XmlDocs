package xml.xsd;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Unmarshaller {

    public static final String XSD_ADDRESS_1_XSD = "xsd/address1.xsd";
    public static final String XSD_ADDRESS_1_XML = "xsd/address1.xml";

    public Address unmarshal() throws JAXBException, IOException, SAXException {
        JAXBContext context = JAXBContext.newInstance(Address.class);
//        validate();
        javax.xml.bind.Unmarshaller unmarshaller = context.createUnmarshaller();
        Address address2 = (Address) unmarshaller.unmarshal(new File(getClass().getClassLoader().getResource(XSD_ADDRESS_1_XML).getFile()));
        return address2;
    }

    private void validate() throws SAXException, IOException {
        boolean valid = isValid(XSD_ADDRESS_1_XSD, XSD_ADDRESS_1_XML);
        return;
    }

    private Validator initValidator(String xsdPath) throws SAXException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(new File(getClass().getClassLoader().getResource(xsdPath).getFile()));
        Schema schema = factory.newSchema(schemaFile);
        return schema.newValidator();
    }
    public boolean isValid(String xsdPath,String xmlPath) throws IOException, SAXException {
        Validator validator = initValidator(xsdPath);
        try {
            Class<? extends Unmarshaller> aClass = getClass();
            ClassLoader classLoader = aClass.getClassLoader();
            URL resource = classLoader.getResource(xmlPath);
            String file = resource.getFile();
            File f = new File(file);
            StreamSource source = new StreamSource(f);
            validator.validate(source);
            return true;
        } catch (SAXException e) {
            e.printStackTrace();
            return false;
        }
    }
}