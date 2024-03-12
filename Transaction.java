
package myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    String pinnumber;
    JButton  deposit,fastcash,withdrawl,ministatement,pin,balance,exit;
    
    Transaction(String pinnumber) {
    this.pinnumber = pinnumber;  
    setLayout(null);
        
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,900,800);
    add(image);
    
    JLabel text = new JLabel("Please selesct Transaction");
    text.setBounds(230,250,700,35);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD,16));
    image.add(text);
    
    deposit = new JButton("Deposit");
    deposit.setBounds(170,365,130,30);
    deposit.addActionListener(this);    
    image.add(deposit);
    
    withdrawl = new JButton("Cash Withdrawl");
    withdrawl.setBounds(370,365,130,30);
    withdrawl.addActionListener(this);
    image.add(withdrawl);
      
    fastcash = new JButton("Fast Cash");
    fastcash.setBounds(170,400,130,30);
    fastcash.addActionListener(this);
    image.add(fastcash);
    
    ministatement = new JButton("Ministatement");
    ministatement.setBounds(370,400,130,30);
    ministatement.addActionListener(this);
    image.add(ministatement);
    
    
    pin = new JButton("Pin Change");
    pin.setBounds(170,435,130,30);
    pin.addActionListener(this);
    image.add(pin);
    
    balance = new JButton("Balance Enquiry");
    balance.setBounds(370,435,130,30);
    balance.addActionListener(this);
    image.add(balance);
    
    exit = new JButton("Exit");
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
            System.exit(0);  
        } else if(ae.getSource()==deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if(ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pin) {
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balance) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);        
        } else if (ae.getSource() == ministatement) {
            //setVisible(false);
            new Ministatement(pinnumber).setVisible(true);
        }
    }
      
    public static void main(String args[]) {
        
        new Transaction("");
        
    }
}
