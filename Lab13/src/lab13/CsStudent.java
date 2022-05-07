
package lab13;

/*
 * @author Jonathan Ogden 
 *CSIC 113B
 * 0211330
 * assignment 16
 * implementing abstract classes and checing time on computers
 */



public class CsStudent extends Student {
    static int MATH_HOURS = 20;
    static int CS_HOURS = 4;
    static int GEN_ED_HOURS = 60;

    private int mathHours, csHours, genEdHours;
    
    public CsStudent(String name, String idNumber, int yearAdmitted)
    {
        super(name, idNumber, yearAdmitted);
        mathHours = 0;
        csHours = 0; 
        genEdHours = 0;
        
    }
    
    public CsStudent()
    {
        this(" "," ",0);
    }
   public void setCsHours(int houers)
   {
       csHours = houers;
   }
   public void setGenEdHours(int houers)
   {
    genEdHours = houers;
   }
   public void setMathHours(int houers)
   {
      mathHours = houers;
   }
    
    @Override
    public int computeRemainingHours()
    {
     int sumstatic = MATH_HOURS + CS_HOURS + GEN_ED_HOURS; 
     int sum = mathHours + csHours + genEdHours;
     return  sumstatic - sum;
    }
    
    
    
}
