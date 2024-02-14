package Lesson5.Question4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDecryption {

    private String encryptedFileName, decryptedFileName;
    private String line;

    public void decryptedFile() throws IOException {

        Scanner scanner = new Scanner(System.in);
        int shift = 5;

        System.out.println("Please enter the encrypted file that needs to be decrypted: ");
        this.encryptedFileName = scanner.nextLine();
        decryptedFileName = "decrypted_" + this.encryptedFileName;
        System.out.println("Decrypted file name: " + decryptedFileName);

        BufferedReader reader = new BufferedReader(new FileReader(encryptedFileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(decryptedFileName));

        while ((line = reader.readLine()) != null) {

            String decryptedLine = decryptingChar(line, shift);
            writer.write(decryptedLine);
            writer.newLine();
        }

        writer.close();
        reader.close();
        scanner.close();
    }

    public String encryptingChar(String text, int shift) {

        StringBuilder encryptedText = new StringBuilder();

        for (char character : text.toCharArray()) {

            if (Character.isLetter(character)) {

                char base = Character.isLowerCase(character) ? 'a' : 'A';
                encryptedText.append((char) ((character - base + shift) % 26 + base));

            } else {

                encryptedText.append(character);
            }

        }
        return encryptedText.toString();
    }

    public String decryptingChar(String text, int shift) {

        StringBuilder decryptedText = new StringBuilder();

        for (char character : text.toCharArray()) {

            if (Character.isLetter(character)) {

                char base = Character.isLowerCase(character) ? 'a' : 'A';
                decryptedText.append((char) ((character - base - shift + 26) % 26 + base));

            } else {

                decryptedText.append(character);
            }

        }
        return decryptedText.toString();
    }

}
