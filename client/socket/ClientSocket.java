package client.socket;

import infos.SystemInfo;

import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket {
    int port;
    String host;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public static void main(String[] args) {
        try {
            String hostW="10.211.55.4";
            String hostM="localhost";
            String hostMac="10.37.129.2";
            String hostTec="192.168.19.225";
            String hostLinux="192.168.19.159";
            Socket s = new Socket(hostTec, 1234);

            SystemInfo infos=new SystemInfo();
            ObjectOutputStream dout=new ObjectOutputStream(s.getOutputStream());
            dout.writeObject(infos);
            dout.flush();
            dout.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
//        ClientSocket client=new ClientSocket();

    }

//    @Override
    public void run() {
        try {

            Socket s = new Socket(getHost(), getPort());

            SystemInfo infos=new SystemInfo(s.getInetAddress().getHostAddress());
            ObjectOutputStream dout=new ObjectOutputStream(s.getOutputStream());
            dout.writeObject(infos);
            dout.flush();
            dout.close();
            s.close();
            Thread.sleep(2000);
//            this.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
