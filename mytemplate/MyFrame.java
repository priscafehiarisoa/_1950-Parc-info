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
        getMypannel().setSize(1000,600);
    }

    public MyFrame(String titre) throws HeadlessException {
        setTitle(titre);
        setMypannel(new JPanel());
        getMypannel().setAutoscrolls(true);
        setLayout(new BorderLayout());
        getMypannel().add(new JLabel(getTitre()), BorderLayout.NORTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(1100,550));
        setLocationRelativeTo(null);
        JScrollPane j=new JScrollPane(getMypannel());
        add(j);
    }

    public void showPannel()
    {
        setVisible(true);
    }


}
