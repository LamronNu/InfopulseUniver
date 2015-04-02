package lessons.xml;

/**
 * Created by Univer_29 on 21.03.2015.
 */
public class Client {
    String id;
    String firstName;
    String secondName;
    Place place;

    static class Place {
        String contry;
        String city;

        public Place(String country, String city) {
            this.contry = country;
            this.city = city;
        }

        public Place() {

        }

        @Override
        public String toString() {
            return city + "(" + contry +')';
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Client-" + id +" {"  +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", place=" + place +
                '}';
    }
}
