package Lesson10.Question7_v2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        String url = "jdbc:mysql://localhost:3306/enhancedchatapplication";
        String username = "root";
        String password = "12345";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            String query = "INSERT INTO messages (recipient, original_message, encrypted_message) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setString(1, recipient);
                preparedStatement.setString(2, originalMessage);
                preparedStatement.setString(3, encryptedMessage);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {

            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}