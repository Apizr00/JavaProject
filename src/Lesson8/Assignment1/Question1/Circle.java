package Lesson8.Assignment1.Question1;

class Circle extends Shape {

    private double radius;

    public Circle(String color, boolean filled, double radius) {

        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {

        return radius;
    }

    @Override
    public double getArea() {

        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {

        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        
        return "Circle [radius=" + radius + ", " + super.toString() + "]";
    }
}
