package labs.examples.lab_1_OOP.chef;

/**
 * This class implements interface Comparator to compare Vegetables by
 * calories per 100g.
 * @version 1.0 3 Oct 2013
 * @author Andrei Loyevets
 */
public class CaloriesComparator implements java.util.Comparator<Vegetable>{

    public int compare(Vegetable v1, Vegetable v2) {
        return (int) (v1.getCalories() - v2.getCalories());
    }
}
