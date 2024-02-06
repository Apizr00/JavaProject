package lesson1.quiz1.Q4;

public class Test {

    private static void div() {

        System.out.println(1 / 0);
    }

    public static void main(String[] args) {

        try {

            div();
        } finally {
            System.out.println("FINALLY");
        }
    }

}
