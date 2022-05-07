/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data7;

/**
 *
 * @author The Meat Man
 */
public class HashNode {
    
    private int Key;
    private String name;
    private String number;
         /*
     Function: HashNode
     Author: jonatan Ogden
     Description: an overloded constructor used to set the data section of the node 
     Inputs: two strings that are used to set the data secion of the node
     Outputs:  N/a
     */
    public HashNode(String name, String number)
    {
        this.name = name;
        this.number = number;
    }
          /*
     Function: HashNode
     Author: jonatan Ogden
     Description: a defalt constructor
     Inputs: N/a
     Outputs:  N/a
     */
    public HashNode()
    {
        
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
     Function: getKey
     Author: jonatan Ogden
     Description: a accessor method used to get the name data section
     Inputs: a String that is the name data section
     Outputs:  N/a
     */
    public String getName()
    {
        return name;
    }
           /*
     Function: setName
     Author: jonatan Ogden
     Description: a mutator method used to set the Name data section
     Inputs: N/a
     Outputs:  a String that sets the Name data section
     */
    public void setName(String name)
    {
        this.name = name;
    }
           /*
     Function: getNumber
     Author: jonatan Ogden
     Description: a accessor method used to get the number data section
     Inputs: a String that is the number data section
     Outputs:  N/a
     */
    public String getNumber()
    {
        return number;
    }
           /*
     Function: setNumber
     Author: jonatan Ogden
     Description: a mutator method used to set the Number data section
     Inputs: N/a
     Outputs:  a String that sets the Number data section
     */
    public void setNumber(String number)
    {
        this.number = number;
    }
}
