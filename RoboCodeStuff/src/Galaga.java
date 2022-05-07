/*/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author The Meat Man
 */

import java.awt.*;
import java.util.Random;
import robocode.AdvancedRobot;
import robocode.HitRobotEvent;
import robocode.MoveCompleteCondition;
import robocode.ScannedRobotEvent;
import robocode.TurnCompleteCondition;
import static robocode.util.Utils.normalRelativeAngleDegrees;

public class Galaga extends AdvancedRobot{
    
private byte gunDirection = 1;
    
    public void run()
    {
       
       
      setColors(Color.GREEN,Color.WHITE,Color.GREEN,Color.GREEN,Color.CYAN);
      
       moveToWall(roomsize());
       
      
    }

    private void moveToWall(double dist) 
    {
        
        setTurnLeft(getHeading() + closeWall(finedwall()));
       waitFor(new TurnCompleteCondition(this));

        setAhead(dist);
        waitFor(new MoveCompleteCondition(this));
        setTurnGunRight(90);
        setTurnRight(90);
        waitFor(new TurnCompleteCondition(this));

        galaga();
    }

    private void galaga() {
        Random r = new Random();
        while(true)
         {
           
           setAhead(r.nextInt((int)roomsize() - 10));
           waitFor(new MoveCompleteCondition(this));
           setBack(r.nextInt((int)roomsize() - 10));
           waitFor(new MoveCompleteCondition(this));
           
         }
    }
    
   

    public void onScannedRobot(ScannedRobotEvent e) 
               {
               setTurnGunRight(getHeading() - getGunHeading() + e.getBearing());
               setFire(Math.min(400 / e.getDistance(), 3));
               }
    
    private double roomsize() {
        return  Math.max(getBattleFieldWidth(), getBattleFieldHeight());
    }

    private char finedwall() {
    
    double x = getX();
    double y = getY();
    double wallWidth = getBattleFieldWidth()/2;
    double wallHeight = getBattleFieldHeight()/2;
    
    if(x>wallWidth)
    {
        if(y>wallHeight)
        {
            if((wallWidth-x) > (wallHeight-y))
                return 'c';
            else
                return 'b';
        }
        else
        {
            if((wallWidth-x) > (wallHeight-y))
                return 'a';
            else
                return 'b';
        }
    }
    else
    {
        if(y>wallHeight)
        {
            if((wallWidth-x) > (wallHeight-y))
                return 'c';
            else
                return 'd';
        }
        else
        {
            if((wallWidth-x) > (wallHeight-y))
                return 'a';
            else
                return 'd';
        }
    }
    
}
    
    private int closeWall(char walls)
    {
        int turn = 0;
       double temp = walls;
       
       if(walls == 'b')
        {
            turn = -90;
        }else if(walls == 'd')
        {
            turn = 90;
        }else if(walls == 'c')
        {
            turn = 0;
        }else if(walls == 'a')
        {
            turn = 180;
        }
  
       return turn;
    }
 
}
