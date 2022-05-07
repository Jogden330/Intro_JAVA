

package midterm;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class sample extends JPanel implements MouseListener, MouseMotionListener
{
        private Image img, oimg;
        private int ulx, uly;
        private int width = 25, height = 25;
        private boolean isSizing = false, isMoving = false;
        private Point origin = new Point(0,0);
        

        public sample(int height, int width,String path)
        {
                this.setBackground(Color.white);
              
               this.setBackground(Color.WHITE); 
       
           try
             {
             img = ImageIO.read(new File(path));
             
              }
              catch(IOException e)
              {
               System.out.println("Image not found"); 
            }

                MediaTracker mt = new MediaTracker(this);
                mt.addImage(this.img, 0);

                try
                {
                        mt.waitForID(0);
                }
                catch(Exception ie)
                {
                        System.out.println(" " + ie.getMessage());
                }

                this.addMouseListener(this);
                this.addMouseMotionListener(this);

                this.ulx = (this.getWidth() - this.width)/2;
                this.uly = (this.getHeight() - this.height)/2;
        }

        public void paint(Graphics g)
        {
                if(this.img == null)
                        return;
                
                if(this.oimg == null)
                        oimg = createImage(this.getWidth(),this.getHeight());//this.oimg = this.createImage(this.getSize().width, this.getSize().height);
                
                Graphics og = this.oimg.getGraphics();
                og.clearRect(0, 0, this.getWidth(), this.getHeight());
                og.drawImage(this.img, this.ulx, this.uly, this.width, this.height, this);
                og.fillRect(this.ulx, this.uly, 4, 4); // upper left
                og.fillRect(this.ulx, this.uly+this.height-4, 4, 4); // lower left
                og.fillRect(this.ulx+this.width-4, this.uly, 4, 4); // upper right
                og.fillRect(this.ulx+this.width-4, this.uly+this.height-4, 4, 4); // lower right
                g.drawImage(this.oimg,0,0, null);
                og.dispose();
        }

        public void update(Graphics g)
        {
                this.paint(g);
        }

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e)
        {
                Rectangle r = new Rectangle(this.ulx,this.uly,this.width,this.height);
                r.grow(-6, -6);
                if(r.contains(e.getX(), e.getY()))
                {
                        this.isMoving = true;
                        this.origin.x = e.getX();
                        this.origin.y = e.getY();
                }
                else
                {
                        r.grow(+8, +8);
                        if(r.contains(e.getX(), e.getY()))
                        {
                                this.isSizing = true;
                        }
                }
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
                this.isMoving = this.isSizing = false;
        }

        @Override
        public void mouseDragged(MouseEvent e)
        {
                if(this.isSizing)
                {
                        int midx = (ulx + width)/ 2;
                        int midy = (uly + height)/2;
                        if(e.getX() < midx)
                        {
                                this.width+=this.ulx - e.getX();
                                this.ulx = e.getX();
                        }
                        else if(e.getX() >= midx)
                        {
                                this.width = e.getX() - this.ulx;
                        }
                        
                        if(e.getY() < midy)
                        {
                                this.height+=this.uly - e.getY();
                                this.uly = e.getY();
                        }
                        else if(e.getY() > midy)
                        {
                                this.height = e.getY() - this.uly;
                        }
                        this.repaint();
                }
                else if(this.isMoving)
                {
                        this.ulx += e.getX() - this.origin.x;
                        this.uly += e.getY() - this.origin.y;
                        this.origin.x=e.getX();
                        this.origin.y=e.getY();
                        this.repaint();
                }
        }

        @Override
        public void mouseMoved(MouseEvent e) {}
        
}
        
