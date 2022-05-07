/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonathan
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
        
public class RamdomArrey extends JApplet implements ActionListener{
    
    
    int[] ar = new int[10];
    JTextField tfIndex = new JTextField(7);
    JTextField tfGuess = new JTextField(7);
    JLabel lblStatus = new JLabel();
    Container content = getContentPane();
    JButton btn = new JButton("play");
    
    public void init()
    {
      content.setLayout(new FlowLayout());
      content.add(new JLabel("Enter Index"));
      content.add(tfIndex);
      content.add(new JLabel("Enter Guess"));
      content.add(tfGuess);
      content.add(btn);
      content.add(lblStatus);
      fillArray();
      shuffle();
      btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int index = Integer.parseInt(tfIndex.getText());
        int guess = Integer.parseInt(tfGuess.getText());
        
        int value = ar[index];
        if(value == guess)
        {
          lblStatus.setText("Right");
        }else{
          lblStatus.setText("Wrong");   
        }
    }
    public void fillArray()
    {
        Random r = new Random();
       for(int i = 0; i < ar.length; i++)
       {
           ar[i] = r.nextInt(10) + 1;
       }
    }
    public void shuffle()
    {
        Random r = new Random();
        for(int i = 0; i < 1000; i++)
        {
            int idx1 = r.nextInt(10);
            int idx2 = r.nextInt(10);
            int temp = ar[idx1];
            ar[idx1] = ar[idx2];
            ar[idx2] = temp;
            
        }
    }
}
