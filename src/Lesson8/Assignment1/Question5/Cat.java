package Lesson8.Assignment1.Question5;

class Cat extends Animal {

    public Cat(String name, int age) {

        super(name, age);
    }

    @Override
    void makeSound() {

        System.out.println(name + " says Meow!");
    }
}
