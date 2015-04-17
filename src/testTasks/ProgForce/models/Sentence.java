package testTasks.ProgForce.models;


import java.util.*;

public class Sentence extends Lexeme {
    public String value;
    private List<Lexeme> lexemes = new ArrayList<>();
    private List<Interval> intervals = new ArrayList<>();
    private List<Word> words = new ArrayList<>();
    private Set<Word> uniqueWords = new HashSet<>();
    private Map<Word, Integer> wordHistogram = new HashMap<>();

    //constructors
    public Sentence() {

    }

    public Sentence(String text) {
        super(text);
        this.value = text;
        parseText(text);//fill lexemes
    }

    /**
     * parse text on intervals and words
     * at the same time count frequency of words
     * @param text -- parsed text
     */
    private void parseText(String text) {
        int i = 0;
        Integer currentCount;
        Word currentWord;
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
                currentWord = (Word)lexeme;
                words.add(currentWord);
                uniqueWords.add(currentWord);
                currentCount = wordHistogram.get(currentWord);
                wordHistogram.put(currentWord, currentCount == null ? 1 : currentCount + 1);
            }
            lexemes.add(lexeme);
        }
    }

    /**
     * @return string view of object
     */
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

    public String getWordsHistogram(int minWordSize, int minWordCount) {
//        if (minWordCount < 0 || minWordSize < 0){
//            throw new IllegalArgumentException("no negative values!");
//        }
        String result = "";
        int wordCount;
        for (Word word : uniqueWords){
            wordCount = wordHistogram.get(word);
            if (word.length() >= minWordSize
                    && wordCount >= minWordCount){
                result += word + "=>" + wordCount + "\n";
            }
        }
        return result;
    }

    public List<Word> getWords() {
        return new ArrayList<>(words);
    }
}
