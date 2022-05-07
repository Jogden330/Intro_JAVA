/*
 * @author Jonathan Ogden 
 * CSIC 123B
 * 0211330
 * assignment MidTerm
 * moving and resizing picturs
 */
package midterm;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;


public class PixTrix extends JPanel implements MouseListener, MouseMotionListener{
    private Image img, oimg; // = ImageIO.read(new File("redball.giv"));
    private int ulx, uly;
    private int width = 25;
    private int height = 25;
    private boolean isSizing = false;
    private boolean isMoving = false;
    private Point origin = new Point(0,0);
    
    public PixTrix(int width, int height,  String path)
    {
      
       this.setBackground(Color.WHITE); 
       
       
       try
       {
             img = ImageIO.read(new File(path));
             
       }
       catch(IOException e)
       {
            System.out.println("Image not found"); 
       }
      
       addMouseMotionListener(this);
       addMouseListener(this);
       
        ulx = ( width - getWidth() )/2;
        uly = ( height - getHeight() )/2;
     }
    @Override
    public void paint(Graphics g)
    { 
        if(img == null) {
            return;
        }
        if(oimg == null) {
            oimg = createImage(this.getWidth(),this.getHeight());
        }
        
        
        
        Graphics og = oimg.getGraphics();
        og.clearRect( 0, 0, this.getWidth(),this.getHeight());
        og.drawImage(img, ulx, uly, width, height, this);
        og.fillRect(ulx,uly,4,4);
        og.fillRect((ulx+width)-4,uly,4,4);
        og.fillRect(ulx,(uly+height)-4,4,4);
        og.fillRect((ulx+width)-4,(uly+height)-4,4,4);
        
        
        
        g.drawImage(oimg, 0, 0, this);
        og.dispose();
        
    }
    
    public void update(Graphics g)
    {
        this.paint(g);
    }

    @Override
    public void mouseClicked(MouseEvent me) {}

    @Override
    public void mousePressed(MouseEvent me) {
         Rectangle r = new  Rectangle(ulx,uly,width,height);
         r.grow(-6, -6);
        
         
         if(r.contains(me.getX(), me.getY()))
         {
             isMoving = true;
             System.out.println("i can move");
             origin.x = me.getX();
             origin.y = me.getY();
         } 
         else 
         {
               r.grow(+8, +8);
               if(r.contains(me.getX(), me.getY()))
               {
                   isSizing = true;
               }
             
         }
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        isSizing = false;
        isMoving = false;
    }

    @Override
    public void mouseEntered(MouseEvent me) {}

    @Override
    public void mouseExited(MouseEvent me) {}

    @Override
    public void mouseDragged(MouseEvent me) {
    
        
               if(this.isMoving)
                {
                        this.ulx += me.getX() - origin.x;
                        this.uly += me.getY() - origin.y;
                        origin.x = me.getX();
                        origin.y = me.getY();
                        repaint();
                }
        
                else if(this.isSizing)
                {
                        int midx = ulx + width / 2;
                        int midy = uly + height / 2;
                       
                        
                        if(me.getX() >= midx)
                        {
                                width =  (me.getX() - ulx) ;
                        }
                        else if(me.getX() < midx)
                        {
                                width += ulx - me.getX();
                                ulx = me.getX();
                        }
                        
                        if(me.getY() > midy)
                        {
                                height =  (me.getY() - uly);
                        }
                        else if(me.getY() < midy)
                        {
                                height += uly - me.getY();
                                uly = me.getY();
                        }
                    
                        this.repaint();
                }
                
    }
    @Override
    public void mouseMoved(MouseEvent me) {}
    
}
