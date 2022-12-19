package mytemplate.listener;

import client.displays.ClientDisplay;
import client.socket.ClientSocket;
import mytemplate.Mybutton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Client_listener implements MouseListener {
    Mybutton mybutton;
    ClientSocket client;
    ClientDisplay display;
    Boolean on=true;
    Boolean socket=true;

    public Boolean getSocket() {
        return socket;
    }

    public void setSocket(Boolean socket) {
        this.socket = socket;
    }

    public Boolean isOn() {
        return on;
    }

    public void setOn(Boolean on) {
        this.on = on;
    }

    public ClientDisplay getDisplay() {
        return display;
    }

    public void setDisplay(ClientDisplay display) {
        this.display = display;
    }

    public ClientSocket getClient() {
        return client;
    }

    public void setClient(ClientSocket client) {
        this.client = client;
    }

    public Mybutton getMybutton() {
        return mybutton;
    }

    public void setMybutton(Mybutton mybutton) {
        this.mybutton = mybutton;
    }

    public Client_listener(Mybutton button, ClientSocket client, ClientDisplay display) {
        setMybutton(button);
        setClient(client);
        setDisplay(display);

    }


    @Override
    public void mouseClicked(MouseEvent e) {


        if(isOn()) {

            setSocket(true);
            getDisplay().repaint();
            getClient().setHost(getDisplay().getHost().getText());
            getClient().setRuninng(true);
            System.out.println(getClient().getHost());
            getClient().setPort(Integer.parseInt(getDisplay().getPort().getText()));
            getClient().start();
            getDisplay().getMybutton().setText("starting");
            getDisplay().repaint();
            setOn(false);
        } else if (!isOn() && getSocket()) {
            getClient().setRuninng(false);
            getDisplay().getMybutton().setText("stopped");

            setOn(true);
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
