package labs.examples.lab_1_OOP.chef;

/**
 * Class Vinaigrette consists of a set of ingredients (vegetables). It provides
 * methods to add ingredients, sort them, show on the screen.
 * @version 1.0 3 Oct 2013
 * @author Andrei Loyevets
 */
public class Vinaigrette extends Salad{

    public Vinaigrette() {
        setname("Vinaigrette");

        addIngredient(new Potato(500));
        addIngredient(new Carrot(150));
        addIngredient(new Beta(250));
        addIngredient(new Cucumber());
    }


}