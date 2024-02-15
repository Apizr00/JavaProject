package Lesson7.Question4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Scanner;

public class FileCopy {

    private String fileName, line;

    public FileCopy(String fileName) throws IOException {

        this.fileName = fileName;
    }

    public void copy() throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        System.out.println("Please write the name of copied file: ");
        BufferedWriter writer = new BufferedWriter(new FileWriter(sc.nextLine()));
        sc.close();

        while ((line = reader.readLine()) != null) {

            System.out.println(line);
            writer.write(line);
            writer.newLine();
        }
        System.out.println("The file were overwrite.");
        writer.close();
        reader.close();
    }
}
