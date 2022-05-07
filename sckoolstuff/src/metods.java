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

public class metods extends JApplet implements ActionListener{
    
    
    Container content = getContentPane();
    JLabel lblout = new JLabel("hellow");
    JTextField tfnum = new JTextField(10);
    JButton btn = new JButton("Click me");
    
    public void init(){
        
        content.setLayout(new FlowLayout());
        content.add(lblout);
        content.add(tfnum);
        content.add(btn);
        btn.addActionListener(this);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
      
       int val = Integer.parseInt(tfnum.getText());
       int sq = this.sqa(val);
       lblout.setText("this squared is " + sq);
       
       
    }
    
    
    private void sayGoodBye(){
        lblout.setText("Good Bye");
    }
    private int sqa(int x){
        return x * x;
    }
    private void setMess(String msg)
    {
        lblout.setText(msg);
    }    
}
