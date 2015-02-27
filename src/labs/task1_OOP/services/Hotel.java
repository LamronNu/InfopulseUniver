package labs.task1_OOP.services;

import labs.task1_OOP.utils.enums.HotelFood;

public class Hotel extends OrderService {
    private String place;
    private HotelFood food = HotelFood.OB;

    public Hotel(double price) {
        this(price, 1);
    }

    public Hotel(double price, int count) {
        super("Hotel", price, count);
    }

    public String getFoodTypeStr() {
        return food.toString();
    }

    public void setFoodType(HotelFood foodType) {
        this.food = foodType;
    }
}
