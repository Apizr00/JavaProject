package Lesson10.Quiz4.Question19;

interface M {

    public static void log() {

        System.out.println("M");
    }
}

abstract class A {

    public static void log() {

        System.out.println("N");
    }
}

class MyClass extends A implements M {
}

public class Test {

    public static void main(String[] args) {

        // M obj1 = new MyClass();
        // obj1.log();

        // A obj2 = new MyClass();
        // obj2.log();

        // MyClass obj3 = new MyClass();
        // obj3.log();
    }

}
