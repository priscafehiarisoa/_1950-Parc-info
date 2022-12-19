package server.displays;

import infos.SystemInfo;
import mytemplate.listener.ButtonListener;

import javax.swing.*;
import java.awt.*;

public class SocketDisplay extends JFrame {
    public SocketDisplay(String title) throws Exception {
        super(title);
        SystemInfo s=new SystemInfo();
        Color background=new Color(50,0,35);
        this.setSize(500,500);
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBackground(background);
        panel.setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel label=new JLabel("server");
        JLabel label2=new JLabel("addresse ip : 192.168.88.25");
        JLabel label3=new JLabel("port: 1234");

        label.setForeground(new Color(200,200,255));
        label.setFont(new Font("Serif", Font.PLAIN, 30));
        label.setBounds(200,10,350,350);

        label2.setForeground(new Color(200,200,255));
        label2.setFont(new Font("Serif", Font.PLAIN, 30));
        label2.setBounds(100,50,350,350);

        label3.setForeground(new Color(200,200,255));
        label3.setFont(new Font("Serif", Font.PLAIN, 30));
        label3.setBounds(200,100,350,350);

        panel.add(label);
        panel.add(label2);
        panel.add(label3);
//        panel.setLayout(null);
        JButton button=new JButton("start server");
        button.addMouseListener(new ButtonListener(this));
        button.setBounds(200,350,100,35);
        panel.add(button);
        this.add(panel);
        this.setVisible(true);

    }
}
