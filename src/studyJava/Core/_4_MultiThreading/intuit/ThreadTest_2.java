package studyJava.Core._4_MultiThreading.intuit;

/**
 * Created by Olga on 27.06.2014.
 */
public class ThreadTest_2 implements Runnable {
    public final static ThreadGroup GROUP = new ThreadGroup("DaemonDemo");
    private int start;

    public ThreadTest_2(int s) {
        start = (s%2 == 0) ? s :s+1;
        new Thread(GROUP, this, "Thread " + start).start();
    }

    @Override
    public void run() {
        for (int i = start; i > 0; i--) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException ignore) {/*NOP*/}
            //in the middle create new Thread
            if (start >2 && i == start/2){
                new ThreadTest_2(i);
            }
        }

    }
}
