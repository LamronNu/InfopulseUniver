package labs.examples.lab_1_OOP.chef;

/**
 * This class implements interface Comparator to compare Vegetables by their
 * weight in the salad.
 * @version 1.0 3 Oct 2013
 * @author Andrei Loyevets
 */
public class WeightComparator implements java.util.Comparator<Vegetable>{
    public int compare(Vegetable v1, Vegetable v2) {
        return (int) (v1.getWeight() - v2.getWeight());
    }
}