package Travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BookPackage extends JFrame implements ActionListener {

    Choice Package;
    JTextField tfperson;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice,bookPackage,back;
    BookPackage(String username){
        this.username=username;
        setBounds(100,100,1100,500);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text=new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);

        JLabel lblUsername= new JLabel("Username");
        lblUsername.setBounds(40,70,100,20);
        lblUsername.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblUsername);

        labelusername=new JLabel();
        labelusername.setBounds(250,70,200,20);
        labelusername.setFont(new Font("Tahoma",Font.BOLD,16));
        add(labelusername);

        JLabel lblpackage= new JLabel("Select Package");
        lblpackage.setBounds(40,110,150,20);
        lblpackage.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblpackage);

        Package=new Choice();
        Package.add("Gold Package");
        Package.add("Silver Package");
        Package.add("Bronze Package");
        Package.setBounds(250,110,200,20);
        add(Package);

        JLabel lblperson= new JLabel("Total Persons");
        lblperson.setBounds(40,150,150,20);
        lblperson.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblperson);

        tfperson =new JTextField("12");
        tfperson.setBounds(250,150,200,25);
        add(tfperson);

        JLabel lblid= new JLabel("Id");
        lblid.setBounds(40,190,150,20);
        lblid.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblid);

        labelid= new JLabel();
        labelid.setBounds(250,190,200,25);
        add(labelid);

        JLabel lblnumber= new JLabel("Number");
        lblnumber.setBounds(40,230,150,20);
        lblnumber.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblnumber);

        labelnumber= new JLabel();
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);

        JLabel lblphone= new JLabel("Phone");
        lblphone.setBounds(40,270,150,20);
        lblphone.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblphone);

        labelphone= new JLabel();
        labelphone.setBounds(250,270,200,25);
        add(labelphone);

        JLabel lbltotal= new JLabel("Total Price");
        lbltotal.setBounds(40,310,150,20);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbltotal);

        labelprice= new JLabel();
        labelprice.setBounds(250,310,150,25);
        add(labelprice);

        try {
            Conn conn =new Conn();
            String query="select * from customer where username ='"+username+"'";
            ResultSet rs=conn.s.executeQuery(query);
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        checkprice =new JButton("Check Price");
        checkprice.setBackground(Color.black);
        checkprice.setForeground(Color.white);
        checkprice.setBounds(60,380,120,35);
        checkprice.addActionListener(this);
        add(checkprice);

        bookPackage =new JButton("Book Package");
        bookPackage.setBackground(Color.black);
        bookPackage.setForeground(Color.white);
        bookPackage.setBounds(200,380,120,35);
        bookPackage.addActionListener(this);
        add(bookPackage);

        back =new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(340,380,120,35);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookPackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(550,50,500,300);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            int cost =0;
            String pack=Package.getSelectedItem();
            if (pack.equals("Gold Package")){
                cost+=12000;
            } else if (pack.equals("Silver Package")) {
                cost+=25000;
            }else {
                cost+=32000;
            }
            int persons= Integer.parseInt(tfperson.getText());
            cost*=persons;
            labelprice.setText("Rs "+cost);

        } else if (ae.getSource()==bookPackage) {
            try {
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+Package.getSelectedItem()+"','"+tfperson.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");

                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookPackage("");
    }
}
