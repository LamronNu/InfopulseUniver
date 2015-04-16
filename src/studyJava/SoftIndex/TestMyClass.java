package studyJava.SoftIndex;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class TestMyClass {
    MyMap myMap;

    @Before
    public void setUp(){
        myMap = new MyMap ();
    }

    @Test
    public void createNewObject(){
        //default constructor
        assertNotNull(myMap);
        //constructor with initial capacity
        myMap = new MyMap(100);
        assertNotNull(myMap);
        //constructor with initial capacity and loadfactor
        myMap = new MyMap(100, 0.6);
        assertNotNull(myMap);
    }


}
