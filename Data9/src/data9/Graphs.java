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
 * a lgrapf program
 */    

public class Graphs {
    
    private LinkedList<String>[] table;
    
      /*
     Function: Graphs
     Author: jonatan Ogden
     Description: a defalt constructs that sets the array to 10
     Inputs: N/a
     Outputs:  N/a
     */
    public Graphs()
    {
        this(10);
    }
       /*
     Function: Graphs
     Author: jonatan Ogden
     Description: an overloded constructs that sets the array to a sepsifided amount
     Inputs: an int that sets the array to a lingth
     Outputs:  N/a
     */
    public Graphs(int numb)
    {
        table = new LinkedList[numb];
         for(int i = 0; i < table.length; i++)
         {
             table[i] = null;
         }
    }
     /*
     Function: addlink(
     Author: jonatan Ogden
     Description: a function that takes two string and places links on a graph
     Inputs: two string that are places on the grapf
     Outputs:  N/a
     */
    public void addlink(String first,String second)
    {
        if(this.search(first) == -1 || this.search(second) == -1)
        {
            System.out.println("City not found");
            
        }
        else
        {
        table[this.search(first)].addLink(second);
        table[this.search(second)].addLink(first);
        }
            
    }
       /*
     Function: addCity
     Author: jonatan Ogden
     Description: a function that takes a string and places it on a graph
     Inputs: a string that is to be paced on the grapf
     Outputs:  N/a
     */
    public void addCity(String name)
    {
      
        int hash = hashFunc(name);
         while(table[hash] != null)
      {
             ++hash;
             hash %= table.length;   
      }
         table[hash] = new LinkedList(name);
         table[hash].addLink(name);
          if(Graphcheck())
        {
            this.GraphExpand();
        }
    }
    
    /*
     Function: GraphExpand
     Author: jonatan Ogden
     Description: expands the graph array and palces them on the grapf acording to thare new hash values
     Inputs: N/a
     Outputs:  N/a
     */
     private void GraphExpand()
    {
        //System.out.println("im doing this");
        LinkedList [] temp = new LinkedList[table.length];
        System.arraycopy(table, 0, temp, 0, table.length);
       
        table = new LinkedList [table.length*2];
        for(int i = 0; i < table.length; i++)
        {
            table[i] = null;
        }
        
        for(int i =0; i < temp.length; i++)
        {
           LinkedList  p = temp[i];
           if(p != null)
           {
               this.addCity((String)p.getData());
               
           }
        }
        
    }
         /*
     Function: Graphcheck
     Author: jonatan Ogden
     Description: checks to see if the grapf is 75% full
     Inputs: N/a
     Outputs:  a boolean that checks if the graph is 75% full
     */
     private boolean Graphcheck()
    {
        if(this.Graphsfull() > (table.length*0.75))
        {
            return true;
        }else{
            return false;
        }
    }
      /*
     Function: Graphsfull
     Author: jonatan Ogden
     Description: a function that counts the number of plases on the gragh that have a value in them
     Inputs: N/a
     Outputs:  an int that is the number of spaces on a grafp are taken
     */
        private int Graphsfull()
    {
        int numb = 0;
        for(int i =0; i < table.length; i++)
        {
            LinkedList p = table[i];
            if(p != null)
            {
                numb++;
                
            }
        }
        return numb;
    }
           /*
     Function: hashFunc
     Author: jonatan Ogden
     Description: takes a string and findes a hash value for it 
     Inputs: a string to be hashed
     Outputs:  an int that is the hash value
     */
     private int hashFunc(String s) {

        int ascii = 0;
        for (int i = 0; i < s.length(); i++) {
            ascii += (int) s.charAt(i);
        }
        return ascii % table.length;
    }
       /*
     Function: show
     Author: jonatan Ogden
     Description: prints the data sections off all the parts off the grapf
     Inputs: N/a
     Outputs:N/a
     */
      public void show()
     {
         for(int i = 0; i < table.length; i++)
         {
             if(table[i] != null)
             table[i].printlist();
         }
     }
         /*
     Function: search
     Author: jonatan Ogden
     Description: serceches the table for a name value and reterns ware that value is
     Inputs: a string to be hashed and than used to surch
     Outputs:  an int that is the place on the array
     */
       private int search(String name)
     {
         int key = hashFunc(name);
         while(table[key] != null)
             {
             if(table[key].getData().equals(name))
             {
               
                return key;
             }else{
                  
                 ++key;
                 key %= table.length;   
             }
             
         }
         return -1;
      }
        /*
     Function: DepthFirstTraversa
     Author: jonatan Ogden
     Description: a public method that finds the first vallue on a grafp the sends it to a private meatrhod
     Inputs: N/A
     Outputs:  N/A
     */
       public void DepthFirstTraversal()
      {
          int i = 0;
          
          while(table[i] == null)
          {
              i++;
          }
           this.DepthFirstTraversal(table[i]);
      }
        /*
     Function: DepthFirstTraversa
     Author: jonatan Ogden
     Description: a private method that serces for unvisited leanks on a grapf the recalls this meathod
     Inputs: a LinkedList that is to be used
     Outputs:  N/A
     */
       private void DepthFirstTraversal(LinkedList node)
       {
           
           node.setVisited();
           LinkedList p = node.getHead();
           while(p.getNext() != null)
           {
               
              p = p.getNext();
              if(table[this.search((String)p.getData())].isVisited() == false)
              {
                  
                 DepthFirstTraversal(table[this.search((String)p.getData())]);
              }
           }
           System.out.println(node.getData());
       }
}
