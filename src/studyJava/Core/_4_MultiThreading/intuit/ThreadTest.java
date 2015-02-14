package studyJava.Core._4_MultiThreading.intuit;

/**
 * Created by Olga on 27.06.2014.
 */
public class ThreadTest implements Runnable {

    @Override
    public void run() {
        double calc;
        for (int i = 0; i < 500000; i++) {
            calc = Math.sin(i*i);
            if (i%1000 == 0){
                System.out.println(getName() + " counts " + i/10000 );
            }

        }
    }

    private int getPriority() {
        return Thread.currentThread().getPriority();
    }

    private String getName() {
        return Thread.currentThread().getName();
    }
}
