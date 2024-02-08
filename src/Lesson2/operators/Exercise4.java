package Lesson2.operators;

import java.util.Scanner;

public class Exercise4 {

    public static void main(String[] args) {

        int X = 1;
        int Y = 1;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please Input Int X Value: ");
        X = scanner.nextInt();

        System.out.print("Please Input Int Y Value: ");
        Y = scanner.nextInt();

        if (X != Y) {

            System.out.println("1");
        }
        if (X > Y) {

            System.out.println("2");
        }

        if (X % Y == 0) {

            System.out.println("3");
        }
        scanner.close();
    }

}
