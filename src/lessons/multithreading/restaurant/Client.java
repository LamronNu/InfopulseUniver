package lessons.multithreading.restaurant;

import java.util.Queue;

class Client implements Runnable {
        Queue soup;
        Queue cake;
        Queue coffee;

        public Client(Queue soup, Queue cake, Queue coffee) {
            this.soup = soup;
            this.cake = cake;
            this.coffee = coffee;
        }

        public void run() {
            String elem = "";
            while (true) {
                //get soup
                synchronized (soup) {
                    while (soup.size() == 0) {
                        try {
                            soup.wait();
                        } catch (InterruptedException e) {/*NOP*/}
                    }
                    elem = (String) soup.poll();
                    soup.notifyAll();
                    System.out.println("We take a Soup " + elem
                            + ", client -- " + Thread.currentThread().getName());
                }
                //get cake
                synchronized (cake) {
                    while (cake.size() == 0) {
                        try {
                            cake.wait();
                        } catch (InterruptedException e) {/*NOP*/}
                    }
                    elem = (String) cake.poll();
                    cake.notifyAll();
                    System.out.println("We take a Cake " + elem
                            + ", client -- " + Thread.currentThread().getName());
                }

                //get Coffee
                synchronized (coffee) {
                    while (coffee.size() == 0) {
                        try {
                            coffee.wait();
                        } catch (InterruptedException e) {/*NOP*/}
                    }
                    elem = (String) coffee.poll();
                    coffee.notifyAll();
                    System.out.println("We take a Coffee " + elem
                            + ", client -- " + Thread.currentThread().getName());
                }
            }
        }
    }
