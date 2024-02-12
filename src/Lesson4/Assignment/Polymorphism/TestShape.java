package Lesson4.Assignment.Polymorphism;

public class TestShape {

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle(5, 10);
        Circle circle = new Circle(7);

        System.out.println("Area of Rectangle: " + rectangle.area());
        System.out.println("Area of Circle: " + circle.area());
    }

}
