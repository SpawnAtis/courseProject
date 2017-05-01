package my.client;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainWinow extends JFrame {
    private JTextField portField;
    private JTextField hostField;
    private JTextField aField;
    JButton sendBtn;
    private JTextArea inField;
    private JButton connectBtn;
    private JTextField salaryFiled;
    private JTextField hoursField;

    private Client client;

    public MainWinow() {

        setSize(347,488);
        getContentPane().setLayout(null);

        setSize(347,418);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Client");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(105, 13, 184, 28);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\u041F\u043E\u0440\u0442");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(12, 40, 111, 22);
        getContentPane().add(lblNewLabel_1);

        JLabel lblSecondName = new JLabel("\u0425\u043E\u0441\u0442");
        lblSecondName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSecondName.setBounds(105, 40, 71, 22);
        getContentPane().add(lblSecondName);

        JLabel lblPassportNumber = new JLabel("\u041D\u0430\u0437\u0432\u0430\u043D\u0438\u0435 \u043F\u0440\u043E\u0444\u0444\u0435\u0441\u0438\u0438");
        lblPassportNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPassportNumber.setBounds(12, 110, 164, 22);
        getContentPane().add(lblPassportNumber);

        sendBtn = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438\u0442\u044C \u0417\u0430\u043F\u0438\u0441\u044C");
        sendBtn.setFont(new Font("Tahoma", Font.BOLD, 25));
        sendBtn.setBounds(12, 335, 305, 27);
        getContentPane().add(sendBtn);

        portField = new JTextField();
        portField.setText("8080");
        portField.setBounds(12, 75, 71, 22);
        getContentPane().add(portField);
        portField.setColumns(10);

        hostField = new JTextField();
        hostField.setText("127.0.0.1");
        hostField.setColumns(10);
        hostField.setBounds(105, 75, 71, 22);
        getContentPane().add(hostField);

        aField = new JTextField();
        aField.setColumns(10);
        aField.setBounds(12, 135, 305, 28);
        getContentPane().add(aField);

        inField = new JTextArea();
        inField.setBounds(11, 264, 306, 58);
        getContentPane().add(inField);
        inField.setColumns(10);

        JLabel lblIn = new JLabel("In");
        lblIn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblIn.setBounds(154, 233, 57, 22);
        getContentPane().add(lblIn);

        connectBtn = new JButton("\u0421\u043E\u0435\u0434\u0438\u043D\u0438\u0442\u044C\u0441\u044F");
        connectBtn.setBounds(183, 40, 134, 58);
        getContentPane().add(connectBtn);

        JLabel label = new JLabel("\u0417\u0430\u0440\u043F\u043B\u0430\u0442\u0430");
        label.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label.setBounds(12, 167, 137, 22);
        getContentPane().add(label);

        salaryFiled = new JTextField();
        salaryFiled.setColumns(10);
        salaryFiled.setBounds(12, 192, 137, 28);
        getContentPane().add(salaryFiled);

        hoursField = new JTextField();
        hoursField.setColumns(10);
        hoursField.setBounds(171, 192, 137, 28);
        getContentPane().add(hoursField);

        JLabel label_1 = new JLabel("\u043A\u043E\u043B-\u0432\u043E \u0440\u0430\u0431. \u0447\u0430\u0441\u043E\u0432");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_1.setBounds(171, 167, 137, 22);
        getContentPane().add(label_1);



        connectBtn.addActionListener(e -> setConnect());
        sendBtn.addActionListener(e -> send("LOL"));

    }


    private void setConnect(){
        try {
            if (portField.getText().equals("8080")&&hostField.getText().equals("127.0.0.1")) {
                InetAddress addr = InetAddress.getByName(null);
                //client = new Client(addr, Integer.parseInt(portField.getText()), inField);
            }else {
                InetAddress addr = InetAddress.getByName(hostField.getText());
                System.out.println();
                //client = new Client(addr, Integer.parseInt(portField.getText()), inField);
            }
        } catch (UnknownHostException e)
        {
            client.println("cannot Connect");
        }
    }

    public void send(String str){
        System.out.println(aField.getText());
        if(client!=null)
            client.send(str);
    }

}
