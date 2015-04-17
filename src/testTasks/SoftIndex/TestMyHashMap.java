package testTasks.SoftIndex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.Assert.*;

public class TestMyHashMap {
    MyHashMap map;
    Random random;

    @Before
    public void setUp(){
        map = new MyHashMap();
        random = new Random();
    }

    @After
    public void tearDown(){
        map.clear();
    }

    //creating map
    @Test
    public void createNewObject(){
        //default constructor
        assertNotNull(map);
        //constructor with initial capacity
        map = new MyHashMap(100);
        assertNotNull(map);
        //constructor with initial capacity and loadfactor
        map = new MyHashMap(100, 0.6f);
        assertNotNull(map);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createNewObjectWithIllegalCapacity(){
        map = new MyHashMap(-100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createNewObjectWithIllegalLoadFactor(){
        map = new MyHashMap(100, 1.2f);
    }

    //put
    @Test
    public void putNulls(){
        //first null key
        assertTrue(map.put(null, 1l));
        //second -- not put
        assertFalse(map.put(null, 3l));
        //first null value
        assertTrue(map.put(1, null));
        //second -- also put
        assertTrue(map.put(3, null));
    }

    @Test
    public void putValues(){
        //first 16 keys
        for (int i = 0; i < 16; i++) {
            assertTrue(map.put(i, random.nextLong()));
        }
        //not put
        assertFalse(map.put(random.nextInt(), random.nextLong()));
    }

    //size
    @Test
    public void resize(){
        assertEquals(0, map.size());
        //first 16 keys
        for (int i = 0; i < 16; i++) {
            map.put(i, random.nextLong());
            assertEquals(i+1, map.size());
        }
        assertEquals(16, map.size());
        //not put
        assertFalse(map.put(random.nextInt(), random.nextLong()));
        assertEquals(16, map.size());
    }


    //get
    @Test(expected = NullPointerException.class)
    public void getFromEmptyMap(){
        map.get(0);
    }

    @Test(expected = NoSuchElementException.class)
     public void getNotExistsElement(){
        map.put(1, 1l);
        map.get(0);
    }

    @Test
    public void getNulls(){
        //put some nulls (according to the test putNulls)
        map.put(null, 1l); //put
        map.put(null, 3l);//not put
        map.put(1, null);//put
        map.put(3, null);//put
        //check
        assertEquals((Long)1l, map.get(null));
        assertEquals(null, map.get(1));
        assertEquals(null, map.get(3));
    }

    @Test
    public void getValues(){
        long[] testArray = new long[16];
        long curValue;
        //put values
        for (int i = 0; i < 16; i++) {
            curValue = random.nextLong();
            map.put(i, curValue);
            testArray[i] = curValue;
        }
        //check
        for (int i = 0; i < 16; i++) {
            assertEquals((Long)testArray[i], map.get(i));
        }
    }

}
