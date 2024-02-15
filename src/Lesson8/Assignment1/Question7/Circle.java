package Lesson8.Assignment1.Question7;

class Circle implements SortableShape {

    private double radius;

    public Circle(double radius) {

        this.radius = radius;
    }

    @Override
    public double area() {

        return Math.PI * radius * radius;
    }

    @Override
    public String getShapeName() {

        return "Circle";
    }
}
