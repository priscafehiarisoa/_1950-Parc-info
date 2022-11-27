package infos;

import java.io.Serializable;
import java.net.*;
import java.util.Enumeration;

public class SystemInfo implements Serializable {
    String OperatingSystem;
    String UserName;
    String OSVersion;
    String CPU;
    int processorsCores;
    String ipaddress;
    String macAddress;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = System.getProperty("user.name");
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface ni = networkInterfaces.nextElement();
            byte[] hardwareAddress = ni.getHardwareAddress();
            if (hardwareAddress != null) {
                String[] hexadecimalFormat = new String[hardwareAddress.length];
                for (int i = 0; i < hardwareAddress.length; i++) {
                    hexadecimalFormat[i] = String.format("%02X", hardwareAddress[i]);
                }
                this.macAddress =String.join(":", hexadecimalFormat);
            }
        }

    }

    public void setOperatingSystem() {
        OperatingSystem = System.getProperty("os.name");
    }

    public void setOSVersion() {
        this.OSVersion = System.getProperty("os.version");
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public void setProcessorscores() {
        this.processorsCores = Runtime.getRuntime().availableProcessors();
    }

    public String getOperatingSystem() {
        return OperatingSystem;
    }

    public String getOSVersion() {
        return OSVersion;
    }

    public String getCPU() {
        return CPU;
    }

    public int getProcessorscores() {
        return processorsCores;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress() throws UnknownHostException {
        InetAddress ip= InetAddress.getLocalHost();
        String ipv4=ip.getHostAddress();
        ipaddress=ipv4;
    }

    public SystemInfo() throws Exception{
        setMacAddress();
        setCPU("");
        setIpaddress();
        setOperatingSystem();
        setOSVersion();
        setProcessorscores();

    }

    public void showSysteminfo()
    {
        System.out.println("informations systeme de "+ getUserName());
        System.out.println("ipv4: "+getIpaddress());
        System.out.println("Mac Adress "+getMacAddress());
        System.out.println("OS : "+getOperatingSystem());
        System.out.println("OS version :"+getOSVersion());
        System.out.println("processorscores : "+getProcessorscores());
        System.out.println("CPU :"+getCPU());
    }
}
