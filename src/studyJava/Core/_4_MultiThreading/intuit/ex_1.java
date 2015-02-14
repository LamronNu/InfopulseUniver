package studyJava.Core._4_MultiThreading.intuit;

/**
 * Created by Olga on 27.06.2014.
 */
public class ex_1 {
    public static void main(String[] args) {
        //prepare
        Thread t[] = new Thread[3];
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new ThreadTest(), "Thread " + i);
            t[i].setPriority(Thread.MIN_PRIORITY +
                    (Thread.MAX_PRIORITY - Thread.MIN_PRIORITY)/t.length*i);
        }
        //run
        for (int i = 0; i < t.length; i++) {
            t[i].start();
            System.out.println(t[i].getName() + " started" +
                    " (priority:" + t[i].getPriority() + ")");

        }
    }
}
