/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan Ogden
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class  magic extends JApplet implements MouseMotionListener
{
JLabel myName = new JLabel("Jonathan Ogden");
JLabel myId = new JLabel("0211330");
Font realBigFont = new Font("Helvetica",Font.BOLD, 36);
Font anatherFont = new Font("SansSerif",Font.ITALIC,36);
Color myColor1 = new Color(0f,.6f,.9f);
Color myColor2 = new Color(110,200,50);


	public void init()
	{
		Container content = this.getContentPane();
                content.setBackground(Color.blue);
                content.setLayout(new FlowLayout());
		
		myName.setFont(anatherFont);
                myName.setForeground(myColor1);
		content.add(myName);
                myId.setFont(realBigFont);
                myId.setForeground(myColor2);
                content.add(myId);
		content.addMouseMotionListener(this);
	}
	
	 public void mouseMoved(MouseEvent e)
    {
        myName.setVisible(false);
        myId.setVisible(false); 
    }

    public void mouseDragged(MouseEvent e)
    {
      myName.setVisible(true);
      myId.setVisible(true);   

    }

}