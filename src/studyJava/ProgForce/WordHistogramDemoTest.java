package studyJava.ProgForce;

public class WordHistogramDemoTest {

    public static void main(String[] args) {
        WordHistogramDemo demo = new WordHistogramDemo();
        //tests
        /**
         * test 1
         * ----
         * typeOfInput : console
         * typeOfOutput : console
         * minWordSize : 2
         * minWordsCount : 2
         * caseSensitive : false
         * ----
         * data must be inputted and outputted manually (from console)
         * other options are due task
         * Note: for ending of enter data it must be clicked "Enter"-button twice
         */
        System.out.println("----start test 1:---");
        demo.setConfigFileName("src\\studyJava\\ProgForce\\tests\\t1_cons_cons_2_2_f\\config.txt");
        demo.doIt();
        System.out.println("---------end test 1--");

        /**
         * test 2
         * ----
         * typeOfInput : console
         * typeOfOutput : file>>src\studyJava\ProgForce\tests\t2_cons_file_2_2_f\out.txt
         * minWordSize : 2
         * minWordsCount : 2
         * caseSensitive : false
         * ----
         * data must be inputted  manually (from console) and outputted to file
         * other options are due task
         * Note: for ending of enter data it must be clicked "Enter"-button twice
         */
        System.out.println("----start test 2:---");
        demo.setConfigFileName("src\\studyJava\\ProgForce\\tests\\t2_cons_file_2_2_f\\config.txt");
        demo.doIt();
        System.out.println("---------end test 2--");

        /**
         * test 3
         * ----
         * typeOfInput : console
         * typeOfOutput : folder>>src\studyJava\ProgForce\tests\t3_cons_folder_2_2_f\out
         * minWordSize : 2
         * minWordsCount : 2
         * caseSensitive : false
         * ----
         * data must be inputted  manually (from console) and outputted to file
         * other options are due task
         * Note: for ending of enter data it must be clicked "Enter"-button twice
         */
        System.out.println("----start test 3:---");
        demo.setConfigFileName("src\\studyJava\\ProgForce\\tests\\t3_cons_folder_2_2_f\\config.txt");
        demo.doIt();
        System.out.println("---------end test 3--");

        /**
         * test 4
         * ----
         * typeOfInput : file>>src\studyJava\ProgForce\tests\t4_file_cons_2_2_f\in.txt
         * typeOfOutput : console
         * minWordSize : 2
         * minWordsCount : 2
         * caseSensitive : false
         * ----
         * data must be inputted  from file and outputted to console
         * other options are due task
         */
        System.out.println("----start test 4:---");
        demo.setConfigFileName("src\\studyJava\\ProgForce\\tests\\t4_file_cons_2_2_f\\config.txt");
        demo.doIt();
        System.out.println("---------end test 4--");

        /**
         * test 5
         * ----
         * typeOfInput : file>>src\studyJava\ProgForce\tests\t5_file_file_2_2_f\in.txt
         * typeOfOutput : file>>src\studyJava\ProgForce\tests\t5_file_file_2_2_f\out.txt
         * minWordSize : 2
         * minWordsCount : 2
         * caseSensitive : false
         * ----
         * data must be inputted  from and outputted to file
         * other options are due task
         */
        System.out.println("----start test 5:---");
        demo.setConfigFileName("src\\studyJava\\ProgForce\\tests\\t5_file_file_2_2_f\\config.txt");
        demo.doIt();
        System.out.println("---------end test 5--");

        /**
         * test 6
         * ----
         * typeOfInput : file>>src\studyJava\ProgForce\tests\t6_file_folder_2_2_f\in.txt
         * typeOfOutput : folder>>src\studyJava\ProgForce\tests\t6_file_folder_2_2_f\out
         * minWordSize : 2
         * minWordsCount : 2
         * caseSensitive : false
         * ----
         * data must be inputted  from file and outputted to folder
         * other options are due task
         * Note: out-files have the same name as in-files
         */
        System.out.println("----start test 6:---");
        demo.setConfigFileName("src\\studyJava\\ProgForce\\tests\\t6_file_folder_2_2_f\\config.txt");
        demo.doIt();
        System.out.println("---------end test 6--");

        /**
         * test 7
         * ----
         * typeOfInput : folder>>src\studyJava\ProgForce\tests\t7_folder_cons_2_2_f\in
         * typeOfOutput : console
         * minWordSize : 2
         * minWordsCount : 2
         * caseSensitive : false
         * ----
         * data must be inputted  from folder and outputted to console
         * other options are due task
         */
        System.out.println("----start test 7:---");
        demo.setConfigFileName("src\\studyJava\\ProgForce\\tests\\t7_folder_cons_2_2_f\\config.txt");
        demo.doIt();
        System.out.println("---------end test 7--");

        /**
         * test 8
         * ----
         * typeOfInput : folder>>src\studyJava\ProgForce\tests\t8_folder_folder_2_2_f\in
         * typeOfOutput : folder>>src\studyJava\ProgForce\tests\t8_folder_folder_2_2_f\out
         * minWordSize : 2
         * minWordsCount : 2
         * caseSensitive : false
         * ----
         * data must be inputted  from and outputted to folder
         * other options are due task
         * Note: out-files have the same name as in-files
         */
        System.out.println("----start test 8:----");
        demo.setConfigFileName("src\\studyJava\\ProgForce\\tests\\t8_folder_folder_2_2_f\\config.txt");
        demo.doIt();
        System.out.println("---------end test 8--");

        /**
         * test 9
         * ----
         * typeOfInput : folder>>src\studyJava\ProgForce\tests\t9_folder_file_2_2_f\in
         * typeOfOutput : file>>src\studyJava\ProgForce\tests\t9_folder_file_2_2_f\out.txt
         * minWordSize : 2
         * minWordsCount : 2
         * caseSensitive : false
         * ----
         * data must be inputted  from folder and outputted to file
         * other options are due task
         */
        System.out.println("----start test 9:---");
        demo.setConfigFileName("src\\studyJava\\ProgForce\\tests\\t9_folder_file_2_2_f\\config.txt");
        demo.doIt();
        System.out.println("---------end test 9--");

        /**
         * test 10
         * ----
         * typeOfInput : file>>src\studyJava\ProgForce\tests\t10_file_file_1_1_f\in.txt
         * typeOfOutput : file>>src\studyJava\ProgForce\tests\t10_file_file_1_1_f\out.txt
         * minWordSize : 1
         * minWordsCount : 1
         * caseSensitive : false
         * ----
         * data must be inputted  from and outputted to file
         */
        System.out.println("----start test 10:---");
        demo.setConfigFileName("src\\studyJava\\ProgForce\\tests\\t10_file_file_1_1_f\\config.txt");
        demo.doIt();
        System.out.println("---------end test 10--");

        /**
         * test 11
         * ----
         * typeOfInput : file>>src\studyJava\ProgForce\tests\t11_file_file_2_1_f\in.txt
         * typeOfOutput : file>>src\studyJava\ProgForce\tests\t11_file_file_2_1_f\out.txt
         * minWordSize : 2
         * minWordsCount : 1
         * caseSensitive : false
         * ----
         * data must be inputted  from and outputted to file
         */
        System.out.println("----start test 11:---");
        demo.setConfigFileName("src\\studyJava\\ProgForce\\tests\\t11_file_file_2_1_f\\config.txt");
        demo.doIt();
        System.out.println("---------end test 11--");

        /**
         * test 12
         * ----
         * typeOfInput : file>>src\studyJava\ProgForce\tests\t12_file_file_2_2_t\in.txt
         * typeOfOutput : file>>src\studyJava\ProgForce\tests\t12_file_file_2_2_t\out.txt
         * minWordSize : 2
         * minWordsCount : 2
         * caseSensitive : true
         * ----
         * data must be inputted  from and outputted to file
         */
        System.out.println("----start test 12:---");
        demo.setConfigFileName("src\\studyJava\\ProgForce\\tests\\t12_file_file_2_2_t\\config.txt");
        demo.doIt();
        System.out.println("---------end test 12--");

        /**
         * test 13
         * ----
         * typeOfInput : file>>src\studyJava\ProgForce\tests\t13_file_file_2_2_f_emptyIn\in.txt
         * typeOfOutput : file>>src\studyJava\ProgForce\tests\t13_file_file_2_2_f_emptyIn\out.txt
         * minWordSize : 2
         * minWordsCount : 2
         * caseSensitive : true
         * ----
         * data must be inputted  from and outputted to file
         * Case: in-file is empty
         */
        System.out.println("----start test 13:---");
        demo.setConfigFileName("src\\studyJava\\ProgForce\\tests\\t13_file_file_2_2_f_emptyIn\\config.txt");
        demo.doIt();
        System.out.println("---------end test 13--");

        /**
         * test 14
         * ----
         * typeOfInput : file>>src\studyJava\ProgForce\tests\t14_file_file_2_2_f_noIn\in.txt
         * typeOfOutput : file>>src\studyJava\ProgForce\tests\t14_file_file_2_2_f_noIn\out.txt
         * minWordSize : 2
         * minWordsCount : 2
         * caseSensitive : true
         * ----
         * data must be inputted  from and outputted to file
         * Case: in-file is absent
         */
        System.out.println("----start test 14:---");
        demo.setConfigFileName("src\\studyJava\\ProgForce\\tests\\t14_file_file_2_2_f_noIn\\config.txt");
        demo.doIt();
        System.out.println("---------end test 14--");

        /**
         * test 15
         * ----
         * typeOfInput : folder>>src\studyJava\ProgForce\tests\t15_folder_folder_2_2_f_sameFolders\folder
         * typeOfOutput : folder>>src\studyJava\ProgForce\tests\t15_folder_folder_2_2_f_sameFolders\folder
         * minWordSize : 2
         * minWordsCount : 2
         * caseSensitive : false
         * ----
         * data must be inputted  from and outputted to folder
         * other options are due task
         * Note: out-files have the same name as in-files
         * Case: in and out foldername are the same
         */
        System.out.println("----start test 15:---");
        demo.setConfigFileName("src\\studyJava\\ProgForce\\tests\\t15_folder_folder_2_2_f_sameFolders\\config.txt");
        demo.doIt();
        System.out.println("---------end test 15--");

        /**
         * test 16
         * ----
         * typeOfInput : file>>src\studyJava\ProgForce\tests\t16_file_file_1_2_f\in.txt
         * typeOfOutput : file>>src\studyJava\ProgForce\tests\t16_file_file_1_2_f\out.txt
         * minWordSize : 1
         * minWordsCount : 2
         * caseSensitive : true
         * ----
         * data must be inputted  from and outputted to file
         */
        System.out.println("----start test 16:---");
        demo.setConfigFileName("src\\studyJava\\ProgForce\\tests\\t16_file_file_1_2_f\\config.txt");
        demo.doIt();
        System.out.println("---------end test 16--");




    }

}
