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



public class Counstare extends JApplet implements ActionListener{
  
    JTextField tfPennies = new JTextField(10);
    JTextField tfNickels = new JTextField(0);
    JTextField tfDimes = new JTextField(10);
    JTextField tfQuarters = new JTextField(10);
    JLabel lblDollars = new JLabel();
    JButton btnCal = new JButton("Calculate");
    
    Container content = getContentPane();
    
    
    public void init (){
        content.setLayout(new GridLayout(5,2));
        content.add(new JLabel("Pennies:"));
        content.add(tfPennies);
        content.add(new JLabel("Nickels:"));
        content.add(tfNickels);
        content.add(new JLabel("Dimes:"));
        content.add(tfDimes);
        content.add(new JLabel("Quarters:"));
        content.add(tfQuarters);
        content.add(btnCal);
        content.add(lblDollars);
        btnCal.addActionListener(this);
        
    
}
@Override
public void actionPerformed(ActionEvent e){
     double pen = Double.parseDouble(tfPennies.getText());
     double nic = Double.parseDouble(tfNickels.getText()) * 5;
     double dim = Double.parseDouble(tfDimes.getText()) * 10;
     double qur = Double.parseDouble(tfQuarters.getText()) * 25;
     
     double totpen = pen + nic + dim + qur;
     double totdoll = totpen / 100;
     
     
     lblDollars.setText("$" + totdoll);
     
     
     
}
}