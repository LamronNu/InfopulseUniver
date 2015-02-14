package studyJava.Core._1_pcocedural.proc_1;

import java.util.Arrays;

/**
 * Created by Olga on 26.05.2014.
 */
public class SortByBubble {
    public static void sort(){
        int[] data = {10, 20, 30, 40, 50};
        //System.out.println(data.length);
        //for (int border = data.length - 1; border >= 0; border--) {
            for (int index = data.length / 2; index >= 0 ; index--) {
                //if (data[index] > data[index + 1]) {
                    swap(data, index, data.length - 1 - index);
                //}
                //System.out.print(index);
            }
            //System.out.println(Arrays.toString(data));
        //}
        //System.out.println("---");
        System.out.println(Arrays.toString(data));
    }

    private static void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }
}