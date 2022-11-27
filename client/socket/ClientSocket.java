package client.socket;

import infos.SystemInfo;

import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket {
    public static void main(String[] args) {
        try {
            SystemInfo infos=new SystemInfo();
            Socket s = new Socket("localhost", 6666);
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
