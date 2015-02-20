package labs.task2_Strings;

import java.util.Comparator;

//Отсортировать слова в тексте по убыванию количества вхождений
// заданного символа, а в случае равенства – по алфавиту.

public class Lexeme_13_Comparator
    implements Comparator<Lexeme>{

    private Symbol symbol;

    public Lexeme_13_Comparator(Symbol symbol) {
        this.symbol = symbol;
    }

    public Lexeme_13_Comparator(char symbol) {
        this(new Symbol(symbol));
    }

    @Override
    public int compare(Lexeme o1, Lexeme o2) {
        int diff = o2.getSymbolCount(symbol) - o1.getSymbolCount(symbol);//по убыванию
        if (diff != 0){
            return diff;
        }else{
            return o1.compareTo(o2);
        }
    }
}
