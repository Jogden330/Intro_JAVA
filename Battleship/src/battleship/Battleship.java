/**
 *
 * @author Jonathan Ogden
 *  CSIS 123B
 * 0211330
 * Assignment Final
 * a single player battleship game
 */
package battleship;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/**
 *
 * @author The Meat Man
 */
public class Battleship extends JFrame implements ActionListener, MouseListener {

    JLabel[][] lblBoard = new JLabel[16][16];
    ShipInfo[] ships;
    
    int tries = 0;
    Random r = new Random();
    boolean vertical;
    
    
    ImageIcon water;
    ImageIcon Hit;
    ImageIcon miss;
    ImageIcon AftHorizontalRed;
    ImageIcon DeckHorizontalRed;
    ImageIcon SternHorizontalRed;
    ImageIcon AftVerticalRed;
    ImageIcon DeckVerticalRed;
    ImageIcon SternVerticalRed;
    ImageIcon SternHorizontal;
    ImageIcon AftHorizontal;
    ImageIcon SternVertical;
    ImageIcon AftVertical;
    ImageIcon DeckHorizontal1;
    ImageIcon DeckHorizontal2;
    ImageIcon DeckHorizontal3;
    ImageIcon DeckVertical1;
    ImageIcon DeckVertical2;
    ImageIcon DeckVertical3;
    ImageIcon water2;

    public Battleship(String Tital, int width, int hight) {
        
        setLayout(new BorderLayout()); 
        this.setSize(width, hight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(Tital);
        this.getContentPane().setBackground(Color.BLUE);
        
        
        biuldShips();
        loadImages();
        add(toolBar(),BorderLayout.SOUTH);
        add(createBourd(),BorderLayout.CENTER);
        add(new JLabel("   "),BorderLayout.WEST);
        add(new JLabel("   "),BorderLayout.NORTH);
        for(int i = 0;i < ships.length; i++)
        {
           this.placeShip(ships[i]);
        }
        //updatebourd();
        this.setVisible(true);;
    }

    public static void main(String[] args) {
        Battleship battleshipgame = new Battleship("Battleship", 350, 350);
    }

    public JPanel createBourd() {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(16, 16, 2, 2));
        p.setBackground(Color.BLUE);
       

        for (int x = 0; x < lblBoard.length; x++) {
            for (int y = 0; y < lblBoard.length; y++) {
                lblBoard[x][y] = new JLabel("", JLabel.CENTER);
                lblBoard[x][y].setOpaque(true);
                lblBoard[x][y].setIcon(water);
                lblBoard[x][y].setBackground(Color.BLUE);

                lblBoard[x][y].addMouseListener(this);
                lblBoard[x][y].setName("");
                p.add(lblBoard[x][y]);
            }
        }
        return p;
    }
      JPanel toolBar()
    {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        String[] btns = {"New Game", "Give Up"};
        for (int i = 0; i < btns.length; i++)
        {
            JButton b = new JButton(btns[i]);
            b.setActionCommand(btns[i]);
            b.addActionListener(this);
            p.add(b);
        }
        
        p.setBackground(Color.lightGray);
        
        return p;
    }

    public void loadImages() {

        water = new ImageIcon(getClass().getResource("water.gif"));
        Hit = new ImageIcon(getClass().getResource("hit.gif"));
        miss = new ImageIcon(getClass().getResource("miss.gif"));
        AftHorizontalRed = new ImageIcon(getClass().getResource("AftHorizontalRed.gif"));
        DeckHorizontalRed = new ImageIcon(getClass().getResource("DeckHorizontalRed.gif"));
        SternHorizontalRed = new ImageIcon(getClass().getResource("SternHorizontalRed.gif"));
        AftVerticalRed = new ImageIcon(getClass().getResource("AftVerticalRed.gif"));
        DeckVerticalRed = new ImageIcon(getClass().getResource("DeckVerticalRed.gif"));
        SternVerticalRed = new ImageIcon(getClass().getResource("SternVerticalRed.gif"));
        SternHorizontal = new ImageIcon(getClass().getResource("SternHorizontal.gif"));
        AftHorizontal = new ImageIcon(getClass().getResource("AftHorizontal.gif"));
        SternVertical = new ImageIcon(getClass().getResource("SternVertical.gif"));
        AftVertical = new ImageIcon(getClass().getResource("AftVertical.gif"));
        DeckHorizontal1 = new ImageIcon(getClass().getResource("DeckHorizontal1.gif"));
        DeckHorizontal2 = new ImageIcon(getClass().getResource("DeckHorizontal2.gif"));
        DeckHorizontal3 = new ImageIcon(getClass().getResource("DeckHorizontal3.gif"));
        DeckVertical1 = new ImageIcon(getClass().getResource("DeckVertical1.gif"));
        DeckVertical2 = new ImageIcon(getClass().getResource("DeckVertical2.gif"));
        DeckVertical3 = new ImageIcon(getClass().getResource("DeckVertical3.gif"));
        water2 = new ImageIcon(getClass().getResource("Water2.gif"));
    }

    public void placeShip(ShipInfo ship) {
      
      
        int row = r.nextInt(lblBoard.length);
        int col = r.nextInt(lblBoard.length);
        if ("".equals(lblBoard[row][col].getName())) 
        {
            vertical = r.nextBoolean();
            if (vertical == true) 
            {
                if (col + ship.getSize() < lblBoard.length)
                {
                    for (int i = 0; i < ship.getSize(); i++) 
                    {
                        if (!"".equals(lblBoard[row][col + i].getName())) 
                        {
                            placeShip(ship);
                        
                            return;
                        }
                    }

                    for (int x = 0; x < ship.getSize(); x++) 
                    {
                        this.lblBoard[row][col + x].setName(ship.getName() + "V" + x);
                        ship.setLocation(row, col  + x, x);
                    }
                    ship.setIsVertical(vertical);

                } else {
                    placeShip(ship);
                    
                }
            } else {
                if (row + ship.getSize() < lblBoard.length) 
                {
                    for (int i = 0; i < ship.getSize(); i++)
                    {
                        if (!"".equals(lblBoard[row + i][col].getName())) 
                        {
                            placeShip(ship);
                            isOver();
                            return;
                        }
                    }

                    for (int x = 0; x < ship.getSize(); x++) 
                    {
                        this.lblBoard[row + x][col].setName(ship.getName()+"H"+x);
                        ship.setLocation(row  + x, col  , x);
                    }
                     ship.setIsVertical(vertical);

                } else {
                    placeShip(ship);
                    
                }

            }
        } else {
            placeShip(ship);
           
        }
        
    }
    void biuldShips()
    {
        ships = new ShipInfo[r.nextInt(4) + 5];
        
        for(int i = 0; i< ships.length; i++)
        {
          ships[i] = new ShipInfo(r.nextInt(4) + 2);
        }
    }

    public void updatebourd() {
        for (int x = 0; x < lblBoard.length; x++) {
            for (int y = 0; y < lblBoard.length; y++) {
                if (!"".equals(lblBoard[x][y].getName())) {
                    lblBoard[x][y].setIcon(water2);
                }
            }
        }
    }
    void showShip(ShipInfo ship)
    {
    int x;
    int y;
        
    for(int i = 0; i < ship.getSize(); i++) 
    {
        x = ship.getXposition(i);
        y = ship.getYposition(i);
        if (!"".equals(lblBoard[x][y].getName())) {
                    if("MinesweepV0".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(AftHorizontalRed);
                    }
                    else if("MinesweepV1".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(SternHorizontalRed);
                    } 
                    else if("MinesweepH0".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(AftVerticalRed);
                    } 
                    else if(("MinesweepH1".equals(lblBoard[x][y].getName())))
                    {
                        lblBoard[x][y].setIcon(SternVerticalRed);
                    } 
                    else if("FrigateV0".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(AftHorizontalRed);
                    } 
                    else if("FrigateV1".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(DeckHorizontalRed);
                    }
                    else if("FrigateV2".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(SternHorizontalRed);
                    }
                    else if("FrigateH0".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(AftVerticalRed);
                    } 
                    else if(("FrigateH1".equals(lblBoard[x][y].getName())))
                    {
                        lblBoard[x][y].setIcon(DeckVerticalRed);
                    }
                    else if("FrigateH2".equals(lblBoard[x][y].getName()))
                    {
                         lblBoard[x][y].setIcon(SternVerticalRed);
                    }
                    
                    else if("CruiserH0".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(AftVerticalRed);
                    } 
                    else if(("CruiserH1".equals(lblBoard[x][y].getName())))
                    {
                        lblBoard[x][y].setIcon(DeckVerticalRed);
                    }
                    else if("CruiserH2".equals(lblBoard[x][y].getName()))
                    {
                         lblBoard[x][y].setIcon(DeckVerticalRed);
                    }
                    else if("CruiserH3".equals(lblBoard[x][y].getName()))
                    {
                         lblBoard[x][y].setIcon(SternVerticalRed);
                    }
                    else if("CruiserV0".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(AftHorizontalRed);
                    } 
                    else if("CruiserV1".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(DeckHorizontalRed);
                    }
                    else if("CruiserV2".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(DeckHorizontalRed);
                    } else if("CruiserV3".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(SternHorizontalRed);
                    }     
                    else if("BattleshipH0".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(AftVerticalRed);
                    } 
                    else if(("BattleshipH1".equals(lblBoard[x][y].getName())))
                    {
                        lblBoard[x][y].setIcon(DeckVerticalRed);
                    }
                    else if("BattleshipH2".equals(lblBoard[x][y].getName()))
                    {
                         lblBoard[x][y].setIcon(DeckVerticalRed);
                    }
                    else if("BattleshipH3".equals(lblBoard[x][y].getName()))
                    {
                         lblBoard[x][y].setIcon(DeckVerticalRed);
                    }
                    else if("BattleshipH4".equals(lblBoard[x][y].getName()))
                    {
                         lblBoard[x][y].setIcon(SternVerticalRed);
                    }
                    else if("BattleshipV0".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(AftHorizontalRed);
                    } 
                    else if("BattleshipV1".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(DeckHorizontalRed);
                    }
                    else if("BattleshipV2".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(DeckHorizontalRed);
                    } 
                    else if("BattleshipV3".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(DeckHorizontalRed);
                    } 
                    else if("BattleshipV4".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(SternHorizontalRed);
                    }
                          
                }
        
           }
           }
    
    void resetBourd()
    {
        for (int x = 0; x < lblBoard.length; x++)
        {
            for (int y = 0; y < lblBoard.length; y++) 
            {
                
                lblBoard[x][y].setIcon(water);             
                lblBoard[x][y].setName("");
            }
         }
        tries = 0;
    }
    
    void showBourd()
    {
        for (int x = 0; x < lblBoard.length; x++) {
            for (int y = 0; y < lblBoard.length; y++) {
           
                    if("MinesweepV0".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(AftHorizontal);
                    }
                    else if("MinesweepV1".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(SternHorizontal);
                    } 
                    else if("MinesweepH0".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(AftVertical);
                    } 
                    else if(("MinesweepH1".equals(lblBoard[x][y].getName())))
                    {
                        lblBoard[x][y].setIcon(SternVertical);
                    } 
                    else if("FrigateV0".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(AftHorizontal);
                    } 
                    else if("FrigateV1".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(DeckHorizontal1);
                    }
                    else if("FrigateV2".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(SternHorizontal);
                    }
                    else if("FrigateH0".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(AftVertical);
                    } 
                    else if(("FrigateH1".equals(lblBoard[x][y].getName())))
                    {
                        lblBoard[x][y].setIcon(DeckVertical1);
                    }
                    else if("FrigateH2".equals(lblBoard[x][y].getName()))
                    {
                         lblBoard[x][y].setIcon(SternVertical);
                    }
                    
                    else if("CruiserH0".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(AftVertical);
                    } 
                    else if(("CruiserH1".equals(lblBoard[x][y].getName())))
                    {
                        lblBoard[x][y].setIcon(DeckVertical1);
                    }
                    else if("CruiserH2".equals(lblBoard[x][y].getName()))
                    {
                         lblBoard[x][y].setIcon(DeckVertical2);
                    }
                    else if("CruiserH3".equals(lblBoard[x][y].getName()))
                    {
                         lblBoard[x][y].setIcon(SternVertical);
                    }
                    else if("CruiserV0".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(AftHorizontal);
                    } 
                    else if("CruiserV1".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(DeckHorizontal1);
                    }
                    else if("CruiserV2".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(DeckHorizontal2);
                    } else if("CruiserV3".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(SternHorizontal);
                    }     
                    else if("BattleshipH0".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(AftVertical);
                    } 
                    else if(("BattleshipH1".equals(lblBoard[x][y].getName())))
                    {
                        lblBoard[x][y].setIcon(DeckVertical1);
                    }
                    else if("BattleshipH2".equals(lblBoard[x][y].getName()))
                    {
                         lblBoard[x][y].setIcon(DeckVertical2);
                    }
                    else if("BattleshipH3".equals(lblBoard[x][y].getName()))
                    {
                         lblBoard[x][y].setIcon(DeckVertical3);
                    }
                    else if("BattleshipH4".equals(lblBoard[x][y].getName()))
                    {
                         lblBoard[x][y].setIcon(SternVertical);
                    }
                    else if("BattleshipV0".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(AftHorizontal);
                    } 
                    else if("BattleshipV1".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(DeckHorizontal1);
                    }
                    else if("BattleshipV2".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(DeckHorizontal2);
                    } 
                    else if("BattleshipV3".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(DeckHorizontal3);
                    } 
                    else if("BattleshipV4".equals(lblBoard[x][y].getName()))
                    {
                        lblBoard[x][y].setIcon(SternHorizontal);
                    } else {
                        lblBoard[x][y].setIcon(water2);
                    }
                          
                
            }
        }
        
    }
    void isOver()
    {
       boolean wingame = true;
        
       for(int i = 0;i < ships.length; i++)
       {
           if(ships[i].getHits() != 0 )
           {
               wingame = false;
               
           }
       }
       if(wingame == true)
       {
          showBourd();
          JOptionPane.showMessageDialog(this,"Congratulations!! You Win in " + tries + " attempts");
       }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ;
        if(ae.getActionCommand().equals("New Game"))
        {
            System.out.println("i made it");
            biuldShips();
            resetBourd();
             for(int i = 0;i < ships.length; i++)
             {
               this.placeShip(ships[i]);
             }
        }else if(ae.getActionCommand().equals("Give Up"))
        {
            showBourd();
        }
            
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        JLabel clicked = (JLabel) me.getSource();
        for (int row = 0; row < lblBoard.length; row++) 
        {
            for (int col = 0; col < lblBoard.length; col++) 
            {
                if (clicked == lblBoard[row][col] && lblBoard[row][col].getIcon() == water)
                {
                    
                    for (int i = 0; i < ships.length; i++)
                    {
                        for (int x = 0; x < ships[i].getSize(); x++)
                        {
                            if (row == ships[i].getXposition(x) && col == ships[i].getYposition(x)) 
                            {
                                lblBoard[row][col].setIcon(Hit);
                                tries++;
                                
                                ships[i].isSunck();
                                if(ships[i].getHits() == 0)
                                {
                                    showShip(ships[i]);
                                    JOptionPane.showMessageDialog(this, "you sunk my " + ships[i].getName());
                                    this.isOver();
                                }
                                    
                                return;
                            }
                          
                        }
                    }
                    tries++;
                    lblBoard[row][col].setIcon(miss);
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
}