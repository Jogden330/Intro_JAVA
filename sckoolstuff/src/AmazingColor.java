

/**
 *
 * @author Jonathan Ogden
 * CSIS 113B
 * 0211330
 * Assignment 12
 * some cool color stuff
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AmazingColor extends JApplet implements Runnable, ActionListener {
    
    JTextField tfRed = new JTextField(10);
    JTextField tfGreen = new JTextField(10);
    JTextField tfBlue = new JTextField(10);
    JTextField tfIter = new JTextField(10);
    JTextField tfStep = new JTextField(10);
    JTextField tfDel = new JTextField(10);
    JCheckBox cbRed = new JCheckBox("Red");
    JCheckBox cbGreen = new JCheckBox("Green");
    JCheckBox cbBlue = new JCheckBox("Blue");
    JButton btn = new JButton("Start");
    JLabel lblColor = new JLabel();
    
    Thread theThread = null;
    
    Container content = this.getContentPane();
    
    public void init()
    {
        setLayout(new BorderLayout()); 
        JPanel grid1 = new JPanel();
        grid1.setLayout(new GridLayout(4,3,5,5));
        grid1.add(new JLabel("Red"));
        grid1.add(new JLabel("Green"));
        grid1.add(new JLabel("Blue"));
        grid1.add(tfRed);
        tfRed.setText("40");
        grid1.add(tfGreen);
        tfGreen.setText("50");
        grid1.add(tfBlue);
        tfBlue.setText("60");
        grid1.add(new JLabel("Iterations"));
        grid1.add(new JLabel("Step Amount"));
        grid1.add(new JLabel("Delay"));
        grid1.add(tfIter);
        tfIter.setText("10");
        grid1.add(tfStep);
        tfStep.setText("20");
        grid1.add(tfDel);
        tfDel.setText("1000");
        add(grid1,BorderLayout.CENTER);
        JPanel grid2 = new JPanel();
        grid2.setLayout(new GridLayout(2,4,2,2));
        grid2.add(cbRed);
        cbRed.setSelected(true);
        grid2.add(cbGreen);
        cbGreen.setSelected(true);
        grid2.add(cbBlue);
        cbBlue.setSelected(true);
        grid2.add(btn);
        grid2.add(lblColor);
        add(grid2,BorderLayout.SOUTH);
        
        btn.addActionListener(this);
        
        
        
        
    }

    @Override
    public void run() {
       //System.out.println("im in run");
       int red = Integer.parseInt(tfRed.getText());
       int blue = Integer.parseInt(tfBlue.getText());
       int green = Integer.parseInt(tfGreen.getText());
       int iter = Integer.parseInt(tfIter.getText());
       int step = Integer.parseInt(tfStep.getText());
       int del = Integer.parseInt(tfDel.getText());
       
       for(int i = 0;i < iter; i++)
       {
           //System.out.println("im in the loop");
           if(cbRed.isSelected() == true)
           {
               red += step;
               if(red > 255)
                       {
                           red = 0;
                       }
           }
           if(cbBlue.isSelected() == true)
           {
               blue += step;
               if(blue > 255)
               {
                   blue = 0;
               }
           }
           if(cbGreen.isSelected() == true)
           {
               green += step;
               if(green > 255)
               {
                   green = 0;
               }
           }
               try
               {
                   Thread.sleep(del);
               }
                    catch(InterruptedException ex){}
               
               lblColor.setText(""+red+" "+green+" "+blue);
               lblColor.setOpaque(true);
               lblColor.setBackground(new Color(red,green,blue));
               
         }
       btn.setText("Start");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //System.out.println("i made it here");
        if(theThread == null)
        {
            theThread = new Thread(this);
            theThread.start();
            btn.setText("Stop");
        }else{
            theThread.stop();
            theThread = null;
            btn.setText("Start");
        }
    }
    
}
