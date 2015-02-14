package labs.examples.lab_1_OOP.chef;

/**
 * Potato (Êàðòîôåëü)
 * @version 1.0 3 Oct 2013
 * @author Andrei Loyevets
 */
public class Potato extends NightshadeVegetable{

    /**
     * Default constructor.
     */
    public Potato() {
        super("Potato", 77);
    }

    /**
     * Constructor with parameters. Creates a Potato of a given weight.
     * @param weight the mass of the vegetable that will be created
     */
    public Potato(double weight) {
        super("Potato", 77, weight);
    }
}
