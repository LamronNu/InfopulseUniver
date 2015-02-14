package labs.examples.lab_1_OOP.chef;


/**
 * Beta (Ñâåêëà)
 * @version 1.0 3 Oct 2013
 * @author Andrei Loyevets
 */
public class Beta extends RootVegetable{

    /**
     * Default constructor.
     */
    public Beta() {
        super("Beta", 47);
    }

    /**
     * Constructor with parameters. Creates a Beta of a given weight.
     * @param weight the mass of the vegetable that will be created
     */
    public Beta(double weight) {
        super("Beta", 47, weight);
    }
}
