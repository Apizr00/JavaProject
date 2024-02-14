package Lesson1.quiz1.Q7;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {

        LocalDate date = LocalDate.parse("1983-06-30");
        System.out.println(date.plusMonths(8));
    }

}
