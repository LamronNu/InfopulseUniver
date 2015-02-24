package lessons.multithreading.executor;

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

    @Override
    public  void work() {
        System.out.println("Work-" + id + " is working... (" + Thread.currentThread().getName() + ")");
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
