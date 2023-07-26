package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务器已启动，等待客户端连接...");

            while (true) {
                Socket acceptSocket = serverSocket.accept();
                System.out.println("已建立连接");
                // 使用多线程处理客户端请求
                new Thread(() -> handleClientRequest(acceptSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClientRequest(Socket clientSocket) {
        try {
            // 处理客户端请求，例如读取HTTP请求和发送HTTP响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            String line;
            // 读取HTTP请求的头部
            while ((line = reader.readLine()) != null && !line.isEmpty()) {
                System.out.println(line);
            }

            // HTTP响应
            String response = "HTTP/1.1 200 OK\r\nContent-Type: text/plain\r\nContent-Length: 13\r\n\r\nHello, client!";
            writer.write(response);
            writer.flush();

            // 关闭资源
            reader.close();
            writer.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
