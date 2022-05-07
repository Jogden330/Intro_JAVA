/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab6;

/**
 *
 * @author The Meat Man
 */
public class ArrayMetrics 
{
 
    private ArrayMetrics()
            {
                
            }
       
    public static double mean(int[] ar)
    {
        int sum = 0;
        
        for(int i = 0; i < ar.length; i++)
        {
            sum += ar[i];
        }
        return sum / ar.length;
    }

    
    public static int meadiam (int[] ar)
    {
        int[] arranged = ar;
        int temp = 0, val = 0;
        boolean dswap = false;
        
        while(dswap = false)
        {
            
            dswap = true;
        
            for(int i = 1; i < arranged.length - 1; i++)
            {
             if(arranged[i -1] > arranged[i])
             {
                temp = arranged[i -1];
                arranged[i - 1] = arranged[i];
                temp = arranged[i];
                dswap = false;
             }
            }
        }
        if(arranged.length % 2 == 0)
        {
            
            val += arranged[(arranged.length / 2) - 1];
            val += arranged[(arranged.length / 2) + 1];
            val = val/2;
        }else{
            val = arranged[arranged.length] / 2;
        }
        return val;
    }
    
    public static int max(int[] ar)
    {
        int max = ar[0];
        
        for(int i = 1; i < ar.length; i++)
        {
            if(max < ar[i])
                max = ar[i];
        }
              return max;  
    }
    public static int min(int[] ar)
    {
        int min = ar[0];
        
        for(int i = 1; i < ar.length; i++)
        {
            if(min > ar[i])
                min = ar[i];
            
        }
        return min;
        
    }
    
    public static int sum(int[] ar)
    {
            int sum = 0;
            
            for(int i = 0; i < ar.length; i++)
            {
                sum += ar[i];
            }
            
            return sum;
    }      
}
