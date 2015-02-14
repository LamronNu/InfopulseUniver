package lessons.recursion;

import java.util.Scanner;

public class CheckDegree {

        public static int getDegree(int value, int currentDegree){
            return (value == 0 || (value/2 != value/2.)) ? -1 :
                        ((value == 1) ? currentDegree
                        : getDegree(value / 2, ++currentDegree));

        }

        public int inputValue(){
            Scanner in = new Scanner(System.in);
            return in.nextInt();

        }
        public static void main(String[] args) {

            System.out.println("print number");

            CheckDegree value = new CheckDegree();
            int in = value.inputValue();

            int result = getDegree(in,0);
            System.out.println(result);
        }

}
