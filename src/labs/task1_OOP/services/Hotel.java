package labs.task1_OOP.services;

import labs.task1_OOP.utils.HotelFood;

public class Hotel extends OrderService {
    private String place;
    private HotelFood food = HotelFood.OB;

    public Hotel(double price) {
        super("Hotel", price);
    }

    public Hotel(double price, int count) {
        super("Hotel", price, count);
    }
}
