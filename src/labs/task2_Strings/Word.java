package labs.task2_Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Word extends Lexeme     {
    //private String value;
    //public int length;//??
    private List<Symbol> letters = new ArrayList<Symbol>();
    private Set<Symbol> uniqueLetters = new HashSet<Symbol>();
    private List<Symbol> digits = new ArrayList<Symbol>();
    private Set<Symbol> uniqueDigits = new HashSet<Symbol>();

    //constructors
    public Word() {
    }
    public Word(String str)   {
        //this.value = str;
        parseText(str);

    }

    private void parseText(String text) {
        //letters and digits
        for (int i = 0; i < text.length(); i++) {
            addChar(text.charAt(i));
        }
    }

    @Override
    public void addChar(char value) {
        Symbol symbol = new Symbol(value);
        super.addChar(symbol);
        if (symbol.isDigit()){
            digits.add(symbol);
            uniqueDigits.add(symbol);
        } else{
            letters.add(symbol);
            uniqueLetters.add(symbol);
        }
    }

    //getters
    public List<Symbol> getLetters() {
        return new ArrayList<Symbol>(letters);
    }

    public Set<Symbol> getUniqueLetters() {
        return new HashSet<Symbol>(uniqueLetters);
    }

    public List<Symbol> getDigits() {
        return new ArrayList<Symbol>(digits);
    }

    public Set<Symbol> getUniqueDigits() {
        return new HashSet<Symbol>(uniqueDigits);
    }

    public void setValue(String text){
        parseText(text);
    }

    public int length(){
        return symbols.size();
    }
}
