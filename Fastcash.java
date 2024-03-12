
package myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener{
    String pinnumber;
    JButton  deposit,fastcash,withdrawl,ministatement,pin,balance,exit;
    Fastcash(String pinnumber) {
      this.pinnumber = pinnumber;  
    setLayout(null);
        
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,900,800);
    add(image);
    
    JLabel text = new JLabel("Select withdrawl Amount");
    text.setBounds(230,250,700,35);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD,16));
    image.add(text);
    
    deposit = new JButton("RS 500");
    deposit.setBounds(170,365,130,30);
    deposit.addActionListener(this);    
    image.add(deposit);
    
    withdrawl = new JButton("RS 1000");
    withdrawl.setBounds(370,365,130,30);
    withdrawl.addActionListener(this);
    image.add(withdrawl);
      
    fastcash = new JButton("RS 1500");
    fastcash.setBounds(170,400,130,30);
    fastcash.addActionListener(this);
    image.add(fastcash);
    
    ministatement = new JButton("RS 2000");
    ministatement.setBounds(370,400,130,30);
    ministatement.addActionListener(this);
    image.add(ministatement);
    
    pin = new JButton("RS 5000");
    pin.setBounds(170,435,130,30);
    pin.addActionListener(this);
    image.add(pin);
    
    balance = new JButton("RS 10000");
    balance.setBounds(370,435,130,30);
    balance.addActionListener(this);
    image.add(balance);
    
    exit = new JButton("Back");
    exit.setBounds(370,470,130,30);
    exit.addActionListener(this);
    image.add(exit);
    
    
    setSize(900,800);
    setLocation(300,0);
    setUndecorated(true);
    setVisible(true);
    
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else{
             String amount = ((JButton)ae.getSource()).getText().substring(3);
             Conn conn = new Conn();
             try {
                 ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                 int balance = 0;
                 while(rs.next()) {
                     if(ae.getSource() != exit && rs.getString("type").equals("Deposit+")) {
                         balance = balance + Integer.parseInt(rs.getString("amount"));
                     }else {
                          balance = balance - Integer.parseInt(rs.getString("amount"));
                     }
                 }//System.out.println("Balance: " + balance);
                 if(balance < Integer.parseInt(amount)){
                     JOptionPane.showMessageDialog(null, "Insufficient Balance");
                     return;
                 }
                 
                 Date date = new Date();
                 String query ="insert  into bank value('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                 conn.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null, "RS "+amount+ "Debited Sucessfully");
                 
                 setVisible(false);
                 new Transaction(pinnumber).setVisible(true);
             }catch (Exception e){
                 System.out.println(e);
             }
        }
    }
      
    public static void main(String args[]) { 
        new Fastcash("");    
    }   
}
