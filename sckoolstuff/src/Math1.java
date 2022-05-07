/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan Ogden
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Math1 extends JApplet implements ActionListener {
    
    JPanel pnlTA = new JPanel();
    JTextField tfnum1 = new JTextField(10);
    JTextField tfnum2 = new JTextField(10);
    JTextField tfnum3 = new JTextField(10);
    
    JLabel lblSuqare = new JLabel();
    JLabel lblCube= new JLabel();
    JLabel lblSum = new JLabel();
    
    JButton btnCalc = new JButton("Calculate");
    
    Container content = getContentPane();
    
    
    
    public void init(){
        
        pnlTA.setLayout(new GridLayout(2,3));
       
        pnlTA.add(new JLabel("num1:",JLabel.RIGHT));
         pnlTA.add(tfnum1);
         pnlTA.add(new JLabel("num2:",JLabel.RIGHT)); 
         pnlTA.add(tfnum2);
          pnlTA.add(new JLabel("num3:",JLabel.RIGHT));
         pnlTA.add(tfnum3);
        
          pnlTA.add(new JLabel("squared:",JLabel.RIGHT));
         pnlTA.add(lblSuqare);
          pnlTA.add(new JLabel("cubed:",JLabel.RIGHT));
         pnlTA.add(lblCube);
          pnlTA.add(new JLabel("sum:",JLabel.RIGHT));
         pnlTA.add(lblSum);
       
         content.add(pnlTA,BorderLayout.CENTER);
         content.add(btnCalc,BorderLayout.SOUTH);
         btnCalc.addActionListener(this);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        double num1 = Double.parseDouble(tfnum1.getText());
        double num2 = Double.parseDouble(tfnum2.getText());
        double num3 = Double.parseDouble(tfnum3.getText());
        
        double sum = num1 + num2 + num3;
        double cube = Math.pow(sum, 3.0);
        double square = Math.pow(sum,2.0);
        
        
        lblSuqare.setText("" + square);
        lblCube.setText("" + cube);
        lblSum.setText("" + sum);
        
        
        
    }
    
}
