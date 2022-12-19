package display_test;

import client.displays.ClientDisplay;
import infos.SystemInfo;
import mytemplate.MyFrame;
import mytemplate.Tableau;
import server.displays.SocketDisplay;

import javax.management.MBeanServerConnection;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;
//import java.lang.management.OperatingSystemMXBean;
import com.sun.management.OperatingSystemMXBean;

//import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws Exception {

        ClientDisplay c = new ClientDisplay();
        SystemInfo s = new SystemInfo();
        s.showSysteminfo();
        System.out.println(new Timestamp(System.currentTimeMillis()));
        System.out.println("---------");
//        System.out.println(SystemInfo.getCPULoad());
        System.out.println();
        System.out.println("----------");
//            SocketDisplay s=new SocketDisplay("server");
//
//        }
/*        while (true) {
            MBeanServerConnection mbsc = ManagementFactory.getPlatformMBeanServer();

            OperatingSystemMXBean osMBean = ManagementFactory.newPlatformMXBeanProxy(
                    mbsc, ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME, OperatingSystemMXBean.class);

            long nanoBefore = System.nanoTime();
            long cpuBefore = osMBean.getProcessCpuTime();

// Call an expensive task, or sleep if you are monitoring a remote process

            long cpuAfter = osMBean.getProcessCpuTime();
            long nanoAfter = System.nanoTime();

            long percent;
            if (nanoAfter > nanoBefore)
                percent = ((cpuAfter - cpuBefore) * 100L) /
                        (nanoAfter - nanoBefore);
            else percent = 0;

            System.out.println("Cpu usage: " + percent + "%");
            Thread.sleep(2000);
        }*/

    }



//    public static double getCPULoad2() {
//        try {
//            ProcessBuilder processBuilder = new ProcessBuilder();
//            processBuilder.command("bash", "-c", "top -bn1 | grep load | awk '{printf \"%.2f\", $(NF-2)}'");
//            Process process = processBuilder.start();
//            Scanner scanner = new Scanner(process.getInputStream());
//            double load = Double.parseDouble(scanner.nextLine());
//            scanner.close();
//            return load;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0.0;
//        }
//    }

}

