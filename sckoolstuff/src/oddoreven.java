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

public class oddoreven extends JApplet implements ActionListener{
    
    JTextField tfnume = new JTextField(10);
    JLabel tfEO = new JLabel();
    Container content = getContentPane();
    
    public void init(){
        
        content.setLayout(new FlowLayout());
        content.add(tfnume);
        content.add(tfEO);
        tfnume.addActionListener(this);
    
}

    @Override
    public void actionPerformed(ActionEvent ae) {
       int nume = Integer.parseInt(tfnume.getText());
       
       
       
       if(nume % 2 == 0){
           tfEO.setText("your number is even");
       }else{
           tfEO.setText("your number is odd");
       }
    }
    
}
