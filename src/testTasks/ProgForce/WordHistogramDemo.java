package testTasks.ProgForce;

import testTasks.ProgForce.models.Sentence;
import testTasks.ProgForce.models.Symbol;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WordHistogramDemo {



    enum IO_Type {
        CONSOLE, FILE, FOLDER
    }
    //for config
    private String configFileName = "src\\studyJava\\ProgForce\\files\\config.txt";
    private static final String CONFIG_DELIMITER = " : ";
    private static final String DATA_DELIMITER = ">>";
    //default values
    private IO_Type typeOfInput = IO_Type.FILE;
    private String textInFileName = "src\\studyJava\\ProgForce\\files\\text_in.txt";
    private String textInFolderName = "tests";
    private IO_Type typeOfOutput = IO_Type.FILE;
    private String textOutFileName = "src\\studyJava\\ProgForce\\files\\text_out.txt";
    private String textOutFolderName = "tests";
    private int minWordSize = 2;
    private int minWordsCount = 2;

    //in-out
    private Map<String, String> inputData = new HashMap<>();
    private Map<String, String> outputData = new HashMap<>();

    public void setConfigFileName(String configFileName) {
        this.configFileName = configFileName;
    }

    private void setConfig(String configName, String configValue) {
        String type;
        switch (configName){
            case "typeOfInput":// file>>files\text_in.txt
                type = configValue.split(DATA_DELIMITER)[0];
                switch (type.toLowerCase()){
                    case "console":
                        typeOfInput = IO_Type.CONSOLE;
                        break;
                    case "file":
                        typeOfInput = IO_Type.FILE;
                        textInFileName = configValue.split(DATA_DELIMITER)[1];
                        break;
                    case "folder":
                        typeOfInput = IO_Type.FOLDER;
                        textInFolderName = configValue.split(DATA_DELIMITER)[1];
                        break;
                }
                break;
            case "typeOfOutput"://console
                type = configValue.split(DATA_DELIMITER)[0];
                switch (type.toLowerCase()){
                    case "console":
                        typeOfOutput = IO_Type.CONSOLE;
                        break;
                    case "file":
                        typeOfOutput = IO_Type.FILE;
                        textOutFileName = configValue.split(DATA_DELIMITER)[1];
                        break;
                    case "folder":
                        typeOfOutput = IO_Type.FOLDER;
                        textOutFolderName = configValue.split(DATA_DELIMITER)[1];
                        break;
                }
                break;
            case "minWordSize": //2
                minWordSize = Integer.parseInt(configValue);
                break;
            case "minWordsCount": //2
                minWordsCount = Integer.parseInt(configValue);
                break;
            case "caseSensitive": //2
                Symbol.setCaseSensitive(Boolean.parseBoolean(configValue));
                break;
        }
    }

    private void getConfig(String fileConfig) throws FileNotFoundException {
        Scanner in = new Scanner(new File(fileConfig));
        String currentRow = "";
        while (in.hasNext()){
            currentRow = in.nextLine();
            setConfig(currentRow.split(CONFIG_DELIMITER)[0], currentRow.split(CONFIG_DELIMITER)[1]);
        }
    }

    private String inputText(Scanner in) {
        StringBuilder tempText = new StringBuilder();
        String temp = in.next();
        temp += "" + in.nextLine();
        while ( temp.length() > 0) {
            tempText.append(temp + "\n");
            if (!in.hasNextLine()) break;
            temp = in.nextLine();
        }
        return tempText.toString();
    }

    private void inputData() throws FileNotFoundException {
        Scanner in = null;
        switch (typeOfInput){
            case CONSOLE:
                System.out.println("Please, enter your text:");
                in = new Scanner(System.in);
                inputData.put("console", inputText(in));
                break;
            case FILE:
                in = new Scanner(new File(textInFileName));
                inputData.put(textInFileName, inputText(in));
                break;
            case FOLDER:
                File folder = new File(textInFolderName);
                for (File file : folder.listFiles(new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        return pathname.isFile();
                    }
                })) {
                    in = new Scanner(file);
                    inputData.put(file.getName(), inputText(in));
                }
                break;
        }
    }

    private void writeResult(PrintStream out, String key) {
        out.println("--------------------------");
        out.println("get text from: " + key);
        out.println("-----WordsHistogram-------");
        out.println(outputData.get(key));
    }

    private void outputData() throws IOException {
        PrintStream  out = null;
        String header = "WordsHistogram (minWordSize=" + minWordSize
                + ", minWordsCount=" + minWordsCount
                + ", caseSensitive=" + Symbol.getCaseSensitive()+ ").";
        switch (typeOfOutput){
            case CONSOLE:
                System.out.println(header);
                for (String key : outputData.keySet()) {
                    writeResult(System.out, key);
                }
                break;
            case FILE:
                out = new PrintStream (textOutFileName);
                out.println(header + "\n");
                for (String key : outputData.keySet()) {
                    writeResult(out, key);
                }
                out.flush();
                out.close();
                break;
            case FOLDER:
                //check if the same folders for in and out
                String folderName =
                        (typeOfInput == IO_Type.FOLDER &&  textOutFolderName.equals(textInFolderName))
                                ? textOutFolderName + "_out" : textOutFolderName;
                try {
                    Files.createDirectory(Paths.get(folderName));
                } catch (FileAlreadyExistsException ex){
                    /*NOP*/
                }
                for (String key : outputData.keySet()) {
                    String fileName = key.split("\\\\")[key.split("\\\\").length - 1];
                    out = new PrintStream(folderName + "\\" + fileName);
                    writeResult(out, key);
                    out.flush();
                    out.close();
                }
                break;
        }
    }


    public void doIt() {
        //get initial config
        try {
            getConfig(configFileName);
        } catch (IndexOutOfBoundsException | FileNotFoundException ex){
             /*NOP. run program with defaults*/
        }
        //input data
        try {
            inputData();
        } catch (FileNotFoundException | NoSuchElementException e) {
            e.printStackTrace();//??
        }
        //processing data
        for (String key : inputData.keySet()){
            outputData.put(key, new Sentence(inputData.get(key))
                    .getWordsHistogram(minWordSize, minWordsCount));
        }
        //output result
        try {
            outputData();
        } catch (IOException e) {
            e.printStackTrace();//??
        }
        //clear temp data
        inputData.clear();
        outputData.clear();
    }

    public static void main(String[] args) {
        WordHistogramDemo demo = new WordHistogramDemo();
        demo.doIt();
    }




}

