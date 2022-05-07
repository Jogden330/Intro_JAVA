/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12;

/*
 * @author Jonathan Ogden 
 * CSIC 123B
 * 0211330
 * assignment 12
 * the Pair class again
 *
 */
class Pair <T,B> {
        
  T mything1;
  B mything2;
   
  public Pair(T elem1,B elem2)
    {
             
       mything1 = elem1;
       mything2 = elem2;
    }
  
    void setFirst(T elem)
    {
        mything1 = elem;
    }
    void setSecond(B elem)
    {
        mything2 = elem;
    }
    
    T getFirst()
    {
        return  mything1;
       
    }   
    B getSecond()
    {
        return mything2;
    }
}