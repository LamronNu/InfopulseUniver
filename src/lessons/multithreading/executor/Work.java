package lessons.multithreading.executor;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.Queue;

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
//            Thread.sleep(ms);
//        } catch (InterruptedException e) {}
        long sum = 0;
        for (int i = 0; i<ms*100; i++)
            sum += i;
        System.out.println("Work-" + id + " is finish. sum=" + sum);
        //((ThreadPool.MyThread)Thread.currentThread()).setWork(null);
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
