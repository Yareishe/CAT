package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws IOException {
        String url = "https://http.cat/" + code + ".jpg";
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        int responseCode = connection.getResponseCode();
        connection.disconnect();
        if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {
            System.out.println("don't know this is the code " + code);
            url = null;
        }
        return url;
    }

}
