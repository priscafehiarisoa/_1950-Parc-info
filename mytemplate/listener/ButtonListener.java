package mytemplate.listener;

import server.displays.SocketDisplay;
import server.socket.Server_socket;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class ButtonListener implements MouseListener {
    SocketDisplay display;

    public SocketDisplay getDisplay() {
        return display;
    }

    public void setDisplay(SocketDisplay display) {
        this.display = display;
    }

    public ButtonListener(SocketDisplay socketDisplay) {
        setDisplay(socketDisplay);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        getDisplay().dispose();
        Server_socket server=new Server_socket();
        server.start();
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
