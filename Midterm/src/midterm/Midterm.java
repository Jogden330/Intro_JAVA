/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package midterm;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author The Meat Man
 */
public class Midterm extends JFrame{
    
    
    
    public static void main(String[] args) {
        
        Midterm mt = new Midterm();
      
        
    }

    public Midterm()
    {
       this.setSize(400, 300);                 
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       this.setTitle("test Gui");
       this.setResizable(false);
       PixTrix pt = new PixTrix(400,300,"britney.jpg");
       this.add(pt, BorderLayout.CENTER);
       this.setVisible(true);
    }


    
    /**
     * @param args the command line arguments
     */
    
}
