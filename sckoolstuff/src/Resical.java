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
import java.text.NumberFormat;

public class Resical extends JApplet implements ActionListener {
    JPanel pnlTA = new JPanel();
    JTextField tfcan = new JTextField(10);
    JTextField tfbot = new JTextField(10);
    
    JLabel lblSum = new JLabel();
    
    JButton btnCalc = new JButton("Calculate");
    
    Container content = getContentPane();
    
     public void init(){
        
        pnlTA.setLayout(new GridLayout(3,2));
        pnlTA.add(new JLabel("How Meany Cans:"));
       
        pnlTA.add(tfcan);
        pnlTA.add(new JLabel("How Meany Bottles:"));
        pnlTA.add(tfbot);
        
        pnlTA.add(lblSum);
      
         content.add(pnlTA,BorderLayout.CENTER);
         content.add(btnCalc,BorderLayout.SOUTH);
         btnCalc.addActionListener(this);
        
     
        
     }   
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        double can = Double.parseDouble(tfcan.getText());
        double bot = Double.parseDouble(tfbot.getText());
        
        can = can * 0.35;
        bot = bot * 0.7;
        
        double sum = can + bot;
        
         NumberFormat fmt = NumberFormat.getCurrencyInstance();
         lblSum.setText(fmt.format(sum));
        
        
                
    }
    
}
