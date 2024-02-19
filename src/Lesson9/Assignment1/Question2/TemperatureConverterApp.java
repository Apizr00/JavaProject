package Lesson9.Assignment1.Question2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterApp extends JFrame {

    private JTextField inputField;
    private JComboBox<String> fromUnitComboBox, toUnitComboBox;
    private JLabel resultLabel;

    public TemperatureConverterApp() {

        setTitle("Temperature Converter");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Components
        inputField = new JTextField(10);
        fromUnitComboBox = new JComboBox<>(new String[] { "Celsius", "Fahrenheit", "Kelvin" });
        toUnitComboBox = new JComboBox<>(new String[] { "Celsius", "Fahrenheit", "Kelvin" });
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel("Result:");

        // Layout
        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("Enter Temperature:"));
        add(inputField);
        add(new JLabel("From Unit:"));
        add(fromUnitComboBox);
        add(new JLabel("To Unit:"));
        add(toUnitComboBox);
        add(convertButton);
        add(resultLabel);

        // Event handling
        convertButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                convertTemperature();
            }
        });
    }

    private void convertTemperature() {

        try {

            double temperature = Double.parseDouble(inputField.getText());
            String fromUnit = fromUnitComboBox.getSelectedItem().toString();
            String toUnit = toUnitComboBox.getSelectedItem().toString();

            double result = convert(temperature, fromUnit, toUnit);

            resultLabel.setText("Result: " + result + " " + toUnit);

        } catch (NumberFormatException ex) {

            resultLabel.setText("Invalid input. Please enter a valid number.");
        }
    }

    private double convert(double temperature, String fromUnit, String toUnit) {

        // Conversion logic
        if (fromUnit.equals("Celsius")) {

            if (toUnit.equals("Fahrenheit")) {

                return (temperature * 9 / 5) + 32;

            } else if (toUnit.equals("Kelvin")) {

                return temperature + 273.15;

            } else {

                return temperature;
            }
        } else if (fromUnit.equals("Fahrenheit")) {

            if (toUnit.equals("Celsius")) {

                return (temperature - 32) * 5 / 9;

            } else if (toUnit.equals("Kelvin")) {

                return (temperature - 32) * 5 / 9 + 273.15;

            } else {

                return temperature;
            }

        } else if (fromUnit.equals("Kelvin")) {

            if (toUnit.equals("Celsius")) {

                return temperature - 273.15;

            } else if (toUnit.equals("Fahrenheit")) {

                return (temperature - 273.15) * 9 / 5 + 32;

            } else {

                return temperature;
            }
        } else {

            return temperature; // Same unit, no conversion needed
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                new TemperatureConverterApp().setVisible(true);
            }
        });
    }
}
