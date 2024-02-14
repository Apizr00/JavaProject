package Lesson4.Exercise.Exercise6;

public class Main {

    public static void main(String[] args) {

        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner("InnerObject");
        System.out.println("Inner Name: " + inner.getName());

    }

}
