/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;





public final class Data7  {
    
    private HashTable hash = new HashTable(53);
    Scanner in ;
    
          /*
     Function: Data7
     Author: jonatan Ogden
     Description: asces the user for a name and fineds it in a hash table
     Inputs: a name to surch for and if thy want to do it again
     Outputs: outputs text to help the user use the progaram
     */
    public Data7()
    {
      char again = 'y';
      String name;
      getData();
      in = new Scanner(System.in);
      //hash.show();
      while(again == 'y')
      {
      System.out.println("Enter name: ");  
      name = in.next();
      hash.search(name);
      System.out.println("Look up another number <Y/N>");
      again = Character.toLowerCase(in.next().trim().charAt(0));
      }
    }
          /*
     Function: getData
     Author: jonatan Ogden
     Description: sercess a text file for names and nubers and sets them in the hash table
     Inputs: N/a
     Outputs:  N/a
     */
    void getData()
    {
          try 
        {
             BufferedReader fileScanner = new BufferedReader(new FileReader("PhoneNumbers.txt"));
             String input;
             Pattern pName = Pattern.compile("([A-Za-z]+;)");
             Pattern pNumber = Pattern.compile("(\\([0-9]{3}\\)+\\s+[0-9]{3}+-+[0-9]{4}+;)");

             Matcher mName;
             Matcher mNumber;
           
             while ((input = fileScanner.readLine()) != null)
             {
                mName = pName.matcher(input);
                while(mName.find())
                {
                    
                    mNumber = pNumber.matcher(input);
                    while(mNumber.find())
                    {
                        hash.hash(mName.group(1).replaceAll(";", ""), mNumber.group(1).replaceAll(";", ""));
                        
                    }
                }
              }
 
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException ie)
        {
            System.out.println("somthin else");
        }
    }
          /*
     Function: main
     Author: jonatan Ogden
     Description: starts the program
     Inputs: N/a
     Outputs:  N/a
     */
  public static void main(String[] args) {
        Data7 d7 = new Data7();
        
    }


}
  

  
