// Calc7 - A four-function calculator with error checking

import java.awt.*;

import java.applet.*;

import javax.swing.*;

import java.awt.event.*;





public class calc7 extends JApplet implements ActionListener

{

  // ---------------------------------------------------------

  // Attributes:

  //    TextArea total displays running total of calculations

  //    Label output shows current number being entered

  //    doubles memVal and curVal are used for calculations

  // ---------------------------------------------------------

  JTextArea total  = new JTextArea(5, 25);

  JScrollPane scrollingArea = new JScrollPane(total);

  JLabel output;

  double  memVal    = 0;

  double  curVal    = 0;
  
  Container content = this.getContentPane();



  // ---------------------------------------------------------

  // The init() method sets the layout and color.

  // It then calls the makeButtons() to do the actual layout

  // for the calculator

  // ---------------------------------------------------------

  public void init()

  {

    content.setLayout(new BorderLayout());

    content.setBackground(Color.lightGray);



    content.add("Center", makeButtons()); }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   

  }
public void actionPerformed(ActionEvent e)

  {

    // Local variables
    
    JButton btn = (JButton) e.getSource();

	String arg = btn.getText(); // Key that was pressed

    char   c    = arg.charAt(0);      // First char of key caption

    String s    = output.getText();   // Current value of output



    // "Special" keys operate on current value

    if (arg.equals("Backspace"))    backSpace();

    else if (arg.equals("C"))       clearAll();

    else if (arg.equals("CE"))      clearEntry();

    else if (arg.equals("sqrt"))    setCurVal(Math.sqrt(curVal));

    else if (arg.equals("1/x"))     setCurVal(1.0/curVal);

    else if (arg.equals("+/-"))     setCurVal(-curVal);



    // Digit keys are always added to current value

    else if (c >= '0' && c <= '9')  setCurVal(s + c);



    // Decimal point added only if not already in output

    else if (c == '.')

    {

      if (s.indexOf(c) < 0) setCurVal(s + c);

    }



    // Handle all of the operator keys

    else

    {

      switch (c)

      {

        case '/':

          memVal /= curVal;

          break;

        case '*':

          memVal *= curVal;

          break;

        case '-':

          memVal -= curVal;

          break;

        case '+':

          memVal += curVal;

          break;

        case '%':

          memVal %= curVal;

          break;

        case '=':

          memVal = curVal;

          total.append(padText("=============\n",25));

          break;

      }



      // Display results on the TextArea named total

      String memstr  = "" + curVal + " " + c + " \n";

      total.append(padText(memstr,25));



      String memstr  = "" + memVal + "   \n";

      total.append(padText(memstr,25));



      // Clear the output Label

      curVal = 0;

      output.setText("");

    }

    return true;

  }



  // ----------------------------------------------------------

  // These are utility methods

  // ----------------------------------------------------------

  Sting padText(String s, int size)

  {

    String temp = "                                       " + s;

    return temp.substring(temp.length() - size);

  }



  // Handles the backspace key

  void backSpace()

  {

    s = s.substring(0, s.length()-1);

    setCurVal(s);

  }



  // Handles the 'C' [Clear All] key

  void clearAll()

  {

    total.setText("");

    output.setText("");

    curVal = memVal = 0;

  }



  // Handles the 'CE' [Clear Entry] key

  void clearEntry()

  {

    output.setText("");

    curkVal = 0;

  }



  // Sets the current value, using a String

  void setCurVal(String s)

  {

    output.setText(s);

    curVal = (new Double(s)).doubleValue();

  }



  // Sets the current value, using a number

  void setCurVal(double newValue)

  {

    curVal = nwValue;

    output.setText(newValue);

  }



  // ---------------------------------------------------------

  // This lays out the appearance of the applet, using

  // BorderLayout and GridLayout

  // The colors used for the buttons may, or may not, appear

  // on your copy, depending upon your Web browser

  // ---------------------------------------------------------

  private Component makeButtons()

  {

    // Create 4 JPanels [p1 through p4]

    JPanel p   = new JPanel(new BorderLayout());

    JPanel p1  = new JPanel(new BorderLayout());

    JPanel p2  = new JPanel(new BorderLayout());

    JPanel p3  = new JPanel(new GridLayout(1,3,5,));

    JPanel p4  = new JPanel(new GridLayout(4,5,5,5));

    JPanel p5  = new JPanel(new BorderLayout());



    //  Add Backspace, CE, and C buttons to p3
    JButton Backspace = new JButton("Backspace");
    JButton CE = new JButton("CE");
    JButton Clear = new JButton("C");
    
    Backspace.addActionListener(this);
    CE.addActionListener(this);
    Clear.addActionListener(this);

    p3.setForeground(new Color(232,0,0));

    p3.setFont(new Font("Dialog", Font.PLAIN, 12));

    p3.add(Backspace);
    
    p3.add(CE);
    
    p3.add(Clear);



    // Add Number buttons to p4
    
    JButton zero = new JButton("0");
    JButton one = new JButton("1");
    JButton two = new JButton("2");
    JButton three = new JButton("3");
    JButton four = new JButton("4");
    JButton five = new JButton("5");
    JButton six = new JButton("6");
    JButton seven = new JButton("7");
    JButton eight = new JButton("8");
    JButton nine = new JButton("9");
    JButton addition = new JButton("+");
    JButton subtract = new JButton("-");
    JButton multiply = new JButton("*");
    JButton divide = new JButton("/");
    JButton sqrt = new JButton("sqrt");
    JButton xOver1 = new JButton("1/x");
    JButton plusOrMinus = new JButton("+/-");
    JButton decimal = new JButton(".");
    JButton eql = new JButton("eql");
    
    zero.addActionListener(this);
    one.addActionListener(this);
    two.addActionListener(this);
    three.addActionListener(this);
    four.addActionListener(this);
    five.addActionListener(this);
    six.addActionListener(this);
    seven.addActionListener(this);
    eight.addActionListener(this);
    nine.addActionListener(this);
    addition.addActionListener(this);
    subtract.addActionListener(this);
    multiply.addActionListener(this);
    divide.addActionListener(this);
    sqrt.addActionListener(this);
    xOver1.addActionListener(this);
    plusOrMinus.addActionListener(this);
    decimal.addActionListener(this);
    eql.addActionListener(this);
    

    p4.setForeground(new Color(0, 0, 235));

    p4.setFont(new Font("Dialog", Font.PLAIN, 14));

    p4.add(zero);
    p4.add(one);
    p4.add(two);
    p4.add(three);
    p4.add(four);
    p4.add(five);
    p4.add(six);
    p4.add(seven);
    p4.add(eight);
    p4.add(nine);
    p4.add(addition);
    p4.add(subtract);
    p4.add(multiply);
    p4.add(divide);
    p4.add(sqrt);
    p4.add(xOver1);
    p4.add(plusOrMinus);
    p4.add(decimal);
    p4.add(eql);



    // Add and initialize output and total

    // [JLabel and JTextArea for output]

    output.setBackground(Color.white);

    output.setForeground(Color.black);

    output.setFont(new Font("Courier", Font.BOLD, 18));



    total.setBackground(new Color(255, 255, 128));

    total.setForeground(Color.black);

    total.setFont(new Font("Courier", Font.BOLD, 14));



    p5.add("Center", scrollingArea);

    p5.add("South",  output);





    // Hook up the panels

    p2.add("North", p3);

    p2.add("Center", p4);



    // Add some spacing around outside

    p1.add("North",  p5);

    p1.add("Center", p2);



    p.setFont(new Font("Helvetica", Font.PLAIN, 6));

    p.add("North", new Label(" "));

    p.add("East",  new Label(" "));

    p.add("West",  new Label(" "));

    p.add("South", new Label(" "));

    p.add("Center", p1);



    

  }

}
