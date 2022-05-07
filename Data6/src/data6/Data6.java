/*
 * @author Jonathan Ogden 
 * CSIC 211
 * 0211330
 * assignment 6
 * to test the hashtable
 */
package data6;

import java.util.Random;

public class Data6 {

       HashTable table = new HashTable();
       Random r = new Random();
       double sample = 5.5;
/*
     Function: data6
     Author: jonatan Ogden
     Description: palcess 100 random doubles on the hash table then 3 of the same doubles the seches for those 3 doubles then prints the table
     Inputs: N/a
     Outputs:  N/a
     */
    public Data6()
    {
        
        for(int i = 0; i < 100;i++)
        {
             table.hash(r.nextDouble() * 1000);
        }
        table.hash(sample);
        table.hash(sample);
        table.hash(sample);
        table.printTable();
        System.out.println("this meany " + sample + ": " + table.search(5.5));
        
        
    }
    public static void main(String[] args) {
        Data6 d6 = new Data6();
        
    }
}
