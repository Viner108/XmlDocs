package xml.xsd;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XsdMain {

    private static final String BAELDUNG_XML_PATH = "xsd/individual.xml";
    private static final String PERSON_XSD_PATH = "xsd/persons.xsd";
    private static final String FULL_PERSON_XSD_PATH = "xsd/full-persons.xsd";

    public static void main(String... args) throws IOException, SAXException, JAXBException {
        Address address=new Address();
        address.setZip(new Zip());
        address.setCity("fds");
        JAXBContext context=JAXBContext.newInstance(Address.class);
        Unmarshaller unmarshaller=new Unmarshaller();
        Address unmarshal = unmarshaller.unmarshal();

        Marshaller marshaller=context.createMarshaller();
        marshaller.marshal(unmarshal,new File("library/address1.xml"));

        boolean r1 = givenValidXML_WhenIsValid_ThenTrue();
        boolean r2 =givenInvalidXML_WhenIsValid_ThenFalse();
        boolean r22 =givenInvalidXML_WhenIsValid_ThenFalse();
    }


    public static boolean givenValidXML_WhenIsValid_ThenTrue() throws IOException, SAXException {
        return new XmlValidator(PERSON_XSD_PATH, BAELDUNG_XML_PATH).isValid();
    }


    public static boolean givenInvalidXML_WhenIsValid_ThenFalse() throws IOException, SAXException {
        return new XmlValidator(FULL_PERSON_XSD_PATH, BAELDUNG_XML_PATH).isValid();
    }
}
