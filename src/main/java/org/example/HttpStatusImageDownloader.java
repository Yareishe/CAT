package org.example;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class HttpStatusImageDownloader {
    public static void main(String[] args) throws IOException {
        HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
        httpStatusImageDownloader.downloadStatusImage(1000);
    }

    public void downloadStatusImage(int code) throws IOException {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String noteror = httpStatusChecker.getStatusImage(code);
        if (noteror != null) {
            URL url = new URL(noteror);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(code + ".jpg");
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            inputStream.close();
        }
        else {
            System.out.println("Failed to download image. " + code);
        }
    }

}

