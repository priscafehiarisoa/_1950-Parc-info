package server.socket;

import infos.SystemInfo;
import mytemplate.MyFrame;
import mytemplate.Tableau;
import thread.Mythread;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server_socket {

    public static Socket createServer() throws Exception
    {
        ServerSocket socket=new ServerSocket(6666);
        Socket socket1=socket.accept();
        return socket1;
    }

    public static void main(String[] args) throws IOException {
        Vector<SystemInfo> myinfos=new Vector<>();
        MyFrame frame=new MyFrame("ma page");
        ServerSocket socket = new ServerSocket(1234);

        int o=0;
        while(true) {
            try {
                System.out.println("ordinateurs connectes" + myinfos.size());
                Socket s = socket.accept();
                Mythread thread=new Mythread(s,myinfos);
                thread.start();
                thread.join();
//                Thread.sleep(3000);
                Tableau tab=new Tableau(myinfos);
//                JTable t =tab.createJtable();
                JScrollPane t =tab.createJtable2();

                t.setPreferredSize(new Dimension(1000,450));
                frame.getMypannel().remove(0);
                frame.getMypannel().add(t);
                frame.repaint();
                frame.showPannel();
                o=1;

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
}
