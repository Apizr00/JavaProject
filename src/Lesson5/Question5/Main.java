package Lesson5.Question5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file name to be deleted: ");
        String fileName = scanner.nextLine();

        FileOperation fileOperation = new FileDeletion();
        fileOperation.performFileOperation(fileName);

        scanner.close();
    }

}
