package Lesson10.Question7_v3;

// MainChatApplication.java
import javax.swing.*;

public class MainChatApplication {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            @SuppressWarnings("unused")
            AbstractChatApplication chatApplication = new EnhancedChatApplication(new CaesarCipherEncryption());
        });
    }
}
