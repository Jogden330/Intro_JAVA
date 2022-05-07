/*
 * @author Jonathan Ogden 
 * CSIC 123B
 * 0211330
 * assignment 7
 * doing things to numbers
 */

package lab7;

import java.lang.Throwable;


public class IntMetrics {
    
    static private int numbs;
    static private int length;
    
    
    public IntMetrics(int number,int lengthnum)
    {
        
      numbs = number;  
      length = lengthnum;    
      
    }  
    

    //over loded constructors
    public IntMetrics(int number)
    {
        this(number,3);
    }
    public IntMetrics()
    {
        this(0,3);
    }
    
    //static classes
    public static int sumNumb()
    {
        int sum = 0;
        
        
        for(int y = 0;y < length; y++)
        {
            String strnumb = Integer.toString(numbs);
            sum += Character.getNumericValue(strnumb.charAt(y));  
        }
        return sum;
    }
    
      public static String reverseNums()
    {
        String revnume = "";
        
        for(int y = length-1;y >= 0;y--)
        {
            revnume += (Integer.toString(numbs).charAt(y));
        }
        return revnume;
    }
      public static int[] getArray()
    {
        int numarra[] = new int[length];
        
        for(int y = 0;y <length; y++)
        {
            String strnumb = Integer.toString(numbs);
            numarra[y] = Character.getNumericValue(strnumb.charAt(y));
        }
        return numarra;
    }
    // mutater methods
    public static void setNumb(int x)
    {
        numbs = x;
    }
    public static void setlength(int x)
    {
        length = x;
    }
    // acsesor methods
    public static int getnumb()
    {
        return numbs;
    }
    
    public static int getLength()
    {
        return length;
    }

    
    }
