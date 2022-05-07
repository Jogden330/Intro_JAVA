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

public class draw extends JApplet{
    
    @Override 
    public void paint(Graphics g){
        
        super.paint(g);
        g.setColor(Color.blue);
        g.drawString("hi",15,10);
        g.setColor(Color.red);
        g.fillRect(50,75, 100, 100);
        g.setColor(Color.green);
        g.fillRoundRect(17, 32, 6, 5, 9, 10);
        
        FontMetrics fm = g.getFontMetrics();
        int rowHeight = fm.getHeight();
        String s =  "row height" + rowHeight;
        int sw = fm.stringWidth(s);
        String sws = "String width" + sw;
        
        g.drawString(s, 20, 16);
        g.drawString(sws,40,32);
    }
    
}
