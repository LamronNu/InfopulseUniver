package studyJava.Core._4_MultiThreading.intuit;



/**
 * Created by Olga on 27.06.2014.
 */
public class DaemonDemo extends Thread{

    public DaemonDemo() {
        super("DaemonDemo thread");
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        Thread threads[] = new  Thread[10];
        while(true){
            //get threads
            int count = ThreadTest_2.GROUP.activeCount();
            if (threads.length < count) {
                threads = new Thread[count + 10];
            }
            count = ThreadTest_2.GROUP.enumerate(threads);
            //print names
            for (int i = 0; i < count; i++) {
                System.out.print(threads[i].getName() + ", ");

            }
            System.out.println();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                /*NOP*/
            }
        }

    }

}
