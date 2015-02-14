package studyJava.Core._5_Collections.l_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Olga on 27.06.2014.
 */
public class Anagram {
    public static void main(String[] args) {
        String string = "aa ab bbb ba bb ca ac cc";
        String[] arr = string.split(" ");
        System.out.println(Arrays.toString(arr));
        Set<AnagramString> set = new HashSet<AnagramString>();
        for (String elem:arr) {
            set.add(new AnagramString((elem)));

        }
        System.out.println(set);
                
        
    }

}
