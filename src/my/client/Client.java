package my.client;



import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends Thread {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    private String name;
    private JTextArea txOut;

    private boolean isRunning = true;

    public Client(InetAddress addr, int port)
    {
        //this.txOut = ta;

        try {
            socket = new Socket(addr, port);
            try {
                in = new BufferedReader(new InputStreamReader(socket
                        .getInputStream()));
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                        socket.getOutputStream())), true);
                start();
            } catch (IOException e) {
                try {
                    socket.close();
                } catch (IOException e2) {
                    System.err.println("Socket not closed");
                }
            }
            //println("connected successfully");
        } catch (IOException e) {
            println("cannot connect");
            //System.err.println("Socket failed");
        }

    }

    public void run() {
        try {
            while (isRunning)
            {
                String str = in.readLine();
                println(str);
            }
        } catch (IOException e) {
            System.err.println("IO Exception");
        } finally {
            // Всегда закрывает:
            try {
                System.out.println("here");
                socket.close();
            } catch (IOException e) {
                System.err.println("Socket not closed");
            }
        }
    }

    public void println(String str)
    {
        txOut.append(str+"\n");
    }

    public void  send(String str){
        out.println(str);
    }

    public void setTxOut(JTextArea txOut) {
        this.txOut = txOut;
    }

    public void stopClient(){
        isRunning = false;
        System.out.println("stopping client");
    }
}
