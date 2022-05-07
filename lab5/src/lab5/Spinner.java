/*
 * @author Jonathan Ogden 
 *CSIC 113B
 * 0211330
 * assignment 5
 * using external class to proform tascks
 */
 
package lab5;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

 public class Spinner extends JPanel implements AdjustmentListener
    {
        
       private JScrollBar theBar;
       private  JLabel theLabel = new JLabel("    ",JLabel.RIGHT);
       Font myfont = new Font("Serif",Font.BOLD,12);
       
        public Spinner(int val,int min ,int max, AdjustmentListener listener)
        {   
            theBar = new JScrollBar(JScrollBar.VERTICAL,(max - val + min),1,min,max+1);
            theBar.addAdjustmentListener(this);
            
            if(listener != null)
                 theBar.addAdjustmentListener(listener);
            this.setLayout(new BorderLayout());
            theLabel.setFont(myfont);
           
            this.add(theLabel,BorderLayout.CENTER);
            this.add(theBar,BorderLayout.EAST);
             theLabel.setText(" "+getValue()+" ");
            
        }
        public Spinner()
        {
            this(1,1,10, null);
        }
       
        public Spinner(int val,int min, int max)
        {
           this(val,min,max,null);
        }
      
        public void setValue(int val)
        {
            int max = theBar.getMaximum();
            int min = theBar.getMinimum();
            theBar.setValue(max - val + min);
            theLabel.setText(" "+getValue()+" ");
           
        }
     
        public void  setStepValue(int inc) 
        {
          theBar.setUnitIncrement(inc);   
        }
        public int getValue()
        {
            int max = theBar.getMaximum();
            int min = theBar.getMinimum();
            int val = theBar.getValue();
         
            return   (max-1) - val + min ;
           
        }
        @Override
        public void adjustmentValueChanged(AdjustmentEvent ae)
        {
            theLabel.setText(" "+getValue()+" ");
        }
       @Override
        public Dimension getPreferredSize() 
        { 
             return  
             new Dimension(theBar.getPreferredSize().width + 
                   theLabel.getPreferredSize().width, 
                   theLabel.getPreferredSize().height); 
         }
        
    }
