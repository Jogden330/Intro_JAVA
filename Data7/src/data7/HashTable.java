/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data7;

/**
 *
 * @author The Meat Man
 */
public class HashTable {
    
    private HashNode[] table;
    
        /*
     Function: HashTable
     Author: jonatan Ogden
     Description: a defalt constructs that sets the array to 53
     Inputs: N/a
     Outputs:  N/a
     */
      public HashTable()
    {
        this(53);
    }
         /*
     Function: HashTable
     Author: jonatan Ogden
     Description: an overloded constructs that sets the array to a sepsifided amount
     Inputs: an int that sets the array to a lingth
     Outputs:  N/a
     */
       public HashTable(int numb)
    {
         table = new HashNode[numb];
         for(int i = 0; i < table.length; i++)
         {
             table[i] = null;
         }
                  
    }
         /*
     Function: Hash
     Author: jonatan Ogden
     Description: a function that takes two strings and places it on a hash table
     Inputs: two strings to be placed on the hash table
     Outputs:  N/a
     */
    public void hash(String name, String number)
    {
        HashNode node = new HashNode(name,number);
        int hash = hashFunc(node.getName());
        addToTable(hash,node);
          if(hashcheck())
        {
            this.hashExpand();
        }
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
     Function: search
     Author: jonatan Ogden
     Description: serceches the table for a name value and prints the data in that section
     Inputs: a string to be hashed and than used to surch
     Outputs:  N/a
     */
     public void search(String name)
     {
         int key = hashFunc(name);
         while(table[key] != null)
             {
             if(table[key].getName().equals(name))
             {
                System.out.println(table[key].getName() +"(" +table[key].getKey()+")" );
                System.out.println(table[key].getNumber());
                return;
             }else{
                  System.out.println("i made it");
                 ++key;
                 key %= table.length;   
             }
             
         }
         System.out.print( name +" was not found");
     }
     private void addToTable(int hash,HashNode node)
     {
      while(table[hash] != null)
      {
             ++hash;
             hash %= table.length;   
      }
        
        table[hash] = node;
        node.setKey(hash);
      
     }
             /*
     Function: show
     Author: jonatan Ogden
     Description: prints the data sections off all the parts off the hash table
     Inputs: N/a
     Outputs:N/a
     */
     public void show()
     {
         for(int i = 0; i < table.length; i++)
         {
             if(table[i] != null)
             System.out.println(table[i].getName()+ "(" +table[i].getKey()+ ")"  + " " + table[i].getNumber());
         }
     }
            /*
     Function: Hashcheck
     Author: jonatan Ogden
     Description: checks to see if the hash table is 75% full
     Inputs: N/a
     Outputs:  a boolean that checks if the table is 75 % full
     */
    private boolean hashcheck()
    {
        if(this.hashfull() > (table.length*0.75))
        {
            return true;
        }else{
            return false;
        }
    }
         /*
     Function: Hashfull
     Author: jonatan Ogden
     Description: a function that counts the number of plases on the cach table have a value in them
     Inputs: N/a
     Outputs:  an int that is the number of spaces on a table are taken
     */
    private int hashfull()
    {
        int numb = 0;
        for(int i =0; i < table.length; i++)
        {
            HashNode p = table[i];
            if(p != null)
            {
                numb++;
                
            }
        }
        return numb;
    }
         /*
     Function: HashExpand
     Author: jonatan Ogden
     Description: expands the hash table array and palces them on the table acording to thare new hash values
     Inputs: N/a
     Outputs:  N/a
     */
    private void hashExpand()
    {
        
        HashNode [] temp = new HashNode[table.length];
        System.arraycopy(table, 0, temp, 0, table.length);
       
        table = new HashNode [table.length*2];
        for(int i = 0; i < table.length; i++)
        {
            table[i] = null;
        }
        
        for(int i =0; i < temp.length; i++)
        {
           HashNode  p = temp[i];
           if(p != null)
           {
               this.hash(p.getName(),p.getNumber());
               
           }
        }
    }
}
