package studyJava.Core._5_Collections.l_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olga on 26.06.2014.
 */
public class testList {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        System.out.println(list.size());
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("B");
        list.add("C");
        System.out.println(list);

        List<String> subList = list.subList(1,3);
        System.out.println(subList);
        System.out.println(list);

        list.add("X");
        System.out.println(subList);
//        System.out.println(list);

//        subList.add(0, "Y");
//        System.out.println(subList);
//        System.out.println(list);


    }
}
