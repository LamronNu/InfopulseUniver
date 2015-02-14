package lessons.multithreading.ProducerConsumer.lesson;

import java.util.LinkedList;
import java.util.Queue;

class Test {
    public static void main(String[] args) {
        Queue q = new LinkedList();
        Producer p1 = new Producer(q);
        Producer p2 = new Producer(q);
        Consumer c1 = new Consumer(q);
        Consumer c2 = new Consumer(q);
        Consumer c3 = new Consumer(q);
        new Thread(p1).start();
        new Thread(p2).start();
        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();

    }
}