package studyJava.Core._1_pcocedural.proc_2;

import java.util.Stack;

/**
 * Created by Olga on 26.05.2014.
 */
public class Hanoi {
    public static void main(String[] args) {
        Stack<Integer> from = new Stack<Integer>();
        Stack<Integer> help = new Stack<Integer>();
        Stack<Integer> to = new Stack<Integer>();
        from.push(3);
        from.push(2);
        from.push(1);
        System.out.println("FROM: " + from);
        exchange(from, help, to, from.size());
        System.out.println("TO: " + to);


    }

    private static void exchange(
            Stack<Integer> from, Stack<Integer> help, Stack<Integer> to, int count) {
//        System.out.println("from: " + from);
//        System.out.println("to: " + to);
//        System.out.println("help: " + help);
//        System.out.println("count: " + count);
        if (count > 0) {
            exchange(from, to, help, count - 1);
            int biggest = from.pop();
            to.push(biggest);
            exchange(help, from, to, count - 1);
        }
    }
}
