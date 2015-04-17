package testTasks.ProgForce.models;



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
    public int length() {
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
        String thisText = caseSensitive ? getText() : getText().toLowerCase();
        String thatText = caseSensitive ? ((Lexeme) o).getText() : ((Lexeme) o).getText().toLowerCase();
        return thisText.equals(thatText);
//        if (symbols != null ? !symbols.equals(lexeme.symbols) : lexeme.symbols != null) return false;
//        return true;
    }

    @Override
    public int hashCode() {
        String text = caseSensitive ? getText() : getText().toLowerCase();
        return text.hashCode();
    }

    @Override
    public int compareTo(Lexeme o) {
        if (getClass() != o.getClass()){
            throw new ClassCastException("cannot compare different classes!");//???
        }
        if (o == null || this == null) {
            return o == null ? 1 : -1; //Object > null
        }
        String thisText = caseSensitive ? getText() : getText().toLowerCase();
        String thatText = caseSensitive ? o.getText() : o.getText().toLowerCase();
        return thisText.compareTo(thatText);//by Alphabet
        //return getText().compareTo(o.getText());

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
