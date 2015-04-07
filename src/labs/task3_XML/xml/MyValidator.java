package labs.task3_XML.xml;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import labs.task3_XML.model.MyErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class MyValidator {

    public static final String XCD_SCHEMA = "src\\labs\\task3_XML\\xml\\vouchers.xsd";
    public static final String XML_FILE = "src\\labs\\task3_XML\\xml\\vouchers.xml";
    public static final String LOG_FILE = "src\\labs\\task3_XML\\log.txt";

    /**
     * example get from http://stackoverflow.com/questions/15732/whats-the-best-way-to-validate-an-xml-file-against-an-xsd-file
     * @throws SAXException
     * @throws IOException
     */
    private static void validateByValidator() throws SAXException, IOException {
        File schemaFile = new File(XCD_SCHEMA);
        Source xmlFile = new StreamSource(new File(XML_FILE));
        SchemaFactory schemaFactory = SchemaFactory
                .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(schemaFile);
        Validator validator = schema.newValidator();
        try {
            validator.validate(xmlFile);
            System.out.println(xmlFile.getSystemId() + " is valid");
        } catch (SAXException e) {
            System.out.println(xmlFile.getSystemId() + " is NOT valid");
            System.out.println("Reason: " + e.getLocalizedMessage());
        }
    }

    private static void validateByDomParcer() throws IOException, SAXException {
        DOMParser parser = new DOMParser();
        try {
            // установка обработчика ошибок
            parser.setErrorHandler(new MyErrorHandler(LOG_FILE));
            // установка способов проверки с  использованием XSD
            parser.setFeature("http://xml.org/sax/features/validation", true);
            parser.setFeature("http://apache.org/xml/features/validation/schema", true);
            parser.parse(XML_FILE);
            System.out.println("file is valid");
        } catch (SAXNotRecognizedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SAXException, IOException {
        validateByValidator();
//        validateByDomParcer();
    }
}
