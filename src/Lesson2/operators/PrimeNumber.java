package Lesson2.operators;

import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Starting number: ");
        int start = scanner.nextInt();
        System.out.print("Enter Ending number: ");
        int end = scanner.nextInt();
        getPrimeNumber(start, end);
        scanner.close();

    }

    private static void getPrimeNumber(int isStart, int isEnd) {

        int start = isStart;
        int end = isEnd;

        for (int i = start; i <= end; i++) {

            if (isPrimeNumber(i)) {

                System.out.printf("%d, ", i);
            }
        }

    }

    private static boolean isPrimeNumber(int isNum) {

        int num = isNum;
        boolean res = true;

        for (int i = 2; i <= Math.sqrt(num); i++) {

            if (num % i == 0) {

                res = false;
                break;
            }
        }
        return res;
    }

}