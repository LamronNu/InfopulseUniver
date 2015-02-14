package labs.examples.lab_1_OOP.chef;

/**
 * Carrot (Ěîđęîâü)
 * @version 1.0 3 Oct 2013
 * @author Andrei Loyevets
 */
public class Carrot extends RootVegetable{

    /**
     * Default constructor.
     */
    public Carrot() {
        super("Carrot", 41);
    }

    /**
     * Constructor with parameters. Creates a Carrot of a given weight.
     * @param weight the mass of the vegetable that will be created
     */
    public Carrot(double weight) {
        super("Carrot", 41, weight);
    }
}