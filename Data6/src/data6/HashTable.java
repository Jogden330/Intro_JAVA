/*
 * @author Jonathan Ogden 
 *CSIC 211
 * 0211330
 * assignment 6
 * a hash table
 */
package data6;

/**
 *
 * @author The Meat Man
 */
public class HashTable{
    
    private LinkedList[] listArray;
    
    
        /*
     Function: HashTable
     Author: jonatan Ogden
     Description: a defalt constructs that sets the array to 50
     Inputs: N/a
     Outputs:  N/a
     */
    public HashTable()
    {
        this(50);
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
         listArray = new LinkedList[numb];
         for(int i = 0; i < listArray.length; i++)
         {
             listArray[i] = new LinkedList();
         }
                  
    }
        /*
     Function: Hash
     Author: jonatan Ogden
     Description: a function that takes a double and places it on a hash table
     Inputs: a double that is to be paced on the hash table
     Outputs:  N/a
     */
    public void hash(double value)
    {
        int hash = hashFunc(value);
        
        if(this.search(value) == 0) // if value is new it gose in first
        {
            listArray[hash].firstlink(value);
        }else{
            listArray[hash].addLink(value);
        }
        if(hashcheck())
        {
            this.hashExpand();
        }
    }
        /*
     Function: search
     Author: jonatan Ogden
     Description: serceches the table for a double value and reterns the number of instences that that number is found
     Inputs: the double to be serced for
     Outputs:  an int that is the number of the times a value is found
     */
    public int  search(double value)
    {
     
        return listArray[hashFunc(value)].searchListNumb(value);
            
    }
     /*
     Function: printTable
     Author: jonatan Ogden
     Description: prints a the entier hash table
     Inputs: N/a
     Outputs:  N/a
     */
    public void printTable()
    {
        for(int i = 0; i < listArray.length;i++)
        {
            System.out.println("Array at " + i);
            listArray[i].printlist();
        }
    }
        /*
     Function: HashTable
     Author: jonatan Ogden
     Description: takes a double and findes a hash value for it 
     Inputs: a double to be hashed
     Outputs:  an int that is the hash value
     */
    private int hashFunc(double numb)
    {
        return (int) (numb % listArray.length);
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
        
        LinkedList[] temp = new LinkedList[listArray.length];
        System.arraycopy(listArray, 0, temp, 0, listArray.length);
       
        listArray = new LinkedList[listArray.length*2];
        for(int i = 0; i < listArray.length; i++)
        {
            listArray[i] = new LinkedList();
        }
        
        for(int i =0; i < temp.length; i++)
        {
           LinkedList p = temp[i].getHead();
           while(p != null)
           {
               this.hash(p.getData());
               p = p.getNext();
           }
        }
    }
        /*
     Function: Hashcheck
     Author: jonatan Ogden
     Description: checks to see if the hash table is 75% full
     Inputs: N/a
     Outputs:  a boolean that checks if the table is 75% full
     */
    private boolean hashcheck()
    {
        if(this.hashfull() > (listArray.length*0.75))
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
        for(int i =0; i < listArray.length; i++)
        {
            LinkedList p = listArray[i].getHead();
            if(p != null)
            {
                numb++;
                
            }
        }
        return numb;
    }
}
