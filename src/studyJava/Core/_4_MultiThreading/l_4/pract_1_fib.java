package studyJava.Core._4_MultiThreading.l_4;

/**
 * Created by Olga on 23.06.2014.
 */
public class pract_1_fib {
    public static void main(String[] args) throws InterruptedException {
        for (int k = 1  ; k < Integer.MAX_VALUE; k++) {
            String spaces = spaces(k);
            Runnable printer = new PrintRunnableX(spaces + k, 100);
            Thread thread = new Thread(printer);
            thread.start();
            Thread.sleep(100);

        }
    }

    private static String spaces(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
             result += " ";
        }
        return result;
    }
}
