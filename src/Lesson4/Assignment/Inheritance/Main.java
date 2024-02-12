package Lesson4.Assignment.Inheritance;

public class Main {

    public static void main(String[] args) {

        Animal genericAnimal = new Animal("Generic Animal", "Some sound");
        System.out.print("Animal:");
        genericAnimal.makeSound();

        Dog myDog = new Dog("Buddy");
        System.out.print("Dog:");
        myDog.makeSound();
    }

}
