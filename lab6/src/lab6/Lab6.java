
package lab6;

import Lab6.ArrayMetrics;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import java.util.Random;

public class Lab6 extends JFrame implements ActionListener{
    
   int[] ar = new int[50]; 

   JLabel lblmean = new JLabel(" ");
   JLabel lblmed = new JLabel(" ");
   JLabel lblmin = new JLabel(" ");
   JLabel lblmax = new JLabel(" ");
   JLabel lblsum = new JLabel(" ");
   JButton btn = new JButton("Compute");
   TextArea taoutput = new TextArea();
   
   JScrollPane scrollArea = new JScrollPane(taoutput);
   
   Random rand = new Random();
   
   
   public Lab6(String tital,int width,int hight )
   {
       this.setSize(width, hight);                 
       this.setVisible(true);       
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       this.setTitle(tital);
       
       
       setLayout(new BorderLayout()); 
       
       JPanel P1 = new JPanel();
       P1.add(new JLabel("Mean:"));
       P1.add(lblmean);
       P1.add(new JLabel("Meadian:"));
       P1.add(lblmed);
       P1.add(new JLabel("Min:"));
       P1.add(lblmin);
       P1.add(new JLabel("Max:"));
       P1.add(lblmax);
       P1.add(new JLabel("Sum:"));
       P1.add(lblsum);
       P1.setLayout(new GridLayout(5,2));
       
       JPanel P2 = new JPanel();
       P2.setLayout(new FlowLayout());
       P2.add(btn);
       btn.addActionListener(this);
              
       taoutput.setColumns(10);
       taoutput.setRows(10);
       add(scrollArea,BorderLayout.CENTER);
       add(P1,BorderLayout.EAST);
       add(P2,BorderLayout.SOUTH);
       
   }
   public Lab6()
   {
       this("Test GUI",400,300);
   }
   
    public static void main(String[] args) 
    {
      Lab6 l6 = new Lab6();
    }



    @Override
    public void actionPerformed(ActionEvent ae)
    {
           
              billdArra(ar);
              showArra();
              lblmean.setText("" + ArrayMetrics.mean(ar));
              lblmax.setText("" + ArrayMetrics.max(ar));
              lblmin.setText("" + ArrayMetrics.min(ar));
              lblsum.setText("" + ArrayMetrics.sum(ar));
              lblmed.setText("" + ArrayMetrics.meadiam(ar));
    }
    
    
       
   

    public void billdArra(int[] ar)
    {
        int[] numarra = new int[ar.length];
        
       
        for(int y = 0;y < ar.length; y++)
        {
            
           ar[y] = rand.nextInt(51);
        }
        
    }
   public void showArra()
    {
        for(int i =0; i < ar.length; i++)
        {
             taoutput.append(" " + ar[i] + "\n");
        }
    }
}
