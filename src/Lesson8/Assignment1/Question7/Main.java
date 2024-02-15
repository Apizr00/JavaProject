package Lesson8.Assignment1.Question7;

public class Main {
    public static void main(String[] args) {

        SortableShape[] shapes = {

                new Rectangle(5, 3),
                new Circle(4),
                new Triangle(6, 8)
        };

        System.out.println("Areas Before Sorting:");

        for (SortableShape shape : shapes) {

            System.out.println(shape.getShapeName() + ":" + shape.area());
        }

        ShapeSorter.sort(shapes);

        System.out.println("\nAreas After Sorting:");

        for (SortableShape shape : shapes) {

            System.out.println(shape.getShapeName() + ":" + shape.area());
        }
    }
}
