package Lesson8.Assignment1.Question3;

public class Main {
    public static void main(String[] args) {

        Vehicle car = new Car();
        car.start();
        car.accelerate(50);
        car.brake(10);
        car.stop();

        System.out.println();

        Vehicle bicycle = new Bicycle();
        bicycle.start();
        bicycle.accelerate(20);
        bicycle.brake(5);
        bicycle.stop();
    }
}
