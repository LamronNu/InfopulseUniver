package mockTests;

import org.apache.log4j.Logger;

public class Mock3 {
    private static final Logger log = Logger.getLogger(Mock3.class);
}

class TryMe {

    public static void printB(String str) {
        System.out.print(Boolean.valueOf(str) ? "true" : "false");
    }

    public static void main(String args[]) {
        printB("tRuE");
        printB("false");
    }
}