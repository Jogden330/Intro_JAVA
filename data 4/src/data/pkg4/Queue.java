/*
 * @author Jonathan Ogden 
 * CSIC 211
 * 0211330
 * assignment 4
 * a queue of linked lists
 */
package data.pkg4;


public class Queue<T> extends LinkedList<T> {

    int top;
    /*
     Function: queue()
     Author: jonatan Ogden
     Description: constructor for the queue class
     Inputs: N/a
     Outputs:  N/a
     */
    public Queue() 
    {
    }
    /*
     Function: enqueue
     * Author: jonatan Ogden
     Description: adds a item to the front of the linked list
     Inputs: a genaric that is added to the data section of the linked list
     Outputs:  N/a
     */
    public void enqueue(T elem) {
        top++;
        this.addLink(elem);


    }
/*
     Function: dequeue
     Author: jonatan Ogden
     Description: removes the last item in the linked list
     Inputs: N/a
     Outputs:  a generic that is the data section of the linked list that is removed
     */
    public T dequeue() {
  
        if (top > 0) 
        {
            top--;
            T popped = (T) getHead().getData();
            setHead(getHead().getNext());
            return popped;
        } else {
            return null;
        }

            

    }
/*
     Function: Peek
     Author: jonatan Ogden
     Description: Ta function that shows the last link list in the queue
     Inputs: N/a
     Outputs: a genaric of the data section of the linked list
     */
    public T peek() {
        try {
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

    public int size() {
        return top;
    }
}
