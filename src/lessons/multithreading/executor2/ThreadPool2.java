package lessons.multithreading.executor2;

import lessons.multithreading.executor.Workable;

import java.util.*;
import java.util.Queue;

//interface Workable {
//    public void work();
//}

//from nick

class ThreadPool {
    volatile Queue<Workable> works;
    static List<MyThread> workers = new LinkedList<MyThread>();

    static class MyThread extends Thread {
        Workable w;

        public void run() {
            while(!interrupted()) {
                synchronized(this) {
                    try{
                        while(w == null) {
                            System.out.println(Thread.currentThread().getName() + " waiting!");
                            wait();
                        }
                        workers.remove(this);
                        w.work();
                        w = null;
                        synchronized(workers) {
                            workers.add(this);
                            this.notify();
                        }
                    } catch (InterruptedException e) {
                        interrupt();
                    }
                }
            }
        }

        public void setWork(Workable w){
            this.w = w;
        }

        public void clearWork() {
            this.w = null;
        }
    }


    //constructor ThreadPool
    public ThreadPool (int counT, Queue<Workable> works) {
        this.works = works;

        for (int i = 0; i < counT; i++) {
            MyThread t = new MyThread();
            t.start();
            System.out.println(t.getName() + " run!");
            this.workers.add(t);
        }
    }

    public void execute() throws InterruptedException {
        while(true) {
            if (works.size() == 0) break;
            Workable w = works.poll();
            while(workers.size() == 0)
            {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            MyThread worker = workers.get(0);
            synchronized (worker) {
                //System.out.println(works);
                //System.out.println(worker.getName() + " get " + w);
                worker.setWork(w);
                worker.notify();
            }
            System.out.println("Work is getted by " + worker.getName());
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (Thread t : workers) {
            t.interrupt();
            System.out.println("Thread is interrupted");
        }
    }
}

class Execute {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        for (int i = 0; i < 10; i++) {
            queue.add(new Workable() {
                @Override
                public void work() {
                    try {
                        System.out.println(Thread.currentThread().getName() + " Work");
                        Thread.sleep(1000);
//                        ThreadPool.MyThread t = (ThreadPool.MyThread)Thread.currentThread();
//                        t.clearWork();
                        System.out.println(Thread.currentThread().getName() + " cleared");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        ThreadPool threadPool = new ThreadPool(2, queue);
        try {
            threadPool.execute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
