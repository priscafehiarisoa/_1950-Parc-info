package thread;

import infos.SystemInfo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Vector;

public class Mythread extends Thread{
    Socket socket;
    /*Server server;

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }*/
    Vector<SystemInfo> systemInfoVec;

    public Vector<SystemInfo> getSystemInfoVec() {
        return systemInfoVec;
    }

    public void setSystemInfoVec(Vector<SystemInfo> systemInfoVec) {
        this.systemInfoVec = systemInfoVec;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket s) {
        this.socket = s;
    }



    public Mythread(Socket s, Vector<SystemInfo> vector) {
        setSocket(s);
        setSystemInfoVec(vector);

    }

    @Override
    public void run() {
        try {
            ObjectInputStream dis=new ObjectInputStream(getSocket().getInputStream());
            SystemInfo info = (SystemInfo) dis.readObject();
           /* if( !info.isInList(getSystemInfoVec()))
            {
                getSystemInfoVec().add(info);
            }*/
            getSystemInfoVec().add(info);

            info.showSysteminfo();
            getSocket().close();
            System.out.println("isa="+getSystemInfoVec().size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
