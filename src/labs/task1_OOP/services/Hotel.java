package labs.task1_OOP.services;

import labs.task1_OOP.utils.enums.HotelFood;

public class Hotel extends OrderService {
    private String place;
    private HotelFood food = HotelFood.OB;
    private HotelFood foodType;

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
    public void setFoodType(String foodType) {
        this.food = HotelFood.valueOf(foodType);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "food=" + food + "\t" +
                "price=" + super.getPrice() + "\t" +
                "days=" + super.getCount() + "\t" +
                "amount=" + super.getAmount() +
                "} ";
    }

    public HotelFood getFoodType() {
        return foodType;
    }
}
