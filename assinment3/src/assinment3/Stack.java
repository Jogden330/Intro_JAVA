/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assinment3;

import java.util.ArrayList;

     /*
class: stack
Author: jonatan Ogden
Description: a genaric class that inputs and outputs data onto a stack
Inputs: inputs data that gose onto the stack
Outputs: outputs data the gose out if the stack
*/
public class Stack <T>{
    
    
   
    
    private int top = -1;
    private ArrayList<T> stack;
     /*
construtor: stack
Author: jonatan Ogden
Description: sets the size of the stack array to the value past to the constructor
Inputs: an int that is size of the stack array
Outputs:  N/a 
*/    
  
     /*
construtor: stack
Author: jonatan Ogden
Description: sets the defalt size of the stack array to 10
Inputs: N/a
Outputs:  N/a 
*/
    public Stack()
   {
       
   }
    /*
Function: push
Author: jonatan Ogden
Description: This function is used to add additional elements to the top of the array plus add aditional space if needed
Inputs: inputs a genaric that is placed at the top of the array
Outputs:  N/a 
*/
   public void push(T elem)
   {
      
       stack.add(elem);
        top++;
        
   }
   /*
Function: pop
Author: jonatan Ogden
Description: This function is used take the top off the array and return that value Plus if the array gets to small shrink it by half
Inputs: N/a
Outputs:  a genaric that is a the top of the array
*/
   public T pop()
   {
       
       if(top >= 0) {
         return stack.remove(--top);
       }else{
           return null;
       }
       
       
   }
   /*
Function: peek
Author: jonatan Ogden
Description: showes what is on the top of the array
Inputs: N/A
Outputs:  a genaric that is at the top of the array
*/
    public T peek() {
        try {
            return stack.get(top);
        } catch (NullPointerException e) {
            return null;
        }
    }
    /*
Function: size
Author: jonatan Ogden
Description: This function is used to show the curent size of the array
Inputs: N/a
Outputs:  an int the represents the amout of stuff is in the array
*/
   public int size()
   {
       return top+1;
   }
  
}
