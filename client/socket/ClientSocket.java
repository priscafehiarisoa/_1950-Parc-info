package client.socket;

import infos.SystemInfo;
import server.socket.Server_socket;

import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket extends Thread{
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

    public static void main(String[] args) throws Exception {
//        try {
//            String hostW="10.211.55.4";
//            String hostM="localhost";
//            String hostMac="10.37.129.2";
//            String hostTec="192.168.19.225";
//            String hostLinux="192.168.19.159";
//            Socket s = new Socket(hostM, 1234);
//
//            SystemInfo infos=new SystemInfo();
//            ObjectOutputStream dout=new ObjectOutputStream(s.getOutputStream());
//            dout.writeObject(infos);
//            dout.flush();
//            dout.close();
//            s.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        while(true) {
            ClientSocket client = new ClientSocket();
            client.setHost("192.168.88.165");
            client.setPort(1234);
            client.start();
            Thread.sleep(2000);


        }
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
            ClientSocket c=new ClientSocket();
//            Thread.sleep(2000);
//            c.start();


//            this.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
