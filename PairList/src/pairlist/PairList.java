/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pairlist;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author The Meat Man
 */
public class PairList <S,F> extends ArrayList<Pair>
{
    
    


  
    void addPair(S thing1 ,F thing2)
    {
        
       Pair<S,F> prthing = new Pair<S,F>(thing1,thing2);
       
       add(prthing);
    
    }
    public S searchFirst(S thing)
    {
      
        Iterator it = this.iterator();
        
        while(it.hasNext())
        {
            Pair <S,F> prlook = (Pair <S,F>) it.next();
            
            if(prlook.getFirst() == thing)
            {
                
                return (S) prlook.getSecond();
            }
                
            
                    
        }
        return null;
    }
    public F searchSecond(F thing)
               {
      
        Iterator it = this.iterator();
        
        while(it.hasNext())
        {
            Pair <S,F> prlook = (Pair <S,F>) it.next();
            
            if(prlook.getSecond() == thing)
            {
                
                return (F) prlook.getFirst();
            }
                
            
                    
        }
        return null;
    }
    
    public PairList(S thing1, F thing2)
    {
         Pair<S,F> prthing = new Pair<S,F>(thing1,thing2);
       
         add(prthing);
    
        
    }
    public PairList()
    {
        
    }
}

