package studyJava.Core._4_MultiThreading.l_3;

/**
 * Created by Olga on 23.06.2014.
 */
public class App11 {
    public synchronized static void inc(){
        counter++;
    }
    public synchronized static int getCounter(){
        return counter;
    }
    public static int counter = 0;
    public static final int N = 100000000;
    public static void main(String[] args) throws InterruptedException {
        //t0
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) {
                    inc();
                }
            }
        });
        t0.start();
        //t1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < N; i++) {
                    inc();
                }
            }
        });
        t1.start();

        t0.join();
        t1.join();
        System.out.println(counter);
    }
}
