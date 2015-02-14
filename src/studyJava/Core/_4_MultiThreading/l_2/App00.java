package studyJava.Core._4_MultiThreading.l_2;

/**
 * Created by Olga on 19.06.2014.
 */
public class App00 {
    public static void main(String[] args) {
        System.out.println("Thread.activeCount(): " + Thread.activeCount());
        Thread[] array = new Thread[Thread.activeCount()];
        Thread.enumerate(array);
        for (Thread t: array){
            System.out.println(t);
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("!");
            }
        }).start();

        while ((true));
    }
}
class  X implements Runnable{
    @Override
    public void run() {
        System.out.println("!");
    }
}
