/*
 * @author Jonathan Ogden 
 * SIC 211
 * 0211330
 * assignment 4
 * conversts a string from prifix notation to postsix notation
 */
package data.pkg4;


public class Infix 
{
    
    private Stack<Character> stack = new Stack();
    private String input;
    private String output = " ";
    private boolean isfirst = false;
    
      /*
     Function: infix
     Author: jonatan Ogden
     Description: changes a infix notation to a postfix notation
     Inputs: a string to be converted
     Outputs:  n/a
     */
    public Infix(String input) 
    {
        try {
            this.input = input;

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (!isOperator(c)) {
                    output += Character.toString(c);
                    dumpStack(i);
                } else {
                    if (isfirst) {
                        if (PluseorMinuse(c) && PluseorMinuse(stack.peek())) {
                            output += stack.pop();
                            stack.push(c);
                            dumpStack(i);
                        }
                        if (moltaplyorSDivide(c) && moltaplyorSDivide(stack.peek())) {
                            output += stack.pop();
                            stack.push(c);
                            dumpStack(i);
                        } else if (PluseorMinuse(c) && moltaplyorSDivide(stack.peek())) {
                            output += stack.pop();
                            stack.push(c);
                            dumpStack(i);
                        } else if (moltaplyorSDivide(c) && moltaplyorSDivide(stack.peek())) {
                            stack.push(c);
                            dumpStack(i);

                        } else {
                            output += c;
                            dumpStack(i);
                        }
                    } else {
                        stack.push(c);
                        isfirst = false;
                    }
                }

            }
        } catch (Exception e) {
            System.out.println("im sorry somthing went rong");

        }
    }
      /*
     Function: dmpstack
     Author: jonatan Ogden
     Description: plasses all itumes in the stack at the end of the output string
     Inputs: N/a
     Outputs:  n/a
     */
    private void dumpStack(int i)
    {
        if (i == (input.length() - 1)) {
                    for (int y = stack.size(); y > 0 ; y--) {
                        output += stack.pop();
                    }
        }
        
    }
      /*
     Function: plusorminuse
     Author: jonatan Ogden
     Description: checks to see is a charicter is eathor a + or a - simbol
     Inputs: a charicter to check
     Outputs:  a boolean that returns true if the charicter is a + or -
     */
    private boolean PluseorMinuse(char c)
    {
        switch(c)
       {
           case '+':
              
               return true;
           case '-':
                
                return true;
           default:
               return false;
        }
    }
      /*
     Function: moltaplyorSDivide
     Author: jonatan Ogden
     Description: checks to see is a charicter is eathor a * or a / simbol
     Inputs: a charicter to check
     Outputs:  a boolean that returns true if the charicter is a * or /
     */
    private boolean moltaplyorSDivide(char c)
    {
        switch(c)
       {
          case '*':
              
               return true;
           case '/':
                
                return true;
           default:
               return false;
        }
    }
    /*
     Function: isOperator
     Author: jonatan Ogden
     Description: checs if the charicter is a mathmatical operator 
     Inputs: a char that is to be checed
     Outputs:  a boolean to tell if a charicter is mathmatical operator
     */
    private boolean isOperator(char c)        
    {
        
    
       switch(c)
       {
           case '+':
              
               return true;
           case '-':
                
                return true;
           case '*':
              
               return true;
           case '/':
               
               return true;
           default:
               return false;
       }
    }
    /*
     Function: getoutput
     Author: jonatan Ogden
     Description: assessess the output string that sould be converted into Postfix
     Inputs: N/a
     Outputs:  a sring that sould be converted into Postfix
     */
    String getOutPut()
    {
        return output;
    }
}
