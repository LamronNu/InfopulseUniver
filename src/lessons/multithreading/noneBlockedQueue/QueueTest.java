package lessons.multithreading.noneBlockedQueue;

class Element<T>{
    private T value;
    private Element next;

    public Element(T value, Element next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Element getNext() {
        return next;
    }

    public void setNext(Element next) {
        this.next = next;
    }
}

class NoneBlockedQueue<T>{
    private int size;
    private Element<T> first;
    private Element<T> last;

    public NoneBlockedQueue() {
    }

    public T getFirst(){
        return first == null ? null : first.getValue();
    }

    public T getLast(){
        return last == null ? null : last.getValue();
    }

    public int size(){
        return size;
    }

    public void add(T value){//add to the end
        Element element = new Element(value, null);
       if (first == null){
           first = element;
           last = element;
       }
        if (last == null){
            last = element;
        } else {
            last.setNext(element);
            last = element;
        }
        size++;
    }

    public Object remove(){//remove first
        if (first == null){
            return null;
        }
        T value = first.getValue();
        Element next = first.getNext();
        first = next;
        size--;
        return value;
    }

    @Override
    public String toString() {
        String result = "[";
        Element element = first;
        while (element != null){
            result += element.getValue().toString()
                    + ((element != last)? ", " : "]" );
            element = element.getNext();
        }
        return result;
    }
}

public class QueueTest {
    public static void main(String[] args) {
        NoneBlockedQueue q = new NoneBlockedQueue<String>();
        q.add("AAA");
        q.add("BBB");
        q.add("CCC");
        q.add("DDD");
        System.out.println(q);

    }
}
