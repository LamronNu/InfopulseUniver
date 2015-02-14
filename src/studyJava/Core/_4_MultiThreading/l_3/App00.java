package studyJava.Core._4_MultiThreading.l_3;

/**
 * Created by Olga on 20.06.2014.
 */
public class App00 {
    public static void main(String[] args) throws InterruptedException {
        final Object ref = new Object();
        (new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ref){
                    try{
                        System.out.println("RUN: wait ...");
                        ref.wait();
                        System.out.println("RUN: ok!");
                    } catch (InterruptedException ignore) {/*NOP*/}

                }
            }
        })).start();
        System.out.println("MAIN: sleep...");
        Thread.sleep(2000);
        System.out.println("MAIN: sleep!");
        System.out.println("MAIN:  notify 1");

        final Object ref2 = new Object();
        synchronized (ref2){
            ref2.notify();
        }

        System.out.println("MAIN:  notify 2");

        synchronized (ref) {
            ref.notify();
            System.out.println("after notify 1");
            Thread.sleep(1000);
        }
        Thread.sleep(1000);
        System.out.println("after notify 2");

    }
}
