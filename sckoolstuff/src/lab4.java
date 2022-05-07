/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan Ogden
 * labe 4
 * making labels that change color and text depending if the 
 * mouse is in the window or not
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class lab4 extends JApplet implements MouseListener
{
    
    Container content;
    JLabel lblText = new JLabel("Move mouse here");
    Font fntText = new Font("plain",Font.BOLD,46);
    Color offColor = new Color(0.8f,0.4f,0.5f );
    Color onColor = new Color(125,200,0);
    
    public void init()
    {
        content = this.getContentPane();
        content.setBackground(onColor);
        lblText.setFont(fntText);
        content.add(lblText);
        content.addMouseListener(this);
       

  }
     public void mousePressed(MouseEvent e)
     {
        

     }

    public void mouseReleased(MouseEvent e)
    {
        

    }

    public void mouseEntered(MouseEvent e)
    {
        content.setBackground(offColor);
        lblText.setText("YOU DID IT!!!!");

       

    }

    public void mouseExited(MouseEvent e)
    {
        content.setBackground(onColor);
        lblText.setText("Move mouse here");

    }

    public void mouseClicked(MouseEvent e)
    {
      lblText.setText("I didn't say click");
    }


}

