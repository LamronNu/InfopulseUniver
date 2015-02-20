package labs.task2_Strings;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringTests {
    public static void main(String[] args) {
        //String testText = "gggg.-- dddd??;; dff3443dd hdty45pnxcy7;;0t48";

        //
        System.out.println("Please, enter your text:");
        //input text
        Scanner in = new Scanner(System.in);
        String testText = in.nextLine();

        Sentence sentence = new Sentence(testText);
        //System.out.println(sentence.getFullInfo());

        //due task2
        //
        System.out.println("Please, enter your symbol:");
        //input text
       // Scanner in = new Scanner(System.in);
        char symbol = (char) in.next().charAt(0);
        List<Word> words = sentence.getWords();
        Collections.sort(words, new Lexeme_13_Comparator(symbol));
        System.out.println("sorted words:");
        System.out.println(words);
        System.out.println("words:");
        System.out.println(sentence.getWords());

    }
}
