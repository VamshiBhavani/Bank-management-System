
package myproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Pinchange extends JFrame implements ActionListener{
    
      
    JButton change,  back ;
    JPasswordField pin , repin ;     
    String pinnumber;       
    Pinchange(String pinnumber) {
    this.pinnumber=pinnumber;  
    
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
    Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel image = new JLabel(i3);
    image.setBounds(0,0,900,800);
    add(image);
        
    JLabel text = new JLabel("CHANGE YOUR PIN");
    text.setBounds(270,240,700,35);
    text.setForeground(Color.WHITE);
    text.setFont(new Font("System", Font.BOLD,16));
    image.add(text);
    
    
    JLabel pintext = new JLabel("New PIN:");
    pintext.setBounds(170,280,700,35);
    pintext.setForeground(Color.WHITE);
    pintext.setFont(new Font("System", Font.BOLD,16));
    image.add(pintext);
    
    pin = new JPasswordField();
    pin.setFont(new Font("railway",Font.BOLD,16));
    pin.setForeground(Color.BLACK);
    pin.setBounds(330,285,180,25);
    image.add(pin);
    
    
    JLabel repintext = new JLabel("Re-Enter New PIN:");
    repintext.setBounds(170,320,700,35);
    repintext.setForeground(Color.WHITE);
    repintext.setFont(new Font("System", Font.BOLD,16));
    image.add(repintext);
    
    repin = new JPasswordField();
    repin.setFont(new Font("railway",Font.BOLD,16));
    repin.setForeground(Color.BLACK);
    repin.setBounds(330,325,180,25);
    image.add(repin);
    
    change = new JButton("CHANGE");
    change.setBounds(355,430,150,30);
    change.addActionListener(this);
    image.add(change);
    
    back = new JButton("BACK");
    back.setBounds(355,465,150,30);
    back.addActionListener(this);
    image.add(back);
    
    setSize(900,800);
    //setLocationRelativeTo(null); // Center the JFrame 
    setLocation(300,0);
    setUndecorated(true);
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== change) {
          try {
              String npin = pin.getText();
              String rpin = repin.getText();
              
              
              if(npin.equals("")) {
                  JOptionPane.showMessageDialog(null, "Please Enter New PIN");
                  return;
              }
              if(rpin.equals("")) {
                  JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
                  return;
              }
              if(!npin.equals(rpin)) {
                  JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                  return;
              }
              
              Conn conn = new Conn();
              String query1 = "update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
              String query2 = "update login set pin = '"+rpin+"' where pin='"+pinnumber+"'";
              String query3 = "update signupthree set pin = '"+rpin+"' where pin='"+pinnumber+"'";
              
              conn.s.executeUpdate(query1);
              conn.s.executeUpdate(query2);
              conn.s.executeUpdate(query3);
              JOptionPane.showMessageDialog(null, "PIN Changed successfully");
              setVisible(false);
              new Transaction(pinnumber).setVisible(true);
              
          } catch (Exception e) {
              System.out.println(e);
          } 
        }else {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
         new Pinchange("").setVisible(true);
    }
}
