package labs.task2_Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Symbol {
    private static final List<Character> PUNCTUATION_MARKS =
            new ArrayList(Arrays.asList(' ', '.', ',', '!', '?', ':', '"', ';',
                    '-', '\'', '\n', '\t'));

//            new ArrayList(Arrays.asList(" -.,!?:\"';\\n\\t".toCharArray()));

    private static final List<Character> SENTENCE_END_MARKS =
            new ArrayList(Arrays.asList('.', '!', '?'));

    private static final List<Character> DIGITS =
           new ArrayList(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));

    private char value;

    public Symbol() {
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

        if (value != symbol.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) value;
    }

    public Symbol(char ch)  {
        this.value = ch;
    }

    public String getValue() {//????
        return "" + value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    //for deciding is value a punctuation mark (between words)
    public boolean isPunctuationMark(char ch) {
        return (PUNCTUATION_MARKS.contains(ch));
    }

    public boolean isPunctuationMark() {
        return isPunctuationMark(value);//or(PUNCTUATION_MARKS.contains(ch));
    }


    //for deciding is value an end of sentence (between sentences)
    public boolean isSentenceEnd(char ch) {
        return (SENTENCE_END_MARKS.contains(ch));
    }
    public boolean isSentenceEnd() {
        return isSentenceEnd(value);//or (SENTENCE_END_MARKS.contains(value));
    }

    //for deciding is value a digit
    public boolean isDigit(char ch) {
        return DIGITS.contains(ch);
    }

    public boolean isDigit() {
        return isDigit(value);//or DIGITS.contains(value)
    }
}
