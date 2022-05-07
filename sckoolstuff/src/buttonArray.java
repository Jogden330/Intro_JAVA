/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jonathan
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class buttonArray extends JApplet implements ActionListener {
      Container content = getContentPane();
      JPanel pnlButtons = new JPanel();
      
      JButton[][] btnA = new JButton[3][3];
    
    public void init()
    {
        pnlButtons.setLayout(new GridLayout(3,3));
        billdButton();
        content.add(pnlButtons, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton btn = (JButton) ae.getSource();
        if(ae.getSource() == btnA[2][0])
        {
             System.out.println("button 2 is awsome");
        }
        System.out.println("" + btn.getText());
    }
    public void billdButton()
    {
        int count = 0;
        for(int x = 0; x < btnA.length; x++)
        {
           for(int i = 0; i < btnA[x].length; i++)
            {
                  btnA[i][x] = new JButton("" + count);
                  btnA[i][x].addActionListener(this);
                  pnlButtons.add(btnA[i][x]);
                  count++;
             }
        }
    }
    
}
