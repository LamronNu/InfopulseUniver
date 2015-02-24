package lessons.multithreading.executor;

import java.util.*;

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
                            workers.notify();
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
            System.out.println(t.getName() + " is start");
            this.workers.add(t);
        }
    }

    public void execute() throws InterruptedException {
        while(works.size() != 0){
            synchronized (workers) {
                while (workers.size() == 0) {
                    workers.wait();
                }
            }
            Workable w = works.poll();
            MyThread worker = workers.get(0);
            synchronized (worker) {
                worker.setWork(w);

                worker.notify();
           }
            System.out.println(worker.getName() + " get " + w);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (works.size() == 0) {
            System.out.println("Works is empty " + works);
        }
        for (int i = 0; i < workers.size(); i++){
            workers.get(i).interrupt();
            System.out.println(workers.get(i).getName() + " is interrupted");
        }
    }
}

