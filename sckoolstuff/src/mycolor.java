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

public class mycolor  extends JApplet implements ActionListener
{
    
    JLabel lblhellow = new JLabel("hello");
    Container content = this.getContentPane();
    JButton btngreen = new JButton("green");
    JButton btnblue = new JButton("Blue");
    
    
    
    public void init()
    {
        content.setLayout(new FlowLayout());
        Font fnt = new Font("TimesRoman",Font.BOLD,42);
        lblhellow.setFont(fnt);
        content.add(lblhellow);
        content.add(btngreen);
        content.add(btnblue);
        btngreen.addActionListener(this);
        btnblue.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == btngreen)
        {
            lblhellow.setForeground(Color.green);
        }
        else
        {
             lblhellow.setForeground(Color.blue);
        }
     }
 }
    

