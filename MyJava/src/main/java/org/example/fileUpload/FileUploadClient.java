package org.example.fileUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileUploadClient {

    public static void main(String[] args) {
        String fileToUpload = "D:\\test\\uploadTest\\1.txt";
        String serverUrl = "http://139.159.189.207:8000/upload";

        try {
            File file = new File(fileToUpload);
            uploadFile(file, serverUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void uploadFile(File file, String serverUrl) throws Exception {
        HttpURLConnection connection = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;

        try {
            URL url = new URL(serverUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/octet-stream");
            connection.setRequestProperty("X-Filename", file.getName());

            outputStream = connection.getOutputStream();
            fileInputStream = new FileInputStream(file);

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.flush();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("File uploaded successfully");
            } else {
                System.out.println("Failed to upload file: " + responseCode);
            }
        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
