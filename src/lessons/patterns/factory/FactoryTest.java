package lessons.patterns.factory;


interface Car{
    public void move();
}
class Bmw implements Car{

    @Override
    public void move() {
        System.out.println("BMW");
    }
}

class Opel implements Car{

    @Override
    public void move() {
        System.out.println("Opel");
    }
}
class CarFactory{
    protected static CarFactory instance;

    protected CarFactory() {
    }

    public CarFactory getInstance(){
        if (instance == null){
            instance = new CarFactory();
        }
        return instance;
    }

    public  Car getCar(String type){
        Car car = null;
        switch (type){
            case "BMW":
                car = new Bmw();
                break;
            case "Opel":
                car = new Opel();
            break;
        }
        return car;
    }
}
/**
 * Created by Univer_29 on 07.03.2015.
 */
public class FactoryTest {
}
