package Travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BookHotel extends JFrame implements ActionListener {

    Choice chotel,cac,cfood;
    JTextField tfdays,tfperson;
    String username;
    JLabel labelusername,labelid,labelnumber,labelphone,labelprice;
    JButton checkprice,bookPackage,back;
    BookHotel(String username){
        this.username=username;
        setBounds(100,100,1100,600);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text=new JLabel("BOOK HOTEL");
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

        JLabel lblpackage= new JLabel("Select Hotel");
        lblpackage.setBounds(40,110,150,20);
        lblpackage.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblpackage);

        chotel=new Choice();
        chotel.setBounds(250,110,200,20);
        add(chotel);

        try{
            Conn c=new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while (rs.next()){
                chotel.add(rs.getString("name"));

            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel lblperson= new JLabel("Total Persons");
        lblperson.setBounds(40,150,150,20);
        lblperson.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblperson);

        tfperson =new JTextField("1");
        tfperson.setBounds(250,150,200,25);
        add(tfperson);

        JLabel lbldays= new JLabel("No. of Days");
        lbldays.setBounds(40,190,150,20);
        lbldays.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbldays);

        tfdays =new JTextField("1");
        tfdays.setBounds(250,190,200,25);
        add(tfdays);

        JLabel lblac= new JLabel("AC/ Non-AC");
        lblac.setBounds(40,230,150,20);
        lblac.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblac);

        cac=new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250,230,200,20);
        add(cac);

        JLabel lblfood= new JLabel("Food Included");
        lblfood.setBounds(40,270,150,20);
        lblfood.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblfood);

        cfood=new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250,270,200,20);
        add(cfood);

        JLabel lblid= new JLabel("Id");
        lblid.setBounds(40,310,150,20);
        lblid.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblid);

        labelid= new JLabel();
        labelid.setBounds(250,310,200,25);
        add(labelid);

        JLabel lblnumber= new JLabel("Number");
        lblnumber.setBounds(40,350,150,20);
        lblnumber.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblnumber);

        labelnumber= new JLabel();
        labelnumber.setBounds(250,350,150,25);
        add(labelnumber);

        JLabel lblphone= new JLabel("Phone");
        lblphone.setBounds(40,390,150,20);
        lblphone.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblphone);

        labelphone= new JLabel();
        labelphone.setBounds(250,390,200,25);
        add(labelphone);

        JLabel lbltotal= new JLabel("Total Price");
        lbltotal.setBounds(40,430,150,20);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbltotal);

        labelprice= new JLabel();
        labelprice.setBounds(250,430,150,25);
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
        checkprice.setBounds(60,490,120,35);
        checkprice.addActionListener(this);
        add(checkprice);

        bookPackage =new JButton("Book Hotel");
        bookPackage.setBackground(Color.black);
        bookPackage.setForeground(Color.white);
        bookPackage.setBounds(200,490,120,35);
        bookPackage.addActionListener(this);
        add(bookPackage);

        back =new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(340,490,120,35);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(550,50,500,400);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==checkprice){
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name='" + chotel.getSelectedItem() + "'");
                while (rs.next()) {
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));

                    int person = Integer.parseInt(tfperson.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String acSelected = cac.getSelectedItem();
                    String foodSelected = cfood.getSelectedItem();

                    if (person * days > 0) {
                        int total = 0;
                        total += acSelected.equals("AC") ? ac : 0;
                        total += foodSelected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * person * days;
                        labelprice.setText("Rs " + total);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please Enter the Valid Number");
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==bookPackage) {
            try {
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfperson.getText()+"','"+tfdays.getText() +"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");

                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotel("");
    }
}
