package lessons.multithreading.semaphore;

import org.apache.log4j.Logger;

import java.util.LinkedList;

class Barrier {
    private static final Logger log = Logger.getLogger(Barrier.class);
    int value;
    private int barrier;
    private LinkedList<Thread> waitingThreads = new LinkedList<Thread>();

    public Barrier(int value) {
        this.value = value;
        this.barrier = value;
    }

    public synchronized void await() throws InterruptedException {

        if (waitingThreads.contains(Thread.currentThread())) { //when method is called twice
            throw new IllegalStateException();
        }
        Thread currentThread = Thread.currentThread();
        while (value == 0) { //  means that waitingThreads.size() == barrier
            log.info("  !!!" + currentThread.getName() + " is waiting.... "
                    + " waitingThreads: " + waitingThreads
                    + " value = " + value);
            //notifyAll();
            wait();

        }

        value--;


        if (!waitingThreads.contains(currentThread)){
            waitingThreads.add(currentThread);
            log.info(currentThread.getName() + " add to"
                    + " waitingThreads: " + waitingThreads
                    + " value = " + value);
        }
        if (value == 0) { //  means that waitingThreads.size() == barrier
            log.info(currentThread.getName() + " notify to "
                    + " waitingThreads: " + waitingThreads
                    + " value = " + value);
            notifyAll();
            //wait();

        }
        while (value != 0){

            wait();
            log.info(currentThread.getName() + " wake up!"
                    + ", waitingThreads: " + waitingThreads);
            if (value == 0) {
                while (waitingThreads.size() != 0) {
                    Thread pt = waitingThreads.poll();
                    log.info("    " + pt.getName() + " remove from"
                            + " waitingThreads: " + waitingThreads);
                    notifyAll();//??
                    //?? start???
                }
                value = barrier;
            }
        }




//
//        log.debug("    " + "await: " + value +
//                ", waitingThreads: " + waitingThreads);
    }



    public synchronized void release() {

        if (!waitingThreads.contains(Thread.currentThread())) {
            throw new IllegalStateException();
        }
        //waitingThreads.remove(Thread.currentThread());

        //value++;

//        log.debug("    " + "release: " + value + " (" +
//                Thread.currentThread().getName() + ") " +
//                ", sleepThreads: " + sleepThreads);

        this.notifyAll();
    }

}

class TestThread extends Thread{
    private static final Logger log = Logger.getLogger(TestThread.class);
    Barrier b;
    public TestThread(Barrier b){
        this.b = b;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public void run(){
        while (true){
            try {
//               log.info(Thread.currentThread().getName() + " tries to take semaphore");
                b.await();
                log.info(Thread.currentThread().getName() + " takes barrier");
                Thread.sleep(1000);
            } catch (InterruptedException e) {/*NOP*/
            }
          finally{
                log.info(Thread.currentThread().getName() + " end");
//                b.release();
           }
        }
    }
}
public class TestBarrier {
    private static final Logger log = Logger.getLogger(TestBarrier.class);
    private static final int capacityB = 3;
    private static final int countT = 7;

    public static void main(String[] args) throws InterruptedException {
        log.info("---------------------");
        log.info("start test Barrier ");
        log.info("capacity of Barrier: " + capacityB);
        log.info("count of threads: " + countT);
        log.info("---------------------");
        Barrier s = new Barrier(capacityB);
        for (int i = 0; i < countT; i++) {
            log.info("start thread " + i);
            new TestThread(s).start();


        }
        //System.out.println(Thread.currentThread().getContextClassLoader().getResource("__log4j.properties"));
        Thread.sleep(10 * 1000);
        log.info("---------------------");
        System.exit(-1);
    }
}
