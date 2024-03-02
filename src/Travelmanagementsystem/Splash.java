package Travelmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread thread;
    Splash(){
//        setSize(1200,600); //Desktop Size
//        setLocation(100,50);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/desktop.jpeg"));
        Image i2=i1.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        add(image);

        setVisible(true); // For visibility of desktop
        thread=new Thread(this);
        thread.start();
    }

    public void run(){
        try{
            Thread.sleep(5000);
            setVisible(false);

            Login l=new Login();
            l.setVisible(true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Splash Frame=new Splash();

        int x=1;

        for (int i=1;i<=500;x+=7,i+=6){
            Frame.setLocation(650-(x+i)/2,350-(i/2));
            Frame.setSize(x+i,i);
            try {
            Thread.sleep(10);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
