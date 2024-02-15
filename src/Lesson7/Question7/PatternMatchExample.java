package Lesson7.Question7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatchExample {
    public static void main(String[] args) {

        String regex = "\\b\\w+\\b";

        Pattern pattern = Pattern.compile(regex);

        String inputText = "Hafiz-Rodzli";

        Matcher matcher = pattern.matcher(inputText);

        while (matcher.find()) {

            System.out.println("Match found: " + matcher.group());
        }

    }
}