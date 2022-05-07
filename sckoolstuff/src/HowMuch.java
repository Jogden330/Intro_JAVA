
/*
 * @author Jonathan Ogden
 * CSIS 113B
 * 0211330
 * Assignment 5
 * A yearly payment calculator
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class HowMuch extends JApplet implements ActionListener {

 
     JTextField tfAmont = new JTextField(10);
     JTextField tfIrate = new JTextField(10);
     JTextField tfYTP = new JTextField(10);
     JLabel lblMpay = new JLabel();
     JLabel lblTpay = new JLabel();
     JButton btnCal = new JButton("Calculate");
     
     Container content = getContentPane();
     
       public void init(){
         
           content.setLayout(new GridLayout(6,2,0,10));
           
           content.add(new JLabel("Amount of Purchase:"));
           content.add(tfAmont);
           content.add(new JLabel("Intrest Rate [like 7.5]:"));
           content.add(tfIrate);
           content.add(new JLabel("Years to Pay:"));
           content.add(tfYTP);
           content.add(new JLabel("Mounthly Payment:"));
           content.add(lblMpay);
           content.add(new JLabel("Total Purchase Cost:"));
           content.add(lblTpay);
           content.add(btnCal);
           btnCal.addActionListener(this);
           tfYTP.addActionListener(this);
           
       }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
     double amunt = Double.parseDouble(tfAmont.getText());
     double irate = Double.parseDouble(tfIrate.getText());
     double YTP = Double.parseDouble(tfYTP.getText());
        
     irate = irate / 100;
     irate = irate / 12;
     
     
     double payment = amunt * irate / (1 - (Math.pow(1/(1+irate), YTP * 12)));
     double total = YTP * (payment * 12);
   
     NumberFormat fmt = NumberFormat.getCurrencyInstance();
     lblMpay.setText(fmt.format(payment));
     lblTpay.setText(fmt.format(total));
    }
    
    
}

