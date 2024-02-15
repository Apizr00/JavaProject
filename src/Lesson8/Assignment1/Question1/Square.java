package Lesson8.Assignment1.Question1;

class Square extends Rectangle {

    public Square(String color, boolean filled, double side) {

        super(color, filled, side, side);
    }

    @Override
    public double getArea() {

        return super.getArea();
    }

    @Override
    public double getPerimeter() {

        return super.getPerimeter();
    }

    @Override
    public String toString() {

        return "Square [" + super.toString() + "]";
    }
}
