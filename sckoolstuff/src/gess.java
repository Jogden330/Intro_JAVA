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
import javax.swing.border.*;
import java.text.*;
import java.util.*;

public class gess  extends JApplet implements ActionListener{
    
   JTextField tfGuess = new JTextField(10);

 
   JLabel lblBank = new JLabel("");
   JButton btnPlay = new JButton("Pay");
   JLabel lblStatus = new JLabel("");
   
   double bank = 10.0;
   
   Container content = this.getContentPane();
    
    
    public void init(){
        content.setLayout(new GridLayout(3,2));
        content.add(new JLabel("Guess: "));
        content.add(tfGuess);
        Border blackBorder = BorderFactory.createLineBorder(Color.black, 1);
        
        lblBank.setBorder(blackBorder);
        lblBank.setOpaque(true);
        content.add(new JLabel("Bank: "));
        
        content.add(lblBank);
        content.add(btnPlay);
        content.add(lblStatus);
        btnPlay.addActionListener(this);
        
        
    }
    
    public void outputBank(){
        
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        lblBank.setText(fmt.format(bank));
        
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
       
        Random r = new Random();
        int dice = r.nextInt(6) + 1;
        int guess = Integer.parseInt(tfGuess.getText());
        if (bank <= 0.0){
            lblStatus.setText("your out of munny");
            return;
        }
        if (guess == dice){
            bank += 2.0;
            lblStatus.setText("Winnern Winner rolled a " + dice);
            
        }else{
            bank -= 1;
            lblStatus.setText("you Suck rolled a" + dice);
            
        }
         outputBank(); 
         tfGuess.requestFocus();
         tfGuess.selectAll();
        
    }
    
    
    
}
