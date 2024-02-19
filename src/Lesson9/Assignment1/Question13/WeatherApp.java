package Lesson9.Assignment1.Question13;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherApp {

    private JFrame frame;
    private JTextField cityTextField;
    private JTextArea weatherTextArea;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> new WeatherApp().createAndShowGUI());
    }

    private void createAndShowGUI() {

        frame = new JFrame("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        JLabel cityLabel = new JLabel("Enter City:");
        cityLabel.setBounds(20, 20, 80, 25);
        frame.add(cityLabel);

        cityTextField = new JTextField();
        cityTextField.setBounds(100, 20, 200, 25);
        frame.add(cityTextField);

        JButton getWeatherButton = new JButton("Get Weather");
        getWeatherButton.setBounds(310, 20, 120, 25);

        getWeatherButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String city = cityTextField.getText();

                if (!city.isEmpty()) {

                    String weatherData = getWeatherData(city);
                    weatherTextArea.setText(weatherData);

                } else {

                    JOptionPane.showMessageDialog(frame, "Please enter a city name.");
                }
            }
        });
        frame.add(getWeatherButton);

        weatherTextArea = new JTextArea();
        weatherTextArea.setBounds(20, 60, 360, 180);
        frame.add(weatherTextArea);

        frame.setVisible(true);
    }

    private String getWeatherData(String city) {

        try {

            String apiKey = "YOUR_API_KEY"; // Replace with your actual API key
            String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
            URL url = new URL(apiUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {

                response.append(line);
            }

            reader.close();
            connection.disconnect();

            return response.toString();

        } catch (Exception e) {

            e.printStackTrace();
            return "Error fetching weather data.";
        }
    }
}
