package studyJava.Core._4_MultiThreading.l_2;

/**
 * Created by Olga on 19.06.2014.
 */
public class App01 {
    public static volatile boolean interruptedStatus = false;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread((new Runnable() {
            @Override
            public void run() {
                while(!interruptedStatus){
                    System.out.println("!");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("Ok!");
            }
        }));
       thread.start();
//        System.out.println(thread.isInterrupted());
//
//        Thread me = Thread.currentThread();
//        me.interrupt();
//        System.out.println(me.isInterrupted());

        Thread.sleep(1000);

        interruptedStatus = true;
    }
}
