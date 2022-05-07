

/**
 *
 * @author Jonathan 
 * CSIS 113B
 * 0211330
 * Assignment 10
 * A dice Game 
 */
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Random;
import javax.swing.border.Border;

public class dice extends JApplet implements ActionListener{
    
    Font fTitle = new Font("TimesRoman",Font.BOLD,24);
    JLabel lblTitle = new JLabel("Roll The Dice, Test Your Luck");
    JLabel lblBank = new JLabel("$100.00");
    JTextField tfBet = new JTextField(10);
    JTextField tfGuess = new JTextField(10);
    JButton btn = new JButton("Play");
    JLabel lblStatus = new JLabel();
    NumberFormat fmt = NumberFormat.getCurrencyInstance();
    JLabel lbl = new JLabel();
    
    double bank = 100.00, bet = 0;
    int guess = 0, die = rollDice();
    Container content = this.getContentPane();
    
    ImageIcon die1;
    ImageIcon die2;
    ImageIcon die3;
    ImageIcon die4;
    ImageIcon die5;
    ImageIcon die6;
    
            
    public void init()
    {
        setLayout(new BorderLayout()); 
        loadImages();
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setFont(fTitle);
        lblTitle.setForeground(Color.BLUE);
        setImages();
        add(lblTitle,BorderLayout.NORTH);
        
        lbl.setLayout(new FlowLayout());
        lbl.setHorizontalAlignment(JLabel.CENTER);
        add(lbl,BorderLayout.CENTER);
        JPanel Grid = new JPanel();
        Grid.setLayout(new GridLayout(4,2,10,5));
        Grid.add(new JLabel("Banke"));
        Grid.add(lblBank);
        
        Border blackBorder = BorderFactory.createLineBorder(Color.black, 1);
        lblBank.setBorder(blackBorder);
        lblBank.setOpaque(true);
        lblBank.setBackground(Color.WHITE);
        Grid.add(new JLabel("Bet"));
        Grid.add(tfBet);
        Grid.add(new JLabel("Guess"));
        Grid.add(tfGuess);
        Grid.add(btn);
        Grid.add(lblStatus);
        add(Grid,BorderLayout.SOUTH);
        btn.addActionListener(this);
        
    }
        
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        bet = Double.parseDouble(tfBet.getText());
        guess = Integer.parseInt(tfGuess.getText());
       
        if(bet>bank || bank<=0 )
        {
           lblStatus.setForeground(Color.RED); 
           lblStatus.setText(bank <= 0 ? "Sorry Out Of Money" : "Not Enough Money");
        }else{
            die = rollDice();
            setImages();
            if(die == guess)
            {
                lblStatus.setForeground(Color.BLUE);
                lblStatus.setText("You Won "+ bet);
                bank += bet;
                
            }else{
                lblStatus.setForeground(Color.RED);
                lblStatus.setText("You Lost " + bet);
                bank -= bet;   
            }
            
        }
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        lblBank.setText(fmt.format(bank));
        
    }
    
    protected URL getURL(String filename)
{
    URL codeBase = getCodeBase();
    URL url = null;
   
     try
    {
        url = new URL(codeBase, filename);
     }
     catch (java.net.MalformedURLException e)
    {
         return null;
    }
    return url;
 }
    public void loadImages()
    {
      
      die1 = new ImageIcon(getURL("Die1.png"));
      die2 = new ImageIcon(getURL("Die2.png"));
      die3 = new ImageIcon(getURL("Die3.png"));
      die4 = new ImageIcon(getURL("Die4.png"));
      die5 = new ImageIcon(getURL("Die5.png"));
      die6 = new ImageIcon(getURL("Die6.png"));

    }
    public void setImages()
    {
     switch(die)  
     {
         case 1: lbl.setIcon(die1); break;
             
         case 2: lbl.setIcon(die2); break;   
             
         case 3: lbl.setIcon(die3); break;    
         
         case 4: lbl.setIcon(die4); break; 
             
         case 5: lbl.setIcon(die5); break; 
             
         case 6: lbl.setIcon(die6); break;    
     }
    }
    public int rollDice()
    {
        
        Random r = new Random();
        
        return r.nextInt(6) + 1;
        
        
    }

}

