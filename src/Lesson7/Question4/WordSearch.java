package Lesson7.Question4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WordSearch {

    private String fileName, line;
    private String searchLine;

    public WordSearch(String fileName) {

        this.fileName = fileName;
    }

    public void searchWord() throws IOException {

        Boolean found = null;
        int i = 1, j = 1;
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        System.out.println("Enter the word: ");
        searchLine = scanner.nextLine();

        while ((line = reader.readLine()) != null) {

            String[] words = line.split("\s+");

            for (String word : words) {

                found = word.equals(searchLine) ? true : false;

                if (found) {
                    break;
                }
            }
            j += !found ? 1 : 0;
            i++;
        }

        System.out.println(j != i ? "Found the word!" : "The word doesnt exist!");

        reader.close();
        scanner.close();
    }
}