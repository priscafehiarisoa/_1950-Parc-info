package mytemplate;

import infos.SystemInfo;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.Vector;

public class Tableau {
    Vector <SystemInfo> infoSysteme;

    public Vector<SystemInfo> getInfoSysteme() {
        return infoSysteme;
    }

    public void setInfoSysteme(Vector<SystemInfo> infoSysteme) {
        this.infoSysteme = infoSysteme;
    }

    public Tableau(Vector<SystemInfo> infoSysteme) {
        this.infoSysteme = infoSysteme;
    }

    public JTable createTable()
    {
        return new JTable();
    }


    public String [][] createStringTable() throws Exception
    {
        /**buts
         * creer un tableau de string A afficher dans le tableau a partir d'un vecteur
         * vecteur en parametre de la classe
         * */
        SystemInfo tries=new SystemInfo();
        int size= getInfoSysteme().size();
        Field[] field=tries.getClass().getDeclaredFields();
        String[][] datas=new String[size][field.length];
        System.out.println("hhehehee: "+field.length);
        for (int i = 0; i < getInfoSysteme().size(); i++) {
            datas[i]=getInfoSysteme().get(i).createSystemInfoTable();
        }
        return datas;
    }

    public JScrollPane createJtable2 () throws Exception/**/
    {
        SystemInfo test=new SystemInfo();
        String [] column= test.getAttributs();
        String [][] datas=createStringTable();
         JTable jt = new JTable(datas, column);
       /* for (int i = 0; i < column.length; i++) {
            jt.getColumnModel().getColumn(i).setPreferredWidth(100);
        }*/
        JScrollPane sp = new JScrollPane(jt);
//        sp.setSize(1000,500);
        System.out.println("column");

        return sp;
    }
    public JTable createJtable () throws Exception/**/
    {
        SystemInfo test=new SystemInfo();
        String [] column= test.getAttributs();
        String [][] datas=createStringTable();
        JTable jt = new JTable(datas, column);
      /*  for (int i = 0; i < column.length; i++) {
            jt.getColumnModel().getColumn(i).setPreferredWidth(300);
        }*/
        JScrollPane sp = new JScrollPane(jt);
        sp.setSize(1000,500);
        System.out.println("column");

        return jt;
    }


}
