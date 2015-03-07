package lessons.multithreading.atomicQueue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class NotBlockingQueue<T> {

    static class Node<T> {
        T data;
        Node next;
        Node prev;

    }

    AtomicReference<Node> first = new AtomicReference<Node>(null);
    AtomicReference<Node> last = new AtomicReference<Node>(null);
    AtomicInteger size = new AtomicInteger(0);

    public NotBlockingQueue(){}

    public void add(T element) {
        Node<T> p = new Node<T>();
        Node temp = first.getAndSet(p);
        p.data = element;
        if (temp == null || last.get() == null) {
            last.set(p);
        } else {
            temp.prev = p;
            p.next = temp;
        }
        size.getAndIncrement();
    }

    public T remove() {
        if (last.get() == null) {
            return null;
        }

        Node<T> temp = last.getAndSet(last.get().prev);
        temp.prev = null;
        temp.next = null;
        size.decrementAndGet();
        return temp.data;

    }

    public int size() {
        return this.size();
    }
}

class Producer extends Thread {
    NotBlockingQueue<Integer> q;

    public Producer(NotBlockingQueue<Integer> q) {
        this.q = q;
    }

    public void run(){
        Integer i = 1;
        while (true) {

            q.add(i);
            System.out.println(i);
            i+=2;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer1 extends Thread {
    NotBlockingQueue<Integer> q;

    public Producer1(NotBlockingQueue<Integer> q) {
        this.q = q;
    }

    public void run(){
        Integer i = 2;
        while (true) {

            q.add(i);
            System.out.println(i);
            i+=2;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    NotBlockingQueue<Integer> q;

    public Consumer(NotBlockingQueue<Integer> q) {
        this.q = q;
    }

    public void run(){
        while (true) {
            Integer element = q.remove();
            System.out.println("Consumed " + element);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MainStart {
    public static void main(String... args) {
        NotBlockingQueue<Integer> q = new NotBlockingQueue<Integer>();
        Producer p = new Producer(q);
        Producer1 p1 = new Producer1(q);
        Consumer c = new Consumer(q);
        p.start();
        p1.start();
        c.start();
    }
}
public class Test {
}
