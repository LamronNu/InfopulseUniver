package lessons.multithreading.semaphore;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Semaphore1 {
    int value;
    Set<Thread> q = new HashSet<Thread>();
    Queue<Thread> sleepThreads = new LinkedList<Thread>();

    public Semaphore1(int value){
        this.value = value;
    }

    public synchronized void aquire() throws InterruptedException{

        if (q.contains(Thread.currentThread())){
            throw new IllegalStateException();
        }
        q.add(Thread.currentThread());
        sleepThreads.add(Thread.currentThread());

        while (!(value != 0 && sleepThreads.element()== Thread.currentThread())){

            System.out.println(Thread.currentThread() + " is waiting for semaphore");
            this.wait();


        }

        value--;


    }

    public  synchronized void release() {

        if(!q.contains(Thread.currentThread())){
            throw new IllegalStateException();
        }
        q.remove(Thread.currentThread());

        value++;

        this.notifyAll();
    }

}

class MyThread1 extends Thread{
    Semaphore1 s;
    public MyThread1(Semaphore1 s){
        this.s = s;
    }

    public void run(){
        while (true){
            try {
                s.aquire();
                System.out.println(Thread.currentThread() + " takes semaphore");
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }finally{
                s.release();
            }

        }
    }
}

public class Test{
    public static void main (String[] args){
        Semaphore1 s = new Semaphore1(3);
        new MyThread1(s).start();
        new MyThread1(s).start();
        new MyThread1(s).start();
        new MyThread1(s).start();
        new MyThread1(s).start();
        new MyThread1(s).start();


    }
}


