package studyJava.Core._1_pcocedural.proc_1;

import java.util.Arrays;

/**
 * Created by Olga on 26.05.2014.
 */
public class TestMerger {
    public static void main(String[] args) {
        //1
        SortByBubble.sort();
        //2
        int[][][] data = {
                {{}, {}},
                {{0}, {}},
                {{}, {0}},
                {{0}, {0}},
                {{0, 2}, {1, 3}},
                {{0, 2, 7, 9, 123}, {1, 3, 4, 5, 6}},
        };
        for (int[][] origin : data) {
            int[] left = origin[0];
            int[] right = origin[1];
            int[] merged = Merger.merge(left, right);
            System.out.println(
                    Arrays.toString(left) +
                            " + " +
                            Arrays.toString(right) +
                            " -> " +
                            Arrays.toString(merged));
            System.out.println();
        }
    }
}
