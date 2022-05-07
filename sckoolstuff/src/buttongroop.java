/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonathan
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class buttongroop extends JApplet implements ActionListener{
    
    ButtonGroup grbColors = new ButtonGroup();
    JPanel pnlColors = new JPanel();
    JRadioButton btnRed = new JRadioButton("red");
    JRadioButton btnBlue = new JRadioButton("Blue");
    JRadioButton btnGreen = new JRadioButton("Green");
    
    Container content = getContentPane();
    
    public void init()
    {
        grbColors.add(btnRed);
        grbColors.add(btnBlue);
        grbColors.add(btnGreen);
        pnlColors.add(btnRed);
        pnlColors.add(btnBlue);
        pnlColors.add(btnGreen);
        
        btnRed.addActionListener(this);
        btnBlue.addActionListener(this);
        btnGreen.addActionListener(this);
        
        content.add(pnlColors, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JRadioButton rdo =(JRadioButton)ae.getSource();
        if(rdo == btnRed)
        
          pnlColors.setBackground(Color.red);  
          else if(rdo == btnBlue)
              pnlColors.setBackground(Color.blue);
          else if(rdo == btnGreen)
              pnlColors.setBackground(Color.green);
              
          
              
        
           
              }
}
