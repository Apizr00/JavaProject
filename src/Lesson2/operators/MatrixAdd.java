package Lesson2.operators;

import java.util.Scanner;

// n = 100
// sum = 1 to n
// sum = 1 + 2 + 3 ... 100

public class MatrixAdd {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Your Value To Sum: ");
        int num = scanner.nextInt();
        System.out.println(matrix(num));
        System.out.println("Verify: " + verify(num));
        scanner.close();
    }

    static int verify(int num) {

        int f = 0;
        for (int i = 0; i <= num; i++) {

            f += i;

        }
        return f;

    }

    static int matrix(int num) {

        return (num / 2) * (num + 1);

    }

}
