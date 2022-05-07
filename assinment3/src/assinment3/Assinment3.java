/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assinment3;

import java.util.Scanner;

       /*
 class: Assinment3
Author: jonatan Ogden
Description: a class that is used to display a menu to asseses the stack class
Inputs: menu choises
Outputs: information from the stack class
*/
public class Assinment3 {

    Stack<String> strStack = new Stack<String>();
    Stack <Integer> intStack = new Stack<Integer>();
    
    int pick;
    Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        Assinment3 a3 = new Assinment3();
    }
       /*
Function: Assinment3()
Author: jonatan Ogden
Description: a function that is used to repedidly asses the menu functio seleced a number and pass the to the choise funtion
Inputs: inputs an int the represents the users munu chioes
Outputs:  N/a
*/
    public Assinment3()
    {
        do{
        menu();
        pick = in.nextInt();
        choise(pick);
        }while(pick != 5);
    }
    /*
Function: menu
Author: jonatan Ogden
Description: a function that is used to display several munu items
Inputs: N/a
Outputs:  N/a
*/
    void menu()
    {
       System.out.println("1 :Add number to stack"); 
       System.out.println("2 :pop number off stack");
       System.out.println("3 :peek at number in the stack");
       System.out.println("4 :check size of stack"); 
       System.out.println("5 :exit");
             
    }
         /*
Function: choise
Author: jonatan Ogden
Description: a function that is used to select one of several munu items
Inputs: an int that is used to determen the desiered munu item
Outputs:  N/a
*/
    void choise(int i)
    {
        switch(i)
        {
            case 1: add();
                break;
            case 2: pop();
                break;
            case 3: peek();
                break;
            case 4: size();
                break;
        }
     
    }
         /*
Function: push
Author: jonatan Ogden
Description: a function that calls the push function from th stack class and adds the information provided to it
Inputs: an int that is passed to the push function of the stack class
Outputs:  N/a
*/
    public void add()
    {
        System.out.println("enter a number");
        intStack.push(in.nextInt());
    }
         /*
Function: pop
Author: jonatan Ogden
Description: a function that calls the pop function from th stack class and displyes that information on the screen
Inputs: N/a
Outputs:  N/a
*/
    public void pop()
    {
        System.out.println(intStack.pop());
    }
         /*
Function: peek
Author: jonatan Ogden
Description: a function that calls the peek function from th stack class and displyes that information on the screen
Inputs: N/a
Outputs:  N/a
*/
    public void peek()
    {
        System.out.println(intStack.peek());
    }
     /*
Function: size
Author: jonatan Ogden
Description: a function that calls the size function from th stack class and displyes that information on the screen
Inputs: N/a
Outputs:  N/a
*/
    public void size()
    {
        System.out.println(intStack.size());
    }
}
