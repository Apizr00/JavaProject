package Lesson9.Assignment1.Question7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleChatApplication extends JFrame {

    private JTextField messageField;
    private JTextArea chatArea;
    private int replyCount = 1;

    public SimpleChatApplication() {

        // Basic Setup
        setTitle("Simple Chat Application");
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

        sendButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                sendMessage();
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Method
    private void sendMessage() {

        String userMessage = messageField.getText();

        int heartUnicode = 0x2764;
        char heartChar = (char) heartUnicode;

        if (!userMessage.isEmpty()) {

            chatArea.append("Sender: " + userMessage + "\n");
            messageField.setText("");

            if (replyCount == 1) {

                String autoReply = "Hye too";
                chatArea.append("Receiver: " + autoReply + "\n");
                replyCount++;

            } else if (replyCount == 2) {

                String autoReply = "I am good, thanks " + heartChar;
                chatArea.append("Receiver: " + autoReply + "\n");
                replyCount++;

            } else {

                replyCount = 1;
                chatArea.append("Reciever: Okay see you soon\n");
            }
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new SimpleChatApplication();
            }
        });
    }
}
