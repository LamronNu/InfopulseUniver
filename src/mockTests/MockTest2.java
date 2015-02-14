package mockTests;

import org.apache.log4j.Logger;

public class MockTest2 {
    private static final Logger log = Logger.getLogger(MockTest2.class);
}
class Util {
    public enum State{ACTIVE, DELETED, INACTIVE}
}

class Test {
    public static void main(String args[]) {
        //some code goes here
        Util.State state = Util.State.INACTIVE;
//        State state = INACTIVE;
    }
}