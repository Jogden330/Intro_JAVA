/*
 * @author Jonathan Ogden 
 * CSIC 123B
 * 0211330
 * assignment 11
 * working with inharitens to make fance labels
 */

package lab11;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;


public class RollOver extends JLabel implements MouseListener {
    
    private String onMsg;
    private String offMsg;
    private Color onFg, onBg, offFg, offBg;
    
    public RollOver(String offMsg,int align,String onMsg,Color offFg,Color offBg, Color onFg,Color onBg)
    {
       super(offMsg,align);
       this.setOpaque(true);
       this.offMsg = offMsg;
       if("".equals(onMsg)) {
            this.onMsg = offMsg;
        }else{
           this.onMsg = onMsg;
       }
       
       this.offFg = offFg;
       this.offBg = offBg;
       this.onFg = onFg;
       this.onBg = onBg;
       
       if(offBg == null){
       }else{
           this.setBackground(offBg);
       }
       
       if(offFg == null){
       }else{
           this.setForeground(offFg);
       }
       
        addMouseListener(this);
       
    }
    
    public RollOver(String onMsg)
    {
        this(onMsg,JLabel.LEFT,"",null,null,null,null);
    }
    
    public RollOver(String onMsg,int align)
    {
        this(onMsg,align,"",null,null,null,null);
    }
    
     public RollOver(String onMsg,Color offFg)
    {
        this(onMsg,JLabel.LEFT,"",offFg,null,null,null);
    }



    @Override
    public void mouseClicked(MouseEvent me) {}

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {
    this.setBackground(onBg);
    this.setForeground(onFg);
    this.setText(onMsg);
    }

    @Override
    public void mouseExited(MouseEvent me) {
    this.setBackground(offBg);
    this.setForeground(offFg);
    this.setText(offMsg);
    }
       
     public void addNotify() 
     {
         super.addNotify();
         
         if(offFg == null) {
             offFg = this.getForeground();
         }
             
         if(offBg == null) {
             offBg = this.getBackground();
         }
         
         if(onFg == null) {
             onFg = this.getBackground();
         }
         
         if(onBg == null) {
             onBg = this.getForeground();
         }
         
     }

}
