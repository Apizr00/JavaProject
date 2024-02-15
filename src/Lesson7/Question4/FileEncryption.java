package Lesson7.Question4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEncryption {

    private String fileName, encryptedFileName;
    private String line;

    public FileEncryption() {

    }

    public void encryptedFile() throws IOException {

        Scanner scanner = new Scanner(System.in);
        int shift = 5;

        System.out.println("Please enter the file that need to be encrypted: ");
        this.fileName = scanner.nextLine();
        encryptedFileName = "encrypted" + this.fileName;
        System.out.println(encryptedFileName);

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(encryptedFileName));

        while ((line = reader.readLine()) != null) {

            String encryptedLine = encryptingChar(line, shift);
            writer.write(encryptedLine);
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
}