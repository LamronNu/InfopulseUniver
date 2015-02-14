package lessons.multithreading.ProducerConsumer.lesson;

import java.util.Queue;

class Consumer implements Runnable {
    Queue q;

    Consumer(Queue q) {
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

                    }
                }
                System.out.println("We take the element!" + Thread.currentThread());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                q.poll();
                q.notifyAll();
            }
        }
    }
}
