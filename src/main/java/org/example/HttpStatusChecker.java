package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws IOException, ImageNotFoundException {
        String url = "https://http.cat/" + code + ".jpg";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        int responseCode = connection.getResponseCode();
        connection.disconnect();
        if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
            throw new ImageNotFoundException("Image not found for code: " + code);
        }
        return url;
    }

    public class ImageNotFoundException extends Exception {
        public ImageNotFoundException(String message) {
            super(message);
        }
    }

}
