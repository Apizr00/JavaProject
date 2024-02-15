package Lesson7.Question4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    private String fileName, line;

    public ReadFile(String fileName) {

        this.fileName = fileName;
    }

    public void read() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }
}