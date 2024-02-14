package Lesson5.Question4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppendFile {

    private String fileName;

    public AppendFile(String fileName) {

        this.fileName = fileName;

    }

    public void appendFile() throws IOException {

        Scanner scanner = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

        System.out.println("Please enter the text: ");
        writer.write(scanner.nextLine());
        writer.newLine();

        writer.close();
        scanner.close();
        System.out.println("The file were appended.");
    }
}
