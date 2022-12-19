package client.socket;

import client.displays.ClientDisplay;
import infos.SystemInfo;
import server.socket.Server_socket;
import test.Chart;

import javax.swing.*;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;

public class ClientSocket extends Thread{
    int port;
    String host;
    boolean runinng;
    Vector<SystemInfo> infos;

    public Vector<SystemInfo> getInfos() {
        return infos;
    }

    public void setInfos(Vector<SystemInfo> infos) {
        this.infos = infos;
    }

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
        setInfos(new Vector<SystemInfo>());
        while(true) {
            try {
                if(this.isRuninng()) {
                    Socket s = new Socket(getHost(), getPort());
                    SystemInfo infos = new SystemInfo(s.getInetAddress().getHostAddress());
                    getInfos().add(infos);
                    ObjectOutputStream dout = new ObjectOutputStream(s.getOutputStream());
                    dout.writeObject(infos);
                    System.out.println("Host: " + getHost());
                    System.out.println("port: " + getPort());
                    dout.flush();
                    dout.close();
                    s.close();
                    System.out.println(">>"+getInfos().size());

                    Thread.sleep(2000);

                }
                else {
                    System.out.println("stopped");
                    this.interrupt();
                    // chart
                    Chart example = null;
                    try {
                        example = new Chart("chart",getInfos());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    example.setAlwaysOnTop(true);
                    example.pack();
                    example.setSize(600, 400);
                    example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    example.setVisible(true);
                    break;
                }

            } catch (Exception e) {
                System.out.println(e);
                break;
            }

        }
    }
}
