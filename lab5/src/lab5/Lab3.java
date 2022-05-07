package lab5;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab3 extends JFrame implements 
        AdjustmentListener, ActionListener
{
    Container content = getContentPane();
    
    private  JTextField tf = new JTextField(10);
    private  JLabel lbl = new JLabel("", JLabel.CENTER);
    
    Spinner sp1 = new Spinner();
    Spinner sp2 = new Spinner(1, -5, 5);
    Spinner sp3 = new Spinner(10, 5, 20, this);

    public Lab3()
    {
        content.setLayout(new FlowLayout()); 
        this.setSize(400, 300);                 
        this.setVisible(true);       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setTitle("Test Spinner");
        content.add(lbl, "North");

        JPanel p = new JPanel();
        p.add(sp1);
        p.add(sp2);
        p.add(sp3);
            sp3.setStepValue(2);
        p.add(tf);
        content.add(p, "Center");
        tf.addActionListener(this);       
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        String svalue = tf.getText();
        int value = Integer.parseInt(svalue);
        sp1.setValue(value);
        sp2.setValue(value);
        sp3.setValue(value);
    }

    public void adjustmentValueChanged(AdjustmentEvent ae)
    {
        lbl.setText("sp1=" + sp1.getValue() +
              ", sp2 = " + sp2.getValue() +
              ", sp3 = " + sp3.getValue());

       
    }

    
    public static void main(String[] args) {
        Lab3 l3 = new Lab3();
    }
}