package Lesson2.operators;

import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Start Term: ");
        int f = scanner.nextInt();
        scanner.close();

        System.out.println(fibonacci(f));

    }

    static int fibonacci(int n) {

        int T0 = 0;
        int T1 = 1;
        int T = T1 + T0;

        for (int i = 0; i < n; i++) {

            System.out.println(T0 + " ");
            T = T1 + T0;
            T0 = T1;
            T1 = T;
        }
        return T0;
    }

}