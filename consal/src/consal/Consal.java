
import java.util.Scanner; 

public class consal {
  
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("enter your name ");
        String name = in.nextLine();
        System.out.println("give me numbers ");
        int val = in.nextInt();
        consal c = new consal;
        int sq = c.squar(val);        
        System.out.println("thanks " + name + "your number sqared is " +  sq );
        
    }
    public int squar(int x)
    {
        return x * x;
    }
    
}
