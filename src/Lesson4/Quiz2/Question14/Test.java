package Lesson4.Quiz2.Question14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Test {

    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();

        list.add(new Employee("James", 25, 15000));
        list.add(new Employee("Lucy", 23, 12000));
        list.add(new Employee("Bill", 27, 10000));
        list.add(new Employee("Jack", 19, 5000));
        list.add(new Employee("Liya", 20, 8000));

        process(list, e -> e.getAge() > 20);
    }

    private static void process(List<Employee> list, Predicate<Employee> predicate) {

        Iterator<Employee> iterator = list.iterator();

        while (iterator.hasNext()) {

            Employee e = iterator.next();

            if (predicate.test(e)) {

                System.out.println(e + " ");
            }

        }

    }

}