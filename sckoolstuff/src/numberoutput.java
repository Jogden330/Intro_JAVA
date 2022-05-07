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

public class numberoutput extends JApplet implements ActionListener {
    
    JLabel LBLnume = new JLabel();
    JTextField TFnume = new JTextField(10);
    JButton btn = new JButton("Click Me");
    
     Container content = this.getContentPane();
     
     public void init()
    {
    
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Number"));
        content.add(LBLnume);
        content.add(TFnume);
        content.add(btn);
        btn.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        finednumber();
    }
    
    public void finednumber()
    {
        int nume = Integer.parseInt(TFnume.getText());
        switch(nume)
        {
            case 1: LBLnume.setText("I one");break;
             
            case 2: LBLnume.setText("II two"); break;
                
            case 3: LBLnume.setText("III three"); break;
               
            case 4: LBLnume.setText("IV For"); break;
                
            case 5: LBLnume.setText("V five"); break;
               
            case 6: LBLnume.setText("VI six"); break;
               
            case 7: LBLnume.setText("VII seven"); break;
                
            case 8: LBLnume.setText("VIII eat"); break;
                
            case 9: LBLnume.setText("IX Nine"); break;
                
            default: LBLnume.setText("not a number from 1-9"); break;    
        }
     
     }           
 
}
