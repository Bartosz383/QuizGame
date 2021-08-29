package pl.kru;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz implements ActionListener {

    String[] questions =    {
                                "Who was the president of the USA?",
                                "Which city is the capital of France?",
                                "Is Esperanto a programming language?",
                                "What is steel?"
                            };

    String[][] options =      {
                                 {"Diego Morales", "Donald Trump", "Hugo Jackman", "Bill Codingthon"},
                                 {"Paris", "Roma", "China", "Washington"},
                                 {"Yes", "Esperanto is a native language of Americans", "Esperanto is a development environment", "Esperanto is a artificial language"},
                                 {"Is a car", "Is a game", "Is an alloy of carbon and iron", "Is a book"}
                            };

    char[] answers =        {
                                'B',
                                'A',
                                'D',
                                'C'
                            };

    char guess;
    char answer;
    int index;
    int correct_quesses = 0;
    int total_questions = questions.length;
    int result;
    int seconds = 10;

    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if(seconds <= 0){
                displayAnswer();
            }

        }
    });


    public Quiz() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                       // close button - exit the application
        frame.setSize(650,650);                                         // windows's size
        frame.getContentPane().setBackground(new Color(50,50,50));          // set background's color
        frame.setLayout(null);
        frame.setResizable(false);

        // set a black field on top of window
        textfield.setBounds(0,0,650,50);
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Arial", Font.ITALIC, 30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);
//        textfield.setText("hejo Tekla. Piszę dziś do Ciebie, bo...");                                          // text on black field

        textarea.setBounds(0,50,650,50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25,25,25));
        textarea.setForeground(new Color(25,255,0));
        textarea.setFont(new Font("MV Boli", Font.ITALIC, 30));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);
//        textarea.setText("Jesteś spoko ;)");


        // There are my buttons
        buttonA.setBounds(0,100,100,100);
        buttonA.setFont(new Font("MV Boli", Font.ITALIC, 35));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");                                               // You see a "A" on button

        buttonB.setBounds(0,200,100,100);
        buttonB.setFont(new Font("MV Boli", Font.ITALIC, 35));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");                                               // You see a "B" on button

        buttonC.setBounds(0,300,100,100);
        buttonC.setFont(new Font("MV Boli", Font.ITALIC, 35));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");                                               // You see a "C" on button

        buttonD.setBounds(0,400,100,100);
        buttonD.setFont(new Font("MV Boli", Font.ITALIC, 35));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");                                               // You see a "D" on button

        answer_labelA.setBounds(125,100,500,100);
        answer_labelA.setBackground((new Color(50,50,50)));
        answer_labelA.setForeground(new Color(25,255,0));
        answer_labelA.setFont(new Font("MV Boli", Font.PLAIN, 35));
//        answer_labelA.setText("Litwo");

        answer_labelB.setBounds(125,200,500,100);
        answer_labelB.setBackground((new Color(50,50,50)));
        answer_labelB.setForeground(new Color(25,255,0));
        answer_labelB.setFont(new Font("MV Boli", Font.PLAIN, 35));
//        answer_labelB.setText("Ojczyzno moja");

        answer_labelC.setBounds(125,300,500,100);
        answer_labelC.setBackground((new Color(50,50,50)));
        answer_labelC.setForeground(new Color(25,255,0));
        answer_labelC.setFont(new Font("MV Boli", Font.PLAIN, 35));
//        answer_labelC.setText("Ty jesteś jak zdrowie");

        answer_labelD.setBounds(125,400,500,100);
        answer_labelD.setBackground((new Color(50,50,50)));
        answer_labelD.setForeground(new Color(25,255,0));
        answer_labelD.setFont(new Font("MV Boli", Font.PLAIN, 35));
//        answer_labelD.setText("Ilę Cię cenić trzeba ten tylko się dowie");


        // Timer's field
        seconds_left.setBounds(535,510,100,100);
        seconds_left.setBackground(new Color(25,25,25));
        seconds_left.setForeground(new Color(255,0,0));
        seconds_left.setFont(new Font("Ink Free", Font.BOLD, 60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        // Timer (you can comment on anything)
        time_label.setBounds(535,475,100,25);
        time_label.setBackground(new Color(50,50,50));
        time_label.setForeground(new Color(255,0,0));
        time_label.setFont(new Font("MV Boli", Font.PLAIN, 16));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("timer >:D");

        number_right.setBounds(225,225,200,100);
        number_right.setBackground(new Color(25,25,25));
        number_right.setForeground(new Color(25,255,0));
        number_right.setFont(new Font("Ink Free", Font.BOLD, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(225,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setFont(new Font("Ink Free", Font.BOLD, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);


        frame.add(time_label);
        frame.add(seconds_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textarea);
        frame.add(textfield);
        frame.setVisible(true);

        nextQuestion();

    }

    public void  nextQuestion() {

        if(index >= total_questions) {
            results();
        } else {                                                // you can see the content of the answer
            textfield.setText("Question " + (index + 1 ));
            textarea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // By default, the button isn't pressed
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        // if you answered correctly it will give you a point
        if(e.getSource() == buttonA) {
            answer = 'A';
            if(answer == answers[index]) {
                correct_quesses++;
            }
        }

        // if you answered correctly it will give you a point
        if(e.getSource() == buttonB) {
            answer = 'B';
            if(answer == answers[index]) {
                correct_quesses++;
            }
        }

        // if you answered correctly it will give you a point
        if(e.getSource() == buttonC) {
            answer = 'C';
            if(answer == answers[index]) {
                correct_quesses++;
            }
        }

        // if you answered correctly it will give you a point
        if(e.getSource() == buttonD) {
            answer = 'D';
            if(answer == answers[index]) {
                correct_quesses++;
            }
        }

        displayAnswer();

    }

    public void displayAnswer() {

        timer.stop();

        // By default, the button isn't pressed
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(answers[index] != 'A')
            answer_labelA.setForeground(new Color(255,0,0));
        if(answers[index] != 'B')
            answer_labelB.setForeground(new Color(255,0,0));
        if(answers[index] != 'C')
            answer_labelC.setForeground(new Color(255,0,0));
        if(answers[index] != 'D')
            answer_labelD.setForeground(new Color(255,0,0));

        Timer pause = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                answer_labelA.setForeground(new Color(25,255,0));
                answer_labelB.setForeground(new Color(25,255,0));
                answer_labelC.setForeground(new Color(25,255,0));
                answer_labelD.setForeground(new Color(25,255,0));

                answer = ' ';
                seconds = 10;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });

        pause.setRepeats(false);
        pause.start();
    }

    public void results() {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = (int)((correct_quesses/(double)total_questions)*100);

        textfield.setText("RESULTS!");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_right.setText( "(" + correct_quesses + "/" + total_questions + ")" );
        percentage.setText(result + "%");

        frame.add(percentage);
        frame.add(number_right);
    }
}
