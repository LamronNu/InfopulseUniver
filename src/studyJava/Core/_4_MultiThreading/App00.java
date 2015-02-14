package studyJava.Core._4_MultiThreading;

/**
 * Created by Olga on 18.06.2014.
 */
public class App00 {
    private  static  final int COUNT = 1;//Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) throws InterruptedException {

        int[] array = new int[10000000];
        array[1000] = 1;
        array[4000000] = 2;
        array[6000000] = 3;
        array[8000000] = 4;
        array[9000000] = 5;
        long t0 = System.currentTimeMillis();

        MyRunnable[] runners = new MyRunnable[COUNT];
        Thread[] threads = new Thread[COUNT];
        int len = array.length / COUNT;
        for (int k = 0; k < COUNT; k++) {
            runners[k] = new MyRunnable(array, len*k, len*(k+1));
            threads[k] = new Thread((runners[k]));
            threads[k].start();
        }
        for (int k = 0; k < COUNT; k++) {
            threads[k].join();
        }
        long t1 = System.currentTimeMillis();
        System.out.println("dt = " + (t1-t0));
        for (int k = 0; k < COUNT; k++) {
            System.out.println(runners[k].maxValue);
        }
    }
}

class MyRunnable implements Runnable{
    private final int[] array;
    private final int from;
    private final int to;
    public  volatile int maxValue;

    MyRunnable(int[] array, int from, int to) {
        this.array = array;
        this.from = from;
        this.to = to;
    }


    @Override
    public void run() {
        int currentMaxValue = array[from];
        for (int i = from +1; i < to; i++) {
            currentMaxValue = Math.max(currentMaxValue, array[i]);
        }
        maxValue = currentMaxValue;
    }
}
