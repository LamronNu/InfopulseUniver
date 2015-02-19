package labs.task2_Strings;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Symbol {
    private char value;

    public Symbol() {
    }
    public Symbol(char ch)  {
        this.value = ch;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

}
class Lexeme extends Symbol{
    private String value;
    public Lexeme(String s) {
        this.value = s;
    }

    public Lexeme() {

    }
    public String getText(){
        return value;
    }
}
class PunctuationMark extends Lexeme{
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

class Sentence {
    public String value;
    private List<Lexeme> lexemes;
    //
    public Sentence(String text) {
        lexemes = new ArrayList<Lexeme>();
        List<String> tLexemes = new ArrayList<String>();
        //check length

        //parse text
        boolean nextIsPunctuationMark = PunctuationMark.isPunctuationMark(text.charAt(1));
        for (int i = 0; i < text.length() - 1; i++){

            char currentChar = text.charAt(i);
            while (!nextIsPunctuationMark) {
                Lexeme lexeme = new Word();
            }

        }
        //
        for (String s : tLexemes)
            lexemes.add(new Lexeme(s));
    }

    /*Ну и, т.к. мы будем использовать в качестве основного источника получения
      всяких там данных из текста, то реализовать тут можно геттеры и сеттеры
       отдельных частей параграфа.

      А т.к. все предложения заносятся последовательно, то
      и порядок, конечно же, сохранится.
     */

    public String getText() {
        return value;//???
//        //Будет совмещать назат весь параграф. Например так:
//        String res = "";
//        // Извлекаем содержимое предложений из нашего класса.
//        for (Lexeme lex : lexemes) {
//            res += lex.getText();
//        }
//        return res;
    }
}



public class Test {
    private static final Logger log = Logger.getLogger(Test.class);
}
