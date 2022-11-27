package server.socket;

import infos.SystemInfo;

import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_socket {

    public static Socket createServer() throws Exception
    {
        ServerSocket socket=new ServerSocket(6666);
        Socket socket1=socket.accept();
        return socket1;
    }

    public static void main(String[] args) {
        try{
            ServerSocket socket=new ServerSocket(6666);
            Socket s=socket.accept();
            ObjectInputStream dis=new ObjectInputStream(s.getInputStream());
            SystemInfo info=(SystemInfo) dis.readObject();
            info.showSysteminfo();
//            socket.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
