package labs.examples.lab_1_OOP.chef;

/**
 * Nightshade vegetables (Ïàñëåíîâûå)
 * @version 1.0 3 Oct 2013
 * @author Andrei Loyevets
 */
public class NightshadeVegetable extends Vegetable{

    public NightshadeVegetable(String name, double calories) {
        super(name, calories);
        setCategory("Nightshade vegetables");
    }

    public NightshadeVegetable(String name, double calories, double weight) {
        super(name, calories, weight);
        setCategory("Nightshade vegetables");
    }
}
