package Lesson8.Assignment1.Question3;

class Car implements Vehicle {

    private boolean isRunning = false;
    private double speed = 0;

    @Override
    public void start() {

        if (!isRunning) {

            System.out.println("Car is starting.");
            isRunning = true;

        } else {

            System.out.println("Car is already running.");
        }
    }

    @Override
    public void stop() {

        if (isRunning) {

            System.out.println("Car is stopping.");
            isRunning = false;
            speed = 0;

        } else {

            System.out.println("Car is already stopped.");
        }
    }

    @Override
    public void accelerate(double speed) {

        if (isRunning) {

            this.speed += speed;
            System.out.println("Car is accelerating. Current speed: " + this.speed + " km/h");

        } else {

            System.out.println("Cannot accelerate. Car is not running.");
        }
    }

    @Override
    public void brake(double speed) {

        if (isRunning) {

            this.speed -= speed;

            if (this.speed < 0) {

                this.speed = 0;
            }

            System.out.println("Car is braking. Current speed: " + this.speed + " km/h");

        } else {

            System.out.println("Cannot brake. Car is not running.");
        }
    }
}