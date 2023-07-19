package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HttpImageStatusCli {


    public void askStatus() {
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter HTTP status code:");
            String input = reader.readLine();
            int statusCode = parseStatusCode(input);
            try {
                httpStatusImageDownloader.downloadStatusImage(statusCode);
            } catch (IOException e) {
                System.out.println("There is no image for HTTP status " + statusCode);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading input.");
        }
    }
    private int parseStatusCode(String input) {
        int statusCode;
        try {
            statusCode = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number");
            return -1;
        }
        return statusCode;
    }

    public static void main(String[] args) {
        HttpImageStatusCli httpImageStatusCli = new HttpImageStatusCli();
        httpImageStatusCli.askStatus();
    }

}