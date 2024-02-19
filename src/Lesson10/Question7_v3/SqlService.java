package Lesson10.Question7_v3;

// SqlService.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlService {

    private static final String URL = "jdbc:mysql://localhost:3306/enhancedchatapplication";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void insertMessage(String recipient, String originalMessage, String encryptedMessage) {

        try (Connection connection = getConnection()) {

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

    public static void retrieveAndDisplayData(AbstractChatApplication chatApplication) {

        try (Connection connection = getConnection()) {

            String query = "SELECT * FROM messages";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                try (ResultSet resultSet = preparedStatement.executeQuery()) {

                    while (resultSet.next()) {

                        String sender = resultSet.getString("recipient");
                        String message = resultSet.getString("original_message");
                        String encrypted = resultSet.getString("encrypted_message");

                        // Display the retrieved data in the chat area
                        chatApplication.displayMessage(sender, message);
                        chatApplication.displayEncryptedMessage(encrypted);
                    }
                }
            }
        } catch (SQLException e) {

            e.printStackTrace(); // Handle the exception appropriately
        }
    }
}
