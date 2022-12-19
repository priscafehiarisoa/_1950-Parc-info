package test;

import infos.SystemInfo;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Vector;

public class Chart extends JFrame {

    Vector<SystemInfo> data;

    public Vector<SystemInfo> getData() {
        return data;
    }

    public void setData(Vector<SystemInfo> data) {
        this.data = data;
    }

    public Chart(String title, Vector<SystemInfo> datas) throws HeadlessException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        super(title);
        setData(datas);
        // Create dataset
        DefaultCategoryDataset dataset = createdataset("CPU_Usage");
        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(
                "CPU_Usage", // Chart title
                "Date", // X-Axis Label
                "CPU", // Y-Axis Label
                dataset
        );

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);

    }

    public DefaultCategoryDataset createdataset(String attribute) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        DefaultCategoryDataset mydatas=new DefaultCategoryDataset();

        for (int i = 0; i < getData().size() ; i++) {
            double xValue=(double)getData().get(i).getClass().getMethod("get"+uppercase(attribute)).invoke(getData().get(i));
            Timestamp yvalue=(Timestamp)getData().get(i).getClass().getMethod("getHeure").invoke(getData().get(i));
            mydatas.addValue(xValue,attribute,yvalue );
        }
        return mydatas;
    }
    public static String uppercase(String string)
    {
        return string.substring(0,1).toUpperCase()+string.substring(1,string.length());
    }

    public static void main(String[] args) throws Exception {
        Vector<SystemInfo> syst=new Vector<>();
        syst.add(new SystemInfo());
        Thread.sleep(4000);
        syst.add(new SystemInfo());
        Thread.sleep(4000);
        syst.add(new SystemInfo());
        Thread.sleep(4000);
        syst.add(new SystemInfo());

            Chart example = null;
            try {
                example = new Chart("chart",syst);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            example.setAlwaysOnTop(true);
            example.pack();
            example.setSize(600, 400);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        ;
    }


}
