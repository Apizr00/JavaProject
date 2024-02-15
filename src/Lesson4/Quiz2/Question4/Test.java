package Lesson4.Quiz2.Question4;

import java.util.function.Predicate;

public class Test {

    public static void main(String[] args) {

        String[] arr = { "A", "ab", "bab", "baba", "aba", "Abab" };

        processStringArray(arr, p -> p.length() >= 1);
        // p -> p.length() < 10
        // p -> true
        // p -> !false
    }

    private static void processStringArray(String[] arr, Predicate<String> predicate) {

        for (String str : arr) {

            if (predicate.test(str)) {

                System.out.println(str);
            }
        }

    }

}
