package mockTests;

import org.apache.log4j.Logger;

public class mock4 {
    private static final Logger log = Logger.getLogger(mock4.class);
}

class Cruiser {
    private int a = 0;

    public void foo() {
        Runnable r = new LittleCruiser();
        new Thread(r).start();
        new Thread(r).start();
    }

    public static void main(String arg[]) {
        Cruiser c = new Cruiser();
        c.foo();
    }

    public class LittleCruiser implements Runnable {
        public void run() {
            int current = 0;
            for (int i = 0; i < 4; i++) {
                current = a;
                System.out.print(current + ", ");
                a = current + 2;
            }
        }
    }
}
