package studyJava.Core._1_pcocedural.proc_1;

/**
 * Created by Olga on 26.05.2014.
 */
public class Merger {
    public static int[] merge(int[] a, int[] b) { // wrong!
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex < a.length && bIndex < b.length) {
                result[aIndex + bIndex] = (a[aIndex] < b[bIndex])
                        ? a[aIndex++] : b[bIndex++];
        }
        if (aIndex == a.length) {
            System.arraycopy(b, bIndex, result, aIndex + bIndex, result.length - aIndex - bIndex);
        } else {
            System.arraycopy(a, aIndex, result, aIndex + bIndex, result.length - aIndex - bIndex);
        }
        return result;
    }
}
