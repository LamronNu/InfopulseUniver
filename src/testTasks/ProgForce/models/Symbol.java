package testTasks.ProgForce.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Symbol {
    //consts
    private static final List<Character> PUNCTUATION_MARKS =
            new ArrayList(Arrays.asList(' ', '.', ',', '!', '?', ':', '"', ';',
                    '-', '\n', '\t', '—'));

//            new ArrayList(Arrays.asList(" -.,!?:\"';\\n\\t".toCharArray()));

    public static final List<Character> SENTENCE_END_MARKS =
            new ArrayList(Arrays.asList('.', '!', '?'));

    private static final List<Character> DIGITS =
           new ArrayList(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));

    //field
    private char value;
    protected static boolean caseSensitive = false;


    //constructors
    public Symbol() {
    }
    public Symbol(char ch)  {
        this.value = ch;
    }

    @Override
    public String toString() {
        return "" + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        return value == symbol.value;
    }

    @Override
    public int hashCode() {
        return (int) value;
    }

    //getters-setters
    public String getValue() {//????
        return "" + value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public static void setCaseSensitive(boolean value) {
        caseSensitive = value;
    }

    public static boolean getCaseSensitive() {
        return caseSensitive;
    }
    /**
     * for deciding is value a punctuation mark (between words)
     * @param ch -- checked value
     * @return true if @ch is a punctuation mark, otherwise return false
     */
    public boolean isPunctuationMark(char ch) {
        return (PUNCTUATION_MARKS.contains(ch));
    }

    /**
     * for deciding is Symbol (as object) is an object of a punctuation mark
     * @return true if @value is a punctuation mark (specified in PUNCTUATION_MARKS),
     * otherwise return false
     */
    public boolean isPunctuationMark() {
        return isPunctuationMark(value);//or(PUNCTUATION_MARKS.contains(ch));
    }

    /**
     * for deciding is value is the end of sentence (between sentences)
     * @param ch -- checked value
     * @return true if @ch is an end of sentence, otherwise return false
     */
    public boolean isSentenceEnd(char ch) {
        return (SENTENCE_END_MARKS.contains(ch));
    }

    /**
     * for deciding is Symbol (as object) is an object of the end of sentence (between sentences)
     * @return true if value is an end of sentence, otherwise return false
     */
    public boolean isSentenceEnd() {
        return isSentenceEnd(value);//or (SENTENCE_END_MARKS.contains(value));
    }

    /**
     * for deciding is value is the digit
     * @param ch -- checked value
     * @return true if @ch is a digit (specified in DIGITS),
     * otherwise return false
     */
    public boolean isDigit(char ch) {
        return DIGITS.contains(ch);
    }

    /**
     * for deciding is Symbol (as object) is an object of the digit
     * @return true if value is a digit (specified in DIGITS),
     * otherwise return false
     */
    public boolean isDigit() {
        return isDigit(value);//or DIGITS.contains(value)
    }
}
