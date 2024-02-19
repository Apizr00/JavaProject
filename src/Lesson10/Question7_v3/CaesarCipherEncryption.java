package Lesson10.Question7_v3;

// CaesarCipherEncryption.java
public class CaesarCipherEncryption implements EncryptionStrategy {

    @Override
    public String encrypt(String message) {

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
}
