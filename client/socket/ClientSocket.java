package client.socket;

import client.displays.ClientDisplay;
import infos.SystemInfo;
import server.socket.Server_socket;

import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket extends Thread{
    int port;
    String host;
    boolean runinng;

    public boolean isRuninng() {
        return runinng;
    }

    public void setRuninng(boolean runinng) {
        this.runinng = runinng;
    }

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

     /*   *//** TEST IF CLIENT IS SENDING DATAS*/
        while(true) {
            ClientSocket client = new ClientSocket();
            client.setHost("localhost");
            client.setPort(1234);
            client.start();
            Thread.sleep(3000);
        }
//        ClientDisplay c=new ClientDisplay();
    }

//    @Override
    public void run() {
        while(true) {
            try {

                Socket s = new Socket(getHost(), getPort());
                SystemInfo infos = new SystemInfo(s.getInetAddress().getHostAddress());
                ObjectOutputStream dout = new ObjectOutputStream(s.getOutputStream());
                dout.writeObject(infos);
                System.out.println("Host: "+getHost());
                System.out.println("port: "+getPort());
                dout.flush();
                dout.close();
                s.close();
                Thread.sleep(2000);

            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }
}
