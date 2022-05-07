/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab12;

import java.util.Scanner;

/*
 * @author Jonathan Ogden 
 * CSIC 123B
 * 0211330
 * assignment 12
 * Test app
 */
public class Lab12 {

     public Lab12()
    {
        PairList<String,Integer> studid = new  PairList<String,Integer>();
        
        studid.addPair("Jonathan Ogden", 1);
        studid.addPair("Britney Luoma", 2);
        studid.addPair("Reginald Fuzzybottom", 3);
        studid.addPair("Mega Man", 4);
        studid.addPair("Batman", 5);
        
        System.out.print("find a student number");
        Scanner in = new Scanner(System.in);
        int name = in.nextInt();
        System.out.println(name);
        System.out.println(studid.searchSecond(name));
        
        for(Pair first : studid)
        {
            System.out.println(first.getFirst());
        }
        
    }
    public static void main(String[] args) {
        Lab12 test = new Lab12();
    }
}
