/*
 * @author Jonathan Ogden
 * CSIC 113B
 * 0211330
 * assignment 1
 * printing out numbers... i disided to do any lenght of numbers i hope thats ok
 */

import java.util.Scanner;

public class Javalab1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner in = new Scanner(System.in);
        System.out.print("Give me a number ");
        int numbs = in.nextInt();
        Javalab1 c = new Javalab1();
       
        System.out.println("the sum of the numbers is: " + c.sumNumb(Integer.toString(numbs)));
        System.out.println("the numbers in reverce are: " + c.reverseNums(Integer.toString(numbs)));
        
        System.out.println("Printing Array:");
        int  numbarray[] = c.getArray(numbs);
        
        for(int y = 0; y < numbarray.length;y++)
        {
        System.out.println(numbarray[y]);
        }
        
        
    }
    public int sumNumb(String x)
    {
        int sum = 0;
        
        
        for(int y = 0;y < x.length(); y++)
        {
            sum += Integer.parseInt(Character.toString(x.charAt(y)));   
        }
        return sum;
    }
    public String reverseNums(String x)
    {
        String revnume = "";
        
        for(int y = x.length()-1;y >= 0;y--)
        {
            revnume += Character.toString(x.charAt(y));
        }
        return revnume;
    }
    public int[] getArray(int x)
    {
        int numarra[] = new int[Integer.toString(x).length()];
        
        for(int y = 0;y < Integer.toString(x).length(); y++)
        {
            numarra[y] = Integer.toString(x).charAt(y);
        }
        return numarra;
    }
}
