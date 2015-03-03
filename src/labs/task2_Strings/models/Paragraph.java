package labs.task2_Strings.models;

import java.util.ArrayList;
import java.util.List;

public class Paragraph extends Lexeme{
    public String value;
    private List<Sentence> sentences = new ArrayList<>();


    //constructor
    public Paragraph(String text) {
        //lexemes = new ArrayList<Lexeme>();
        this.value = text;
        parseText(text);//fill sentences
    }

    private void parseText(String text) {
        int begin = 0;
        int end = text.length();
        String tempText = "";
        do{
            tempText = text.substring(begin, text.length());
            end = getNextEOS(tempText); //EOS-pos
            Sentence sentence = new Sentence(tempText.substring(0, end == tempText.length() ? end - 1 : (end + 2)));//???
            sentences.add(sentence);
            begin = begin + end + 2;
        } while (begin  <= text.length());
    }

    //find position of first symbol of EOS (end of sentence)
    // or return position of last symbol
    private int getNextEOS(String text) {
        int i = text.length();
        int cur_i = -1;
        for (Character symbol : SENTENCE_END_MARKS) {
            if ((cur_i = text.indexOf(String.valueOf(symbol))) != -1
                    && cur_i < i)
                i = cur_i;
        }
        return i;
    }

    public String getText() {
        String text = "";
        for (Sentence s : sentences) {
            text += s.getText();
        }
        return text;
    }

    public List<Word> getWords() {
        List<Word> result = new ArrayList<>();
        for (Sentence s : sentences) {
            result.addAll(s.getWords());
        }
        return result;
    }
}
