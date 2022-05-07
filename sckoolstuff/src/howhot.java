

/**
 *
 * @author Jonathan Ogden
 * 0211330
 * CSIS 113B
 * Assignment 8
 * a program the shows you different temperature formats 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import javax.swing.border.*;


public class howhot extends JApplet implements ActionListener
{
    JTextField tfFarenheit = new JTextField(10);
    JLabel lblCelcius = new JLabel();
    JLabel lblKelvin = new JLabel();
    Container content = getContentPane();
    JButton btn = new JButton("Click me");
    DecimalFormat fmt = new DecimalFormat(".##");
    
    
    static final double cFactor = 32.0;
    static final double dFactor = 0.5555;
    static final double eFactor = 273.15;
    
    public void init()
    {
        content.setLayout(new GridLayout(4,2,10,10));
        content.add(new JLabel("Farenheit:",JLabel.RIGHT));
        content.add(tfFarenheit);
        
        Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
        
        content.add(new JLabel("Celcius:",JLabel.RIGHT));
        content.add(lblCelcius);
        lblCelcius.setBorder(blackBorder);
        lblCelcius.setOpaque(true);
        
        content.add(new JLabel("Kelvin:",JLabel.RIGHT));
        content.add(lblKelvin);
        lblKelvin.setBorder(blackBorder);
        lblKelvin.setOpaque(true);
        
        content.add(btn);
        btn.addActionListener(this);
        
    } 
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        double  F = Double.parseDouble(tfFarenheit.getText());
        lblCelcius.setText(getCelcius(F));
        lblKelvin.setText(getKelvin(F));
        
    }
    public String getCelcius(double F)
    {
           
        double Cel = (F - cFactor) * dFactor;   
        return   fmt.format(Cel);
      
    }
    public String getKelvin(double F)
    {
        
        double Kel = (F - cFactor) * dFactor + eFactor;
        return   fmt.format(Kel);
        
    }
}
