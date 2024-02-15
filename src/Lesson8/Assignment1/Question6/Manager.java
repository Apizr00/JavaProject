package Lesson8.Assignment1.Question6;

class Manager extends Employee {

    public Manager(String name, int id) {

        super(name, id);
    }

    @Override
    public void calculateSalary() {

        salary = 10000;
    }
}


