package my.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MyServer {

    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException {

        ServerSocket s = new ServerSocket(PORT);
        System.out.println("Server Started");

        try {
            while (true)
            {
                Socket socket = s.accept();

                try {
                    new ServeOne(socket);
                }
                catch (IOException e) {
                    socket.close();
                }
            }
        }
        finally {
            s.close();
        }
    }
}