package test.lessons.multithreading;

import lessons.multithreading.skiplist.SkipList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class TestSkipList {

    SkipList<Integer> skipList;

    @Before
    public void setUp(){
        skipList = new SkipList<Integer>();
    }

    @Test
    public void createNewObject(){
        assertNotNull(skipList);
    }

    @Test
     public void addOneValue(){
        skipList.add(0);
        assertNotNull(skipList);
        assertTrue(0 == skipList.get());
        assertTrue(1 == skipList.size());
        assertTrue(1 == skipList.levels());
    }

    @Test
    public void addTwoValuesAsc(){
        skipList.add(0);
        skipList.add(10);
        assertNotNull(skipList);
        assertTrue(0 == skipList.get());
        assertTrue(2 == skipList.size());
        assertTrue(1 == skipList.levels());
    }

    @Test
    public void addTwoValuesDesc(){
        skipList.add(10);
        skipList.add(0);
        assertNotNull(skipList);
        assertEquals((Integer) 0, skipList.get());
        assertEquals(2, skipList.size());
        assertEquals(1, skipList.levels());
    }

    @Test
     public void addThreeValuesAsc(){
        skipList.add(0);
        skipList.add(10);
        skipList.add(40);
        assertNotNull(skipList);
        assertEquals((Integer) 0, skipList.get());
        assertEquals(3, skipList.size());
        //assertEquals(skipList.toString(), 1, skipList.levels());
    }
    @Test
     public void addThreeValuesDesc(){
        skipList.add(40);
        skipList.add(10);
        skipList.add(0);
        assertNotNull(skipList);
        assertEquals((Integer) 0, skipList.get());
        assertEquals(3, skipList.size());
//        assertEquals(1, skipList.levels());
    }
    @Test
     public void addThreeValuesAnyOrder213(){
        skipList.add(10);
        skipList.add(0);
        skipList.add(40);
        assertNotNull(skipList);
        assertEquals((Integer) 0, skipList.get());
        assertEquals(3, skipList.size());
//        assertEquals(1, skipList.levels());
    }
    @Test
    public void addThreeValuesAnyOrder312(){
        skipList.add(40);
        skipList.add(0);
        skipList.add(10);
        assertNotNull(skipList);
        assertEquals((Integer) 0, skipList.get());
        assertEquals(3, skipList.size());
//        assertEquals(1, skipList.levels());
    }
    @Test
     public void addThreeEqualValues(){
        skipList.add(0);
        skipList.add(0);
        skipList.add(0);
        assertNotNull(skipList);
        assertEquals((Integer) 0, skipList.get());
        assertEquals(3, skipList.size());
//        assertEquals(1, skipList.levels());
    }
    @Test
     public void addTenValuesAsc(){
        for (int i = 0; i < 10; i++){
            skipList.add(i);
        }
        assertNotNull(skipList);
        assertEquals((Integer) 0, skipList.get());
        assertEquals(10, skipList.size());
//        assertEquals(1, skipList.levels());
    }
}
