package labs.task1_OOP.services;

import labs.task1_OOP.utils.enums.HotelFood;

public class Hotel extends OrderService {
    private String place;
    private HotelFood foodType = HotelFood.OB;

    public Hotel(double price) {
        this(price, 1);
    }

    public Hotel(double price, int count) {
        super("Hotel", price, count);
    }

    public String getFoodTypeStr() {
        return foodType.toString();
    }

    public void setFoodType(HotelFood foodType) {
        this.foodType = foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = HotelFood.valueOf(foodType);
    }

    public HotelFood getFoodType() {
        return foodType;
    }
    @Override
    public String toString() {
        return "Hotel{" +
                " food=" + foodType + ",\t" +
                " price=" + super.getPrice() + ",\t" +
                " days=" + super.getCount() + ",\t" +
                " amount=" + super.getAmount() +
                "} ";
    }


}
