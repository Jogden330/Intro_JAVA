

/*
 * @author Jonathan Ogden
 * CSIS 113B
 * 0211330
 * Assignment 9
 * A Game of Guessing
 */
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class guessOMatic extends JApplet implements ActionListener {
    
    JTextField tfguess = new JTextField(10);
    JLabel lblBakeRoll = new JLabel("100.00 Zipoids");
    JButton btnplayer = new JButton("New PLayer");
    JButton btnnumber = new JButton("New Number");
    JTextField tfPlayer = new JTextField(20);
    TextArea taoutput = new TextArea();
    
    String PlayerName = "";
    
    int TheNumber = 20;
    int NumTrys = 0, numGames =0;
    double amtRemaining = 100.0;
    
    Random randommiser = new Random();
    
    Container content = this.getContentPane();
    
 
    public void init()
    {
        //System.out.println("init() method called.");
        setLayout(new BorderLayout()); 
        JPanel P1 = new JPanel();
        P1.add(new JLabel("Make your guess "));
        P1.add(tfguess);
        tfguess.addActionListener(this);
        P1.add(lblBakeRoll);
        add(P1,BorderLayout.NORTH);
        
        JPanel P2 = new JPanel();
        P2.add(btnplayer);
        btnplayer.addActionListener(this);
        P2.add(tfPlayer);
        tfPlayer.addActionListener(this);
        P2.add(btnnumber);
        btnnumber.addActionListener(this);
        
        add(P2,BorderLayout.SOUTH);
        
        add(new JLabel("  "),BorderLayout.WEST);
        add(new JLabel("  "),BorderLayout.WEST);

        JScrollPane scrollArea = new JScrollPane(taoutput);
        add(scrollArea,BorderLayout.CENTER);
        NewPlayer();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
    if(ae.getSource() == btnplayer)  
    {
      NewPlayer();
        
    }else{
         if(ae.getSource() == tfPlayer)
         {
              addPlayer();
         }else{
                if(ae.getSource() == btnnumber)
                {
                     newGame();
        
                 tfguess.setEnabled(true);
                 tfguess.requestFocus();
                 tfguess.setBackground(Color.yellow);
                 }else{
                          if(ae.getSource() == tfguess)
                          {
                              newGuess();
                          }
                       }  
                 }
           }
    }
      private void NewPlayer()
  {
    //System.out.println("newPlayer() method called.");
    taoutput.setText("");
    taoutput.append("Enter Your Name and Press The Enter Key \n");
    
    taoutput.setEnabled(false);
    tfguess.setEnabled(false);
    tfPlayer.setEnabled(false);
    btnnumber.setEnabled(false);
    btnplayer.setEnabled(false);
    
    tfguess.setBackground(Color.WHITE);
    
    tfPlayer.setEnabled(true);
    tfPlayer.setText("");
    tfPlayer.requestFocus();
    tfPlayer.setBackground(Color.YELLOW);
    
  } 
 private void addPlayer()
  {
    //System.out.println("addPlayer() method called.");
    PlayerName = tfPlayer.getText();
    if(PlayerName.equals(""))
    {
        taoutput.append("You Must Enter A Name \n");
    }else{
         amtRemaining = 100;
         numGames = 0;
         newGame();
         updateScore();
         tfPlayer.setEnabled(false);
         tfPlayer.setBackground(Color.WHITE);
         btnplayer.setEnabled(true);
         btnnumber.setEnabled(true);
         tfguess.setEnabled(true);
         tfguess.requestFocus();
         tfguess.setBackground(Color.yellow);
    }
    
  }
 private void newGame()
  {
    //System.out.println("newGame() method called");
    taoutput.setText(" ");  
    numGames++;
    TheNumber = randommiser.nextInt(101);
    NumTrys = 0;
    displayInstructions();
    amtRemaining--;
    updateScore();
  }
 private void displayInstructions()
  {
    //System.out.println("displayInstructions() method called");
    taoutput.append("I'm guessing a number bettween 0 and 100 \n");  
    taoutput.append("If you guess the number in less then 9 tries you earn \n");
    taoutput.append("    1 try 2.00 Zipoids \n");
    taoutput.append("    2 try 1.75 Zipoids \n");
    taoutput.append("    3 try 1.50 Zipoids \n");
    taoutput.append("    4 try 1.25 Zipoids \n");
    taoutput.append("    5 try 1.00 Zipoids \n");
    taoutput.append("    6 try 0.75 Zipoids \n");
    taoutput.append("    7 try 0.50 Zipoids \n");
    taoutput.append("    8 try 0.25 Zipoids \n");
    
  }
 private void updateScore()
  {
    //System.out.println("updateScore() method called");
    tfPlayer.setText(PlayerName + " " + numGames);
    lblBakeRoll.setText(amtRemaining + " Zipoids");
  }
 private void newGuess()
  {
    //System.out.println("newGuess() method called.");
    int curGuess = Integer.parseInt(tfguess.getText());
    NumTrys++;
    taoutput.append("Number of guesses " + NumTrys + "\n Your last guess is " + curGuess + "\n");
    if(curGuess == TheNumber)
    {
        gameWon();
    }else{
      taoutput.append(curGuess > TheNumber ? "Too High \n" : "Too low \n");
      tfguess.requestFocus();
      tfguess.selectAll();
      tfguess.setBackground(Color.yellow);
    }
  } 
 private void gameWon()
  {
   //System.out.println("gameWon() method called");
    taoutput.setText("************WINNER************** \n");
    taoutput.append("With 1 Zipoid You Got it in " + NumTrys + "\n");
    double curWinnings = 0.0;
    
     switch(NumTrys)
     {
         case 1: curWinnings += 2.00; break;
             
         case 2: curWinnings += 1.75; break;
             
         case 3: curWinnings += 1.50; break;
             
         case 4: curWinnings += 1.25; break;
         
         case 5: curWinnings += 1.00; break;
             
         case 6: curWinnings += 0.75; break;
             
         case 7: curWinnings += 0.50; break;
             
         case 8: curWinnings += 0.25; break;
             
         default: curWinnings += 0; break;    
     }
     taoutput.append("you won " + curWinnings + "\n");
     amtRemaining += curWinnings;
     taoutput.append("You Now Have " + amtRemaining + " Zipods \n");
     taoutput.append("press the New Number button to continue \n");
     updateScore();
     tfguess.setText("");
     tfguess.setBackground(Color.WHITE);
     tfguess.setEnabled(false);
     btnnumber.requestFocus();
  }
}
