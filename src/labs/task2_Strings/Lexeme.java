package labs.task2_Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Lexeme extends Symbol implements Comparable<Lexeme>{
    private String value;
    private int length;
    private List<Symbol> chars;
    //constructors
    public Lexeme() {
        this.chars = new ArrayList<Symbol>();
    }
    public Lexeme(String s) {
        this.value = s;
        this.chars = new ArrayList(Arrays.asList(s.toCharArray()));
    }
    //getters, setters

    @Override
    public String getValue() {
        return getText();
    }

    public void setValue(String value) {
        this.value = value;
        this.chars = new ArrayList(Arrays.asList(value.toCharArray()));
    }

    public int getLength() {
        return chars.size();
    }

    public void setLength(int length) {
        this.length = length; //???? what for??
    }

    //
    public String getText(){
        String text = "";
        for (Symbol s : chars) {
            text += s.getValue();
        }
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lexeme lexeme = (Lexeme) o;

        if (chars != null ? !chars.equals(lexeme.chars) : lexeme.chars != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return chars != null ? chars.hashCode() : 0;
    }

    @Override
    public int compareTo(Lexeme o) {
        if (getClass() != o.getClass()){
            //???
            throw new ClassCastException("cannot compare different classes!");
        }
//        if (this.equals(o)) {
//            return 0;
//        }
        if (o == null || this == null) {
            return o == null ? 1 : -1; //Object > null
        }
        Lexeme lexeme = (Lexeme) o;
        return getText().compareTo(o.getText());

    }
}
