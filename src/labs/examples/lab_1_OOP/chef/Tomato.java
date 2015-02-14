package labs.examples.lab_1_OOP.chef;

/**
 * Tomato (Òîìàò)
 * @version 1.0 3 Oct 2013
 * @author Andrei Loyevets
 */
public class Tomato extends NightshadeVegetable {

    /**
     * Default constructor.
     */
    public Tomato() {
        super("Tomato", 18);
    }

    /**
     * Constructor with parameters. Creates a Tomato of a given weight.
     * @param weight the mass of the vegetable that will be created
     */
    public Tomato(double weight) {
        super("Tomato", 18, weight);
    }
}
