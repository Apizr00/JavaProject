package Lesson10.Question1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnhancedChatApplication extends JFrame {

    private JTextField messageField;
    private JTextArea chatArea;
    private JComboBox<String> recipientComboBox;

    public EnhancedChatApplication() {

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

    // Method
    private void sendMessage() {

        String userMessage = messageField.getText();

        if (!userMessage.isEmpty()) {
            String recipient = (String) recipientComboBox.getSelectedItem();
            chatArea.append(recipient + ": " + userMessage + "\n");
            messageField.setText("");

            // Implement encryption (Caesar Cipher) for messages
            String encryptedMessage = encryptMessage(userMessage);
            chatArea.append("Encrypted Message: " + encryptedMessage + "\n");

            // Auto-reply logic
            handleAutoReply(recipient);
        }
    }

    private void handleAutoReply(String recipient) {

    }

    private String encryptMessage(String message) {

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

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new EnhancedChatApplication();
            }
        });
    }
}
