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


public class entervowels extends JApplet implements ActionListener{
    
    JTextField tfGrade = new JTextField(10);
    JLabel lbloutput = new JLabel("enter a vowel");
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
      char vowel = stGrade.charAt(0);
      switch(vowel)
      {
          case 'A':   
          case 'E':     
          case 'I':    
          case 'O':    
          case 'U':
               lbloutput.setText("YOU HAVE ENTERD A VOWEL");
              break;
            
          default:
              lbloutput.setText("YOU HAVE NOT ENTERD A VOWEL");
              break;
                  
              
      }
        
    }
    
    
}

