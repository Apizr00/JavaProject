package Lesson8.Assignment1.Question13;

class TemperatureSensor implements Sensor {

    @Override
    public void measure() {

        System.out.println("Measuring temperature...");
        // Implement temperature measurement logic here
    }

    @Override
    public void calibrate() {

        System.out.println("Calibrating temperature sensor...");
        // Implement temperature sensor calibration logic here
    }
}
