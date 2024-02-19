package Lesson10.Question7_v3;

// AbstractChatApplication.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        SqlService.retrieveAndDisplayData(this);
    }
}
