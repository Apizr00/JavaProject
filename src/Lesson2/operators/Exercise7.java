package Lesson2.operators;

import java.util.Scanner;

public class Exercise7 {

    public static void main(String[] args) {

        int i;
        int n;
        int nFact;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n Value: ");
        n = scanner.nextInt();

        i = 1;
        nFact = 1;

        while (i <= n) {

            nFact *= i;
            i += 1;
        }

        System.out.printf("n! = %d", nFact);
        scanner.close();

    }

}
