package labs.task1_OOP.services;

public abstract class OrderService {

    //fields
    private String name = "Basic service";
    //private boolean facultative = false;
    private int count = 1;
    private double price; //todo BigDecimal??
    private double amount;

//    private Currency currency = Currency.getInstance(Locale.getDefault());
//    private Currency basicCurrency = Currency.getInstance("UAN");

//    private double basicPrice;
//    private double basicAmount;

    //constructors

    public OrderService(String name, double price) {
        this.name = name;
        this.price = price;
        this.amount = price;
    }

    public OrderService(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.amount = price * count;
    }

    //getters, setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.amount = this.price * count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
        this.amount = price * this.count;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
        this.price = this.amount / count;
    }

    //

    @Override
    public String toString() { //todo
        return "OrderService{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }

}
