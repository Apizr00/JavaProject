package Lesson4.Exercise2;

public class main {

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(5, 4);
        Circle circle = new Circle(3);

        System.out.println("Area of rectangle: " + rectangle.calculateArea());
        System.out.println("Area of circle: " + circle.calculateArea());
    }

    public abstract class Shape {

        public abstract double calculateArea();
    }

}
