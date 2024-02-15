package Lesson8.Assignment1.Question13;

class PressureSensor implements Sensor {

    @Override
    public void measure() {

        System.out.println("Measuring pressure...");
        // Implement pressure measurement logic here
    }

    @Override
    public void calibrate() {

        System.out.println("Calibrating pressure sensor...");
        // Implement pressure sensor calibration logic here
    }
}
