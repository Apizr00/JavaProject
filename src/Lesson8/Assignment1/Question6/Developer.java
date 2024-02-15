package Lesson8.Assignment1.Question6;

class Developer extends Employee {

    public Developer(String name, int id) {

        super(name, id);
    }

    @Override
    public void calculateSalary() {
        
        salary = 5000;
    }
}
