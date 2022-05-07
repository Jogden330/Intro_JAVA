/*
 * @author Jonathan Ogden 
 * CSIC 211
 * 0211330
 * assignment 8
 * a program tusded to test sorting agaritoms
 */
package data8;

import java.util.Random;


public class Data8 {

    
    Random random = new Random();
    double[] d;
    
     /*
     Function: main
     Author: jonatan Ogden
     Description: a main method used to create d8
     Inputs: N/a
     Outputs: N/a 
     */
    public static void main(String[] args)
    {
        Data8 d8 = new Data8();
               
    }
     /*
     Function:Data8
     Author: jonatan Ogden
     Description: a method used to test sort
     Inputs: N/a
     Outputs: N/a 
     */
    public Data8()
    {
       d = new double[1000];
       
        randomiz();
        Sort sort = new Sort(d);
        sort.insertionsort();
        System.out.println("Insertion Sort iterations: " + sort.getTime() + " nanoseconds to compleat: " + sort.getNanoTime());
        randomiz();
        
        sort.shellSort(d);
        System.out.println("Shell Sort iterations: " + sort.getTime() + " nanoseconds to compleat: " + sort.getNanoTime());
        randomiz();
        
        sort.quickSort(d);
        System.out.println("Quick Sort iterations: " + sort.getTime() + " nanoseconds to compleat: " + sort.getNanoTime());
        randomiz();
        
        sort.selectSort(d);
        System.out.println("Select Sort iterations: " + sort.getTime() + " nanoseconds to compleat: " + sort.getNanoTime());
     }
       /*
     Function:Data8
     Author: jonatan Ogden
     Description: a method used to randomiz a double array
     Inputs: N/a
     Outputs: N/a 
     */
    public void randomiz()
    {
       for(int i = 0; i < d.length; i++)
        {
            d[i] = 1 + (100 - 1) * random.nextDouble();
        }  
    }
}
