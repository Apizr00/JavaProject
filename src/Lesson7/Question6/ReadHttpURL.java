package Lesson7.Question6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.net.URL;

public class ReadHttpURL {

    public static void main(String[] args) {

        String urlString = "https://example.com";

        try {

            URL url = new URL(urlString);

            URLConnection connection = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

            reader.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
