package labs.task2_Strings;

class Symbol {
    private char value;

    public Symbol() {
    }
    public Symbol(char ch)  {
        this.value = ch;
    }

    public String getValue() {//????
        return "" + value;
    }

    public void setValue(char value) {
        this.value = value;
    }

}
