package lessons.xml.dom;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.NodeList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build("F:\\infopulse\\skiplist\\lessons\\xml\\clients.xml");
        Element root = document.getRootElement();
        List<Element> clients = root.getChildren("client");
        for (Element client : clients) {
            if (client.getAttribute("id").getValue().equals("a002")) {
                client.getChild("firstname").setText("Nicola");
            }
        }

        XMLOutputter xmlOutputter = new XMLOutputter();
        xmlOutputter.output(document, new FileOutputStream("F:\\infopulse\\skiplist\\lessons\\xml\\clients.xml"));
    }
}
