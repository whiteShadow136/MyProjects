package com.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @Author:谢锦创
 * @Date:2023/6/18
 * @Description:com.example
 * @VERSION:1.0
 */
public class MySocket {

    Socket getSocket() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("开始监听");
        Socket clientSocket = null;
            clientSocket = serverSocket.accept();
        System.out.println(clientSocket);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // Read data from the client and echo it back
        String message = in.readLine();
        System.out.println("Received from client: " + message);
        out.println("Echo: " + message);

        // Close connections
        in.close();
        out.close();
        clientSocket.close();
        return clientSocket;
    }

    public MySocket() {
        System.out.println(11111);
        System.out.println(11111);
        System.out.println(11111);
        System.out.println(11111);
    }

    public static void staticTest() {
        System.out.println(2222);
    }
}
