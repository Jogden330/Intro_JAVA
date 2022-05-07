
/**
 *
 * @author The Meat Man
 * * 0211330
 * CSIS 113B
 * midterm
 * a program that converts hex into numbers and colors
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class colorConverter extends JApplet implements ActionListener 
{
    int red,blue,green;
    
    Container content = getContentPane();
    JTextField tfRed = new JTextField(10);
    JTextField tfBlue = new JTextField(10);
    JTextField tfGreen = new JTextField(10);

    JLabel lblRdes = new JLabel();
    JLabel lblBdes = new JLabel();
    JLabel lblGdes = new JLabel();
    JLabel lblRbdes = new JLabel();
    JLabel lblGbdes = new JLabel();
    JLabel lblBbdes = new JLabel();
    JLabel lblcolor = new JLabel("Color");
    
    Color myclr;
    JButton btn = new JButton("show color");
    DecimalFormat fmt = new DecimalFormat("0.00"); 
    //NumberFormat fmt = new NumberFormat(".##");
    
    public void init()
    {
         content.setLayout(new GridLayout(5,3,10,10));
         content.add(new JLabel("RED"));
         content.add(new JLabel("GREEN"));
         content.add(new JLabel("BLUE"));
         content.add(tfRed);
         content.add(tfGreen);
         content.add(tfBlue);
         content.add(lblRdes);
         content.add(lblGdes);
         content.add(lblBdes);
         content.add(lblRbdes);
         content.add(lblGbdes);
         content.add(lblBbdes);
         content.add(btn);
         content.add(lblcolor);
         lblcolor.setOpaque(true);
         
         btn.addActionListener(this);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
      getcolor();
      getnumbers();
    }
   public void getcolor()
   {
       red = Integer.valueOf(tfRed.getText(),16);
       green = Integer.valueOf(tfGreen.getText(),16);
       blue = Integer.valueOf(tfBlue.getText(),16);
       myclr = new Color(red, green ,blue);
      lblcolor.setBackground(myclr);
   }
   public void getnumbers()
   {
       lblRbdes.setText(""+red);
       lblGbdes.setText(""+green);
       lblBbdes.setText(""+blue);
       
       
       
       lblRdes.setText(""+fmt.format((double)red/255));
       lblGdes.setText(""+fmt.format((double)green/255));
       lblBdes.setText(""+fmt.format((double)blue/255));
       
   }
}
