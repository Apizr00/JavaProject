package Lesson9.Assignment1.Question10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGUI extends JFrame {

    private JButton[][] buttons;
    private char currentPlayer;

    public TicTacToeGUI() {

        buttons = new JButton[3][3];
        currentPlayer = 'X';

        initializeUI();
    }

    private void initializeUI() {

        setTitle("Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                add(buttons[i][j]);
            }
        }

        setSize(300, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private boolean checkWin() {

        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (buttons[i][0].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[i][1].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[i][2].getText().equals(String.valueOf(currentPlayer))) {
                return true; // Row win
            }

            if (buttons[0][i].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[1][i].getText().equals(String.valueOf(currentPlayer)) &&
                    buttons[2][i].getText().equals(String.valueOf(currentPlayer))) {
                return true; // Column win
            }
        }

        if (buttons[0][0].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][2].getText().equals(String.valueOf(currentPlayer))) {
            return true; // Diagonal win (top-left to bottom-right)
        }

        if (buttons[0][2].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[1][1].getText().equals(String.valueOf(currentPlayer)) &&
                buttons[2][0].getText().equals(String.valueOf(currentPlayer))) {
            return true; // Diagonal win (top-right to bottom-left)
        }

        return false;
    }

    private boolean isBoardFull() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (buttons[i][j].getText().isEmpty()) {

                    return false;
                }
            }
        }
        return true;
    }

    private void switchPlayer() {

        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    private class ButtonClickListener implements ActionListener {

        private int row;
        private int col;

        public ButtonClickListener(int row, int col) {

            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (buttons[row][col].getText().isEmpty()) {

                buttons[row][col].setText(String.valueOf(currentPlayer));

                if (checkWin()) {

                    JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
                    resetBoard();

                } else if (isBoardFull()) {

                    JOptionPane.showMessageDialog(null, "It's a draw!");
                    resetBoard();

                } else {

                    switchPlayer();
                }
            }
        }
    }

    private void resetBoard() {

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                buttons[i][j].setText("");
            }
        }
        currentPlayer = 'X';
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new TicTacToeGUI());
    }
}
