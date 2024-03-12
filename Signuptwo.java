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


public class Signuptwo extends JFrame implements ActionListener{
   long random;
    JTextField pan,aadhar; 
    JRadioButton syes,sno,eyes,eno;
    //JDateChooser dateChooser ;
    JButton next;
    JComboBox religion,category,occupation,education,income;
    String formno;
    Signuptwo(String formno) {
       
        setLayout(null);
        this.formno = formno;
        
        setTitle("New Account Form - Page 2");
        
        JLabel additionalDetails = new JLabel("PAGE 2: Additional Details");
        additionalDetails.setFont(new Font("railway",Font.BOLD,26));
        additionalDetails.setBounds(130,20,600,40);
        add(additionalDetails);

        
        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("railway",Font.BOLD,16));
        name.setBounds(130,90,200,40);
        add(name);
        
        String valReligion[] = {"HIndu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,100,250,20);
        religion.setBackground(Color.WHITE);
        add(religion);
        
            
        JLabel fname = new JLabel("Category:");
        fname.setFont(new Font("railway",Font.BOLD,16));
        fname.setBounds(130,120,250,40);
        add(fname);
        
        String valCategory[] = {"General","OBC","SC","ST","OTHER"};
        category = new JComboBox(valCategory);
        category.setBounds(300,130,250,20);
        category.setBackground(Color.WHITE);
        add(category);
        
                
        JLabel dob = new JLabel("Income:");
        dob.setFont(new Font("railway",Font.BOLD,16));
        dob.setBounds(130,150,250,40);
        add(dob);
        
        String IncomeCategory[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","< 10,00,000","+10,00,000"};
        income = new JComboBox(IncomeCategory);
        income.setBounds(300,160,250,20);
        income.setBackground(Color.WHITE);
        add(income);    
        
        JLabel gender = new JLabel("Education");
        gender.setFont(new Font("railway",Font.BOLD,16));
        gender.setBounds(130,180,200,40);
        add(gender);
             
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("railway",Font.BOLD,16));
        email.setBounds(130,195,200,40);
        add(email);
        
        String educationValue[] = {"Non-Graduation","Graduation","Post Graduation","Doctrate","Other"};
        education = new JComboBox(educationValue);
        education.setBounds(300,200,250,20);
        education.setBackground(Color.WHITE);
        add(education);
       
        
        JLabel marital = new JLabel("Occupation:");
        marital.setFont(new Font("railway",Font.BOLD,16));
        marital.setBounds(130,240,200,40);
        add(marital);
        
        String occupationValues[] = {"Salaried","Self-Employed","Bussiness","Student","Other"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300,250,250,20);
        occupation.setBackground(Color.WHITE);
        add(occupation);
              
        JLabel address = new JLabel("Aadhar Number:");
        address.setFont(new Font("railway",Font.BOLD,16));
        address.setBounds(130,270,200,40);
        add(address);
        
        aadhar = new JTextField();
        aadhar.setFont(new Font("railway",Font.BOLD,16));
        aadhar.setBounds(300,280,250,20);
        add(aadhar);
        
        JLabel city = new JLabel("PAN Number:");
        city.setFont(new Font("railway",Font.BOLD,16));
        city.setBounds(130,300,200,40);
        add(city);
        
        pan = new JTextField();
        pan.setFont(new Font("railway",Font.BOLD,16));
        pan.setBounds(300,310,250,20);
        add(pan);
        
        JLabel state= new JLabel("Senior Citizen:");
        state.setFont(new Font("railway",Font.BOLD,16));
        state.setBounds(130,330,200,40);
        add(state);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300,340,120,20);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(430,340,120,20);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup sgroup = new ButtonGroup();
        sgroup.add(syes);
        sgroup.add(sno);      
        
        JLabel pincode= new JLabel("Existing Account:");
        pincode.setFont(new Font("railway",Font.BOLD,16));
        pincode.setBounds(130,360,250,40);
        add(pincode);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300,370,120,20);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(430,370,120,20);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup egroup = new ButtonGroup();
        egroup.add(eyes);
        egroup.add(eno);      
                
        next = new JButton("Next");
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
        String sreligion = (String)religion.getSelectedItem(); //setText
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();  
        String seducation = (String)education.getSelectedItem();
         
        String SeniorCitizen = null;
        
        if(syes.isSelected()){
            SeniorCitizen= "Yes";
        } else if (sno.isSelected()) {
            SeniorCitizen = "NO";
        }
        
        String exisitingaccount = null;
        if(eyes.isSelected()){
            exisitingaccount= "Yes";
        } else if (eno.isSelected()) {
            exisitingaccount = "NO";
        }
        
        String saadhar = aadhar.getText();
        String span = pan.getText();
        
        try {
               Conn c = new Conn();
               String query = "insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+saadhar+"','"+span+"','"+SeniorCitizen+"','"+exisitingaccount+"')";
               c.s.executeUpdate(query);
               //signup3Object  
               setVisible(false);
               new Signupthree(formno).setVisible(true);
               
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        new Signuptwo("");
    }
    
    
}