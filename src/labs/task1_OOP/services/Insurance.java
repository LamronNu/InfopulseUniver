package labs.task1_OOP.services;

public class Insurance extends OrderService {
    public Insurance(double price) {
        super("Insurance", price);
    }

    public Insurance(double price, int count) {
        super("Insurance", price, count);
    }
}
