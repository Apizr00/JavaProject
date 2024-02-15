package Lesson8.Assignment1.Question7;

class Triangle implements SortableShape {

    private double base;
    private double height;

    public Triangle(double base, double height) {

        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {

        return 0.5 * base * height;
    }

    @Override
    public String getShapeName() {

        return "Triangle";
    }
}
