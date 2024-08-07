package org.example.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Description:org.example.controller
 * @Date:2024/6/4
 * @Author:谢锦创
 */
@RestController
public class UploadController {

    @RequestMapping("/upload")
    public String uploadFile(@RequestParam String path,@RequestParam String ip,@RequestParam String port) {
        String serverUrl = "http://".concat(ip).concat(":").concat(port).concat("/upload");

        try {
            File file = new File(path);
            uploadFile(file, serverUrl);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return "SUCCESS";
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
