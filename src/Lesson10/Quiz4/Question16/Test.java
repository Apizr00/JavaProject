package Lesson10.Quiz4.Question16;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Test {

    public static void main(String[] args) {

        List<String> words = new ArrayList<>();
        words.add("A");
        words.add("an");
        words.add("the");
        words.add("when");
        words.add("what");
        words.add("where");
        words.add("whether");

        processStringArray(words, p -> !!!!true);

        // p -> p.length() >= 1
        // p -> true
        // (String p) -> p.length() < 100

    }

    private static void processStringArray(List<String> list, Predicate<String> predicate) {

        for (String str : list) {

            if (predicate.test(str)) {

                System.out.println(str);
            }
        }
    }

}
