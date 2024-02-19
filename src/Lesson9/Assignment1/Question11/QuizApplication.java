package Lesson9.Assignment1.Question11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApplication extends JFrame {
    private int score = 0;
    private int currentQuestionIndex = 0;

    private JLabel questionLabel;
    private JRadioButton[] options;
    private ButtonGroup optionsGroup;
    private JButton nextButton;
    private JLabel scoreLabel;

    private String[][] questions = {

            { "What is the capital of France?", "Paris", "Berlin", "London", "Rome", "Paris" },
            { "Which planet is known as the Red Planet?", "Venus", "Mars", "Jupiter", "Saturn", "Mars" },
            { "What is the largest mammal?", "Elephant", "Whale", "Giraffe", "Horse", "Whale" }
    };

    public QuizApplication() {

        setTitle("Quiz Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initComponents();
        updateQuestion();

        setVisible(true);
    }

    private void initComponents() {

        setLayout(new BorderLayout());

        questionLabel = new JLabel();
        add(questionLabel, BorderLayout.NORTH);

        optionsGroup = new ButtonGroup();
        options = new JRadioButton[4];
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].addActionListener(new OptionSelectedListener());
            optionsGroup.add(options[i]);
            add(options[i]);
        }

        nextButton = new JButton("Next");
        nextButton.addActionListener(new NextButtonListener());
        add(nextButton, BorderLayout.SOUTH);

        scoreLabel = new JLabel("Score: 0");
        add(scoreLabel, BorderLayout.WEST);
    }

    private void updateQuestion() {

        if (currentQuestionIndex < questions.length) {

            questionLabel.setText(questions[currentQuestionIndex][0]);

            for (int i = 0; i < 4; i++) {

                options[i].setText(questions[currentQuestionIndex][i + 1]);
                options[i].setSelected(false);
            }

            nextButton.setEnabled(false);
        } else {
            showResult();
        }
    }

    private void showResult() {

        JOptionPane.showMessageDialog(this, "Quiz completed!\nYour score is: " + score, "Quiz Result",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private class OptionSelectedListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            nextButton.setEnabled(true);
        }
    }

    private class NextButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            checkAnswer();
            currentQuestionIndex++;
            updateQuestion();
        }

        private void checkAnswer() {

            for (int i = 0; i < 4; i++) {

                if (options[i].isSelected() && options[i].getText().equals(questions[currentQuestionIndex][5])) {
                    score++;
                    break;

                }
            }
            scoreLabel.setText("Score: " + score);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new QuizApplication());
    }
}
