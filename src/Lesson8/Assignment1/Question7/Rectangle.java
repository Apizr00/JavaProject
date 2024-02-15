package Lesson8.Assignment1.Question7;

class Rectangle implements SortableShape {

    private double length;
    private double width;

    public Rectangle(double length, double width) {

        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {

        return length * width;
    }

    @Override
    public String getShapeName() {

        return "Rectangle";
    }
}