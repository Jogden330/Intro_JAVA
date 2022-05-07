/*
 * @author Jonathan Ogden 
 * CSIC 211
 * 0211330
 * assignment 4
 * converst a string to an eqation 
 */

package data.pkg4;


public class Postfix {
    
    private Stack<Double> numbs = new Stack();
    private String input;
    private double temp1, temp2;
    
    /*
     Function: postfix
     Author: jonatan Ogden
     Description: is used to take a postfixed notation eqasion and salve it
     Inputs: a string that is the eqasion
     Outputs:  N./a
     */
    Postfix(String input)
    {
        try{
        this.input = input;
        
        for(int i = 0; i < input.length(); i++)
        {
            char c = input.charAt(i);
            if(!isOperator(c))
            {
              if(c != ' ') 
              {
                    numbs.push(Double.parseDouble(Character.toString(c)));
              }
            }
            
        }
        } catch  (Exception e){
            System.out.println("im sorry somthing went rong");
        }
    }
    
    /*
     Function: isOperator
     Author: jonatan Ogden
     Description: checs if the charicter is a mathmatical operator if it is proformes the eqasion
     Inputs: a char that is to be checed
     Outputs:  a boolean to tell if a charicter is mathmatical operator
     */
    private boolean isOperator(char c)        
    {
        
    
       switch(c)
       {
           case '+':
               pluse();
               return true;
           case '-':
                minus();
                return true;
           case '*':
               motaply();
               return true;
           case '/':
               devide();
               return true;
           default:
               return false;
       }
       
           
    }
    /*
     Function: anser
     Author: jonatan Ogden
     Description: assessess the final eation
     Inputs: a double that is the anser to the eqation
     Outputs:  N/a
     */
    double anser()
    {
        
        return numbs.peek();
 
    }
    /*
     Function: plus
     Author: jonatan Ogden
     Description: proforms a sum of caclation
     Inputs: N/a
     Outputs:  n/a
     */
    private void pluse()
    {
        temp1 = numbs.pop();
        temp2 = numbs.pop();
        numbs.push(temp1 + temp2);
        
    }
    /*
     Function: minus
     Author: jonatan Ogden
     Description: proforms a differns of caculation
     Inputs: N/a
     Outputs: n/a
     */
    private void minus()
    {
     temp1 = numbs.pop();
     temp2 = numbs.pop();
     numbs.push(temp1 - temp2);   
    }
    /*
     Function: motaply
     Author: jonatan Ogden
     Description: proforms  a product off caculation
     Inputs: N/a
     Outputs: n/a
     */
    private void motaply()
    {
     temp1 = numbs.pop();
     temp2 = numbs.pop();
     numbs.push(temp1 * temp2);  
    }
     /*
     Function: devide
     Author: jonatan Ogden
     Description: proforms  a quotiont off caculation
     Inputs: N/a
     Outputs: n/a
     */
    private void devide()
    {
     temp1 = numbs.pop();
     temp2 = numbs.pop();
     numbs.push(temp1 / temp2); 
    }
}