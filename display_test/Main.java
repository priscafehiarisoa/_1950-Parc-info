package display_test;

import infos.SystemInfo;
import mytemplate.MyFrame;
import mytemplate.Tableau;

import javax.swing.*;
import java.awt.*;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        try {
            SystemInfo sti=new SystemInfo();
            sti.showSysteminfo();

            OperatingSystemMXBean osBean =
                    (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
            System.out.println("p"+osBean.getSystemLoadAverage());
            ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage();
            System.out.println("====");

        }




        catch(Exception e)
            {
                e.printStackTrace();
            }

        }
    }
