package Lesson8.Assignment1.Question6;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager("Hafiz", 1);
        manager.calculateSalary();
        manager.displayDetails();

        System.out.println();

        Developer developer = new Developer("Ajim", 2);
        developer.calculateSalary();
        developer.displayDetails();

        System.out.println();

        Intern intern = new Intern("Malek", 3);
        intern.calculateSalary();
        intern.displayDetails();
    }
}
