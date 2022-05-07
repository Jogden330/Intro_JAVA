/*
 * @author Jonathan Ogden
 *  CSIS 211
 * 0211330
 * Assignment 1
 * an Exeption class 
 */
package data.structures.assignment.pkg1;


class CharException extends Throwable 
{
     private String Msg;
     
/*
Function: CharException
Author: Jonathan Ogden 
Description: Constructor for CharException
*/

    public CharException(String  message)
    
     {
         this.Msg = message; // sets the message taken from the constructot
     }
    /*
Function: getMessage 
Author: Jonathan Ogden 
Description: returns the message passed by the constructor
* output: outputs the message from the constructor
*/
      public String getMessage ()
              {
                  return this.Msg;
              }
    
    

}
