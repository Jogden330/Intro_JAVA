/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lab13;

/*
 * @author Jonathan Ogden 
 *CSIC 113B
 * 0211330
 * assignment 16
 * an abstract class to program students into s dsts base
 */

public abstract class Student {

    protected String name;
    protected String idNumber;
    protected int yearAdmitted;
    
    public Student(String name, String idNumber, int yearAdmitted)
    {
        this.name = name;
        this.idNumber = idNumber;
        this.yearAdmitted = yearAdmitted;
        
    }
     public Student()
     {
         this(" "," ", 0);
     }
     
     public abstract int  computeRemainingHours();
     
     public String getName()
     {
         return name;
     }
     
     public String getIdNum()
     {
         return idNumber;
     }
     public int getYearAdmitted()
     {
         return yearAdmitted;
     }
     public int getRemainingHours()
     {
         return computeRemainingHours();
     }
}
