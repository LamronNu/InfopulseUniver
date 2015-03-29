package studyJava.ProgForce;

import studyJava.ProgForce.models.Sentence;
import studyJava.ProgForce.models.Symbol;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    public static final String WORD_HISTOGRAM_HAEDER = "-------word Histogram -----";
    private JTextArea in;
    private JTextArea out;
    private JTextField wordSize;
    private JTextField wordsCount;
    private JCheckBox caseSensitive;

    public MainForm() throws HeadlessException {
        initUI();
    }

    private void initUI() {
        createComponents();
        pack();
        //base
        setTitle("Word Histogram");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createComponents() {
        //in area
        in = new JTextArea();
        in.setToolTipText("enter text");
        //out (result) area
        out = new JTextArea(WORD_HISTOGRAM_HAEDER);
        out.setToolTipText("result");
        out.setEditable(false);//disabled
        //configs
        JLabel wordSizeL = new JLabel("word size");
        wordSize = new JTextField("2");
        wordSize.setToolTipText("min word size");

        JLabel wordsCountL = new JLabel("words count");
        wordsCount = new JTextField("2");
        wordsCount.setToolTipText("min words count for histogram");

        JLabel caseSensitiveL = new JLabel("case sensitive");
        caseSensitive = new JCheckBox();

        JButton doItButton = new JButton("do it!");
        doItButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                push();
            }
        });
        JButton quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        //main
        Container rootPanel = getContentPane();
        GridLayout rootLayout = new GridLayout(2,1,5,5);
        rootPanel.setLayout(rootLayout);
        rootPanel.setBounds(5,5,290,190);
        rootPanel.add("in", in);

        Container bottomLeft = new Container();
        bottomLeft.setLayout(new GridLayout(4, 2, 5, 5));
        bottomLeft.add(wordSizeL);
        bottomLeft.add(wordSize);
        bottomLeft.add(wordsCountL);
        bottomLeft.add(wordsCount);
        bottomLeft.add(caseSensitiveL);
        bottomLeft.add(caseSensitive);
        bottomLeft.add(quitButton);
        bottomLeft.add(doItButton);
        Container bottom = new Container();
        bottom.setLayout(new GridLayout(1,2,5,5));
        bottom.add(bottomLeft);
        bottom.add(out);
        //
        rootPanel.add(bottom);
    }

    private void push() {
        String inText = in.getText();
        int wSize;
        try {
            wSize = Integer.parseInt(wordSize.getText());
        } catch (NumberFormatException e){
            wSize = 2;
            wordSize.setText("2");
        }
        int wCount;
        try {
            wCount = Integer.parseInt(wordsCount.getText());
        } catch (NumberFormatException e){
            wCount = 2;
            wordsCount.setText("2");
        }
        boolean cSensitivity = caseSensitive.isEnabled();
        Symbol.setCaseSensitive(cSensitivity);
        Sentence sentence = new Sentence(inText);
        String result = sentence.getWordsHistogram(wSize, wCount);
        out.setText(WORD_HISTOGRAM_HAEDER + "\n" + result);
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainForm mainForm = new MainForm();
                mainForm.setVisible(true);
            }
        });
    }
}
