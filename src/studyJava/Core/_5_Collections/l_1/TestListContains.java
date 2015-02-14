package studyJava.Core._5_Collections.l_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Olga on 26.06.2014.
 */
public class TestListContains {
    public static void main(String[] args) {
        long t0, t1;
        List<String> list;
        //ArrayList
        list = new ArrayList();
        for (int k = 0; k < 10000; k++) {
            list.add("" + k);
        }

        t0 = System.currentTimeMillis();
        testListContains(list);
        t1 = System.currentTimeMillis();
        System.out.println("ArrayList: " + (t1 - t0));

        //ArrayList
        list = new LinkedList();
        for (int k = 0; k < 10000; k++) {
            list.add("" + k);
        }

        t0 = System.currentTimeMillis();
        testListContains(list);
        t1 = System.currentTimeMillis();
        System.out.println("LinkedList: " + (t1 - t0));



    }

    private static void testListContains(List<String> list) {
        for (int k = 0; k < 10000; k++) {
            list.contains("XYZ");
        }
    }
}
