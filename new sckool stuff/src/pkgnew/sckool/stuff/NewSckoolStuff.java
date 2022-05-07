/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew.sckool.stuff;

/**
 *
 * @author The Meat Man
 */
import java.util.Random;
import java.util.Scanner;
public class NewSckoolStuff {
  
    public int[] numarray()
    {
        Scanner in = new Scanner(System.in);
       
        int size = in.nextInt();
        int numarray[] = new int[size];
        return numarray;
    }
    
    public void fillArray(int[] numarray)
    {
        Random r = new Random();
        for(int i = 0; i <numarray.length; i++)
        {
            numarray[i] = r.nextInt(101);
        }
    }
    public void printArray(int[] numarray)
    {
        for(int j=0; j<numarray.length; j++)
        {
            System.out.println(""+ numarray[j]);
        }
    }
      public int max(int[] numarray)
              {
                  int m = numarray[0];
                  for(int i = 1; i < numarray.length ; i++)
                  {
                      if(numarray[i] > m)
                      {
                          m = numarray[i];
                      }
                  }
                  return m;
              }    
    
   
    public static void main(String[] args) {
       NewSckoolStuff as = new NewSckoolStuff();
       System.out.print("Give me a number: ");
       int numarray[] = as.numarray();
       as.fillArray(numarray);
       System.out.println("--");
       as.printArray(numarray);
       int Large = as.max(numarray);
       System.out.println("max is "+Large);
       
    }
}
