
/**
 *
 * @author Jonathan Ogden
 *  CSIS 113B
 * 0211330
 * Assignment 12
 * TicTacToe game
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TicTacToe extends JApplet implements ActionListener, MouseListener {
      
    JLabel[][] grid  = new JLabel[3][3];
    char[][] game = new char[3][3];
    JButton restart = new JButton("restart");
    JPanel p = new JPanel();
    JLabel status = new JLabel("Wold You Like to Play a Game?");
    
    int numClicks;
    boolean isDone = false;
    boolean isXTurn = true;
    
      public void init()
      {
          setLayout(new BorderLayout());
          add(status,BorderLayout.NORTH);
          status.setOpaque(true);
          status.setBackground(Color.YELLOW);
          status.setForeground(Color.BLUE);
          status.setFont(new Font("Helvetica",Font.BOLD,12));
          status.setHorizontalAlignment(JLabel.CENTER);
          p.setLayout(new GridLayout(3,3,3,3));
          p.setBackground(Color.BLACK);
          add(p,BorderLayout.CENTER);
          
          for(int row = 0;row < grid.length; row++)
          {
              for(int cal = 0; cal < grid[row].length; cal++)
              {
                  grid[row][cal] = new JLabel(" ",JLabel.CENTER);
                  grid[row][cal].setOpaque(true);
                  grid[row][cal].setBackground(Color.WHITE);
                  grid[row][cal].setFont(new Font("Helvetica",Font.BOLD,32));
                  grid[row][cal].addMouseListener(this);
                  game[row][cal] = ' ';
                  p.add(grid[row][cal]);
              }
          }
          
          add(restart,BorderLayout.SOUTH);
          restart.setHorizontalAlignment(JButton.CENTER);
          restart.addActionListener(this);
          
      }
      
    @Override
    public void actionPerformed(ActionEvent ae) {
        resetGame();
    }

    @Override
    public void mouseClicked(MouseEvent e) 
        {
    if (isDone) resetGame();
    JLabel clicked = (JLabel) e.getSource();
    
    next:
    for (int row = 0; row < 3; row++)
    {
      for (int col = 0; col < 3; col++)
      {
        if (clicked == grid[row][col])
        {
       
          if (clicked.getText().equals(" "))
          {
               if (isXTurn == true)
              {
                  clicked.setText("X");
                  clicked.setForeground(Color.red);
                  game[row][col] = 'X';
                  
              }else{
                  clicked.setText("0");
                  clicked.setForeground(Color.blue);
                  game[row][col] = '0';
              }
             
          }else{
               status.setText("Invalid Move");
               break next;
             
          }
         
          isXTurn = !isXTurn;
          numClicks += 1;
          
          gameOver();
        }
      }
    }
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

  

    private void resetGame() {
     for(int row = 0;row < grid.length;row++)
     {
         for(int cal = 0;cal < grid[row].length;cal++)
         {
             grid[row][cal].setText(" ");
             game[row][cal] = ' ';
         }
     }
         numClicks = 0;
         isXTurn = true;
    }
      void gameOver()
  {
    char winner = ' ';

    

    if (game[0][0] == game[1][1] &&
        game[1][1] == game[2][2])
      winner = game[0][0];

  
    else if (game[2][0] == game[1][1] &&
             game[1][1] == game[0][2])
      winner = game[2][0];


    else
    {
      for (int row = 0; row < 3; row++)
      {
        if (game[row][0] != ' ' &&
            game[row][0] == game[row][1] &&
            game[row][1] == game[row][2])
          winner = game[row][0];

        else if (game[0][row] != ' ' &&
                 game[0][row] == game[1][row] &&
                 game[1][row] == game[2][row])
          winner = game[0][row];
      }
    }

 
    isDone = true;

    
    if (winner == ' ' && numClicks == 9)
      status.setText("Tie Game");

   
    else if (winner != ' ')
      status.setText("Game Over: " + winner + " Won!!!");

    
    else
    {
      status.setText((isXTurn ? "X's Turn" : "O's Turn"));
      isDone = false;
    }
  }
}
