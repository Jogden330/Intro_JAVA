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
import java.awt.*;
import java.util.Random;

public class guessGame extends JApplet implements ActionListener{

    JTextField tfNumTimes = new JTextField(10);
    JTextField tfGuess = new JTextField(10);
    JButton btn = new JButton("click me");
    JLabel lblOutPut = new JLabel();
    Container content = getContentPane();
   
     public void init()
     {
        content.setLayout(new GridLayout(3,0));
        content.add(new JLabel("Number to search: "));
        content.add(tfGuess);
        content.add(new JLabel("Times to Fined: "));
        content.add(tfNumTimes);
        content.add(btn);
        content.add(lblOutPut);
        btn.addActionListener(this);
        
     }
    @Override
    public void actionPerformed(ActionEvent ae) {
       int guess = Integer.parseInt(tfGuess.getText());
       int numtimes = Integer.parseInt(tfNumTimes.getText());
       
       Random r = new Random();
       int count = 1;
       while(r.nextInt(11) != guess)
       {
           count++;
       }
       if(count == numtimes)
       {
           lblOutPut.setText("You guessed it right");
       }else{
           lblOutPut.setText("it took "+count+" times to get it right");
       }
    }
}
