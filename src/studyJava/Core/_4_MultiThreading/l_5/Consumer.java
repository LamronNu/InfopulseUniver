package studyJava.Core._4_MultiThreading.l_5;

/**
 * Created by Olga on 26.06.2014.
 */
public class Consumer implements Runnable {
    private final SingleElementBuffer buffer;

    public Consumer( SingleElementBuffer buffer){
       this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true){
            try {
                Integer elem = buffer.get();
                System.out.println(elem + " consumed");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " was interrupted");
                break;
            }
        }
    }
}
