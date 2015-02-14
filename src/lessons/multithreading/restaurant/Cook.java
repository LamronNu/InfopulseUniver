package lessons.multithreading.restaurant;

import java.util.Queue;

class Cook implements Runnable {
        Queue soup;
        Queue cake;
        Queue coffee;

        public Cook(Queue soup, Queue cake, Queue coffee) {
            this.soup = soup;
            this.cake = cake;
            this.coffee = coffee;
        }

        public void run() {
            while (true) {
                //add soup
                synchronized (soup) {
                    while (soup.size() > 10) {
                        try {
                            soup.wait();
                        } catch (InterruptedException e) {/*NOP*/}
                    }

                    soup.add("" + soup.size());
                    soup.notifyAll();
                    System.out.println("We cook a Soup " + (soup.size() - 1)
                            + ", cook -- " + Thread.currentThread().getName());
                }
                //add cake
                synchronized (cake) {
                    while (cake.size() > 10) {
                        try {
                            cake.wait();
                        } catch (InterruptedException e) {/*NOP*/}
                    }
                    cake.add("" + cake.size());
                    cake.notifyAll();
                    System.out.println("We cook a Cake " + (cake.size() - 1)
                            + ", cook -- " + Thread.currentThread().getName());
                }
                //add Coffee
                synchronized (coffee) {
                    while (coffee.size() > 10) {
                        try {
                            coffee.wait();
                        } catch (InterruptedException e) {/*NOP*/}
                    }
                    coffee.add("" + coffee.size());
                    coffee.notifyAll();
                    System.out.println("We cook a Coffee " + (coffee.size() - 1)
                            + ", cook -- " + Thread.currentThread().getName());
                }
            }
        }
    }
