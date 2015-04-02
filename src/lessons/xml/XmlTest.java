package lessons.xml;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class MySaxParser extends DefaultHandler {
    List<Client> clients = new ArrayList<>();
    Client client = null;
    String currentField = "";
    Client.Place place = null;

    public List<Client> getClients() {
        return clients;
    }


    @Override
    public void startDocument()  {
        System.out.println("start parse.....");;
    }

    @Override
    public void endDocument() {
        System.out.println("end parsing.");
    }

    /**
     *
     * @param uri -- space of names in xml
     * @param localName -- tag name
     * @param qName -- tag name
     * @param attr -- attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attr)  {
        switch (qName){
            case "clients":
                break;
            case "client":
                client = new Client();
                client.setId(attr.getValue("id"));
                break;
            case "placeOfBirth":
                place = new Client.Place();
            case "firstname":
            case "lastname":
            case "country":
            case "city":
                currentField = qName;
                break;
        }
    }

    @Override
    public void characters(char[] chars, int start, int len){
        String text = new String(chars, start, len);
        switch (currentField){
            case "firstname":
                client.setFirstName(text);
                break;
            case "lastname":
                client.setSecondName(text);
                break;
            case "country":
                place.contry = text;
                break;
            case "city":
                place.city = text;
                break;
        }
        currentField = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName)  {
        switch (qName){
            case "clients":
                break;
            case "client":
                clients.add(client);
                break;
            case "placeOfBirth":
                client.setPlace(place);
                break;
        }
    }
}

public class XmlTest {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        MySaxParser mySaxParser = new MySaxParser();
        parser.parse("src\\lessons\\xml\\clients.xml", mySaxParser);
        List<Client> clients = mySaxParser.getClients();
        System.out.println(clients);

    }
}
