package Lesson10.Question7_v2;

// AbstractChatApplication.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract class AbstractChatApplication extends JFrame {

    protected JTextField messageField;
    protected JTextArea chatArea;
    protected JComboBox<String> recipientComboBox;
    protected EncryptionStrategy encryptionStrategy;

    public AbstractChatApplication() {
        setTitle("Enhanced Chat Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        add(scrollPane, BorderLayout.CENTER);

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

        retrieveAndDisplayData();
    }

    protected abstract void sendMessage();

    protected void displayMessage(String sender, String message) {
        chatArea.append(sender + ": " + message + "\n");
    }

    protected void displayEncryptedMessage(String encryptedMessage) {
        chatArea.append("Encrypted Message: " + encryptedMessage + "\n");
    }

    protected void handleAutoReply(String recipient) {
        // Implement auto-reply logic in subclasses
    }

    private void retrieveAndDisplayData() {

        String url = "jdbc:mysql://localhost:3306/enhancedchatapplication";
        String username = "root";
        String password = "12345";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            String query = "SELECT * FROM messages";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                try (ResultSet resultSet = preparedStatement.executeQuery()) {

                    while (resultSet.next()) {

                        String sender = resultSet.getString("recipient");
                        String message = resultSet.getString("original_message");
                        String encrypted = resultSet.getString("encrypted_message");

                        // Display the retrieved data in the chat area
                        displayMessage(sender, message);
                        displayEncryptedMessage(encrypted);

                    }
                }
            }
        } catch (SQLException e) {

            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}