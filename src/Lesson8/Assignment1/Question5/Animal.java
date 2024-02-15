package Lesson8.Assignment1.Question5;

abstract class Animal {

    String name;
    int age;

    public Animal(String name, int age) {

        this.name = name;
        this.age = age;
    }

    abstract void makeSound();

    void eat() {

        System.out.println(name + " is eating.");
    }

    void sleep() {

        System.out.println(name + " is sleeping.");
    }
}
