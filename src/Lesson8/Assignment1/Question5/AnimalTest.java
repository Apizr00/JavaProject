package Lesson8.Assignment1.Question5;

public class AnimalTest {
    public static void main(String[] args) {

        Dog dog = new Dog("Dog", 3);
        Cat cat = new Cat("Cat", 2);
        Bird bird = new Bird("Bird", 1);

        dog.makeSound();
        dog.eat();
        dog.sleep();

        cat.makeSound();
        cat.eat();
        cat.sleep();

        bird.makeSound();
        bird.eat();
        bird.sleep();
    }
}