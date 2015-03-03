package labs.task1_OOP.services;

public class Insurance extends OrderService {
    public Insurance(double price){
        this("insurance", price, 1);
    }
    public Insurance(String name, double price, int count) {
        super(name, price, count);
    }

    @Override
    public String toString() {
        return "Insurance{" +
                " price=" + super.getPrice() + "\t" +
                " count=" + super.getCount() + "\t" +
                " amount=" + super.getAmount() +
                "} ";
    }
}
