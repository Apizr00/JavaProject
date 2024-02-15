package Lesson8.Assignment1.Question6;

abstract class Employee {

    protected String name;
    protected int id;
    protected double salary;

    public Employee(String name, int id) {

        this.name = name;
        this.id = id;
    }

    public abstract void calculateSalary();

    public void displayDetails() {

        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: RM " + salary);
    }
}
