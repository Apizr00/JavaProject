package Lesson7.Question4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {

    private String fileName, line;

    public WordCount(String fileName) {

        this.fileName = fileName;
    }

    public void countWord() throws IOException {

        int num = 0;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        while ((line = reader.readLine()) != null) {

            System.out.println(line);
            String[] words = line.split("\\s");

            for (String word : words) {
                num += !word.isEmpty() ? 1 : 0;

            }
        }
        reader.close();

        System.out.println("Number of word = " + num);
    }
}
