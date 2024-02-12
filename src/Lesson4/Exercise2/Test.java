package Lesson4.Exercise2;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<LocalDate> dates = new ArrayList<>();
        dates.add(LocalDate.parse("2018-7-11"));
        dates.add(LocalDate.parse("1919-10-25"));
        dates.add(LocalDate.of(1980, Month.DECEMBER, 31));

        dates.removeIf(x -> x.getYear() < 2000);

        System.out.println(dates);

    }

}
