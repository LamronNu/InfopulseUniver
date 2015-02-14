package lessons.multithreading.restaurant;

import java.util.LinkedList;
import java.util.Queue;

public class Restaurant{

    public static void main(String[] args) {
        //counts
        int clientsCount = 10;
        int cookersCount = 2;

        //queues
        Queue soup = new LinkedList();
        Queue cake = new LinkedList();
        Queue coffee = new LinkedList();

        //clients
        for (int i = 0; i < clientsCount; i++) {
            new Thread(new Client(soup, cake, coffee)).start();
        }

        //cookers
        for (int i = 0; i < cookersCount; i++) {
            new Thread(new Cook(soup, cake, coffee)).start();
        }
    }
}
