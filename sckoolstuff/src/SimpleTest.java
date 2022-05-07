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
import java.text.*;

public class SimpleTest extends JApplet implements ActionListener,MouseMotionListener{
    
    Container content = getContentPane();
    JTextField tfNum1 = new JTextField(10);
    JTextField tfNum2 = new JTextField(10);
    JLabel lbloutput = new JLabel();
    JLabel lbldiff = new JLabel();
    JLabel lblprod = new JLabel();
    JButton btn = new JButton("Click me");
    Color numColor = new Color(99,0,0);
    Color anathernumColor = new Color(0,99,9);
    public void init(){
        
        content.setLayout(new FlowLayout());
        content.add(tfNum1);
        content.add(new JLabel("+"));
        content.add(tfNum2);
        tfNum2.addActionListener(this);
        content.add(new JLabel("="));
        
        content.add(lbloutput);
        
        content.add(new JLabel("the diffrents ="));
        content.add(lbldiff);
        content.add(new JLabel("the product is="));
        content.add(lblprod);
        content.add(btn);
        btn.addActionListener(this);
        content.addMouseMotionListener(this);
       
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
     String myText = tfNum1.getText();
     String myText2 = tfNum2.getText();
     double num1 = Double.parseDouble(myText);
     double num2 = Double.parseDouble(myText2);
     double sum = num1 + num2;
     double diff = num1 - num2;
     double prod = num1 * num2;
     NumberFormat fmt = NumberFormat.getCurrencyInstance();
     lbloutput.setText(fmt.format(sum));
     lbldiff.setText(fmt.format(diff));
     lblprod.setText(fmt.format(prod));
 
    
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        lbloutput.setForeground(numColor);
        lbldiff.setForeground(numColor);
        lblprod.setForeground(numColor);
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        lbloutput.setForeground(anathernumColor);
        lbldiff.setForeground(anathernumColor);
        lblprod.setForeground(anathernumColor);
    }
}
