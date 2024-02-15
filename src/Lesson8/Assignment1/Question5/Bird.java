package Lesson8.Assignment1.Question5;

class Bird extends Animal {

    public Bird(String name, int age) {

        super(name, age);
    }

    @Override
    void makeSound() {

        System.out.println(name + " sings Tweet-tweet!");
    }
}