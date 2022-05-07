/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author The Meat Man
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class firstcase extends JApplet implements ActionListener{
    
    JTextField tfGrade = new JTextField(10);
    JLabel lbloutput = new JLabel();
    JButton btn = new JButton("click me");
    Container content = this.getContentPane();
            
    public void init()
    
    {
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Enter a Grade"));
        content.add(tfGrade);
        content.add(lbloutput);
        content.add(btn);
        btn.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
      String stGrade = tfGrade.getText().toUpperCase();
      char grade = stGrade.charAt(0);
      switch(grade)
      {
          case 'A':
              lbloutput.setText("show off");
              break;
          case 'B':
              lbloutput.setText("Pritty Good");
              break;  
          case 'C':
              lbloutput.setText("Average B.S.");
              break;
          case 'D':
              lbloutput.setText("Pritty Sucky");
              break;  
          case 'F':
              lbloutput.setText("You suck");
              break;
          default:
              lbloutput.setText("YOU HAVE TO PUTT A GRADE");
              break;
                  
              
      }
        
    }
    
    
}
