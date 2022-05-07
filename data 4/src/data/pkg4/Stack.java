/*
 * @author Jonathan Ogden 
 *CSIC 211
 * 0211330
 * assignment 4
 * a stack of linked lists
 */
package data.pkg4;



public class Stack<T> extends LinkedList<T>{
     
    
    
   
   
    private int top = 0;
    
            

     /*
construtor: stack
Author: jonatan Ogden
Description: defalt constructor for stack
Inputs: N/a
Outputs:  N/a 
*/
    public Stack()
   {
       
   }
    /*
Function: push
Author: jonatan Ogden
Description: This function is used to add additional elements to the top of a Linked list
Inputs: inputs a genaric that is used to set the data section of the Linked List
Outputs:  N/a 
*/
   public void push(T elem)
   {
       top++;
       LinkedList n = new LinkedList(elem);
        
        n.setNext(getHead());
        
        setHead(n);
        
   }
   /*
Function: pop
Author: jonatan Ogden
Description: This function is used take the top off a linked list and return its data
Inputs: N/a
Outputs: the data section of the liinked list
*/
   public T pop()
    {
        
            if (top > 0) {
                top--;
                T popped = (T) getHead().getData();
                setHead(getHead().getNext());
                return popped;
            } else {
                return null;
            }
       


    }
   /*
Function: peek
Author: jonatan Ogden
Description: showes what is on the top the linked list
Inputs: N/A
Outputs:  data section of the liked list
*/
    public T peek() {
        try{
            return (T) getHead().getData();
        } catch (NullPointerException e) {
            return null;
        }
       
      
    }
/*
     Function: size
     Author: jonatan Ogden
     Description: This function is used to show the curent number of linked lists
     Inputs: N/a
     Outputs:  an int the represents the amout of linked lists
     */
   public int size()
   {
       return top;
   }
  
}

    

