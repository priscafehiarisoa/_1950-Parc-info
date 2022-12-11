package mytemplate.listener;

import mytemplate.Mybutton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client_listener implements ActionListener {
    Mybutton mybutton;

    public Mybutton getMybutton() {
        return mybutton;
    }

    public void setMybutton(Mybutton mybutton) {
        this.mybutton = mybutton;
    }

    public Client_listener(Mybutton button) {
        setMybutton(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(getMybutton().getValues()==1)
        {

        }
    }
}
