package my.client;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        /*MainWinow mainWinow = new MainWinow();
        mainWinow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWinow.setResizable(false);
        mainWinow.setVisible(true);*/

        ClientMainFrame mainFrame = new ClientMainFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.setVisible(true);
    }
}
