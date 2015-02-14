package studyJava.Core._4_MultiThreading.l_4;

/**
 * Created by Olga on 23.06.2014.
 */
public class PrintRunnableX implements Runnable {
    String msg;
    int sleepMillis;
    public PrintRunnableX(String msg, int sleepMillis) {
        this.msg = msg;
        this.sleepMillis = sleepMillis;
    }

    @Override
    public void run() {
        for (int k = 0; k < 10; k++) {
            try {
                Thread.sleep(sleepMillis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(msg);
        }
    }
}
