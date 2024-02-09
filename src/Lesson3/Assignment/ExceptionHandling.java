package Lesson3.Assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandling {

    public static void main(String[] args) {

        FileInputStream file = null;

        try {

            file = new FileInputStream("myfile.txt");

        } catch (FileNotFoundException e) {

            System.out.println("File not found: " + e.getMessage());
            e.printStackTrace();

        } finally {

            try {

                if (file != null) {

                    file.close();
                }

            } catch (IOException e) {

                e.printStackTrace();
            }

            System.out.println("Finally block executed.");
        }
    }
}
