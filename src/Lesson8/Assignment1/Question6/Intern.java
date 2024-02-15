package Lesson8.Assignment1.Question6;

class Intern extends Employee {

    public Intern(String name, int id) {

        super(name, id);
    }

    @Override
    public void calculateSalary() {

        salary = 1800;
    }
}
