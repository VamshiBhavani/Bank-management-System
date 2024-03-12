/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
public class Withdrawl extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdrawl,back;
    String pinnumber;
    Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to Withdrawl");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(190,310,400,20);
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("System", Font.BOLD, 16));
        amount.setBounds(190,345,300,30);
        image.add(amount);
        
        withdrawl = new JButton ("Withdrawl");
        withdrawl.setBounds(355,485,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == withdrawl) {
            String number =  amount.getText();
            Date date = new Date();
            if(number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to d5040935997530374");
            } else {
                try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()) {
                     if(rs.getString("type").equals("Deposit+")) {
                         balance = balance + Integer.parseInt(rs.getString("amount"));
                     }else {
                          balance = balance - Integer.parseInt(rs.getString("amount"));
                     }
                 }//System.out.println("Balance: " + balance);
                 if(balance < Integer.parseInt(number)){
                     JOptionPane.showMessageDialog(null, "Insufficient Balance");
                     return;
                 }
                 
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+number+" Withdrawl Successfull");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                } catch(Exception e){
                    System.out.println(e);
                }
                
            }
        } else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String agrs[]) {
            new Withdrawl("");
        }
    }

