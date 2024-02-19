package Lesson10.Question7_v3;

// EnhancedChatApplication.java
class EnhancedChatApplication extends AbstractChatApplication {

    public EnhancedChatApplication(EncryptionStrategy encryptionStrategy) {

        super();
        this.encryptionStrategy = encryptionStrategy;
    }

    @Override
    protected void sendMessage() {

        String recipient = (String) recipientComboBox.getSelectedItem();
        String message = messageField.getText();
        String encryptedMessage = encryptionStrategy.encrypt(message);

        displayMessage(recipient, message);
        displayEncryptedMessage(encryptedMessage);
        insertMessageIntoDatabase(recipient, message, encryptedMessage);

        // Additional logic, such as auto-reply, can be added here

        messageField.setText("");
    }

    private void insertMessageIntoDatabase(String recipient, String originalMessage, String encryptedMessage) {

        SqlService.insertMessage(recipient, originalMessage, encryptedMessage);
    }
}