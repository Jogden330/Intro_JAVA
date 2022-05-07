/*
 * @author Jonathan Ogden
 *  CSIS 123B
 * 0211330
 * Assignment Final
 *   Minesweep(2),
 *   Frigate(3),
 *   Cruiser(4),
 *   Battleship(5);
 */
package battleship;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ShipInfo {
    
   private int[] x;
   private int[] y;
   private int Size;
   private boolean isvertical;
   private String name;
   private int hits;
    
    
    public ShipInfo( int shipSize)
    {
        
       
        Size = shipSize;
        switch(Size)
        {
            case 2: name = "Minesweep";  break; 
            case 3: name = "Frigate" ; break;
            case 4: name = "Cruiser"; break;
            case 5: name = "Battleship"; break;
                
        }
        
        x = new int[Size];
        y = new int[Size];
        hits = Size;
    
    }
    
    void setIsVertical(boolean isVetical)
    {
        this.isvertical = isVetical;
    }
    void setLocation(int row, int col, int place)
    {
        x[place] = row;
        y[place] = col;
    }
    String getName()
    {
        return name;
    }
    boolean getIsVertical()
    {
        return isvertical;
    }
    int getXposition(int place)
    {
        return x[place];
    }
     int getYposition(int place)
    {
        return y[place];
    }
     int getSize()
     {
         return Size;
     }
     void isSunck()
     {
         hits--;
        
        
       
     }
     int getHits()
     {
         return hits;
     }
  
}

