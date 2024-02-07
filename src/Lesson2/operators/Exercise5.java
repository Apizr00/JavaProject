package Lesson2.operators;

import java.util.Scanner;

public class Exercise5 {

    public static void main(String[] args) {

        boolean p;
        boolean q;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Please Input p Value: ");
        p = scanner.nextBoolean();

        System.out.print("Please Input q Value: ");
        q = scanner.nextBoolean();

        if (p && q) {

            q = false;
            System.out.println(q);

        } else {

            if (!q) {

                System.out.println(p);
            }
            if (p == q) {

                System.out.println(p || q);
            }

            System.out.println(q);
        }
        scanner.close();
    }

}
