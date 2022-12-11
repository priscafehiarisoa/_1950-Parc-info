package mytemplate;

import javax.swing.*;

public class Mybutton extends JButton {
    int values;

    public int getValues() {
        return values;
    }

    public void setValues(int values) {
        this.values = values;
    }

    public Mybutton(int values, int x, int y) {
        getValues();
        setBounds(x,y,100,50);
        setText("lancer");
    }
}
