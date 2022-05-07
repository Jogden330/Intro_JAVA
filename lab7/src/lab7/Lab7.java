/*
 * @author Jonathan Ogden 
 * CSIC 123B
 * 0211330
 * assignment 7
 * test GUI 
 */
package lab7;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



public class Lab7 extends JFrame
{ 

    JFrame Myframe = new JFrame("GUI app");
    JTextField tfnums = new JTextField(10);
    JLabel lblsum = new JLabel();
    JLabel lblrev = new JLabel();
    JLabel[] lbla = new JLabel[3];
    JButton btn = new JButton("Comput");
    TextArea taoutput = new TextArea();
   
    JScrollPane scrollArea = new JScrollPane(taoutput);
    
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
    
    public Lab7(String tital,int width,int hight )
    {
       //set frame 
       Myframe.setSize(width, hight);                 
       Myframe.setVisible(true);       
       Myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
       Myframe.setTitle(tital);
       
       
       //add componits to frame
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
       
       //sets up text area
       taoutput.setColumns(20);
       taoutput.setRows(5);
       content.add(scrollArea);
       layout.putConstraint(SpringLayout.WEST, scrollArea, 85 ,SpringLayout.WEST, lblSa);
       layout.putConstraint(SpringLayout.NORTH, scrollArea, 30 ,SpringLayout.NORTH, lblSrev);
       
      
        
           grbColors.add(btnRed);
           grbColors.add(btnBlue);
           grbColors.add(btnGreen);
        
       content.add(lblStc);
       layout.putConstraint(SpringLayout.WEST, lblStc, 15 ,SpringLayout.WEST, content);
       layout.putConstraint(SpringLayout.NORTH, lblStc, 130 ,SpringLayout.NORTH, lblSa);
        
       content.add(btnRed);
       layout.putConstraint(SpringLayout.WEST, btnRed, 85 ,SpringLayout.WEST, lblStc);
       layout.putConstraint(SpringLayout.NORTH, btnRed, 130,SpringLayout.NORTH, lblSa);
       
       content.add(btnBlue);
       layout.putConstraint(SpringLayout.WEST, btnBlue, 85,SpringLayout.WEST, btnRed);
       layout.putConstraint(SpringLayout.NORTH, btnBlue, 130 ,SpringLayout.NORTH, lblSa);
       
       content.add(btnGreen);
       layout.putConstraint(SpringLayout.WEST, btnGreen, 85 ,SpringLayout.WEST, btnBlue);
       layout.putConstraint(SpringLayout.NORTH, btnGreen, 130 ,SpringLayout.NORTH, lblSa);
       
       content.add(btn);
       layout.putConstraint(SpringLayout.WEST, btn, 150 ,SpringLayout.WEST, content);
       layout.putConstraint(SpringLayout.NORTH, btn, 50 ,SpringLayout.NORTH, lblStc);
  
       //set buttons
        btnRed.addActionListener(new ColorClassRed());
        btnBlue.addActionListener(new ColorClassBlue());
        btnGreen.addActionListener(new ColorClassGreen());
        btn.addActionListener(new BTNClass());
        //set defalt cooler
        setColor();
       
    }
    //over loded constructor
      public Lab7()
   {
       this("Test GUI",400,500);
      
   }
    //button classes  
    private class ColorClassRed implements ActionListener
    {
      
        @Override
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
   
   private class BTNClass  implements ActionListener
      {

        @Override
        public void actionPerformed(ActionEvent ae)
                
        {
         try
         {   
           int numbs = Integer.parseInt(tfnums.getText());
           IntMetrics im = new IntMetrics(numbs);
           //IntMetrics.setNumb(numbs);
           //IntMetrics.setlength(tfnums.getText().length());
         
           IntMetricsException imx = new IntMetricsException(numbs,IntMetrics.getLength());
           lblsum.setText("" + IntMetrics.sumNumb());
           lblrev.setText("" + IntMetrics.reverseNums());
          
           int numarray[] = IntMetrics.getArray();  
         
           for(int i = 0; i < numarray.length ;i++)
           {
                  taoutput.append(" " + numarray[i] + "\n");
           }
         }
         catch(NumberFormatException ne)
         {
             lblsum.setText(ne.getMessage());
         }
         catch(StringIndexOutOfBoundsException np)
         {
             lblsum.setText(np.getMessage());
         }
         catch(IntMetricsException.ToLongException tl)
         {
             lblsum.setText(tl.getMessage());
         }    
               
         
        }
          
      }
      //sets coolr
     public void setColor()
    {
     
            lblsum.setForeground(ctext);
            lblrev.setForeground(ctext);
   
            for(int x = 0; x < lbla.length ; x++)
            {
               taoutput.setForeground(ctext);
            }   
    }
    public static void main(String[] args) {
        Lab7 bl7 = new Lab7();
    }
}
