package labs.task3_XML.model;

import java.util.List;

public class Hotel {
    public static class Apartament{
        public enum AdditionalService{
            TV, CONDITIONER, FRIDGE;
        }
        int rooms;
        String number;
        List<AdditionalService> services;

        @Override
        public String toString() {
            return "A{" + rooms +
                    ", N:" + number +
                    ", services:" + services +
                    '}';
        }

        public void setRooms(int rooms) {
            this.rooms = rooms;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public void setServices(List<AdditionalService> services) {
            this.services = services;
        }
    }
    enum FoodType {
        OB, //(Only Bed), RO (Room Only) или AO (Accommodation Only) подразумевает размещение в номере отеля без питания.
        BB, //(Bed and Breakfast) означает бесплатное питание только во время завтраков – Континентальный завтрак или Шведский стол.
        HB, // (Half Board) означает полупансион, то есть бесплатное двухразовое питание – завтрак и ужин.
        HB_PLUS, //(Half Board plus) – это расширенный полупансион, с той лишь разницей, что помимо завтрака и ужина в стоимость включены спиртные напитки местного производства.
        FB, // (Full Board) означает полный пансион, включающий в себя завтраки, обеды и ужины.
        FB_PLUS, // (Full Board plus) – то же, что и FB, плюс бесплатные алкогольные напитки в течение всего дня.
        AI, // (All Inclusive) переводится как «Все включено»: завтрак, обед и ужин; различные алкогольные и безалкогольные напитки (обычно местного производства); дополнительное питание (второй завтрак, закуски, полдник).
        UAI // (Ultra All Inclusive) отличается от AI тем, что постояльцам предлагаются не только местные, но и импортные алкогольные и безалкогольные напитки в неограниченном количестве.
    }
    FoodType foodType;
    int stars;
    Apartament apartament;

    public Hotel() {
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }
    public void setFoodType(String foodType) {
        setFoodType(FoodType.valueOf(foodType));
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Apartament getApartament() {
        return apartament;
    }

    public void setApartament(Apartament apartament) {
        this.apartament = apartament;
    }

    @Override
    public String toString() {
        return "H{"  + foodType +
                ", " + stars +
                "*, " + apartament +
                '}';
    }
}
