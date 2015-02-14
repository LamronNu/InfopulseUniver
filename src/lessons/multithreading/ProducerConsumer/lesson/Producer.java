package lessons.multithreading.ProducerConsumer.lesson;

import java.util.Queue;

class Producer implements Runnable{
    Queue q;

    Producer(Queue q) {
        this.q=q;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (q) {
                while (q.size() > 10) {
                    try {
                        q.wait();
                    } catch (InterruptedException e) {

                    }
                }
                System.out.println("We put an element!" + Thread.currentThread());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                q.add(100);
                q.notifyAll();
            }
        }
    }
}
