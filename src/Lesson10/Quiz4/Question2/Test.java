package Lesson10.Quiz4.Question2;

class Base {

    String msg = "INHALE";
}

class Derived extends Base {

    Object msg = "EXHALE";
}

public class Test {

    public static void main(String[] args) {

        Base obj1 = new Base();
        Base obj2 = new Derived();
        Derived obj3 = (Derived) obj2;
        String text = obj1.msg + "-" + obj2.msg + "-" + obj3.msg;
        System.out.println(text);

    }

}
