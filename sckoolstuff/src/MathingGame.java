/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jonathan Ogden
 * CSIS 113B
 * 0211330
 * Assignment 13
 * A Game of maching 
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class MathingGame extends JApplet implements ActionListener, MouseListener{
    
    JLabel[] lblBoard = new JLabel[16];
    int[] numes = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8};
    int firstChoice = -1;
    int tries = 0;
    JLabel lblFirst = new JLabel();
    JButton btnGame = new JButton("New Game");
    JLabel lblTries = new JLabel("0");
   
    JPanel pnlControls = new JPanel();
    JPanel p = new JPanel();
    
    private Thread thread;
    
    int shuf = 500;
    
    public void init()
    {
         createLabels();
         shuffle();
         add(p,BorderLayout.CENTER);
         pnlControls.setLayout(new FlowLayout());
         pnlControls.add(btnGame);
         btnGame.addActionListener(this);
         pnlControls.add(new JLabel("number Of trys: "));
         pnlControls.add(lblTries);
         add(pnlControls,BorderLayout.SOUTH);
         
        
    }
     
    public void createLabels()
    {
       p.setLayout(new GridLayout(4,4,5,5)); 
       
       for(int i = 0; i < lblBoard.length; i++)
       {
          
           lblBoard[i] = new JLabel("",JLabel.CENTER);
           lblBoard[i].setOpaque(true);
           lblBoard[i].setBackground(Color.BLUE);
           lblBoard[i].setForeground(Color.red);
           lblBoard[i].setFont(new Font("Helvetica",Font.BOLD,24));
           lblBoard[i].addMouseListener(this);
           lblBoard[i].setName("" + i );
           p.add(lblBoard[i]);
            
       }
    
    }
    public void shuffle()
    {
        int num1, num2, tmp;
        
        Random r = new Random();
        
        for(int i = 0; i <  shuf; i++)
        {
            num1 = r.nextInt(numes.length);
            num2 = r.nextInt(numes.length);
            tmp = numes[num1];
            numes[num1] = numes[num2];
            numes[num2] = tmp;
        }
        
    }
      
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        shuffle();
        firstChoice = -1;
        for(int i = 0; i < lblBoard.length; i++)
        {
            lblBoard[i].setText("");
        }
        tries = 0;
        lblTries.setText(""+tries);
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
         JLabel clicked = (JLabel) me.getSource();
         int theNumber = Integer.parseInt(clicked.getName());
           if(firstChoice == -1)
           {
               clicked.setText("" + numes[theNumber]);
               lblFirst = clicked;
               firstChoice = theNumber;
           }   
           else if(numes[theNumber] != numes[firstChoice])  
           {
                clicked.setText("" + numes[theNumber]);
                p.paintImmediately(0,0, p.getWidth(), p.getHeight());
                try
		  {
		  Thread.sleep(250);
	          }catch(InterruptedException e){}
                lblFirst.setText("");
                clicked.setText("");
                lblFirst = null;
                firstChoice = -1;
                tries++;
           }else{
               clicked.setText("" + numes[theNumber]);
               firstChoice = -1;
               tries++;
           }
           lblTries.setText(""+tries);
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }
    
}
