package xml.xsd;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JAXBExample {
    private static final String XSD_TOKEN_1_XML = "xsd/token.xml";

    public static void main(String[] args) {
        Token token = new Token();
        token.setLowLevel(new HashMap<Info, Zip>() {{ put(new Info("LK1","LV1"), new Zip("sdsd","werwere")); put(new Info("LK2","LV2"), new Zip("sdsd2","werwe")); }});
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Token.class);
            Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
            Token token1 = (Token) unmarshaller.unmarshal(new File(JAXBExample.class.getClassLoader().getResource(XSD_TOKEN_1_XML).getFile()));
            token1.toString();
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            jaxbMarshaller.marshal(token, System.out);
            jaxbMarshaller.marshal(token1, new File("library/token1.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
