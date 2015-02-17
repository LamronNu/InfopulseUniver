package lessons.multithreading.semaphore;
import org.apache.log4j.Logger;

import java.util.*;

class Semaphore {
    private static final Logger log = Logger.getLogger(Semaphore.class);
    int value;
    Set<Thread> activeThreads = new HashSet<Thread>();
    Queue<Thread> sleepThreads = new LinkedList<Thread>();

    public Semaphore(int value) {
        this.value = value;
    }

    public synchronized void acquire() throws InterruptedException {

        if (activeThreads.contains(Thread.currentThread())) { //when method is called twice
            throw new IllegalStateException();
        }
        //check
        Thread currentThread = Thread.currentThread();
        //while()
        if (sleepThreads.size() != 0                     //if exists sleeping threads
                && !sleepThreads.contains(currentThread) //and current is not in queue
                && value != 0){                         //but value>0

            sleepThreads.add(currentThread);            //add it to queue
            log.info("    !!!" + currentThread.getName() + " add to"
                    + " sleepThreads: " + sleepThreads);
//            log.info(currentThread.getName() + " is waiting for semaphore");
            wait();

            while (sleepThreads.element()!= null
                    && sleepThreads.element() != Thread.currentThread()) {
                wait();
            }
           // if (value == 0){break;}
                Thread pt = sleepThreads.poll();
                log.info("    " + pt.getName() + " remove from"
                        + " sleepThreads: " + sleepThreads);

        }
        while (value == 0) {
            if (!sleepThreads.contains(currentThread)){
                sleepThreads.add(currentThread);

                log.info("    " + currentThread.getName() + " add to"
                        + " sleepThreads: " + sleepThreads);
            }
//            log.info(currentThread.getName() + " is waiting for semaphore");
            wait();
            while (sleepThreads.element() != null
                    && sleepThreads.element() != Thread.currentThread()) {
                wait();
            }

            Thread pt = sleepThreads.poll();
            log.info("    " + pt.getName() + " remove from"
                    + " sleepThreads: " + sleepThreads);
        }




        activeThreads.add(Thread.currentThread()); //remember
        value--;
        log.debug("    " + "acquire: " + value + " (" +
                currentThread.getName() + ")" +
                ", sleepThreads: " + sleepThreads);
    }

    public synchronized void release() throws InterruptedException {

        if (!activeThreads.contains(Thread.currentThread())) {
            throw new IllegalStateException();
        }
        activeThreads.remove(Thread.currentThread());

        value++;
//        log.info(Thread.currentThread().getName() + " takes semaphore");
        log.debug("    " + "release: " + value + " (" +
                Thread.currentThread().getName() + ") " +
                ", sleepThreads: " + sleepThreads);

        this.notifyAll();

        //--

//        sleepThreads.add(Thread.currentThread());
//        log.info("    " + Thread.currentThread().getName() + " add to"
//                + " sleepThreads: " + sleepThreads);
        //this.wait();//--
    }

}

class MyThread extends Thread{
    private static final Logger log = Logger.getLogger(MyThread.class);
    Semaphore s;
    public MyThread(Semaphore s){
        this.s = s;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    public void run(){
        while (true){
            try {
//                log.info(Thread.currentThread().getName() + " tries to take semaphore");
                s.acquire();
//                log.info(Thread.currentThread().getName() + " takes semaphore");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            } finally{
//                log.info(Thread.currentThread().getName() + " release semaphore");
                try {
                    s.release();
                } catch (InterruptedException e) {
                    /*NOP*/
                }
            }
        }
    }
}

class TestSemaphore {
    private static final Logger log = Logger.getLogger(TestSemaphore.class);
    private static final int capacityS = 3;
    private static final int countT = 7;

    public static void main (String[] args) throws InterruptedException {
        log.info("---------------------");
        log.info("start test Semaphore ");
        log.info("capacity of semaphore: " + capacityS);
        log.info("count threads: " + countT);
        log.info("---------------------");
        Semaphore s = new Semaphore(capacityS);
        for (int i = 0; i < countT; i++) {
            log.info("start thread " + i);
            new MyThread(s).start();


        }
        //System.out.println(Thread.currentThread().getContextClassLoader().getResource("__log4j.properties"));
        Thread.sleep(5*1000);
        log.info("---------------------");
        System.exit(-1);



    }
}
