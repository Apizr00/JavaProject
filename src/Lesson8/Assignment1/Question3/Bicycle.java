package Lesson8.Assignment1.Question3;

class Bicycle implements Vehicle {

    private boolean isMoving = false;
    private double speed = 0;

    @Override
    public void start() {

        if (!isMoving) {

            System.out.println("Bicycle is starting.");
            isMoving = true;

        } else {

            System.out.println("Bicycle is already moving.");
        }
    }

    @Override
    public void stop() {

        if (isMoving) {

            System.out.println("Bicycle is stopping.");
            isMoving = false;
            speed = 0;

        } else {

            System.out.println("Bicycle is already stopped.");
        }
    }

    @Override
    public void accelerate(double speed) {

        this.speed += speed;
        System.out.println("Bicycle is accelerating. Current speed: " + this.speed + " km/h");
    }

    @Override
    public void brake(double speed) {

        this.speed -= speed;

        if (this.speed < 0) {

            this.speed = 0;
        }

        System.out.println("Bicycle is braking. Current speed: " + this.speed + " km/h");
    }
}
