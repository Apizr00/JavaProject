package Lesson10.Question7;

public class EnhancedChatApplication extends AbstractChatApplication {

    public EnhancedChatApplication() {

        super(); // Call the constructor of the abstract class
    }

    // Implement the abstract method
    @Override
    protected void sendMessage() {

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

}