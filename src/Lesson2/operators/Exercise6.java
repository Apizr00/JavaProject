package Lesson2.operators;

import java.util.Scanner;

public class Exercise6 {

    public static void main(String[] args) {

        int a;
        int b;
        int c;
        int m;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please Input a: ");
        a = scanner.nextInt();

        System.out.print("Please Input b: ");
        b = scanner.nextInt();

        System.out.print("Please Input c: ");
        c = scanner.nextInt();

        if (a <= b) {

            m = b;

        } else {

            m = a;
        }

        if (m <= c) {

            m = c;
        }

        System.out.printf("maximum = %d", m);

        scanner.close();
    }

}
