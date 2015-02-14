package lessons.multithreading.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;


public class ExampleProducerConsumer {


    public static void main(String[] args) throws InterruptedException {
        Queue q = new LinkedList();
        //producers
        Thread tp1 = new Thread(new lessons.multithreading.ProducerConsumer.Producer(q));
        Thread tp2 = new Thread(new lessons.multithreading.ProducerConsumer.Producer(q));
        Thread tp3 = new Thread(new lessons.multithreading.ProducerConsumer.Producer(q));
        //consumers
        Thread tc1 = new Thread(new lessons.multithreading.ProducerConsumer.Consumer(q));
        Thread tc2 = new Thread(new lessons.multithreading.ProducerConsumer.Consumer(q));
        //start threads
        tp1.start();
        tp2.start();
        tp3.start();
        tc1.start();
        tc2.start();

//        tp1.join();
//        tp2.join();
//        tp3.join();
//        tc1.join();
//        tc2.join();



    }
}
