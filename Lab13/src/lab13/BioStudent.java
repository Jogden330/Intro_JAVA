package lab13;

/*
 * @author Jonathan Ogden 
 *CSIC 113B
 * 0211330
 * assignment 16
 * implementing abstract classes and checing time on computers
 */

public class BioStudent extends Student {
    static int MATH_HOURS = 20;
    static int Bio_HOURS = 4;
    static int GEN_ED_HOURS = 60;

    private int mathHours, BioHours, genEdHours;
    
    public BioStudent(String name, String idNumber, int yearAdmitted)
    {
        super(name, idNumber, yearAdmitted);
        mathHours = 0;
        BioHours = 0; 
        genEdHours = 0;
        
    }
    
    public BioStudent()
    {
        this(" "," ",0);
    }
   public void setBioHours(int houers)
   {
       BioHours = houers;
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
     int sumstatic = MATH_HOURS + Bio_HOURS + GEN_ED_HOURS; 
     int sum = mathHours + BioHours + genEdHours;
     return  sumstatic - sum;
    }
    
    
    
}
