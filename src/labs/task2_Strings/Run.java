package labs.task2_Strings;

import labs.task2_Strings.models.Paragraph;
import labs.task2_Strings.models.Word;

import java.io.*;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Run {
    private static final String TEXT_IN_FILE_NAME = "src\\labs\\task2_Strings\\files\\text_in.txt";
    private static final String TEXT_OUT_FILE_NAME = "src\\labs\\task2_Strings\\files\\text_out.txt";

    public static void main(String[] args) {
        System.out.println("What input?\n 1. Console (default)\n 2. File");
        Scanner in = new Scanner(System.in);
        int choice = 1;
        try {
            choice = in.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong option!");
            in.next();
        }

        if (choice == 2) {
            try {
                in = new Scanner(new File(TEXT_IN_FILE_NAME));
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                choice = 1;
            }
        }
        if (choice == 1){
            System.out.println("Please, enter your text:");
        }

        StringBuilder testText = new StringBuilder();
        //input text
        String temp = in.next();
        temp += " " + in.nextLine();
        while ( temp.length() > 0) {
            testText.append(temp + "\n");
            if (!in.hasNextLine()) break;
            temp = in.nextLine();
        }

        //Sentence text = new Sentence(testText.toString());//the same result))
        Paragraph text = new Paragraph(testText.toString());
        //System.out.println(sentence.getFullInfo());
        List<Word> words = text.getWords();

        //due task2
        boolean doIt = true;
        char symbol;
        System.out.println("Please, enter your symbol:");
        symbol =  in.next().charAt(0);
        while (doIt) {
            Collections.sort(words, new Lexeme_13_Comparator(symbol));
            //output results
            if (choice == 2) {
                try {
                    writeResultToFile(words, symbol);
                } catch (IOException e) {
                    choice = 1;
                }
            }

            if (choice == 1) {
                writeResultToConsole(text, words);
            }
            System.out.println("Press any key for enter other symbol or space for exit");
            doIt = (symbol = in.next().charAt(0)) != ' ';
        }

    }

    private static void writeResultToConsole(Paragraph text, List<Word> words) {
        System.out.println("sorted words:");
        System.out.println(words);
        System.out.println("words:");
        System.out.println(text.getWords());
    }

    private static void writeResultToFile(List<Word> words, char symbol) throws IOException {
        FileWriter out;
        out = new FileWriter(TEXT_OUT_FILE_NAME);
        out.write("Sorted words by number of symbol [" + symbol + "] desc\n");
        out.write(String.valueOf(words));
        out.flush();
        out.close();
    }
}
