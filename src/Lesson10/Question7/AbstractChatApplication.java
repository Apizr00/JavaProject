package Lesson10.Question7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class AbstractChatApplication extends JFrame {

    protected JTextField messageField;
    protected JTextArea chatArea;
    protected JComboBox<String> recipientComboBox;

    public AbstractChatApplication() {

        // Basic Setup
        setTitle("Enhanced Chat Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

        // Button sent
        messageField = new JTextField();
        JButton sendButton = new JButton("Send");

        String[] recipients = { "Person1", "Person2", "Group" };
        recipientComboBox = new JComboBox<>(recipients);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(recipientComboBox, BorderLayout.WEST);
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Abstract method to be implemented by subclasses
    protected abstract void sendMessage();

    protected void handleAutoReply(String recipient) {
        // Common implementation or leave abstract for subclasses to implement
    }

    protected String encryptMessage(String message) {
        // Common implementation or leave abstract for subclasses to implement

        int shift = 3;
        StringBuilder encryptedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {

            if (Character.isLetter(c)) {

                char encryptedChar = (char) (((c - 'A' + shift) % 26) + 'A');
                encryptedMessage.append(encryptedChar);

            } else {

                encryptedMessage.append(c);
            }
        }

        return encryptedMessage.toString();

    }
}
