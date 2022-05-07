/*
 * @author Jonathan Ogden
 *  CSIS 211
 * 0211330
 * Assignment 1
 * an object that takes date and makes it tinto a caricter and can also convert that charicter into data
 */
package data.structures.assignment.pkg1;


/*
class: Char
Author: Jonathan Ogden 
Description: takes in data as a char and exports a cahr as data
*/
public class Char
{
    private char myChar;// the data tipe for the class
    
    // constructors
    public Char()
    {
     myChar= '\0'; // sets the char to null
    }
    public Char(char c)
    {
        myChar = c; // sets the char to a char
    }
    Char(int c) // converts an int to a char and sets that to the data tipe
    {
        myChar = (char) c;
    }
    Char(final Char c) // converts the object Char to the data tipe
    {
        myChar =   c.toChar(); //calls the acsessor method of the Char object that returns a char
    }
    // mutator methods
    void equals(final Char c) // sets an external obect char to the data tipe
    {
         myChar =  c.toChar(); //calls the acsessor method of the Char object that returns a char    
    }
    void equals(char c) // sets an external char to the data tipe
    {
        myChar = c;
    }
    void equals(int c) throws CharException // sets an exterla int to the data tipe if it is bettween 33 and 127 if not throughs an exeption
    {
       if(c < 33 || c > 127) {
            throw new CharException("Invalid Character");
        }
       myChar = (char) c;  
    }
    // acssesor methods
    
    char toChar() // gets the data tipe as a char to anather method
    {
    return myChar;
    }
    int toInt() // gets the data tipe as an int to anather meathod
    {
    return (int) myChar;
    }        
     
    @Override
    public String toString() // returns the data tipe as a string to anather method
    {
    return "" + myChar;
    }
    
    String toHexString() // returns the data tipe as a hex to anther method
    {
    return Integer.toHexString((int) myChar);
    }
    String add(char c) // returns the data tipe pluse a saplide chars as a string that are stuck togather 
    {
    return "" + myChar + c;
    }
    String add(final Char c) // returns the data tipe pluse a saplide objest Char as a sring that are stuck togather
    {
         return "" + myChar + c.toChar();
    }
}
