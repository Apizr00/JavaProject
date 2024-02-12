package Lesson4.Assignment.Inheritance;

class Dog extends Animal {

    public Dog(String name) {

        super(name, "Bark");
    }

    @Override
    public void makeSound() {

        System.out.print("Bark");
    }
}