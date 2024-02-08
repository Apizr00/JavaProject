package Lesson2.operators;

import java.util.Scanner;

public class ElvisOperator {

    public static void main(String[] args) {

        int intA = 12;
        int intB = 14;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please Input Int A Value: ");
        intA = scanner.nextInt();

        System.out.print("Please Input Int B Value: ");
        intB = scanner.nextInt();

        int highest = (intA > intB) ? (intA < 15) ? 15 : 20 : intB;
        System.out.println(highest);

        scanner.close();

    }

}