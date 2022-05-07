/*
 * @author Jonathan Ogden 
 * CSIC 123B
 * 0211330
 * assignment 7
 * Hadals toLong exceptions
 */

package lab7;


public class IntMetricsException
{
    
    public IntMetricsException(int numbs, int length ) throws ToLongException
    {
         int numlength = 0;
         int lenlength = 0;
          
             for(int i = 0;i < Integer.toString(numbs).length(); i++)
            {
                numlength++;
            }
            for(int i = 0;i < Integer.toString(length).length(); i++)
      
                {
                lenlength++;
            }
          if(numlength > lenlength) {
            throw new ToLongException("number is to long");
        }
     } 
    //overloded constructers
     public IntMetricsException(int numbs) throws ToLongException
     {
         this(numbs,IntMetrics.getLength());
     }
      public IntMetricsException() throws ToLongException
     {
         this(IntMetrics.getnumb(),IntMetrics.getLength());
     }
      
     public class ToLongException extends Throwable
    {
     private String Msg;
     //exeption class
     public ToLongException (String message)
     {
         this.Msg = message;
     }
      public String getErrorMessage()
              {
                  return this.Msg;
              }
    }
}
