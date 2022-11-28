package display_test;

import infos.SystemInfo;
import mytemplate.MyFrame;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {
        try {
            SystemInfo s = new SystemInfo();

            InetAddress ip = InetAddress.getLocalHost();
            s.setIpaddress();
            System.out.println(s.getIpaddress());
            System.out.println(ip.getHostName());
            System.out.println(ip.getCanonicalHostName());

            System.out.println("PROCESSOR_IDENTIFIER " + System.getenv("PROCESSOR_IDENTIFIER"));
            System.out.println("PROCESSOR_ARCHITECTURE " + System.getenv("PROCESSOR_ARCHITECTURE"));
            System.out.println("PROCESSOR_ARCHITEW6432 " + System.getenv("PROCESSOR_ARCHITEW6432"));
            System.out.println("NUMBER_OF_PROCESSORS " + System.getenv("NUMBER_OF_PROCESSORS"));
            System.out.println("Available processors (cores): " +
                    Runtime.getRuntime().availableProcessors());
            System.out.println("Free memory (bytes): " +
                    Runtime.getRuntime().freeMemory());

            long maxMemory = Runtime.getRuntime().maxMemory();
//             Maximum amount of memory the JVM will attempt to use
            System.out.println("Maximum memory (bytes): " +
                    (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));
            System.out.println("Total memory (bytes): " +
                    Runtime.getRuntime().totalMemory());
            System.out.println("tttttttttttt");

            s.setMacAddress();
            System.out.println(s.getMacAddress());

            System.out.println(System.getProperty("user.name"));
        }


        catch(Exception e)
            {
                e.printStackTrace();
            }
        MyFrame frame=new MyFrame();
        
        frame.showPannel();
        }
    }
