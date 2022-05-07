/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12;

import java.util.ArrayList;
import java.util.Iterator;
/*
 * @author Jonathan Ogden 
 * CSIC 123B
 * 0211330
 * assignment 12
 * working with ArrayLists and genralls
 */
public class PairList <F,S> extends ArrayList<Pair>
{
    
    


  
    void addPair(F thing1 ,S thing2)
    {
        
       Pair<F,S> prthing = new Pair<F,S>(thing1,thing2);
       
       add(prthing);
    
    }
    public S searchFirst(F thing)
    {
      
        Iterator it = this.iterator();
        
        while(it.hasNext())
        {
            Pair <F,S> prlook = (Pair <F,S>) it.next();
            System.out.println(prlook.getFirst() + " " + thing);
            
            if((prlook.getFirst().equals(thing)))
            {
                
                return (S) prlook.getSecond();
            }
                
            
         }
        return null;
    }
    public F searchSecond(S thing)
    {
      
        Iterator it = this.iterator();
        
        while(it.hasNext())
        {
            Pair <F,S> prlook = (Pair <F,S>) it.next();
            
            if(prlook.getSecond().equals(thing))
            {
                
                return (F) prlook.getFirst();
            }
                
            
        }
        return null;
    }
    
    public PairList(F thing1, S thing2)
    {
         Pair<F,S> prthing = new Pair<F,S>(thing1,thing2);
       
         add(prthing);
    
        
    }
    public PairList()
    {
        
    }
}
