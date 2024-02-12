package Lesson4.Exercise7;

public class Main {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        System.out.println("Add two integers: " + calculator.add(5, 10));
        System.out.println("Add two floating-point numbers: " + calculator.add(3.5, 2.2));
        System.out.println("Square of an integer: " + calculator.square(4));
        System.out.println("Square of a floating-point number: " + calculator.square(3.0));
        System.out.println("Average of three integers: " + calculator.average(8, 12, 6));
        System.out.println("Average of three floating-point numbers: " + calculator.average(3.5, 2.0, 4.5));

    }

}
