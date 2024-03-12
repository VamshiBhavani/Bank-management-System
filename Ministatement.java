
package myproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Ministatement extends JFrame implements ActionListener {

    String pinnumber;
    Ministatement(String pinnumber) {
        this.pinnumber = pinnumber;
        
        setTitle("Mini Statement");
        
        setLayout(null);
        JLabel mini = new JLabel();
        mini.setBounds(20,150,400,200);
        add(mini);
        
        JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card = new JLabel("Indian Bank");
        card.setBounds(50,80,300,20);
        add(card);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()) {
                card.setText("Card Number: "+ rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
         }
        }catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            Conn conn = new Conn();
            int bal =0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            while(rs.next()) {
                mini.setText(mini.getText() +"<html>"+ rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>" );
                    if( rs.getString("type").equals("Deposit+")) {
                         bal = bal+ Integer.parseInt(rs.getString("amount"));
                    }else {
                          bal = bal - Integer.parseInt(rs.getString("amount"));
                    }
            }
            balance.setText("Your current account balance is RS " + bal);
        }catch (Exception e) {
            System.out.println(e);
        }
        
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
}
  public void actionPerformed(ActionEvent ae) {
      
  }
  public static void main(String[] args)  {
     new Ministatement("");
  }
}
