package Lesson3.Assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionExample {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter Your First Name: ");
        String firstName = reader.readLine();

        System.out.print("Enter Your Last Name: ");
        String lastName = reader.readLine();

        System.out.print("Hello, " + firstName + " " + lastName + "!");

        reader.close();
    }

}
