package Lesson4.Assignment.Polymorphism;

class Circle extends Shape {

    private double radius;

    public Circle(double radius) {

        this.radius = radius;
    }

    @Override
    public double area() {

        return Math.PI * radius * radius;
    }
}
