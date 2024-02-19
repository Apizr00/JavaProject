package Lesson9.Assignment2.Question1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class SimpleSwingApp {
    public static void main(String[] args) {

        // Create a JFrame (window)
        JFrame frame = new JFrame("Simple Swing Application");

        // Set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JLabel with text
        JLabel label = new JLabel("Hello, Swing!");

        // Set the font and alignment of the label
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        label.setHorizontalAlignment(JLabel.CENTER);

        // Add the label to the content pane of the frame
        frame.getContentPane().add(label);

        // Set the size of the frame
        frame.setSize(300, 150);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }
}
