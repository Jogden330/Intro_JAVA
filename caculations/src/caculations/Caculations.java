/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caculations;

/**
 *
 * @author The Meat Man
 */
public class Caculations {

    double A = 4073;
    double B = 3039;
    
    
    public static void main(String[] args) {
        
        Caculations cal = new Caculations();
        
    }  
    public Caculations(){
        double anser = ((A - B) / ((A + B) / 2)) * 100;
        System.out.println(anser);
}
      
}
