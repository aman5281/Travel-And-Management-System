package Travelmanagementsystem;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{

    String username;
    Thread t;
    JProgressBar bar;

    public void run(){
        try{
            for (int i = 1; i < 200; i++) {
                int max=bar.getMaximum(); //100
                int value=bar.getValue();

                if(value<max){ //101<100
                    bar.setValue(bar.getValue()+1);
                }else{
                    i=201;
                    setVisible(false);
                    new dashboard(username);
                }
                Thread.sleep(50);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    Loading(String username){
        this.username=username;
        t=new Thread(this);

        setBounds(350,200,650,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text= new JLabel("Travel And Tourism Application");
        text.setBounds(50,20,600,40);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Raleway",Font.BOLD,33));
        add(text);

        bar=new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);

        JLabel Loading= new JLabel("Loading,Please Wait");
        Loading.setBounds(230,130,150,40);
        Loading.setForeground(Color.red);
        Loading.setFont(new Font("Raleway",Font.BOLD,15));
        add(Loading);

        JLabel lblusername= new JLabel("Welcome " +username);
        lblusername.setBounds(20,310,400,40);
        lblusername.setForeground(Color.RED);
        lblusername.setFont(new Font("Raleway",Font.BOLD,15));
        add(lblusername);

        t.start();
        setVisible(true);
    }


    public static void main(String[] args) {
        new Loading("");
    }
}
