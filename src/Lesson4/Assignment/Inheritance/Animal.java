package Lesson4.Assignment.Inheritance;

class Animal {

    String name;
    String sound;

    public Animal(String name, String sound) {

        this.name = name;
        this.sound = sound;
    }

    public void makeSound() {

        System.out.println(sound);
    }
}