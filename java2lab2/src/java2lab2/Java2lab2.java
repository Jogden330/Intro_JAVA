/*
 * @author Jonathan Ogden
 * CSIC 113B
 * 0211330
 * assignment 1
 * printing out numbers to a GUI and colors
 */
package java2lab2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author The Meat Man
 */
public class Java2lab2 extends JFrame 
{
    JFrame Myframe = new JFrame("GUI app");
    JTextField tfnums = new JTextField(10);
    JLabel lblsum = new JLabel();
    JLabel lblrev = new JLabel();
    JLabel[] lbla = new JLabel[3];
    JButton btn = new JButton("Comput");
    
    JLabel lblSnum = new JLabel("Enter A Number:");
    JLabel lblSsum = new JLabel("sum:");
    JLabel lblSrev = new JLabel("Reverse:");
    JLabel lblSa = new JLabel("Array:");
    JLabel lblStc = new JLabel("Text Coller:");
    
    SpringLayout layout = new SpringLayout();
    
    ButtonGroup grbColors = new ButtonGroup();
    JRadioButton btnRed = new JRadioButton("red", true);
    JRadioButton btnBlue = new JRadioButton("Blue");
    JRadioButton btnGreen = new JRadioButton("Green");
    
    Color ctext = Color.RED;
   
    Container content = Myframe.getContentPane();
 
    
    public static void main(String[] args) 
    {
       Java2lab2 JL2 = new Java2lab2(); 
 
     
       
   
    }
    
    public Java2lab2()
    {
      
        Myframe.setVisible(true);
        Myframe.setSize(new Dimension(400, 300));
        Myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       content.setLayout(layout);
       content.add(lblSnum);
       layout.putConstraint(SpringLayout.WEST, lblSnum, 15 ,SpringLayout.WEST, content);
       layout.putConstraint(SpringLayout.NORTH, lblSnum, 30 ,SpringLayout.NORTH, content);
       
       content.add(tfnums);
       layout.putConstraint(SpringLayout.WEST, tfnums, 165 ,SpringLayout.WEST, lblSnum);
       layout.putConstraint(SpringLayout.NORTH, tfnums, 30 ,SpringLayout.NORTH, content);
      
       content.add(lblSsum);
       layout.putConstraint(SpringLayout.WEST, lblSsum, 15 ,SpringLayout.WEST, content);
       layout.putConstraint(SpringLayout.NORTH, lblSsum, 30 ,SpringLayout.NORTH, lblSnum);
       
       content.add(lblsum);
       layout.putConstraint(SpringLayout.WEST, lblsum, 165 ,SpringLayout.WEST, lblSsum);
       layout.putConstraint(SpringLayout.NORTH, lblsum, 30 ,SpringLayout.NORTH, lblSnum);
       
       content.add(lblSrev);
       layout.putConstraint(SpringLayout.WEST, lblSrev, 15 ,SpringLayout.WEST, content);
       layout.putConstraint(SpringLayout.NORTH, lblSrev, 30 ,SpringLayout.NORTH, lblSsum);
       
       content.add(lblrev);
       layout.putConstraint(SpringLayout.WEST, lblrev, 165 ,SpringLayout.WEST, lblSrev);
       layout.putConstraint(SpringLayout.NORTH, lblrev, 30 ,SpringLayout.NORTH, lblSsum);
       
       content.add(lblSa);
       layout.putConstraint(SpringLayout.WEST, lblSa, 15 ,SpringLayout.WEST, content);
       layout.putConstraint(SpringLayout.NORTH, lblSa, 30 ,SpringLayout.NORTH, lblSrev);
       
       lbla[0] = new JLabel();
       content.add(lbla[0]);
       layout.putConstraint(SpringLayout.WEST, lbla[0], 85 ,SpringLayout.WEST, lblSa);
       layout.putConstraint(SpringLayout.NORTH, lbla[0], 30 ,SpringLayout.NORTH, lblSrev);
       
       lbla[1] = new JLabel();
       content.add(lbla[1]);
       layout.putConstraint(SpringLayout.WEST, lbla[1], 85 ,SpringLayout.WEST, lbla[0]);
       layout.putConstraint(SpringLayout.NORTH, lbla[1], 30 ,SpringLayout.NORTH, lblSrev);
       
       lbla[2] = new JLabel();
       content.add(lbla[2]);
       layout.putConstraint(SpringLayout.WEST, lbla[2], 85 ,SpringLayout.WEST, lbla[1]);
       layout.putConstraint(SpringLayout.NORTH, lbla[2], 30 ,SpringLayout.NORTH, lblSrev);
       
           grbColors.add(btnRed);
           grbColors.add(btnBlue);
           grbColors.add(btnGreen);
        
       content.add(lblStc);
       layout.putConstraint(SpringLayout.WEST, lblStc, 15 ,SpringLayout.WEST, content);
       layout.putConstraint(SpringLayout.NORTH, lblStc, 30 ,SpringLayout.NORTH, lblSa);
        
       content.add(btnRed);
       layout.putConstraint(SpringLayout.WEST, btnRed, 85 ,SpringLayout.WEST, lblStc);
       layout.putConstraint(SpringLayout.NORTH, btnRed, 30 ,SpringLayout.NORTH, lblSa);
       
       content.add(btnBlue);
       layout.putConstraint(SpringLayout.WEST, btnBlue, 85 ,SpringLayout.WEST, btnRed);
       layout.putConstraint(SpringLayout.NORTH, btnBlue, 30 ,SpringLayout.NORTH, lblSa);
       
       content.add(btnGreen);
       layout.putConstraint(SpringLayout.WEST, btnGreen, 85 ,SpringLayout.WEST, btnBlue);
       layout.putConstraint(SpringLayout.NORTH, btnGreen, 30 ,SpringLayout.NORTH, lblSa);
       
       content.add(btn);
       layout.putConstraint(SpringLayout.WEST, btn, 150 ,SpringLayout.WEST, content);
       layout.putConstraint(SpringLayout.NORTH, btn, 50 ,SpringLayout.NORTH, lblStc);
  
        btnRed.addActionListener(new ColorClassRed());
        btnBlue.addActionListener(new ColorClassBlue());
        btnGreen.addActionListener(new ColorClassGreen());
        btn.addActionListener(new BTNClass());
        setColor();
       
    }

  
                  
    public void setColor()
    {
     
                   lblsum.setForeground(ctext);
                   lblrev.setForeground(ctext);
                   
                   for(int x = 0; x < lbla.length ; x++)
                   {
                   lbla[x].setForeground(ctext);
                   }   
    }
            
      public int sumNumb(int x)
    {
        int sum = 0;
        
        
        for(int y = 0;y < Integer.toString(x).length(); y++)
        {
            String strnumb = Integer.toString(x);
            sum += Character.getNumericValue(strnumb.charAt(y));  
        }
        return sum;
    }
   public String reverseNums(int x)
    {
        String revnume = "";
        
        for(int y = Integer.toString(x).length()-1;y >= 0;y--)
        {
            revnume += (Integer.toString(x).charAt(y));
        }
        return revnume;
    }
   public int[] getArray(int x)
    {
        int numarra[] = new int[Integer.toString(x).length()];
        
        for(int y = 0;y < Integer.toString(x).length(); y++)
        {
            String strnumb = Integer.toString(x);
            numarra[y] = Character.getNumericValue(strnumb.charAt(y));
        }
        return numarra;
    }
       
    
   private class ColorClassRed implements ActionListener
    {
      
        public void actionPerformed(ActionEvent ae) 
        {         
                       ctext = Color.RED;
                       setColor(); 
        }
   
    }


       

    

   private class ColorClassBlue implements ActionListener
    {
      
        public void actionPerformed(ActionEvent ae) 
        {         
                       ctext = Color.BLUE;
                       setColor();
        }
   
    }
      private class ColorClassGreen implements ActionListener
    {
      
        public void actionPerformed(ActionEvent ae) 
        {         
                       ctext = Color.GREEN;
                       setColor();
        }
   
    }
      private class BTNClass implements ActionListener
      {

        @Override
        public void actionPerformed(ActionEvent ae)
                
        {
           int numbs = Integer.parseInt(tfnums.getText());
           
            lblsum.setText("" + sumNumb(numbs));
            lblrev.setText(reverseNums(numbs));
            int  numbarray[] = getArray(numbs);
        
            for(int y = 0; y < 3;y++)
            {
                  lbla[y].setText("" + numbarray[y]);
            }
        
          
        }
          
      }
}
