package Lesson10.Quiz4.Question21;

public class Test {

    public static void main(String[] args) {

        int elements = 0;

        Object[] arr = { "A", "E", "I", new Object(), "O", "U" };

        for (Object obj : arr) {

            if (obj instanceof String) {

                continue;

            } else {

                break;
            }

            // elements++;
        }
        System.out.println(elements);

    }

}
