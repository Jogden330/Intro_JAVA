/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pairlist;

import java.util.Scanner;

/**
 *
 * @author The Meat Man
 */
public class testgui
{
    
    public testgui()
    {
        PairList<String,Integer> studid = new  PairList<String,Integer>();
        
        studid.addPair("Jonathan Ogden", 29330);
        studid.addPair("Britney Luoma", 12345);
        studid.addPair("Maga Man", 656382);
        studid.addPair("Batman", 365869);
        
        System.out.print("find a student ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        System.out.println(studid.searchFirst(name));
        
        
        
    }
    
    public void main()
    {
        testgui tg = new testgui();
    }
}
