

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Glenn
 * CSIC 113B
 * 
 * assignment 16
 * test gui for abstrct class
 */
public class Lab13 extends JFrame implements ActionListener
{
    Container content = this.getContentPane();
    JPanel pnlCS = new JPanel();
    JTextField tfCSName = new JTextField(15);
    JTextField tfCSId = new JTextField(15);
    JTextField tfCSYear = new JTextField(6);
    JTextField tfCSMathHours = new JTextField(3);
    JTextField tfCSHours = new JTextField(3);
    JTextField tfCSGenEdHours = new JTextField(3);
    JButton btnCalculate = new JButton("Compute Hours");
    JLabel lblCsHoursRemain = new JLabel();
    JLabel lblBioHoursRemain = new JLabel();
    
     public Lab13()
     {
        this.setVisible(true); 
        this.setTitle("Lab 8 ");
        this.setSize(400, 300);                 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pnlCS.setLayout(new GridLayout(7,2));
        pnlCS.add(new JLabel("Name: "));
        pnlCS.add(tfCSName);
        pnlCS.add(new JLabel("Id:"));
        pnlCS.add(tfCSId);
        pnlCS.add(new JLabel("Year:"));
        pnlCS.add(tfCSYear);
        pnlCS.add(new JLabel("Math Hours:"));
        pnlCS.add(tfCSMathHours);
        pnlCS.add(new JLabel("CS Hours:"));
        pnlCS.add(tfCSHours);
        pnlCS.add(new JLabel("Gen. Ed. Hours:"));
        pnlCS.add(tfCSGenEdHours);
        
        pnlCS.add(lblCsHoursRemain);
        pnlCS.add(lblBioHoursRemain);
        content.add(pnlCS, BorderLayout.EAST);
        
        content.add(btnCalculate, BorderLayout.SOUTH);
        btnCalculate.addActionListener(this);
              
     }
     public void actionPerformed(ActionEvent ae)
     {
         String name = tfCSName.getText();
         String id = tfCSId.getText();
         int year = Integer.parseInt(tfCSYear.getText());
         int mathHours = Integer.parseInt(tfCSMathHours.getText());
         int CSHours = Integer.parseInt(tfCSHours.getText());
         int genEdHours = Integer.parseInt(tfCSGenEdHours.getText());
         BioStudent student = new BioStudent(name, id, year);
         student.setBioHours(CSHours);
         student.setGenEdHours(genEdHours);
         student.setMathHours(mathHours);
         CsStudent csstudent = new CsStudent(name, id, year);
         csstudent.setCsHours(CSHours);
         csstudent.setGenEdHours(genEdHours);
         csstudent.setMathHours(mathHours);
         
         lblBioHoursRemain.setText("Hours Remaining BS: " + student.getRemainingHours());
         lblCsHoursRemain.setText("Hours Remaining Bio: " + csstudent.getRemainingHours());
           
     }
    
    
    public static void main(String[] args)
    {
        Lab13 lab = new Lab13();
    }
}
