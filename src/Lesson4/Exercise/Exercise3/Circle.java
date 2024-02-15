package Lesson4.Exercise.Exercise3;

public final class Circle {

    private final double radius;
    private final double PI = 3.142;

    public Circle(double radius) {

        this.radius = radius;
    }

    public double calculateArea() {

        return PI * radius * radius;
    }

}
