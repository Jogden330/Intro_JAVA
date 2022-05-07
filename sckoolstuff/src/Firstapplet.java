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

public class Firstapplet extends JApplet {
    
    JLabel lblname = new JLabel("Jonathan Ogden");
    Container content = getContentPane();
    Font nmfont = new Font("Serif",Font.BOLD,48);
            
    public void init(){
         
        lblname.setOpaque(true);
        lblname.setFont(nmfont);
        lblname.setForeground(Color.red);
        lblname.setBackground(Color.blue);
        content.add(lblname);
        
    
    }
    
    
}
