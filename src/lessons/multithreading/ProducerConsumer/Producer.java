package lessons.multithreading.ProducerConsumer;

import java.util.Queue;

public class Producer implements Runnable{
    private Queue q;

    public Producer(Queue q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (q) {
                while (q.size() == 10) {
                    try {
                        q.wait();
                    } catch (InterruptedException e) {
                        System.err.println(e);
                    }
                }
                q.add("Object");
                System.out.println("put " + Thread.currentThread().getName());
                q.notifyAll();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }
    }
}
