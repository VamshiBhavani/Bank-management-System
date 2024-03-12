/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myproject;

/**
 *
 * @author vamsh
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signupthree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancle;
    String formno;
    
    Signupthree(String formno) {
        this.formno = formno;
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Railway",Font.BOLD,22));
        l1.setBounds(200,20,400,40);
        add(l1);
        
        
        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Railway",Font.BOLD,18));
        type.setBounds(100,80,200,40);
        add(type);
        
        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font ("Railway", Font.BOLD,15));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,140,180,20);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposite Account");
        r2.setFont(new Font ("Railway", Font.BOLD,15));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,140,250,20);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font ("Railway", Font.BOLD,15));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,170,180,20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposite Account");
        r4.setFont(new Font ("Railway", Font.BOLD,15));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,170,250,20);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Railway",Font.BOLD,18));
        card.setBounds(100,210,200,40);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4562");
        number.setFont(new Font("Railway",Font.BOLD,18));
        number.setBounds(350,210,300,40);
        add(number);
        
        JLabel carddetailss = new JLabel("16 digit card number");
        carddetailss.setFont(new Font("Railway",Font.BOLD,10));
        carddetailss.setBounds(100,225,300,40);
        add(carddetailss);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Railway",Font.BOLD,18));
        pin.setBounds(100,250,200,40);
        add(pin);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Railway",Font.BOLD,18));
        pnumber.setBounds(350,250,300,40);
        add(pnumber); 
        
        JLabel pindetailss = new JLabel("Your 4 digit Password");
        pindetailss.setFont(new Font("Railway",Font.BOLD,10));
        pindetailss.setBounds(100,265,300,40);
        add(pindetailss);
                
        JLabel service = new JLabel("Services Required:");
        service.setFont(new Font("Railway",Font.BOLD,22));
        service.setBounds(100,310,300,40);
        add(service);
        
        c1= new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Railway",Font.BOLD,10));
        c1.setBounds(100,350,200,30);
        add(c1);
        
        c2= new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Railway",Font.BOLD,10));
        c2.setBounds(350,350,200,30);
        add(c2);
        
        c3= new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Railway",Font.BOLD,10));
        c3.setBounds(100,380,200,30);
        add(c3);
        
        c4= new JCheckBox("Email & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Railway",Font.BOLD,10));
        c4.setBounds(350,380,200,30);
        add(c4);
        
        c5= new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Railway",Font.BOLD,10));
        c5.setBounds(100,410,200,30);
        add(c5);
        
        c6= new JCheckBox("E-statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Railway",Font.BOLD,10));
        c6.setBounds(350,410,200,30);
        add(c6);  
        
        c7= new JCheckBox("AI hereby Declares that the above mentioned detailes are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Railway",Font.BOLD,8));
        c7.setBounds(100,450,450,30);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Railway",Font.BOLD,10));
        submit.setBounds(150,490,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancle = new JButton("Cancle");
        cancle.setBackground(Color.BLACK);
        cancle.setForeground(Color.WHITE);
        cancle.setFont(new Font("Railway",Font.BOLD,10));
        cancle.setBounds(300,490,100,30);
        cancle.addActionListener(this);
        add(cancle);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(700,600);
        setLocation(250,100);
        setVisible(true);
                           
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit) {
            String accountType = "";
            if (r1.isSelected()) {
                accountType = "Saving Account";
            }else if (r2.isSelected()) {
                accountType = "Fixed Deposite Account";
            }else if (r3.isSelected()) {
                accountType = "Current Account";
            }else if (r4.isSelected()) {
                accountType = "Recurring Deposite Account";
            }
        
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000) + 1000l);
            String facility = "";
            if(c1.isSelected()) {
                facility = facility + "ATM Card";
            }if(c2.isSelected()) {
                facility = facility + "Internet Banking";
            }if(c3.isSelected()) {
                facility = facility + "Mobile Banking";
            }if(c4.isSelected()) {
                facility = facility + "Email & SMS Alerts";
            }if(c5.isSelected()) {
                facility = facility + "Cheque Book";
            }if(c6.isSelected()) {
                facility = facility + "E-statement";
            }
            try {
                if(accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null,"Card Number: "+ cardnumber + "\n Pin: "+pinnumber);
                }
                
            }catch (Exception e){
                System.out.println(e);
            }
            
        }else if (ae.getSource()==cancle) {
            System.exit(0);
        }
    }
   
    
    public static void main(String args[])
    {
        new Signupthree("");
    }
}
