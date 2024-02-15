package Lesson8.Assignment1.Question5;

class Dog extends Animal {

    public Dog(String name, int age) {

        super(name, age);
    }

    @Override
    void makeSound() {

        System.out.println(name + " says Woof!");
    }
}