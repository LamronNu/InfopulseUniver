package labs.examples.lab_1_OOP.chef;

/**
 * Dill (Óêðîï)
 * @version 1.0 3 Oct 2013
 * @author Andrei Loyevets
 */
public class Dill extends SpicyVegetable{
    /**
     * Default constructor.
     */
    public Dill() {
        super("Dill", 43);
    }

    /**
     * Constructor with parameters. Creates a Dill of a given weight.
     * @param weight the mass of the vegetable that will be created
     */
    public Dill(double weight) {
        super("Dill", 43, weight);
    }
}
