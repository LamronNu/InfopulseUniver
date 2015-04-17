package testTasks.SoftIndex;

import java.util.NoSuchElementException;

public class MyHashMap {
    //consts
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.5f;

    private float loadFactor;
    private int capacity;
    private int size = 0;
    private Node[] backets;




    //inner class
    class Node {
        Integer key;    //for null
        Long value;     //for null

        public Node(Integer key, Long value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "(" + key +
                    ", " + value +')';
        }
    }

    //constructors
    public MyHashMap() {
       this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initCapacity) {
        this(initCapacity, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initCapacity, float loadFactor) {
        checkCapacity(initCapacity);
        checkLoadFactor(loadFactor);
        this.capacity = initCapacity;
        this.loadFactor = loadFactor;
        initBackets(initCapacity);
    }

    private void initBackets(int initCapacity) {
        this.backets = new Node[initCapacity];
        for (int i = 0; i < initCapacity; i++) {
            backets[i] = null;
        }
    }

    private void checkLoadFactor(float factor) {
        if (factor <= 0 || factor >= 1) {
            throw new IllegalArgumentException("illegal value: " + factor);
        }
    }

    private void checkCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("negative value: " + capacity);
        }
    }

    private int getArrayPos(int pos) {
        int result = pos % capacity;
        return result >= 0 ? result : -result;//or Math.abs(result);
    }

    private int getHashCode(Integer key) {
        return key != null ? 31 * key + 1: 0;
    }

    //put
    public boolean put(Integer key, Long value) {
        if (size == capacity)
            return false; //todo resize
        int keyHashCode = getHashCode(key);
        int pos = getArrayPos(keyHashCode);
        Node curNode;
        while ((curNode = backets[pos]) != null) {
            if (curNode.key == key)
                return false;
            pos++;
            pos = getArrayPos(pos);
        }
        backets[pos] = new Node(key, value);
        size++;
        return true;
    }
    //size
    public int size() {
        return size;
    }
    //get
    public Long get(Integer key) {
        if (size == 0)
            throw new NullPointerException("map is empty");
        int keyHashCode = getHashCode(key);
        int pos = getArrayPos(keyHashCode);
        Node curNode;
        int attempts = 0;
        while (attempts < capacity
                && ((curNode = backets[pos]) == null
                    || curNode.key != key)) {
            attempts++;
            //pos++;
            pos = getArrayPos(++pos);
        }

        if (attempts == capacity)
            throw new NoSuchElementException("key=" + key);
        Long value = backets[pos].value;
        size--;
        return value;
    }
    //clear
    public void clear() {
        initBackets(capacity);
        size = 0;
    }

    @Override
    public String toString() {
        String result = "MyHashMap{" + capacity +
                ":[" ;
        for (int i = 0; i < backets.length; i++) {
            result+=backets[i] + (i==backets.length-1?"]":", ");

        }
        return result;
    }
}
