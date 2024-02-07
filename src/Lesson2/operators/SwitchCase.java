package Lesson2.operators;

import java.util.Scanner;

public class SwitchCase {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Input Number: ");
        String str = scanner.nextLine();
        scanner.close();
        str = switchCase(str);
    }

    static String switchCase(String day) {

        String ret = "";

        switch (day) {
            case "mo":
                ret = "Monday";
                break;

            case "tu":
                ret = "Tuesday";
                break;

            case "we":
                ret = "Wednesday";
                break;

            case "th":
                ret = "Thursday";
                break;

            case "fr":
                ret = "Friday";
                break;

        }
        return ret;

    }

}

// Not Complete (No Output)
