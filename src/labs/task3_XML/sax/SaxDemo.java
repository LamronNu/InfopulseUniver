package labs.task3_XML.sax;

import labs.task3_XML.model.Voucher;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

public class SaxDemo {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        VoucherSaxParcer mySaxParser = new VoucherSaxParcer();
        parser.parse("src\\labs\\task3_XML\\xml\\vouchers.xml", mySaxParser);
        List<Voucher> vouchers = mySaxParser.getVouchers();
        System.out.println(vouchers);
    }
}
