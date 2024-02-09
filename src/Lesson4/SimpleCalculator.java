package Lesson4;

import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {

        double num1, num2, result = 0;
        char operator;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please Input First Number: ");
        num1 = scanner.nextDouble();

        System.out.print("Please Input Second Number: ");
        num2 = scanner.nextDouble();

        System.out.print("Please Input Operation: ");
        operator = scanner.next().charAt(0);

        scanner.close();

        if (operator == '+') {

            result = num1 + num2;

        } else if (operator == '-') {

            result = num1 - num2;

        } else if (operator == '*') {

            result = num1 * num2;

        } else if (operator == '/') {

            if (num2 != 0) {

                result = num1 / num2;
            }

        } else {

            System.out.println("Invalid Operator");
        }

        System.out.println("The Result: " + result);
    }

}
