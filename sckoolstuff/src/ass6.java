
/**
 *
 * @author Jonathan Ogden
 *  CSIS 113B
 * 0211330
 * Assignment 6
 * A calculator that produces multiple values for the same number 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ass6 extends JApplet implements ActionListener {
    
    JTextField tfNum = new JTextField(10);
    JTextField tfAval = new JTextField(10);
    JTextField tfCub = new JTextField(10);
    JTextField tfSquare = new JTextField(10);
    JTextField tfExpo = new JTextField(10);
    JTextField tfLog = new JTextField(10);
    JTextField tfLog10 = new JTextField(10);
    JTextField tfBin = new JTextField(10);
    JTextField tfHex = new JTextField(10);
    
    JButton btnCalc = new JButton("Calculate");
    
    Container content = getContentPane();
    
    public void init(){
         
        content.setLayout(new GridLayout(10,2,10,5));
        content.add(new JLabel("Enter a Number",JLabel.RIGHT));
        content.add(tfNum);
        content.add(new JLabel("Absolute Value",JLabel.RIGHT));
        content.add(tfAval);
        tfAval.setEnabled(false);
        content.add(new JLabel("Cube Root",JLabel.RIGHT));
        content.add(tfCub);
        tfCub.setEnabled(false);
        content.add(new JLabel("Square Root", JLabel.RIGHT));
        content.add(tfSquare);
        tfSquare.setEnabled(false);
        content.add(new JLabel("Exponent",JLabel.RIGHT));
        content.add(tfExpo);
        tfExpo.setEnabled(false);
        content.add(new JLabel("Log",JLabel.RIGHT));
        content.add(tfLog);
        tfLog.setEnabled(false);
        content.add(new JLabel("Log 10",JLabel.RIGHT));
        content.add(tfLog10);
        tfLog10.setEnabled(false);
        content.add(new JLabel("Binary",JLabel.RIGHT));
        content.add(tfBin);
        tfBin.setEnabled(false);
        content.add(new JLabel("Hex",JLabel.RIGHT));
        content.add(tfHex);
        tfHex.setEnabled(false);
        
        content.add(btnCalc);
        btnCalc.addActionListener(this);
       
        
}

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        double num = Double.parseDouble(tfNum.getText());
        tfAval.setText(" " + Math.abs(num)); 
        tfCub.setText(" " + Math.cbrt(num));
        tfSquare.setText(" " + Math.sqrt(num));
        tfExpo.setText(" " + Math.exp(num));
        tfLog.setText(" " + Math.log(num));
        tfLog10.setText(" " + Math.log10(num));
        
        
        int rnum =(int) Math.round(num);
        String binStr = Integer.toBinaryString(rnum); 
        tfBin.setText(binStr);
                
        String hexStr = Integer.toHexString((int)rnum);
        tfHex.setText(hexStr);
                
        
        
        
    }
    
    
}
