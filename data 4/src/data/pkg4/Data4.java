/*
 * @author Jonathan Ogden 
 *CSIC 211
 * 0211330
 * assignment 4
 * a program that converst a string into a salved eqation
 */
package data.pkg4;

import java.util.Scanner;


public final class Data4 {

 
    
    
    Infix pf;
    Postfix post;
    
    Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        Data4 a3 = new Data4();
    }
       /*
Function: Data4()
Author: jonatan Ogden
Description: a function that runs menu forever
Inputs: inputs an int the represents the users munu chioes
Outputs:  N/a
*/
    public Data4()
    {
        for(;;){
        menu();
       
        }
    }
    /*
Function: menu
Author: jonatan Ogden
Description: a function that gets an equation from the userand takes a very circuitous route to solve it
Inputs: N/a
Outputs:  N/a
*/
    void menu()
    {
       System.out.println("enter an equation"); 
       pf = new Infix(in.nextLine());
       post = new Postfix(pf.getOutPut());
       System.out.println(post.anser());
             
    }
   
}

