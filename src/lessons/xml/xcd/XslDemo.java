package lessons.xml.xcd;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by Univer_29 on 28.03.2015.
 */
public class XslDemo {
    public static void main(String[] args) throws TransformerException {
        TransformerFactory tFact = TransformerFactory.newInstance();
        Transformer transformer = tFact.newTransformer(new StreamSource("F:\\infopulse\\skiplist\\lessons\\xml\\xcd\\test.xsl"));
        transformer.transform(new StreamSource("F:\\infopulse\\skiplist\\lessons\\xml\\xcd\\devices.xml"),
                new StreamResult("F:\\infopulse\\skiplist\\lessons\\xml\\xcd\\test.html"));
    }
}
