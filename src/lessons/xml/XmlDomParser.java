package lessons.xml;


import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlDomParser {
    public static void main(String[] args) throws IOException, SAXException {
        DOMParser domParser = new DOMParser();
        List<Client> clients = new ArrayList<>();
        domParser.parse("F:\\infopulse\\skiplist\\lessons\\xml\\clients.xml");
        Document root = domParser.getDocument();
        NodeList nodeList = root.getElementsByTagName("client");

        for (int i = 0; i < nodeList.getLength(); i++){
            Element clientNode = (Element) nodeList.item(i);
            Client client = new Client();
            //id
            client.setId(clientNode.getAttribute("id"));
            Element currentElement;
            String currentValue;
            //firstname
            currentElement = (Element)clientNode.getElementsByTagName("firstname").item(0);
            currentValue = currentElement.getFirstChild().getNodeValue();
            client.setFirstName(currentValue);
            //lastname
            currentElement = (Element)clientNode.getElementsByTagName("lastname").item(0);
            currentValue = currentElement.getFirstChild().getNodeValue();
            client.setSecondName(currentValue);
            //placeOfBirth
//          //country
            currentElement = (Element)clientNode.getElementsByTagName("country").item(0);
            String country = currentElement.getFirstChild().getNodeValue();
            //city
            currentElement =  (Element)clientNode.getElementsByTagName("city").item(0);
            String city = currentElement.getFirstChild().getNodeValue();
            //
            client.setPlace(new Client.Place(country,city));
            //
            clients.add(client);
        }

        System.out.println(clients);
    }
}
