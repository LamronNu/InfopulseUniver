package labs.task2_Strings;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Interval extends Lexeme{
    private static final List<Character> marks =
            new ArrayList(Arrays.asList( '.', ',', '!', '?' ));

    public static boolean isPunctuationMark(char ch) {
        return (marks.contains(ch));
    }
}

class Word extends Lexeme     {
    public String value;
    public int length;
    public Word() {
    }
    public Word(String str)   {
        this.value = str;
    }


}


public class Test {
    private static final Logger log = Logger.getLogger(Test.class);
}
