package Lesson8.Example;

public class Main {

    // private static Border cirlce;

    public static void main(String[] args) {

        Circle circle = new Circle(5);
        System.out.println("The Area Of Circle Is: " + circle.calculateArea());
        System.out.println("The Perimeter Of Circle Is: " + circle.calculatePerimeter());

        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println("The Area Of Rectangle Is: " + rectangle.calculateArea());
        System.out.println("The Perimeter Of Rectangle Is: " + rectangle.calculatePerimeter());

    }

}
