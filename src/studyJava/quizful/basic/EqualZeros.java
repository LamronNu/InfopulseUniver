package studyJava.quizful.basic;

/**
 * Created by Olga on 12.06.2014.
 */
public class EqualZeros {
    public static void main(String[] args) {

        double valueOne = -0.0;
        double valueTwo = 0.0;
        System.out.println(valueOne == valueTwo);
        System.out.println(Double.compare(valueOne, valueTwo) == 0);
    }
}
