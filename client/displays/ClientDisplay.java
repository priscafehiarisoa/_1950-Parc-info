package client.displays;

import client.socket.ClientSocket;
import mytemplate.MyFrame;
import mytemplate.Mybutton;
import mytemplate.listener.Client_listener;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class ClientDisplay extends JFrame {
    ClientSocket client;
    JTextField port;
    JTextField host;
    Mybutton mybutton;

    public Mybutton getMybutton() {
        return mybutton;
    }

    public void setMybutton(Mybutton mybutton) {
        this.mybutton = mybutton;
    }

    public ClientSocket getClient() {
        return client;
    }

    public void setClient(ClientSocket client) {
        this.client = client;
    }

    public JTextField getPort() {
        return port;
    }

    public void setPort(JTextField port) {
        this.port = port;
    }

    public JTextField getHost() {
        return host;
    }

    public void setHost(JTextField host) {
        this.host = host;
    }

    public ClientDisplay() throws HeadlessException {
        //creer le socket client
        setClient(new ClientSocket());

        JLabel label=new JLabel("veuillez remplir les champs ci-dessus ");
        label.setForeground(new Color(200,200,255));
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setBounds(100,10,350,350);

        setLayout(new GridLayout(2,1));
        Color background=new Color(50,0,35);
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel jPanel=new JPanel();
        JPanel jp2=new JPanel();
        setTitle("client");
        jPanel.add(label);
//        setLayout(null);

        jPanel.setSize(500,500);
        jPanel.setBackground(background);
        setPort(new JTextField());
        getPort().setBounds(50,50,200,50);
        getPort().setPreferredSize(new Dimension(200,50));
        getPort().setText("1234");
        setHost(new JTextField());
        getHost().setBounds(250,50,200,50);
        getHost().setPreferredSize(new Dimension(200,50));
        getHost().setText("localhost");
        jPanel.add(getPort());
        jPanel.add(getHost());

        Mybutton JB=new Mybutton(1,400,400);
        setMybutton(JB);
        jp2.add(getMybutton());
        // creer le socket client
        getMybutton().addMouseListener(new Client_listener(JB, getClient(),this));
        jp2.setBounds(100,200,200,100);
        jp2.setBackground(background);
        jPanel.setBackground(background);
        jPanel.setLayout(null);


        add(jPanel);
        add(jp2);
        jp2.add(JB);
        setFocusable(true);
        setVisible(true);


    }

}
