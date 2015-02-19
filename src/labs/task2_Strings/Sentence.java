package labs.task2_Strings;

import java.util.ArrayList;
import java.util.List;

class Sentence {
    public String value;
    private List<Lexeme> lexemes;
    //
    public Sentence(String text) {
        //lexemes = new ArrayList<Lexeme>();
        this.value = text;

        lexemes = parseText(text);
        //
//        for (String s : tLexemes)
//            lexemes.add(new Lexeme(s));
    }

    private List<Lexeme> parseText(String text) {
        List<Lexeme> tLexemes = new ArrayList<Lexeme>();
        //check length

        //parse text
        boolean nextIsPunctuationMark = Interval.isPunctuationMark(text.charAt(1));
        for (int i = 0; i < text.length() - 1; i++){

            char currentChar = text.charAt(i);
            while (!nextIsPunctuationMark) {
                Lexeme lexeme = new Word();
            }

        }

        return tLexemes;
    }

    /*Ну и, т.к. мы будем использовать в качестве основного источника получения
      всяких там данных из текста, то реализовать тут можно геттеры и сеттеры
       отдельных частей параграфа.

      А т.к. все предложения заносятся последовательно, то
      и порядок, конечно же, сохранится.
     */

    public String getText() {
        String text = "";
        for (Lexeme s : lexemes) {
            text += s.getText();
        }
        return text;
    }
}
