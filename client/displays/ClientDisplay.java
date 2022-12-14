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
    JTextField ip;
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

    public JTextField getIp() {
        return ip;
    }

    public void setIp(JTextField ip) {
        this.ip = ip;
    }

    public JTextField getHost() {
        return host;
    }

    public void setHost(JTextField host) {
        this.host = host;
    }

    public ClientDisplay() throws HeadlessException {
        setClient(new ClientSocket());
        setLayout(new GridLayout(2,1));
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel jPanel=new JPanel();
        JPanel jp2=new JPanel();

        jPanel.setSize(500,500);
        setIp(new JTextField());
        setHost(new JTextField());
        jPanel.add(getIp());
        jPanel.add(getHost());

        Mybutton JB=new Mybutton(1,400,400);
        setMybutton(JB);
        jp2.add(getMybutton());
        getMybutton().addMouseListener(new Client_listener(JB, getClient(),this));
        add(jPanel);
        add(jp2);
        add(JB);
        setFocusable(true);
        setVisible(true);


    }

}
