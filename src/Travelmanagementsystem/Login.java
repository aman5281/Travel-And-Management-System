package Travelmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField tfusername,tfpassword;
    JButton login,password,signup;
    Login(){
        setSize(900,400);
        setLocation(250,200);
        setLayout(null);
        getContentPane().setBackground(Color.white);

        JPanel j1=new JPanel();
        j1.setBackground(new Color(131,191,233));
        j1.setBounds(0,0,430,400);
        j1.setLayout(null);
        add(j1);

        JPanel j2= new JPanel();
        j2.setLayout(null);
        j2.setBounds(400,30,450,300);
        add(j2);

        JLabel lblUsername=new JLabel("Username");
        lblUsername.setBounds(60,20,100,25);
        lblUsername.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        j2.add(lblUsername);

        tfusername=new JTextField();
        tfusername.setBounds(50,50,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        j2.add(tfusername);

        JLabel lblPassword=new JLabel("Password");
        lblPassword.setBounds(60,110,100,25);
        lblPassword.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
        j2.add(lblPassword);

        tfpassword=new JTextField();
        tfpassword.setBounds(50,140,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        j2.add(tfpassword);

        login=new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.white);
        login.setBorder(BorderFactory.createEmptyBorder());
        login.addActionListener(this);
        j2.add(login);

        signup=new JButton("Sign Up");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.white);
        signup.setBorder(BorderFactory.createEmptyBorder());
        signup.addActionListener(this);
        j2.add(signup);

        password=new JButton("Forgot Password");
        password.setBounds(130,250,130,30);
        password.setBackground(new Color(133,193,233));
        password.setForeground(Color.white);
        password.setBorder(BorderFactory.createEmptyBorder());
        password.addActionListener(this);
        j2.add(password);

        JLabel text=new JLabel("Trouble in Login...");
        text.setBounds( 300,250,150,20);
        text.setForeground(Color.red);
        j2.add(text);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(100,120,200,200);
        j1.add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==login){
            try{
                String username = tfusername.getText();
                String pass = tfpassword.getText();

                String query ="select * from account where username ='"+username+"'AND password ='"+pass+"'";
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect username or password");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==signup) {
            setVisible(false);
            new Signup();
        }else{
            setVisible(false);
            new ForgetPassword();
        }
    }


    public static void main(String[] args) {
        new Login();
    }
}
