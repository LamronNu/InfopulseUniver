package labs.task2_Strings.models;

import java.util.*;

public abstract class Lexeme extends Symbol
        implements Comparable<Lexeme> {

    protected String value;
    protected int length;
    protected List<Symbol> symbols = new ArrayList<>();
    protected Set<Symbol> uniqueSymbols = new HashSet<>();

    //constructors
    public Lexeme() {

    }
    public Lexeme(String s) {
        setValue(s);
    }

    private void parseText(String text) {
        for (int i = 0; i < text.length(); i++) {
            addChar(text.charAt(i));//goal: break on symbols
        }
    }

    //getters, setters
    public int getLength() {
        return symbols.size();
    }

    public List<Symbol> getSymbols() {
        return new ArrayList<>(symbols);
    }

    public Set<Symbol> getUniqueSymbols() {
        return new HashSet<>(uniqueSymbols);
    }

    //overrides
    @Override
    public String getValue() {
        return getText();
    }

    public void setValue(String value) {
        this.value = value;
        parseText(value);
    }

    @Override
    public String toString() {
        return getText();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lexeme lexeme = (Lexeme) o;
        if (symbols != null ? !symbols.equals(lexeme.symbols) : lexeme.symbols != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return symbols != null ? symbols.hashCode() : 0;
    }

    @Override
    public int compareTo(Lexeme o) {
        if (getClass() != o.getClass()){
            throw new ClassCastException("cannot compare different classes!");//???
        }
        if (o == null || this == null) {
            return o == null ? 1 : -1; //Object > null
        }
        return getText().compareTo(o.getText());//by Alphabet

    }

    //return String value
    public String getText(){
        String text = "";
        for (Symbol s : symbols) {
            text += s.getValue();
        }
        return text;
    }


    public void addChar(char c) {
        Symbol symbol = new Symbol(c);
        addChar(symbol);
    }

    public void addChar(Symbol symbol) {
        symbols.add(symbol);
        uniqueSymbols.add(symbol);
    }

    public int getSymbolCount(Symbol symbol){
        int count = 0;
        for (Symbol s : symbols){
            if (s.equals(symbol)) count++;
        }
        return count;
    }

    public boolean isExistsSymbol(Symbol symbol){
        return uniqueSymbols.contains(symbol);
    }

}
