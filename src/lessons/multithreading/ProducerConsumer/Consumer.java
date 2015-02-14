package lessons.multithreading.ProducerConsumer;

import java.util.Queue;

public class Consumer implements Runnable{
    private Queue q;

    public Consumer(Queue q) {
        this.q = q;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (q) {
                while (q.size() == 0) {
                    try {
                        q.wait();
                    } catch (InterruptedException e) {
                        System.err.println(e);
                    }
                }
                q.poll();
                System.out.println("get " + Thread.currentThread().getName());
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
