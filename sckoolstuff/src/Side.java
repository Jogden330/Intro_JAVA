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

public class Side extends JApplet implements ActionListener{
    
    Container content = this.getContentPane();
    JTextField tfa = new JTextField(10);
    JLabel lbls = new JLabel();
    JButton btnCalc = new JButton("Calculate");
    
    
    public void init(){
        
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Area:"));
        content.add(tfa);
        content.add(new JLabel("Side:"));
        content.add(lbls);
        content.add(btnCalc);
        btnCalc.addActionListener(this);
        
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        double area = Double.parseDouble(tfa.getText());
        lbls.setText(" " + Math.sqrt(area));
        
    }
    
}
