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

public class assending extends JApplet implements ActionListener {

    JTextField tfnum1 = new JTextField(10);
    JTextField tfnum2 = new JTextField(10);
    JTextField tfnum3 = new JTextField(10);
    JLabel lbloutput = new JLabel();
    JButton btn = new JButton("click me");
    
    Container content = this.getContentPane();
    
    
    public void init()
    {
        content.setLayout(new FlowLayout());
        content.add(tfnum1);
        content.add(tfnum2);
        content.add(tfnum3);
        content.add(btn);
        content.add(lbloutput);
        btn.addActionListener(this);
    }
        
    
   
    @Override
    public void actionPerformed(ActionEvent ae)
    {
             int num1 = Integer.parseInt(tfnum1.getText());

    
        int num2 = Integer.parseInt(tfnum2.getText());
         int num3 = Integer.parseInt(tfnum3.getText());
         if(this.isAcending(num1, num2, num3))
         {
             lbloutput.setText("number are ascending");
             
         }
         else
         {
             lbloutput.setText("numbers are not ascending");
         }
    }

    
   
        public boolean isAcending(int n1,int n2, int n3)
    {
        return n1 < n2 && n2 < n3 ? true : false;
    }
      /*  if(n1 < n2 && n2 < n3)
                {
                    return true;
                }
           else
                {
                    return false;
                }
      }*/ 

}
