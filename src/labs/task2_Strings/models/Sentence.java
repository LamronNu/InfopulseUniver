package labs.task2_Strings.models;

import java.util.ArrayList;
import java.util.List;

class Sentence extends Lexeme{
    public String value;
    private List<Lexeme> lexemes = new ArrayList<>();
    private List<Interval> intervals = new ArrayList<>();
    private List<Word> words = new ArrayList<>();

    //constructor
    public Sentence(String text) {
        this.value = text;
        parseText(text);//fill lexemes
    }

    private void parseText(String text) {
        int i = 0;
        while (i < text.length() - 1){
            boolean isPunctuationMark = isPunctuationMark(text.charAt(i));
            Lexeme lexeme = isPunctuationMark ? new Interval() : new Word();
            do {
                lexeme.addChar(text.charAt(i++));
            }
            while (i < text.length()
                    && isPunctuationMark == isPunctuationMark(text.charAt(i)));

            if (isPunctuationMark) {
                intervals.add((Interval)lexeme);
            } else{
                words.add((Word)lexeme);
            }
            lexemes.add(lexeme);
        }
    }

    public String getText() {
        String text = "";
        for (Lexeme s : lexemes) {
            text += s.getText();
        }
        return text;
    }

    public String getFullInfo() {
        return "Your text is: " + getText() + "\n"
                + "Lexemes: " + lexemes + "\n"
                + "  count -- " + lexemes.size() + "\n"
                + getSymbolsInfo(lexemes) + "\n"
                + "Words: " + words + "\n"
                + "   count -- " + words.size() + "\n"
                + getWordInfo(words) + "\n"
                + "Intervals: : " + intervals + "\n"
                + "   count -- " + intervals.size() + "\n";

    }

    private String getWordInfo(List<Word> words) {
        String result1 = "     Letters: ";
        String result2 = "\n     Unique letters: ";
        String result3 = "\n     Digits: ";
        String result4 = "\n     Unique digits: ";
        for (Word word : words){
            result1 += word.getLetters();
            result2 += word.getUniqueLetters();
            result3 += word.getDigits();
            result4 += word.getUniqueDigits();
        }
        return result1 + result2 + result3 + result4;
    }

    private String getSymbolsInfo(List<Lexeme> lexemes) {
        String result1 = "      Symbols: ";
        String result2 = "\n" + "Unigue symbols: " ;
        for (Lexeme lexeme : lexemes){
            result1 += lexeme.getSymbols();
            result2 += lexeme.getUniqueSymbols();
        }
        return result1 + result2;
    }


    public List<Word> getWords() {
        return new ArrayList<>(words);
    }
}
