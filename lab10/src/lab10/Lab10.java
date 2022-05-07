/*
 * @author Jonathan Ogden 
 * CSIC 123B
 * 0211330
 * assignment 10
 * test GUI 
 */
package lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.text.NumberFormat;




public final class Lab10 extends JFrame implements ActionListener {
    
    
    
    TextArea taoutput = new TextArea();
    
    JTextField tfname = new JTextField(10);
    JTextField tfdepart = new JTextField(10);
    JTextField tfrate = new JTextField(10);
    JTextField tfhouers = new JTextField(10);
    JTextField tfGPA = new JTextField(10);
    JTextField tfgrade = new JTextField(10);
    
    JButton btn = new JButton("Calculate");
    
    
    
    
    public Lab10(String tital,int width,int hight)
    {
        this.setTitle(tital);
        this.setSize(width, hight);                 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
      
        
         setLayout(new BorderLayout()); 
         add(getLabels(),BorderLayout.NORTH);
         taoutput.setColumns(20);
         taoutput.setRows(20);
         add(taoutput,BorderLayout.CENTER);
         add(getButton(),BorderLayout.SOUTH);
        
         this.setVisible(true);
      
                
        
    }

    
    public static void main(String[] args) {
       
        Lab10 lb10 = new Lab10("test GUI",500,500);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        Pair<String,Double> prNR = new Pair<String,Double>(tfname.getText(), 	
                 Double.parseDouble(tfrate.getText()));
        Pair<Double,String> prHD = new Pair< Double,String>( Double.parseDouble(tfhouers.getText()), 
                tfdepart.getText());
        Pair<Double,Character> prGG = new  Pair<Double,Character>(Double.parseDouble(tfGPA.getText()),
                getChar(tfgrade.getText()));
               
        double pay = prNR.getSecond();
        double worked = prHD.getFirst();
        double sum = pay * worked;
        
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        
        taoutput.setText("");
        taoutput.append("employee  " + prNR.getFirst() + "\n");
        taoutput.append("Makes " + fmt.format(prNR.getSecond()) + " per hour \n");
        taoutput.append("in the "+ prHD.getSecond() + " department \n");
        taoutput.append("worked " + prHD.getFirst() + " hours this week \n");
        taoutput.append("their GPA is " + prGG.getFirst() + " \n");
        taoutput.append("their grade in business is " + prGG.getSecond() + " \n");
        taoutput.append("total pay " + fmt.format(sum) + "\n"); 
        
        
    }
    
    JPanel getLabels()
    {
        JPanel p = new JPanel();
        
        p.add(new JLabel("Enter employee name:"));
        p.add(tfname);
        p.add(new JLabel("Enter Pay Rate:"));
        p.add(tfrate);
        p.add(new JLabel("Enter The Number of Hours Worked:"));
        p.add(tfhouers);
        p.add(new JLabel("Enter Department Worked:"));
        p.add(this.tfdepart);
        p.add(new JLabel("what is their curent GPA:"));
        p.add(tfGPA);
        p.add(new JLabel("What is thier grade in business class:"));
        p.add(tfgrade);
                
        p.setLayout(new GridLayout(6,2));
        
        return p;
    }
    JPanel getButton()
    {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout());
        p.add(btn);
        btn.addActionListener(this);
        return p;
    }
    Character getChar(String s)
    {
        return s.charAt(0);
    }
}
