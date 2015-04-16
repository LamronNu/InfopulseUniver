package studyJava.SoftIndex;

public class MyMap {
    //consts
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.5f;

    private float loadFactor;
    private int capacity;

    public MyMap() {
       this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyMap(int initCapacity) {
        this(initCapacity, DEFAULT_LOAD_FACTOR);
    }

    public MyMap(int initCapacity, float loadFactor) {
        checkCapacity(initCapacity);
        checkLoadFactor(loadFactor);
        this.capacity = initCapacity;
        this.loadFactor = loadFactor;
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
}
