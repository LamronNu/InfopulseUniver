package labs.examples.lab_1_OOP.chef;
/**
 * Root vegetables (Êîðíåïëîäû)
 * @version 1.0 3 Oct 2013
 * @author Andrei Loyevets
 */
abstract public class RootVegetable extends Vegetable{
    public RootVegetable(String name, double calories) {
        super(name, calories);
        setCategory("Root vegetables");
    }

    public RootVegetable(String name, double calories, double weight) {
        super(name, calories, weight);
        setCategory("Root vegetables");
    }
}
