/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author The Meat Man
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class sunnunbers extends JApplet implements ActionListener{
    
    JTextField tfnum1 = new JTextField(5);
    JTextField tfnum2 = new JTextField(5);
    JLabel Output = new JLabel();
    
    Container content = getContentPane();
    int num1, num2, sum = 0;
    
    public void init()
    {
       content.setLayout(new FlowLayout());
       content.add(tfnum1);
       content.add(tfnum2);
       content.add(Output);
      
       tfnum2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         sumGetter(); 
    }
    public void sumGetter()
    {
         sum = 0;
         int num1 = Integer.parseInt(tfnum1.getText());
         int num2 = Integer.parseInt(tfnum2.getText());
         
         if(num2 < num1)
         {
             int temp = num1;
             num1 = num2;
             num2 = temp;
         }
         
        for(int x = num1; x  <= num2; x++ )
        {
            sum += x;
        }
        Output.setText("" + sum);
    }
}
