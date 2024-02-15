package Lesson8.Assignment1.Question13;

public class SensorTest {
    public static void main(String[] args) {

        // Create instances of TemperatureSensor and PressureSensor
        TemperatureSensor temperatureSensor = new TemperatureSensor();
        PressureSensor pressureSensor = new PressureSensor();

        // Use the sensors
        temperatureSensor.calibrate();
        temperatureSensor.measure();

        pressureSensor.calibrate();
        pressureSensor.measure();
    }
}