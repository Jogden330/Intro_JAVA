
package data.structures.assignment.pkg1;

/*
class: DataStructuresAssignment1
Author: origanaly buy Glenn Stevenson but typed by Jonathan Ogden 
Description: uses the Char Object class to several thing
* output: char ch and c in several ways
*/
public class DataStructuresAssignment1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Char ch = new Char('A'); // creates an objest Char named ch and sets it to A
        Char c = new Char('B'); // creates an objest Char named c and sets it to b
        
        System.out.println(ch.add(c)); // outputs ch and c together as a string
        System.out.println(ch.toChar() + " in Hex " + ch.toHexString()); // outputs ch as a char then as a hex number
        System.out.println(ch.toChar() + " in Decimal " + ch.toInt());// outputs ch as a char then as a decimal
        
        try
        {
            System.out.println("try to set the charicter to 140"); // outputs a string to the screen
            ch.equals(140); // sets the data section of ch hier the ch can handal and throughs an error that will print to the screen
            System.out.println(ch.toChar()); // is never reached
            
        }
        catch(CharException ce)
        {
            System.out.println(ce.getMessage()); // prints the message strored in  getmessage  meathod to the screen
        }
        Char x = new Char(c); // creats a Char object named x and sets it to the chat object c
        System.out.println(x.toChar()); // outputs the data stored in char object x as a char
        
}
}
