package Travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class dashboard extends JFrame implements ActionListener {

    JButton addPersonalDetails,updatePersonalDetails
            ,viewPersonalDetails,deletePersonalDetails,
            checkPackages,bookPackage,viewPackage,viewhotels,
            bookhotel,viewBookedHotel,destination,payments
            ,calculator,notepad,about;

    String username;
    dashboard(String username){
        this.username=username;

        setExtendedState(JFrame.MAXIMIZED_BOTH); //For fullscreen frame
        setLayout(null);

        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1600,65);
        add(p1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel icon=new JLabel(i3);
        icon.setBounds(5, 0,70,70);
        p1.add(icon);

        JLabel heading=new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        heading.setForeground(Color.white);
        p1.add(heading);

        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,300,1400);
        add(p2);

        addPersonalDetails=new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,50);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.white);
        addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);

        updatePersonalDetails=new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,50,300,50);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.white);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);

        viewPersonalDetails=new JButton("View Details");
        viewPersonalDetails.setBounds(0,100,300,50);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.white);
        viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,130));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);

        deletePersonalDetails=new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,150,300,50);
        deletePersonalDetails.setBackground(new Color(0,0,102));
        deletePersonalDetails.setForeground(Color.white);
        deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,35));
        deletePersonalDetails.addActionListener(this);
        p2.add(deletePersonalDetails);

        checkPackages=new JButton("Check Packages");
        checkPackages.setBounds(0,200,300,50);
        checkPackages.setBackground(new Color(0,0,102));
        checkPackages.setForeground(Color.white);
        checkPackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkPackages.setMargin(new Insets(0,0,0,95));
        checkPackages.addActionListener(this);
        p2.add(checkPackages);

        bookPackage=new JButton("Book Package");
        bookPackage.setBounds(0,250,300,50);
        bookPackage.setBackground(new Color(0,0,102));
        bookPackage.setForeground(Color.white);
        bookPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookPackage.setMargin(new Insets(0,0,0,115));
        bookPackage.addActionListener(this);
        p2.add(bookPackage);

        viewPackage=new JButton("View Package");
        viewPackage.setBounds(0,300,300,50);
        viewPackage.setBackground(new Color(0,0,102));
        viewPackage.setForeground(Color.white);
        viewPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPackage.setMargin(new Insets(0,0,0,115));
        viewPackage.addActionListener(this);
        p2.add(viewPackage);

        viewhotels=new JButton("View Hotels");
        viewhotels.setBounds(0,350,300,50);
        viewhotels.setBackground(new Color(0,0,102));
        viewhotels.setForeground(Color.white);
        viewhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewhotels.setMargin(new Insets(0,0,0,135));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);

        bookhotel=new JButton("Book Hotels");
        bookhotel.setBounds(0,400,300,50);
        bookhotel.setBackground(new Color(0,0,102));
        bookhotel.setForeground(Color.white);
        bookhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookhotel.setMargin(new Insets(0,0,0,135));
        bookhotel.addActionListener(this);
        p2.add(bookhotel);

        viewBookedHotel=new JButton("View Booked Hotels");
        viewBookedHotel.setBounds(0,450,300,50);
        viewBookedHotel.setBackground(new Color(0,0,102));
        viewBookedHotel.setForeground(Color.white);
        viewBookedHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewBookedHotel.setMargin(new Insets(0,0,0,65));
        viewBookedHotel.addActionListener(this);
        p2.add(viewBookedHotel);

        destination=new JButton("Destination");
        destination.setBounds(0,500,300,50);
        destination.setBackground(new Color(0,0,102));
        destination.setForeground(Color.white);
        destination.setFont(new Font("Tahoma",Font.PLAIN,20));
        destination.setMargin(new Insets(0,0,0,135));
        destination.addActionListener(this);
        p2.add(destination);

        payments=new JButton("Payments");
        payments.setBounds(0,550,300,50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.white);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,150));
        payments.addActionListener(this);
        p2.add(payments);

        about=new JButton("About");
        about.setBounds(0,600,270,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.white);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,150));
        about.addActionListener(this);
        p2.add(about);

        ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5= i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image =new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);

        JLabel text=new JLabel("Travel And Tourism Management System");
        text.setBounds(400,70,1200,70);
        text.setForeground(Color.white);
        text.setFont(new Font("Raleway",Font.PLAIN,45));
       image.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==addPersonalDetails){
            new AddCustomer(username);
        } else if (ae.getSource()==viewPersonalDetails) {
            new ViewCustomer(username);
        } else if (ae.getSource()==updatePersonalDetails) {
            new UpdateCustomer(username);
        } else if (ae.getSource()==checkPackages) {
            new CheckPackages();
        } else if (ae.getSource()==bookPackage) {
            new BookPackage(username);
        } else if (ae.getSource()==viewPackage) {
            new ViewPackage(username);
        } else if (ae.getSource()==viewhotels) {
            new CheckHotels();
        } else if (ae.getSource()==destination) {
            new Destination();
        } else if (ae.getSource()==bookhotel) {
            new BookHotel(username);
        } else if (ae.getSource()==viewBookedHotel) {
            new ViewBookedHotel(username);
        } else if (ae.getSource()==payments) {
            new Payment();
        } else if (ae.getSource()==about) {
            new About();
        } else if (ae.getSource()==deletePersonalDetails) {
            new DeleteDetails(username);
        }
    }

    public static void main(String[] args) {
     new dashboard("");
    }
}
