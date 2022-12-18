package server.displays;

import mytemplate.listener.ButtonListener;

import javax.swing.*;
import java.awt.*;

public class SocketDisplay extends JFrame {
    public SocketDisplay(String title) throws HeadlessException {
        super(title);
        Color background=new Color(50,0,35);
        this.setSize(500,500);
        JPanel panel=new JPanel();
        panel.setBackground(background);
        panel.setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel label=new JLabel("server");
        label.setForeground(new Color(200,200,255));
        label.setFont(new Font("Serif", Font.PLAIN, 30));
        label.setBounds(100,100,350,350);
        panel.add(label);
        panel.setLayout(null);
        JButton button=new JButton("start server");
        button.addMouseListener(new ButtonListener(this));
        button.setBounds(250,250,100,35);
        panel.add(button);
        this.add(panel);
        this.setVisible(true);

    }
}
