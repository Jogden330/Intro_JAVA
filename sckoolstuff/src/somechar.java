/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author The Meat Man
 */
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class somechar extends JApplet implements ActionListener{
    
    JTextField tfInput = new JTextField(20);
    JLabel lbloutput = new JLabel();
    JButton btn =  new JButton("click me");
    
     Container content = this.getContentPane();
    
    public void init()
    {
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Input a String"));
        content.add(tfInput);
        content.add(lbloutput);
        content.add(btn);
        btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      String s = tfInput.getText();
      lbloutput.setText("the sume of the string is " + sumchar(s));
    }
    int sumchar(String s)
    {
         int sum = 0;
         String revers = "";
         
        for(int i = 0; i < s.length(); i++)
      {
          sum += s.charAt(i);
          revers += s.charAt(i);
      } 
        System.out.println(revers);
        return sum;
    }
}
