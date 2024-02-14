package Lesson5.Question9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleWebScraper {

    public static void main(String[] args) {
        String url = "https://example.com"; // Replace with the URL of the webpage you want to scrape
        String outputFile = "extracted_data.txt";

        try {
            // Fetch HTML content
            String htmlContent = fetchHtmlContent(url);

            // Extract data using regular expressions
            String extractedData = extractData(htmlContent);

            // Write extracted data to a text file
            writeToFile(outputFile, extractedData);

            System.out.println("Extraction and writing to file successful!");

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    private static String fetchHtmlContent(String urlString) throws IOException {

        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {

                content.append(line);
            }

            return content.toString();

        } finally {

            connection.disconnect();
        }
    }

    private static String extractData(String htmlContent) {

        // Replace this regex pattern with the one suitable for your specific data
        // extraction
        Pattern pattern = Pattern.compile("<a\\s+href\\s*=\\s*\"([^\"]+)\"[^>]*>(.*?)</a>");
        Matcher matcher = pattern.matcher(htmlContent);

        StringBuilder extractedData = new StringBuilder();

        while (matcher.find()) {

            String link = matcher.group(1);
            String linkText = matcher.group(2);

            extractedData.append("Link: ").append(link).append("\tText: ").append(linkText).append("\n");
        }

        return extractedData.toString();
    }

    private static void writeToFile(String fileName, String content) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            writer.write(content);
        }
    }
}
