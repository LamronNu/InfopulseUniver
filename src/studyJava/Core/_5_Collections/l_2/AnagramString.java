package studyJava.Core._5_Collections.l_2;

import java.util.Arrays;

/**
 * Created by Olga on 27.06.2014.
 */
public class AnagramString {
    private  String str;

    public AnagramString(String str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnagramString that = (AnagramString) o;

        if (this.str == null && that.str == null) return false;
        if (this.str != null && that.str == null) return false;
        if (this.str == null && that.str != null) return false;

        //if (!str.equals(that.str)) return false;
        //compare
        if (this.str.length() != that.str.length()) return false;
        char[] arr0 = this.str.toCharArray();
        char[] arr1 = that.str.toCharArray();
Arrays.sort(arr0);
        Arrays.sort(arr1);

        return Arrays.equals(arr0,arr1);
    }

    @Override
    public int hashCode() {
        return str.length();
    }

    @Override
    public String toString() {
        return str;
    }
}
