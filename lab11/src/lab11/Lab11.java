
/*
 * @author Jonathan Ogden 
 * CSIC 123B
 * 0211330
 * assignment 11
 * test gui
 */
package lab11;

import java.awt.*;
import javax.swing.*;

public class Lab11 extends JFrame
{
    
   RollOver ROone = new RollOver("first",JLabel.LEFT,
   "second", Color.red, Color.blue, Color.green,Color.yellow);
   RollOver ROtwo = new RollOver("I got a background color added to my using setBackground");
   RollOver ROthree = new RollOver("I'm in the middel",JLabel.CENTER);
   RollOver ROfour = new RollOver("I'm blue",Color.BLUE);

    
  public Lab11(String Tital, int width,int hight )
  {
   this.setVisible(true);
   this.setTitle(Tital);
   this.setSize(width,hight);
   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   setLayout(new GridLayout(4,1));

   add(ROone);
   ROtwo.setBackground(Color.GREEN);
   add(ROtwo);
   add(ROthree);
   add(ROfour);
  }
  public static void main(String[] args)
  {
     Lab11 Gui = new Lab11("Test GUI",400, 300);
  }
}