package labs.task3_XML.sax;

import labs.task3_XML.model.Hotel;
import labs.task3_XML.model.Voucher;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class VoucherSaxParcer extends DefaultHandler {
    private List<Voucher> vouchers;
    private Voucher voucher = null;
    private String currentField = "";
    private Hotel hotel;
    private Hotel.Apartament apartament;
    private ArrayList<Hotel.Apartament.AdditionalService> services;
    private Hotel.Apartament.AdditionalService service;


    public List<Voucher> getVouchers() {
        return vouchers;
    }

    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attr)  {
        switch (qName){
            case "vouchers":
                vouchers = new ArrayList<>();
                break;
            case "voucher":
                voucher = new Voucher();
                voucher.setId(attr.getValue("id"));
                break;
            case "hotel":
                hotel = new Hotel();
                currentField = qName;
                break;
            case "apartament":
                apartament = new Hotel.Apartament();
                currentField = qName;
                break;
            case "services":
                services = new ArrayList<Hotel.Apartament.AdditionalService>();
                currentField = qName;
                break;
            case "voucherType":
            case "transportType":
            case "country":
            case "days":
            case "nights":
            case "dateFrom":
            case "dateTo":
            case "foodType":
            case "stars":
            case "rooms":
            case "number":
            case "service":
            case "cost":
            case "currency":
                currentField = qName;
                break;
        }
    }

    @Override
    public void characters(char[] chars, int start, int len){
        String text = new String(chars, start, len);
        switch (currentField){
            //voucher characteristics
            case "voucherType":
                voucher.setVoucherType(text);
                break;
            case "transportType":
                voucher.setTransportType(text);
                break;
            case "country":
                voucher.setCountry(text);
                break;
            case "days":
                voucher.setDays(Integer.parseInt(text));
                break;
            case "nights":
                voucher.setNights(Integer.parseInt(text));
                break;

            case "cost":
                voucher.setCost(Double.parseDouble(text));
                break;
            case "currency":
                voucher.setCurrency(text);
                break;
            //hotel characteristics
            case "foodType":
                hotel.setFoodType(text);
                break;
            case "stars":
                hotel.setStars(Integer.parseInt(text));
                break;
            //apartament characteristics
            case "rooms":
                apartament.setRooms(Integer.parseInt(text));
                break;
            case "number":
                apartament.setNumber(text);
                break;
            case "service":
                service = Hotel.Apartament.AdditionalService.valueOf(text);
                break;
        }
        currentField = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName)  {
        switch (qName){
            case "vouchers":
                break;
            case "voucher":
                vouchers.add(voucher);
                break;
            case "hotel":
                voucher.setHotel(hotel);
                break;
            case "apartament":
                hotel.setApartament(apartament);
                break;
            case "service":
                services.add(service);
                break;
            case "services":
                apartament.setServices(services);
                break;
        }
    }
}

