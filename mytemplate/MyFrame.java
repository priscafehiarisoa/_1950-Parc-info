package mytemplate;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    JPanel mypannel;
    String titre;


    public String getTitre() {
        return titre;
    }


    public void setTitre(String title) {
        this.titre = title;
    }

    public JPanel getMypannel() {
        return mypannel;
    }

    public void setMypannel(JPanel mypannel) {
        this.mypannel = mypannel;
    }

    public MyFrame() throws HeadlessException {
        setMypannel(new JPanel());
        getMypannel().setAutoscrolls(true);
        setLayout(new BorderLayout());
        getMypannel().add(new JLabel(getTitre()), BorderLayout.NORTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(500,500));
        setLocationRelativeTo(null);
        add(this.getMypannel());
    }

    public void showPannel()
    {
        setVisible(true);
    }


}
