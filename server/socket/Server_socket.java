package server.socket;

import infos.SystemInfo;
import mytemplate.MyFrame;
import mytemplate.Tableau;

import javax.swing.*;
import java.io.DataInputStream;
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

    public static void main(String[] args) {
        Vector<SystemInfo> myinfos=new Vector<>();
        while(true) {
            try {
                System.out.println("ordinateurs connectes" + myinfos.size());
                ServerSocket socket = new ServerSocket(6666);
                Socket s = socket.accept();
                ObjectInputStream dis = new ObjectInputStream(s.getInputStream());
                SystemInfo info = (SystemInfo) dis.readObject();
                info.showSysteminfo();
                socket.close();

                if( !info.isInList(myinfos))
                {
                    myinfos.add(info);
                }
                MyFrame frame=new MyFrame("ma page");
                Tableau tab=new Tableau(myinfos);
                JScrollPane t =tab.createJtable();
                frame.getMypannel().add(t);
                frame.repaint();
                frame.showPannel();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
