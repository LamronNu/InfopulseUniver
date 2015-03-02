package labs.task1_OOP.services;

import labs.task1_OOP.utils.Money;

import java.math.BigDecimal;

public abstract class OrderService {

    //fields
    private String name = "Basic service";
    //private boolean facultative = false;
    private int count = 1;
    private Money price;
    private Money amount;

//    private Currency currency = Currency.getInstance(Locale.getDefault());
//    private Currency basicCurrency = Currency.getInstance("UAN");

//    private double basicPrice;
//    private double basicAmount;

    //constructors
    public OrderService(String name, double price) {
        this(name,price,1);
    }

    public OrderService(String name, double price, int count) {
        checkAmount(price);
        checkCount(count);
        this.name = name;
        this.price = Money.dollars(new BigDecimal(price));
        this.amount = Money.dollars(new BigDecimal(price * count));
    }

    private void checkAmount(double price) {
        if (price < 0){
            throw new IllegalArgumentException("not negative price (" +
                    + price + ")!");
        }
    }

    private void checkCount(int count) {
        if (count <= 0){
            throw new IllegalArgumentException("not negative or 0 count(" +
                    + count + ")!");
        }
    }



    //getters, setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price.getAmount().doubleValue();
    }

    public void setPrice(double price) {
        checkAmount(price);
        this.price.setAmount(price);
        this.amount.setAmount(price * count);
    }
    public void addPrice(double value) {
        checkAmount(price.getAmount().doubleValue() + value);
        this.price.addAmount(value);
        this.amount.addAmount(value * count);
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        checkCount(count);
        this.count = count;
        this.amount.setAmount(price.getAmount().doubleValue() * count);
    }

    public double getAmount() {
        return amount.getAmount().doubleValue();
    }

    public void setAmount(double amount) {
        checkAmount(amount);
        this.amount.setAmount(amount);
        this.price.setAmount(amount / count);
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
