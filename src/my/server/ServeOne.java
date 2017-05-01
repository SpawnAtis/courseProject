package my.server;

import my.server.dao.dao.UserMySQLDAO;
import my.server.dao.entity.User;

import my.server.utils.Parser;


import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ServeOne extends Thread {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private UserMySQLDAO userDAO;

    public ServeOne(Socket s) throws IOException {
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket
                .getOutputStream())), true);

        userDAO = new UserMySQLDAO();
        start();
    }

    //работа сервера
    public void run() {
        try {
            out.println("server connected");

            while (true) {

                String str = in.readLine();
                System.out.println(str);

                String[] arr = str.split("&");

                switch(arr[0]){
                    case "register":

                        String[] info = arr[1].split("/");
                        UserMySQLDAO userMySQLDAO = new UserMySQLDAO();
                        userMySQLDAO.add(new User(0,info[0],info[1]));
                        break;

                    case "client":
                        System.out.println("Client command");
                        break;
                    default:
                        System.out.println("No command");
                }

            }
           // System.err.println("IO Exception");
        } catch (IOException e) {
            System.out.println("closing...");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Socket not closed");
            }
        }
    }
}
