package Lesson7.Question2;

import java.util.Scanner;

public class ConsoleReaderExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter A Number: ");
        int num = scanner.nextInt();
        System.out.print("You Entered: " + num + "\n");
        scanner.close();
    }
}
