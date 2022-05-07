
package java2lab4;

/*
 * @author Jonathan Ogden
 * CSIC 123B
 * 0211330
 * assignment 4
 * reading a sentince and then printing some info
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import  java.lang.Character;


public class Java2lab4 extends  JFrame {
    
     JFrame Myframe = new JFrame();
     JTextField tfsent = new JTextField(10);
     JLabel lblascii = new JLabel();
     JLabel lblval = new JLabel();
     JLabel lbldig = new JLabel();
     JLabel lblUlet = new JLabel();
     JLabel lblLlet = new JLabel();
     JButton btn = new JButton("RUN");
     
     Container content = Myframe.getContentPane();
     
   
    public static void main(String[] args) 
    {
       Java2lab4 JL4 = new Java2lab4("Sentence Test",400,600);
      
    }
    public Java2lab4 (String tital,int hight,int width)
    {
        Myframe.setVisible(true);
        Myframe.setTitle(tital);
        Myframe.setSize(width,hight);
        Myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Myframe.setLayout(new BorderLayout());
        JPanel P1 = new JPanel();
        P1.setLayout(new GridLayout(7,2,5,5)); 
        P1.add(new JLabel("Enter A Sebtence",JLabel.CENTER));
        P1.add(tfsent);
        P1.add(new JLabel("Here Is Some Information About Your String"));
        P1.add(new JLabel(""));        
        P1.add(new JLabel("Ascii Sum:"));
        P1.add(lblascii);
        P1.add(new JLabel("Number Of Valels:"));
        P1.add(lblval);
        P1.add(new JLabel("Number Of Digits:"));
        P1.add(lbldig);
        P1.add(new JLabel("Uppercase Letters:"));
        P1.add(lblUlet);
        P1.add(new JLabel("Lowercase Letters:"));
        P1.add(lblLlet);
        Myframe.add(P1,BorderLayout.NORTH);
        JPanel P2 = new JPanel();
        P2.setLayout(new FlowLayout());
        P2.add(btn);
        Myframe.add(P2,BorderLayout.SOUTH);
        
       btn.addActionListener(new  StrMetric());  
    }
    private class  StrMetric implements ActionListener 
    {
        

        @Override
        public void actionPerformed(ActionEvent ae)
        {
          
            StrMetric ste = new StrMetric(tfsent.getText());
             
               System.out.println("i made it here");
        }
       
  
        private StrMetric()
        {
           this("");
        }
        private StrMetric(String getsent)
        {
            
            String sent = getsent;
           
            
            lblascii.setText(getAsciiSum(sent));
            lblval.setText(getNumVowels(sent));
            lbldig.setText(getNumDigits(sent));
            lblUlet.setText(getNumUpperCase(sent));
            lblLlet.setText(getNumLowerCase(sent));
        }
        public StrMetric(char[] getchar)
        {
            this(new String(getchar));
           // String sent =  String.valueOf(getchar);
 
        }
        public StrMetric(byte[] getbyte)
        {
            this(new String(getbyte));
        }

      
    }
    private String getAsciiSum(String getstring)
    {
         int sum = 0;
        
        
        for(int y = 0;y < getstring.length(); y++)
        {
            sum += getstring.charAt(y);   
        }
     
        return Integer.toString(sum);
        
    }
    private String getNumVowels(String getstring)
    {
        int numVal = 0;
        
       
       for(int x = 0;x < getstring.length(); x++)
       {
           char charstr =  Character.toUpperCase(getstring.charAt(x));
           switch(charstr)
           {
               case 'A':
               case 'E':
               case 'I':
               case 'O':
               case 'U':
                   numVal++; break;
                   
           }
           
       }
           
        return Integer.toString(numVal);
    }
    private String getNumDigits(String getstring)
    {
        int numVal = 0;
        char chartest;
       
        for(int x = 0;x < getstring.length(); x++)
           
        { 
            chartest = getstring.charAt(x);
            if(chartest >= '0' && chartest <= '9')
            numVal++;
        }    
        return Integer.toString(numVal);
    }
    private String getNumUpperCase(String getstring)
    {
       int numVal = 0; 
       for(int x = 0;x < getstring.length(); x++)
       {
           if( Character.isUpperCase(getstring.charAt(x)))
               numVal++;
       }
           return Integer.toString(numVal);
    }
    private String getNumLowerCase(String getstring)
    {
             int numVal = 0; 
       for(int x = 0;x < getstring.length(); x++)
       {
           if( Character.isLowerCase(getstring.charAt(x)))
               numVal++;
       }
           return Integer.toString(numVal);
    }
}
