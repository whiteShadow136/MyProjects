package socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @Description:socket
 * @Date:2023/7/23
 * @Author:谢锦创
 */
public class MySocket {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8889);
        while (true) {
            System.out.println(1111);
            Socket acceptSocket = serverSocket.accept();
            InputStream inputStream = acceptSocket.getInputStream();
            int[] bytes = new int[1024];
            int index = 0;
            while ((bytes[index] = inputStream.read()) != -1) {
                System.out.print((char) bytes[index]);
                index++;
            }

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(acceptSocket.getOutputStream()));
            String response = "HTTP/1.1 200 OK\r\nContent-Type: text/plain\r\nContent-Length: 13\r\n\r\nHello, client!";
            writer.write(response);
            writer.flush();

            inputStream.close();
            acceptSocket.close();
            System.out.println(inputStream);
        }
    }
}
