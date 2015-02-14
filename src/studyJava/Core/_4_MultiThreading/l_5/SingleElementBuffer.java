package studyJava.Core._4_MultiThreading.l_5;

/**
 * Created by Olga on 26.06.2014.
 */
public class SingleElementBuffer {
    private Integer elem = null;

    public synchronized void put(int newElem) throws InterruptedException {
        while (this.elem != null){
            this.wait();
        }
        this.elem = newElem;
        this.notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (elem == null){
            this.wait();
        }
        Integer result = this.elem;
        this.elem = null;
        this.notifyAll();
        return result;
    }
}
