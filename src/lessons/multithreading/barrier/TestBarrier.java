package lessons.multithreading.barrier;

import java.util.LinkedList;
import java.util.List;

class Barrier{
    int maxValue;
    volatile boolean flag=false;
    List<Thread> active=new LinkedList<Thread>();
    public Barrier(int value){
        this.maxValue=value;
    }

    public void acquire() throws InterruptedException{
        synchronized(this){


            while(!flag){
                //System.out.println("ok1");
                active.add(Thread.currentThread());
                while(!flag && active.size()!=maxValue){

                    this.wait();
                }
                flag=true;
                this.notifyAll();
            }
            if(!flag || active.contains(Thread.currentThread())){
                //System.out.println("ok");
                active.remove(Thread.currentThread());
                /// System.out.println(active.size());
                if(active.size()==0){
                    flag=false;

                }
            }
        }
    }
}

class MyThread extends Thread{
    Barrier b;
    public MyThread(Barrier b){
        this.b=b;
    }

    public void run(){

        System.out.println("Thread "+Thread.currentThread()+" try to take barrier");
        try {

            b.acquire();
        } catch (InterruptedException ex) {

        }
        System.out.println("Thread "+Thread.currentThread()+" continue running");
    }
}

public class TestBarrier {


    public static void main(String[] args) throws InterruptedException {
        Barrier b=new Barrier(2);
        MyThread t1=new MyThread(b);
        MyThread t2=new MyThread(b);
        MyThread t3=new MyThread(b);
        MyThread t4=new MyThread(b);
        MyThread t5=new MyThread(b);
        MyThread t6=new MyThread(b);
        t1.start();
        t2.start();
        Thread.sleep(2000);
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }

}


