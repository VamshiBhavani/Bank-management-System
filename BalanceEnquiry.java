
package myproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinnumber;
    
    BalanceEnquiry( String pinnumber) {
    this.pinnumber = pinnumber;  
    setLayout(null);
        
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,900,800);
    add(image);
    
    back = new JButton("BACK");
    back.setBounds(370,465,130,30);
    back.addActionListener(this);
    image.add(back);
    int balance = 0;
    Conn c = new Conn();
    try {
        ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
        while(rs.next()) {
            if(rs.getString("type").equals("Deposit+")) {
                balance = balance + Integer.parseInt(rs.getString("amount"));
            }else {
                balance = balance - Integer.parseInt(rs.getString("amount"));
            }
        }
    }catch (Exception e) {
        System.out.println(e);
    }
    
    JLabel text = new JLabel("Your Current Account Balance is RS "+ balance);
    text.setBounds(170,240,400,35);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD,16));
    image.add(text);
    
    setSize(900,800);
    setLocation(300,0);
    setUndecorated(true);
     setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
         new Transaction(pinnumber).setVisible(true);
    
}
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
