package client.socket;

import infos.SystemInfo;

import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket {
    public static void main(String[] args) {
        try {
            String hostW="10.211.55.4";
            String hostM="localhost";
            String hostMac="10.37.129.2";
            String hostTec="192.168.54.225";
            Socket s = new Socket(hostM, 1234);

            SystemInfo infos=new SystemInfo(s.getInetAddress().getHostName());
            ObjectOutputStream dout=new ObjectOutputStream(s.getOutputStream());
            dout.writeObject(infos);
            dout.flush();
            dout.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
