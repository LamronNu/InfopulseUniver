package studyJava.Core._1_pcocedural.proc_2;

import java.util.Arrays;

/**
 * Created by Olga on 26.05.2014.
 */
public class Permutator {
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3};
        permute(arr, arr.length);
    }

    public static void permute(int[] arr, int size) {
        if (size < 2) {
            System.out.println((Arrays.toString(arr)));
        } else {
            for (int k = size - 1; k >= 0; k--) {
                swap(arr, k, size - 1);
                permute(arr, size - 1);
                swap(arr, k, size - 1);
            }
        }
    }

    private static void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[first] = array[second];
        array[second] = tmp;
    }


}
