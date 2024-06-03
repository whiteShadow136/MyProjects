package org.example.fileUpload;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.Inet4Address;
import java.net.InetSocketAddress;

public class UploadServer {

    private static final String UPLOAD_DIRECTORY = "/uploads";

    public static void main(String[] args) throws IOException {
        if (!new File(UPLOAD_DIRECTORY).exists()) {
            new File(UPLOAD_DIRECTORY).mkdirs();
        }
//        HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0", 8000), 0);
        HttpServer server = HttpServer.create(new InetSocketAddress(Inet4Address.getLocalHost(), 8000), 0);
//        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/upload", new UploadHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started on port 8000");
    }

    static class UploadHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("POST".equals(exchange.getRequestMethod())) {
                InputStream inputStream = exchange.getRequestBody();

                String filename = exchange.getRequestHeaders().getFirst("X-Filename");
                File file = new File(UPLOAD_DIRECTORY + "/" + filename);

                try (FileOutputStream fos = new FileOutputStream(file)) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                    }
                }

                String response = "File uploaded successfully";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else {
                exchange.sendResponseHeaders(405, -1); // 405 Method Not Allowed
            }
        }
    }
}
