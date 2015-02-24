package lessons.multithreading.executor;

import java.util.*;

interface Workable {
    public void work();
}


class ThreadPool{
    Queue<Workable> works;
    List<MyThread> workers = new LinkedList<MyThread>();
    class MyThread extends Thread{
        Workable w;
        public  void run(){
            while(!interrupted()){
                synchronized(this){
                    try{
                        while(w == null){
                            wait();
                        }
                        workers.remove(this);
                        w.work();
                        w = null;
                        synchronized(workers){
                            workers.add(this);
                        }

                    } catch (InterruptedException e){
                        interrupt();
                    }
                }
            }
        }
        public void setWork(Workable w){
            this.w = w;
        }
    }

    public ThreadPool (int counT, Queue<Workable> works){
        this.works = works;
        for (int i = 0; i < counT; i++) {
            MyThread t = new MyThread();
            t.start();
            this.workers.add(t);
        }
    }

    public void execute() throws InterruptedException {
        while(works.size() != 0){
            while (workers.size() == 0) {  }
            Workable w = works.poll();
            MyThread worker = workers.get(0);
            synchronized (worker) {
                worker.setWork(w);
                worker.notify();
           }
        }

        for (int i = 0; i < workers.size(); i++){
            workers.get(i).interrupt();
        }
    }
}

class Work implements Workable{
    int ms = 1000;
    static int count = 0;
    int id;
    public Work() {
        this.id = count++;
    }

    public Work(int s) {
        this();
        this.ms = s * 1000;
    }

    public int getMs() {
        return ms;
    }

    public void setMs(int ms) {
        this.ms = ms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public  void work() {
        System.out.println("Work-" + id + " is working... (" + Thread.currentThread().getName() + ")");//, sleep " + ms/1000 + " s)");
//        try {
//            Thread.currentThread().sleep(ms);
//        } catch (InterruptedException e) {}
        long sum = 0;
        for (int i = 0; i<ms*100; i++)
            sum += i;
        System.out.println("Work-" + id + " is finish. sum=" + sum);
    }

    @Override
    public String toString() {
        return "Work-" + id;
    }

    public static void main(String[] args) throws InterruptedException {
        Queue<Workable> q = new LinkedList<Workable>();
        for (int i = 0; i < 10; i++){
            q.add(new Work(i/2));
        }
        System.out.println(q);
        ThreadPool threadPool = new ThreadPool(4, q);
        threadPool.execute();
        //System.out.println("ok");
    }
}