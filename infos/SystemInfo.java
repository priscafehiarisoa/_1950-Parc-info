package infos;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.net.*;
import java.util.Enumeration;
import java.util.Vector;

public class SystemInfo implements Serializable {

    String UserName;
    String OperatingSystem;


    String OSVersion;
    String CPU;
    int processorsCores;
    String ipaddress;
    String macAddress;

    public String getUserName() {
        return UserName;
    }

    public void setUserName() {
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
        setUserName();

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
    public boolean isInList(Vector<SystemInfo> SI){
        for (int i = 0; i < SI.size(); i++) {
            if(this.getIpaddress().equals(SI.get(i).getIpaddress()))
            {
                return true;
            }
        }
        return false;
    }

/*    public String [] createSystemInfoTable()
    {
        Field [] field= getClass().getDeclaredFields();
        String [] data=new String[field.length];
        for (int i = 0; i < field.length; i++) {
            data[i]=this.getClass().getMethod()
        }
    }*/

    public String [] createSystemInfoTable()
    {
        String [] data=new String[7];
        data[0]=getUserName();
        data[1]=getOperatingSystem();
        data[2]=getOSVersion();
        data[3]=getCPU();
        data[4]=String.valueOf(getProcessorscores());
        data[5]=getIpaddress();
        data[6]=getMacAddress();

        return data;
    }
    public String [] getAttributs()
    {
        Field [] field= getClass().getDeclaredFields();
        String [] attr=new String[field.length];
        for (int i = 0; i < field.length; i++) {
            attr[i]=field[i].getName();
        }
        return attr;

    }
}
