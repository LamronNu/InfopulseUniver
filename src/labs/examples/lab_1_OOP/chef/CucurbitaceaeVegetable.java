package labs.examples.lab_1_OOP.chef;

/**
 * Cucurbitaceae vegetables (Òûêâåííûå)
 * @version 1.0 3 Oct 2013
 * @author Andrei Loyevets
 */
public class CucurbitaceaeVegetable extends Vegetable{

    public CucurbitaceaeVegetable(String name, double calories) {
        super(name, calories);
        setCategory("Cucurbitaceae vegetables");
    }

    public CucurbitaceaeVegetable(String name, double calories, double weight) {
        super(name, calories, weight);
        setCategory("Cucurbitaceae vegetables");
    }
}