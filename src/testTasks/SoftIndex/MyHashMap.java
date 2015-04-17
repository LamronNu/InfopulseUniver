package testTasks.SoftIndex;

import java.util.NoSuchElementException;

/**
 * Summary.
 *
 * Class MyHashMap realizes the simple implementation of the algorithm
 * Hashmap with open addressing.
 * Keys type by Integer and values type by Long (for supporting of nulls in keys or values).
 * The size of the entry is fixed (map is not resizable).
 *
 * Map supports:
 * -- creating new map with default (16) or specified (not negative) capacity;
 * -- adding elements by key (if map`s size is lower than capacity);
 * -- if the map previously contained such key, the old value is NOT replaced;
 * -- getting values by key (throws exception if not exists or map is empty);
 * -- getting the current size of map;
 * -- clearing the map;
 * -- getting the string view of the map.
 */
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
        Integer key;    //for saving null
        Long value;     //for saving null

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

    /**
     * Default constructor: constructs an empty map with
     * an initial capacity of sixteen and load factor 0.5
     */
    public MyHashMap() {
       this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructs an empty map with the specified initial capacity.
     * @param initCapacity the initial capacity of the map
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    public MyHashMap(int initCapacity) {
        this(initCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Constructs an empty map with the specified initial capacity and loadfactor.
     * @param initCapacity  the initial capacity of the map
     * @param loadFactor    the load factor
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative or load factor is not in the district (0, 1)
     */
    public MyHashMap(int initCapacity, float loadFactor) {
        checkCapacity(initCapacity);
        checkLoadFactor(loadFactor);
        this.capacity = initCapacity;
        this.loadFactor = loadFactor;
        initBackets(initCapacity);
    }

    private void initBackets(int initCapacity) {
        this.backets = new Node[initCapacity];
//        for (int i = 0; i < initCapacity; i++) {
//            backets[i] = null;
//        }
    }

    private void checkLoadFactor(float factor) {
        if (factor <= 0 || factor >= 1) {
            throw new IllegalArgumentException("illegal value: " + factor);
        }
    }

    private void checkCapacity(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("illegal capacity: " + capacity);
        }
    }

    private int getArrayPos(int pos) {
        int result = pos % capacity;
        return result >= 0 ? result : -result;//or Math.abs(result);
    }

    private int getHashCode(Integer key) {
        return key != null ? 31 * key : 0;
    }


    //put
    /**
     * Add pair key-value to the map
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is not replaced.
     * If the map is full -- pair is not added.
     * @param key   specified the key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return true if pair was added otherwise return false
     */
    public boolean put(Integer key, Long value) {
        if (size == capacity)
            return false; //to do resize?

        int keyHashCode = getHashCode(key);
        int pos = getArrayPos(keyHashCode);
        Node curNode;
        while ((curNode = backets[pos]) != null) {
            if (curNode.key == key)
                return false;//not replace -- just not add??
            pos++;
            pos = getArrayPos(pos);
        }
        backets[pos] = new Node(key, value);
        size++;
        return true;
    }

    //size
    /**
     * Returns the number of key-value mappings in this map
     * @return size of map
     */
    public int size() {
        return size;
    }

    //get

    /**
     * Returns the value to which the specified key is mapped
     * @param key specified the key for which it must be value
     * @return value for key (if it exists) otherwise throw exception
     * @throws NullPointerException if map is empty
     * @throws java.util.NoSuchElementException if there are no such key in this map
     * @see #put(java.lang.Integer, java.lang.Long)
     */
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
    /**
     * clear this map (creating new entry)
     */
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
