package myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	JButton login , clear, signup;
        JTextField cardTextField;
        JPasswordField pinTextField;
        Login() {
	    setTitle("ATM");
				
	    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
            Image i2 = i1.getImage().getScaledInstance(500,350, Image.SCALE_DEFAULT);
            JLabel label = new  JLabel(i1);
            label.setBounds(110,60,100,50);
            ImageIcon i3 = new ImageIcon(i2);
            add(label);
	        
            JLabel text = new  JLabel("welcome to ATM");
            text.setFont(new Font("Oswerd", Font.BOLD, 38));
            text.setBounds(250,60, 400, 40);
	    add(text);
		        
            JLabel cardno = new  JLabel("Card No:");
            cardno.setFont(new Font("Raleway", Font.BOLD, 28));
	    cardno.setBounds(120,140, 150, 30);
            add(cardno);
		       
            cardTextField = new JTextField();
            cardTextField.setBounds(280,140, 230, 30);
            cardTextField.setFont(new Font("Arial",Font.BOLD, 16));
            add(cardTextField);
            
            JLabel pin = new  JLabel("PIN:");
            pin.setFont(new Font("Raleway", Font.BOLD, 28));
            pin.setBounds(150, 200, 400, 30);
            add(pin);
            
            pinTextField = new JPasswordField();
            pinTextField.setBounds(280,200, 230, 30);
            pinTextField.setFont(new Font("Arial",Font.BOLD, 16));
            add(pinTextField);
            
            login = new JButton("SIGN IN");
            login.setBounds(280,270,100,30);
            login.setBackground(Color.BLACK);
            login.setForeground(Color.WHITE);
            login.addActionListener(this);
            add(login);
            
            clear = new JButton("Clear");
            clear.setBounds(410,270,100,30);
            clear.setBackground(Color.BLACK);
            clear.setForeground(Color.WHITE);
            clear.addActionListener(this);
            add(clear);
            
            signup = new JButton("Signup");
            signup.setBounds(280,330,230,30);
            signup.setBackground(Color.BLACK);
            signup.setForeground(Color.WHITE);
            signup.addActionListener(this);
            add(signup);
                            
            getContentPane().setBackground(Color.WHITE);
		        
            setLayout(null);
            setSize(700,480);
            setLocation(350,200);
            setVisible(true);
        }
        
        public void actionPerformed(ActionEvent ae){
           if (ae.getSource() == clear){
                 cardTextField.setText("");
                 pinTextField.setText("");
           }else if (ae.getSource() == login){
               Conn conn = new Conn();
               String cardnumber = cardTextField.getText();
               String pinnumber = pinTextField.getText(); 
               String query = "select * from login where cardnumber = '" + cardnumber +"'and pin = '"+pinnumber+"'";
               try{
                   ResultSet rs = conn.s.executeQuery(query);
                   if (rs.next()) {
                       setVisible(false);
                       new Transaction(pinnumber).setVisible(true);
                   } else {
                       JOptionPane.showMessageDialog(null,"Incorrect Card Number or pin ");
                   }
               }catch (Exception e) {
                   System.out.println(e);
               }
           }else if (ae.getSource() == signup){
               setVisible(false);
               new Signupone().setVisible(true);
           }
        }		  
	public static void main(String[] args) {
            new Login();        

    }
}

