package infos;

import java.io.File;
import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.net.*;
import java.util.Enumeration;
import java.util.Vector;

public class SystemInfo implements Serializable {

    String UserName;
    String OperatingSystem;

    String OSVersion;
    String CPU_Usage;
    int processorsCores;
    String ipaddress;
    String macAddress;
    double ram;
    double totaldisk;
    double freeDiskMemory;

    public double getFreeDiskMemory() {
        return freeDiskMemory;
    }

    public void setFreeDiskMemory() {

        this.freeDiskMemory = new File("/").getFreeSpace()*9.31e-10;
    }
//111
    public double getRam() {
        return ram;
    }

    public void setRam() {
        this.ram = ((com.sun.management.OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean()).getTotalPhysicalMemorySize() * 9.31e10;
    }
    //111

    public double getTotaldisk() {
        return totaldisk;
    }

    public void setTotaldisk() {
        this.totaldisk = new File("/").getTotalSpace() * 9.31e-10;
    }
    //111
    public String getUserName() {
        return UserName;
    }

    public void setUserName() {
        UserName = System.getProperty("user.name");
    }
    //111
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
    //111
    public void setOperatingSystem() {
        OperatingSystem = System.getProperty("os.name");
    }
    public String getOperatingSystem() {
        return OperatingSystem;
    }
    //111
    public void setOSVersion() {
        this.OSVersion = System.getProperty("os.version");
    }
    public String getOSVersion() {
        return OSVersion;
    }
//111
    public void setCPU_Usage() {
        this.CPU_Usage = String.valueOf(ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage());
        ;
    }
    public String getCPU_Usage() {
        return CPU_Usage;
    }
//    111
    public void setProcessorscores() {
        this.processorsCores = Runtime.getRuntime().availableProcessors();
    }
    public int getProcessorscores() {
        return processorsCores;
    }

//    111
    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress() throws UnknownHostException {
        InetAddress ip= InetAddress.getLocalHost();
        String ipv4=ip.getHostAddress();
        ipaddress=ipv4;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }
//111
    public SystemInfo() throws Exception{
        setMacAddress();
        setCPU_Usage();
        setIpaddress();
        setOperatingSystem();
        setOSVersion();
        setProcessorscores();
        setUserName();
        setFreeDiskMemory();
        setRam();
        setTotaldisk();
        setFreeDiskMemory();

    }
    public SystemInfo(String ipaddress) throws Exception{
        setMacAddress();
        setCPU_Usage();
        setIpaddress(ipaddress);
        setOperatingSystem();
        setOSVersion();
        setProcessorscores();
        setUserName();
        setRam();
        setTotaldisk();
        setFreeDiskMemory();


    }

    public void showSysteminfo()
    {
        System.out.println("informations systeme de "+ getUserName());
        System.out.println("ipv4: "+getIpaddress());
        System.out.println("Mac Adress "+getMacAddress());
        System.out.println("OS : "+getOperatingSystem());
        System.out.println("OS version :"+getOSVersion());
        System.out.println("processorscores : "+getProcessorscores());
        System.out.println("CPU :"+getCPU_Usage());
        System.out.println("ram: "+getRam());
        System.out.println("total disk: "+getTotaldisk());
        System.out.println("free disk: "+getFreeDiskMemory());
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
        String [] data=new String[10];
        data[0]=getUserName();
        data[1]=getOperatingSystem();
        data[2]=getOSVersion();
        data[3]=getCPU_Usage();
        data[4]=String.valueOf(getProcessorscores());
        data[5]=getIpaddress();
        data[6]=getMacAddress();
        data[7]= String.valueOf(getRam());
        data[8]= String.valueOf(getTotaldisk());
        data[9]= String.valueOf(getFreeDiskMemory());

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
    public int getIndex(Vector<SystemInfo> systemInfos)
    {
        for (int i = 0; i < systemInfos.size(); i++) {
            if(this.getIpaddress().equals(systemInfos.get(i).getIpaddress()))
            {
                return i;
            }
        }
        return -1;
    }
}
