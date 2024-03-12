
package myproject;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signupone extends JFrame implements ActionListener{
   
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField, cityTextField ,stateTextField,pincodeTextField ; 
    JRadioButton male, female,other,married,unmarried;
    JDateChooser dateChooser ;
    
    Signupone() {
        Random ran =new Random();
        random =Math.abs(ran.nextLong() % 9000L) + 1000l;
        System.out.println(random);
        
        JLabel formno = new JLabel("APPLICATION FORM NUMBER:"+ random);
        formno.setFont(new Font("railway",Font.BOLD,26));
        formno.setBounds(130,20,600,40);
        add(formno);
	
        JLabel personalDetails = new JLabel(" Page 1: Personal Details");
        personalDetails.setFont(new Font("railway",Font.BOLD,16));
        personalDetails.setBounds(260,60,400,16);
        add(personalDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("railway",Font.BOLD,16));
        name.setBounds(130,90,200,40);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("railway",Font.BOLD,16));
        nameTextField.setBounds(300,100,250,20);
        add(nameTextField);
       
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("railway",Font.BOLD,16));
        fname.setBounds(130,120,250,40);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("railway",Font.BOLD,16));
        fnameTextField.setBounds(300,130,250,20);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("railway",Font.BOLD,16));
        dob.setBounds(130,150,250,40);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,160,250,20);
        dateChooser.setForeground(new Color(200,15,15));
        add(dateChooser);
        
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("railway",Font.BOLD,16));
        gender.setBounds(130,180,200,40);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300,190,120,20);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("FeMale");
        female.setBounds(430,190,120,20);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("railway",Font.BOLD,16));
        email.setBounds(130,210,200,40);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("railway",Font.BOLD,16));
        emailTextField.setBounds(300,220,250,20);
        add(emailTextField);
        
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("railway",Font.BOLD,16));
        marital.setBounds(130,240,200,40);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300,250,80,20);
         married.setBackground(Color.WHITE);
        add( married);
        
        unmarried = new JRadioButton("Un Married");
        unmarried.setBounds(380,250,90,20);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(480,250,70,20);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("railway",Font.BOLD,16));
        address.setBounds(130,270,200,40);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("railway",Font.BOLD,16));
        addressTextField.setBounds(300,280,250,20);
        add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("railway",Font.BOLD,16));
        city.setBounds(130,300,200,40);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("railway",Font.BOLD,16));
        cityTextField.setBounds(300,310,250,20);
        add(cityTextField);
        
        JLabel state= new JLabel("State:");
        state.setFont(new Font("railway",Font.BOLD,16));
        state.setBounds(130,330,200,40);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("railway",Font.BOLD,16));
        stateTextField.setBounds(300,340,250,20);
        add(stateTextField);
        
        
        JLabel pincode= new JLabel("Pin Code:");
        pincode.setFont(new Font("railway",Font.BOLD,16));
        pincode.setBounds(130,360,250,40);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("railway",Font.BOLD,16));
        pincodeTextField.setBounds(300,370,250,20);
        add(pincodeTextField);
        
        JButton next = new JButton("Next");
        next.setBounds(300,420,80,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Railway",Font.BOLD, 14));
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
                
        setLayout(null);
        setSize(700,580);
        setLocation(350,200);
        setVisible(true);      
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;//long
        String name = nameTextField.getText(); //setText
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        
        String email =emailTextField.getText();
        String marital = null;
        if(married.isSelected()) {
            marital = "Married";
        } else if(unmarried.isSelected()) {
            marital = "Unmarried";
        } else if (other.isSelected()){
            marital = "Other";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();
        
        try {
           if(name.equals("")) {
               JOptionPane.showMessageDialog(null, "Name is Required");
           } else{
               Conn c = new Conn();
               String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
               c.s.executeUpdate(query);
               setVisible(false);
               new Signuptwo(formno).setVisible(true);
           }
        } catch (Exception e) {
            System.out.println(e);
        }
  
    }
    
    public static void main(String[] args){
        new Signupone();
    }
  }
