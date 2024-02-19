package Lesson4.Quiz2.Question13;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {

        Super s = new Sub();

        try {
            s.m1();

        } catch (FileNotFoundException e) {

            System.out.println("B");

        } catch (IOException e) {

            System.out.println("A");

        } finally {

            System.out.println("C");
        }
    }

}
