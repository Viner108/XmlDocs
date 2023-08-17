package xml.xsd;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@NoArgsConstructor
@XmlRootElement
class LowLevelToken {
    @XmlAttribute(name = "info-key")
    public String key;
    @XmlAttribute(name = "info-value")
    public String value;
    @XmlElement(name = "Zip")
    public Zip zip;

    public LowLevelToken(String info1, String value, Zip zip) {
        this.key = info1;
        this.value = value;
        this.zip = zip;
    }


}

@XmlRootElement
class HighLevelToken {
    @XmlAttribute(name = "info-1")
    public String info1;
    @XmlAttribute(name = "info-2")
    public String info2;

    @XmlElement(name = "zip")
    public Zip zip;

    private HighLevelToken() {
    }

    public HighLevelToken(String info1, String info2) {
        this.info1 = info1;
        this.info2 = info2;
        this.zip = zip;
    }
}

class TokenWrapper {
    @XmlElement(name = "LowLevel")
    public List<LowLevelToken> tokens = new ArrayList<LowLevelToken>();
}

class TokenAdapter extends XmlAdapter<TokenWrapper, Map<Info, Zip>> {
    @Override
    public TokenWrapper marshal(Map<Info, Zip> lowlevelTokens)
            throws Exception {
        TokenWrapper wrapper = new TokenWrapper();
        List<LowLevelToken> elements = new ArrayList<LowLevelToken>();
        for (Map.Entry<Info, Zip> property : lowlevelTokens.entrySet()) {
            elements.add(new LowLevelToken(property.getKey().toStringForKey(), property.getKey().toStringForValue(), new Zip(property.getValue().toStringForCountry(), property.getValue().toStringForValue())));
        }
        wrapper.tokens = elements;
        return wrapper;
    }

    @Override
    public Map<Info, Zip> unmarshal(TokenWrapper tokenWrapper) throws Exception {
        Map<Info, Zip> tokens = null;
        if (tokenWrapper != null && tokenWrapper.tokens != null && !tokenWrapper.tokens.isEmpty()) {
            tokens = new HashMap<Info, Zip>();
            for (LowLevelToken token : tokenWrapper.tokens) {
                tokens.put(new Info(token.key,token.value),new Zip(token.zip.country,token.zip.value) );
            }
        }
        return tokens;
    }
}

@XmlRootElement(name = "Token")
public class Token {
    Map<Info, Zip> lowLevel;


    public Map<Info, Zip> getLowLevel() {
        return lowLevel;
    }

    @XmlElement(name = "LowLevel")
    @XmlJavaTypeAdapter(TokenAdapter.class)
    public void setLowLevel(Map<Info, Zip> lowLevel) {
        this.lowLevel = lowLevel;
    }

    public String toString() {
        for (Map.Entry<Info, Zip> property : lowLevel.entrySet()) {
            String str="info-key="+property.getKey().toStringForKey()+" " +"info-value="+property.getKey().toStringForValue()+" " +"Zip county="+ property.getValue().toStringForCountry()+" " +"Zip value="+ property.getValue().toStringForValue();
            System.out.println(str);
        }
        return null;
    }
}
