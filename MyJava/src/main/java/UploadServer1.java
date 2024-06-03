import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.InetSocketAddress;

public class UploadServer1 {

    public static void main(String[] args) throws IOException {
        if (!new File("/uploads").exists()) {
            new File("/uploads").mkdirs();
        }

        HttpServer server = HttpServer.create(new InetSocketAddress(5005), 0);
        server.createContext("/upload", new UploadHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server started on port 5005");
    }

    static class UploadHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
                InputStream inputStream = exchange.getRequestBody();
                String filename = exchange.getRequestHeaders().getFirst("X-Filename");
                File file = new File("/uploads" + "/" + filename);
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
        }
    }
}
