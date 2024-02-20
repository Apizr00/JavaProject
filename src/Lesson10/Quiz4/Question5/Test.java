package Lesson10.Quiz4.Question5;

class X {

    void A() {

        System.out.print("A");
    }
}

class Y extends X {

    void A() {

        System.out.println("A-");
    }

    void B() {

        System.out.println("B-");
    }

    void C() {

        System.out.println("C-");
    }
}

public class Test {

    public static void main(String[] args) {

        X obj = new Y();
        obj.A();
        // obj.B();
        // obj.C();
    }

}
