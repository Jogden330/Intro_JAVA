/*
 * @author Jonathan Ogden
 *  CSIS 211
 * 0211330
 * Assignment 2
 * creates an arrey of generics that can be resisesed accsessed, mutated, and cleared
 */
package assinment2;

    /*
class: CheckArray
Author: Jonathan Ogden
Description: a class used to creat a generic array
Inputs: the generic tipe E.X <Integer>
Outputs: N/A 
*/

public class CheckArray <T>
{
    private T[] myArray;
    private static int end = 0;
    
    /*
Constructor: CheckArray
Author: Jonathan Ogden
Description: creates a genaric array with spaces eaquile to the size provided
Inputs: an int that dettermens the size of the array
Outputs: N/A 
*/
   public CheckArray(int size)
   {
       myArray = (T[]) new Object[size];
   }
       /*
Constructor: CheckArray
Author: Jonathan Ogden
Description: creates a genaric array with sappesses eaquile to 10
Inputs: an int that dettermens the size of the array
Outputs: N/A 
*/
   public CheckArray()
   {
       this(10);
   }
/*
Function: realloc
Author: jonatan Ogden
Description: This function is used to add additional space to myArray
Inputs: an int that will determen the size of myArray
Outputs:  N/a 
*/
   void realloc(int size) throws Exception 
   {
       try
       {
         if(size < myArray.length) {
               throw new Exception ("that number was to small");
           }
         
         T[] tempArray = myArray;
         myArray = (T[]) new Object[size];
         
         for(int i = 0; i < tempArray.length; i++)
         {
           myArray[i] = tempArray[i]; 
         }
       }catch(OutOfMemoryError e) {
           System.out.println(e.getMessage());
       }
   }
/*
Function: addElement
Author: jonatan Ogden
Description: This function is used to add new data to the next empty spot on the array
Inputs: takes a Generics that is added to the array
Outputs:  N/a 
*/
   void addElement(T data)
   {
      try
      {
        myArray[end] = data;
        end++;
      }catch (ArrayIndexOutOfBoundsException e){
          System.out.println(e.getMessage());
      } 
   }
 /*
Function: at
Author: jonatan Ogden
Description: This function is used to accssess a spot on the array
Inputs: takes an int that is used to dettermen what spot on the array to acssess
Outputs:  returns a Generic fom whatever spot on the array was acssessed
*/ 
   T at(int index)
   {
       return myArray[index];
   }
    /*
Function: clear
Author: jonatan Ogden
Description: This function is used to set all of the spots on the array to null and to reset the next empty spot to the begging of the array
Inputs: N/A
Outputs:  N/A
*/ 
   void clear()
   {
       for(int i = 0; i < myArray.length; i++)
       {
           myArray[i] = null;
           
       }
       end = 0;
   }
}
