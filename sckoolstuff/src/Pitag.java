/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * * @author The Meat Man
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pitag extends JApplet implements ActionListener{
    Container content = this.getContentPane();
    
    JTextField tfa = new JTextField(10);
    JTextField tfb = new JTextField(10);
    JLabel lblc = new JLabel();
    JButton btnCalc = new JButton("Calculate");
    
    public void init(){
    
         content.setLayout(new FlowLayout());
    
    content.add(new JLabel("A:"));
    content.add(tfa);
    content.add(new JLabel("B:"));
    content.add(tfb);
    content.add(new JLabel("="));
    content.add(lblc);
    content.add(btnCalc);
    btnCalc.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
       double a = Double.parseDouble(tfa.getText());
       double b = Double.parseDouble(tfb.getText());
       
       a = Math.pow(a,2.0);
       b = Math.pow(b,2.0);
       double sqSum= a + b;
       double sqrt = Math.sqrt(sqSum);
       lblc.setText(" " + sqrt);
       
        
        
    }
    
}
