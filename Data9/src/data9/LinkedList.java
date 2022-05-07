/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data9;

/*
 * @author Jonathan Ogden 
 * CSIC 211
 * 0211330
 * assignment 9
 * a linked list program
 */



public class LinkedList <T>{
    
    private T data;
    
    private LinkedList next;
    
    private LinkedList Head;
    
    private boolean visited = false;
    
    private int Key;
    
     
    /*
     Function: linkedList
     Author: jonatan Ogden
     Description: constructs linklist and sets head to null
     Inputs: N/a
     Outputs:  N/a
     */
    public LinkedList()
    {
        Head = null;
    }
    /*
     Function: linkedlist
     Author: jonatan Ogden
     Description: over loded construtor that sets the data cection of the linked list
     Inputs: a genaric that sets the data section of the linked list
     Outputs:  N/a
     */
    public LinkedList(T info)
    {
        this.data = info;
    }
    /*
     Function: firstlink
     Author: jonatan Ogden
     Description: creates a linklist that is placed in front of the stack
     Inputs: a genaric that is used to set the data section of the linked list
     Outputs:  N/A
     */
    void firstlink(T info)
    {
        LinkedList n = new LinkedList(info);
        
        n.next = Head;
        
        Head = n;
        
    }
/*
     Function: addlink
     Author: jonatan Ogden
     Description: addes a link at the end of the linklist
     Inputs: N/a
     Outputs: a gearic the is used to set the data section of the linklist
     */
    void addLink(T info)
    {
        if(Head == null)
        {
            Head = new LinkedList(info);
            Head.next = null;
        }else{
            
        LinkedList p = Head;
        
        LinkedList n = new LinkedList(info);
        
        n.next = null;
        
        while(p.next != null)
        {
            p = p.next;
        }
        p.next = n;
        }
    }
      
    /*
     Function: insert
     Author: jonatan Ogden
     Description: inserts a link in a linkedlist after a spesifided link
     Inputs: two genarics the first: data section to be found second: data section to be added
     Outputs:  N/a
     */
    void insert(T search, T info)
    {
        LinkedList p = Head;

        try {
            while (!p.data.equals(search)) {
                p = p.next;
            }
            LinkedList n = new LinkedList(info);
            n.next = p.next;
            p.next = n;
        } catch (NullPointerException e) {
            System.out.println("sorry " + search + " not be found");
        }
    }
    /*
     Function: deletlink
     Author: jonatan Ogden
     Description: findes a link and removes it
     Inputs: a genaric that is the data section of the link that is to be deleted
     Outputs: N/a
     */
    void deletelink(T search) {
        LinkedList p = Head;

        try {

            while (!p.data.equals(search)) {
                p = p.next;
            }
            p.next = p.next.next;
        } catch (NullPointerException e) {
            System.out.println("sorry " + search + " not be found");
        }

    }
    /*
     Function: searchList
     Author: jonatan Ogden
     Description: serces a list based on how far from the front it is
     Inputs: an int that is the number on the list to be retreved
     Outputs: a geneaic that is the data section of then serced link
     */
    T seacrhlist(int spot)
    {
        try {
            LinkedList p = Head;
            for (int i = 0; i < spot; i++) {
                p = p.next;
            }

            return (T) p.getData();
        } catch (NullPointerException e) {
            return null;
        }

    }
     /*
     Function: searchListNumb
     Author: jonatan Ogden
     Description: findes the number of times a double is found in the list
     Inputs: the double to be serched for
     Outputs: an int that is the number of time a double was found
     */
    int searchListNumb(String value)
    {
        int numb = 0;
        LinkedList p = Head;
        while(p != null)
        {
            if(p.data == value)
            {
                numb++;
            }
            p = p.next;
        }
        return numb;
    }
    /*
     Function: printlist
     Author: jonatan Ogden
     Description: prints the data section of every linked list
     Inputs: N/a
     Outputs:  N/a
     */
   void printlist()
   {
       LinkedList p = Head;
       System.out.println(" ");
        
       while(p != null)
       {
           System.out.print( p.data + " ");
           p = p.next;
       }
   }/*
     Function: sethead
     Author: jonatan Ogden
     Description: mutats the head of the linkedlist
     Inputs: a linkedlist that is set as the head
     Outputs:  N/a
     */
   void setHead( LinkedList elem)
   {
       Head = elem;
   }
   /*
     Function: getHead
     Author: jonatan Ogden
     Description: accessess the head of he linked list
     Inputs: N/a
     Outputs:  a linked list that is set as the head
     */
   LinkedList  getHead()
   {
       return Head;
   }
   /*
     Function: getdata
     Author: jonatan Ogden
     Description: accessess the data setion of the linked list
     Inputs: N/a
     Outputs: a genaric that is the data section of the linked list
     */
   T getData()
   {
     return data;
   }
   /*
     Function: setdata
     Author: jonatan Ogden
     Description: mutates the data section of the linked list
     Inputs: a genaric that is the data section of the linked list
     Outputs: N/a
     */
   void setData(T data)
   {
       this.data = data;
   }
   /*
     Function: getnext
     Author: jonatan Ogden
     Description: accessess the next link in the linked list
     Inputs: N/a
     Outputs:  a linklist that is the next link in the linked list
     */
   LinkedList getNext()
   {
       return next;
   }
   /*
     Function: setnext
     Author: jonatan Ogden
     Description: mutates the next link in the linkedlist
     Inputs: a linkedlist that is set to the next link in the linked list
     Outputs:  n/a
     */
   void setNext(LinkedList next)
   {
       this.next = next;
   }
             /*
     Function: getKey
     Author: jonatan Ogden
     Description: a accessor method used to get the key data section
     Inputs: an int that is the key of the data section
     Outputs:  N/a
     */
    public int getKey()
    {
        return Key;
    }
            /*
     Function: getKey
     Author: jonatan Ogden
     Description: a mutator method used to set the key data section
     Inputs: N/a
     Outputs:  an int that sets the key of the data section
     */
    public void setKey(int key)
    {
        this.Key = key;
    }
          /*
     Function: isVisited
     Author: jonatan Ogden
     Description: a assessor method used to check the boolean visited
     Inputs: N/a
     Outputs:  a boolean 
     */
    public boolean isVisited()
    {
        return visited;
    }
          /*
     Function: setVisited
     Author: jonatan Ogden
     Description: a mutator method change the visited boolean
     Inputs: N/a
     Outputs: N/a
     */
    public void setVisited()
    {
        visited = !visited;
    }
}

