package Lesson4.Quiz2.Question11;

import java.time.LocalDate;
import java.time.Period;

public class Test {

    public static void main(String[] args) {

        LocalDate date = LocalDate.parse("2000-01-01");
        Period period = Period.ofYears(-3000);
        System.out.println(date.plus(period));

    }

}
