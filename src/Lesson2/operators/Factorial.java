package Lesson2.operators;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Input Factorial: ");
        int intA = scanner.nextInt();
        System.out.println(factorial(intA));
        scanner.close();

    }

    static long factorial(long n) {

        if (n == 0 || n == 1) {

            return 1;

        } else {

            return n * factorial(n - 1);

        }
    }

}
// Not Working