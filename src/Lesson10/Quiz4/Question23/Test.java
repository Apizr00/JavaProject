package Lesson10.Quiz4.Question23;

public class Test {

    public static void main(String[] args) {

        System.out.println(new RuntimeException());
        System.out.println(new RuntimeException("HELLO"));
        System.out.println(new RuntimeException(new RuntimeException("Hello")));
    }

}
