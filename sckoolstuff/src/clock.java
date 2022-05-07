
/*
 * @author Jonathan Ogden
 * CSIC 113B
 * 0211330
 * assignment 7
 * a simple clock 
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.text.*;

public class clock extends JApplet implements Runnable{
    
  
    static final int UPDATE_INTERVAL = 1000;
    private Thread thread;
       
  
    public void init(){
        
        Container content = this.getContentPane();
        Font Cfont = new Font("Helvetica",Font.BOLD, 36);
        setFont(Cfont);
        content.setBackground(Color.blue);
        setForeground(Color.red);
        
        
    }
    @Override 
    public void paint(Graphics g ){
   
        super.paint(g);
        String sDate = getDateString();
        int X = getXPos(g,sDate);
        g.drawString(sDate,X,getYPos());
        
}
    public String getDateString(){
        
        Date now = new Date();
        String strDate = DateFormat.getTimeInstance(DateFormat.MEDIUM).format(now);
        
        return strDate;
        
    }
    public int getXPos( Graphics XG,String XDate ){
        
               FontMetrics fm = XG.getFontMetrics();
               int strWidth = fm.stringWidth(XDate);
               int width = getSize().width;
               
               return strWidth - width / 2;
        
    }
    public int getYPos(){
        
        int height = getSize().height;
        
        return height / 2;
    }
    public void run(){
		//Starts thread to establish repaint interval
		Thread me = Thread.currentThread();
		while (thread == me)
		{
		  repaint();
		  try
		  {
			//Sleep (or pause) interval set to 1,000 mSec
			thread.sleep(UPDATE_INTERVAL);
						  }catch(InterruptedException e)
						  {
							break;
						  }
		}
		thread = null;
	  }
	  public synchronized void stop()
	  {
		thread = null;
	  }
	  public void start()
	  {
		thread = new Thread(this);
		thread.setPriority(Thread.MIN_PRIORITY);
		thread.start();
      }
}