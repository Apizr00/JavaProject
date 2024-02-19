package Lesson10.Question7;

// EnhancedChatApplication.java
public class EnhancedChatApplication extends AbstractChatApplication {

    public EnhancedChatApplication(EncryptionStrategy encryptionStrategy) {

        super();
        this.encryptionStrategy = encryptionStrategy;
    }

    @Override
    protected void sendMessage() {

        String userMessage = messageField.getText();

        if (!userMessage.isEmpty()) {

            String recipient = (String) recipientComboBox.getSelectedItem();
            displayMessage(recipient, userMessage);
            messageField.setText("");

            String encryptedMessage = encryptionStrategy.encrypt(userMessage);
            displayEncryptedMessage(encryptedMessage);

            handleAutoReply(recipient);
        }
    }

    @Override
    protected void handleAutoReply(String recipient) {

        // Implement auto-reply logic specific to EnhancedChatApplication
    }
}
