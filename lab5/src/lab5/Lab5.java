/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 

/**
 *
 * @author The Meat Man
 */
public class Lab5  extends JFrame implements AdjustmentListener, ActionListener
{
    Container content = getContentPane();
    
    
        
    

    public Lab5()
    {
        content.setLayout(new FlowLayout()); 
        this.setSize(400, 300);                 
        this.setVisible(true);       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setTitle("Test Spinner");
        content.add(new Spinner(5,1,10,null));
        content.add(new Spinner(1,-5,5,null));
    }
     public static void main(String[] args)
     {
        Lab5 lj5 = new Lab5();
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}