package labs.task3_XML.model;

public class Voucher {


    enum VoucherType {
        HOLIDAY, EXCURSION, REST, PILGRIMAGE;
    }
    enum TransportType {
        AUTO, AVIA, BUS, TRAIN, SHIP;
    }

    String id;
    VoucherType voucherType;
    TransportType transportType;
    String country;
    int days;
    int nights;
    Hotel hotel;
    double cost;
    String currency;

    @Override
    public String toString() {
        return "Voucher-" + id +" {"
                + voucherType +
                ", " + transportType +
                ", '" + country + '\'' +
                ", days/nights:" + days +
                "/" + nights +
                ", " + hotel +
                ", cost:" + cost +
                " " + currency +
                '}';
    }
    //setters and getters
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public VoucherType getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = VoucherType.valueOf(voucherType);
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = TransportType.valueOf(transportType);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }


    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
