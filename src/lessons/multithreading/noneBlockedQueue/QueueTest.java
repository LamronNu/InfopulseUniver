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

    public T remove(){//remove first
        if (first == null){
            return null;
        }
        T value = first.getValue();
        Element next = first.getNext();
        first = next;
        size--;
        return value;
    }

    public T get(int position){
        if (position < 0 || position > size){
            return null;
        }
        int i = 0;
        Element<T> current = first;
        T value;
        do{
            value = current.getValue();
            current = current.getNext();
        }
        while (i++ != position);
        return value;
    }

    public void add(T value, int position){
        if (position < 0 || position >= size){
            add(value);//add to the end
            return;
        }
        if (position == 0){
            first = new Element(value, first);
            size++;
            return;
        }
        int pos = 0;
        Element<T> current = first;
        Element<T> previous = first;
        while (pos != position){
            previous = current;
            current = current.getNext();
            pos++;
        }
        previous.setNext(new Element(value, current));
        size++;

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
        System.out.println(q.get(0));
        q.add("000", 0);
        q.add("111", 1);
        System.out.println(q);
    }
}
