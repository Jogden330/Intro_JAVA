/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assinment2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author Jonathan Ogden
 *  CSIS 211
 * 0211330
 * Assignment 2
 * used to test CheckArray povided by Glenn Stevenson
 */
public class Assinment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CheckArray<Integer> ca = new CheckArray();
        
        Random r = new Random();
        for(int i = 0; i < 10; i++)
        {
           ca.addElement(r.nextInt(100));
        }
        
        int x = ca.at(1);
        System.out.println(x);
        
        try {
            ca.realloc(20);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        for(int i = 0; i < 10; i++)
        {
            ca.addElement(r.nextInt(100));
        }
        
        for(int i = 0; i < 20; i++)
        {
            System.out.println(ca.at(i));
        }
            
    }
}
