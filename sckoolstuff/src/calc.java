/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
/**
*
* @author Jonathan Ogden
*  CSIS 113B
 * 0211330
 * Final Assignment
 * A canculator
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
 

public class calc extends JApplet implements ActionListener
{

JTextArea total = new JTextArea("",5,25);

JScrollPane scrollingArea = new JScrollPane(total);

JLabel output = new JLabel(" ",JLabel.RIGHT);

double memVal = 0.0;

double curVal = 0.0;

Container content = this.getContentPane();

@Override
public void init()
{

makeButtons();
}

@Override
public void actionPerformed(ActionEvent ae)
{


JButton btn = (JButton) ae.getSource();

String arg = btn.getText();


char c = arg.charAt(0);

String s = output.getText();

if (arg.equals("Backspace")) 
{
    backSpace();
}else if (arg.equals("C")) 
{
    clearAll();
}else if (arg.equals("CE")) 
{
    clearEntry();
}else if (arg.equals("sqrt"))
{
    setCurVal(Math.sqrt(curVal));
}else if (arg.equals("1/x")) 
{
    setCurVal(1.0/curVal);
}else if (arg.equals("+/-")) 
{
    setCurVal(-curVal);
}

else if (c >= '0' && c <= '9') 
{
    setCurVal(s + c);
}

else if (c == '.')
{
if (s.indexOf(c) < 0)
{setCurVal(s + c);}
}
else
{
switch (c)
{
case '/': total.append("\n"+output.getText()+" /"+"\n");
memVal /= curVal; total.append(""+memVal); output.setText(" "); break;
    
case '*': total.append("\n"+output.getText()+" *"+"\n");
memVal *= curVal; total.append(""+memVal); output.setText(" "); break;
    
case '-':  total.append("\n"+output.getText()+" -"+"\n"); memVal -= curVal;
total.append(""+memVal); output.setText(" "); break;
    
case '+': total.append("\n"+output.getText()+" +"+"\n"); 
memVal += curVal; total.append(""+memVal); output.setText(" "); break;
    
case '%': total.append("\n"+output.getText()+" %"+"\n"); memVal %= curVal;
total.append(""+memVal); output.setText(" "); break;
    
case '=': total.append("\n"+"============="); memVal = curVal; 
total.append("\n"+output.getText()+"0.0 ="+"\n" +"0.0"+"\n"); output.setText(" "); break;
}
  


String memstr = "" + curVal + " " + c + " \n";
total.append(padText(memstr,25));
memstr += "" + memVal+ "\n";
total.append(padText(memstr,25));
// Clear the output Label
curVal = 0.0;
output.setText(" ");

}
}
void clearAll() {
total.setText("");
output.setText(" ");
curVal = memVal = 0.0;

}

void clearEntry() {

output.setText(" ");
curVal = 0.0;
}
void backSpace() {
    
String s = output.getText();
if (!s.equals(" "))
{
s = s.substring(0, s.length() - 1);

setCurVal(s);
}
}
void setCurVal(double newValue)

{
curVal = newValue;
output.setText( " "+newValue);
}

void setCurVal(String s) {
output.setText(s);
curVal = (new Double(s)).doubleValue();
}

private String padText(String s,int size)
{
String temp = size + s;
return temp.substring(temp.length()-size);
}

JPanel makeButtons()
{
content.setLayout(new BorderLayout(5,5));

content.setBackground(Color.lightGray);
JPanel p = new JPanel(new BorderLayout(5,5));
JPanel p1 = new JPanel(new BorderLayout(5,5));
JPanel p2 = new JPanel(new BorderLayout(5,5));
JPanel p3 = new JPanel(new GridLayout(1,3,5,5));
JPanel p4 = new JPanel(new GridLayout(4,5,5,5));
JPanel p5 = new JPanel(new BorderLayout(5,5));

content.add(p);

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
JButton eql = new JButton("=");
JButton mod = new JButton("%");

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
mod.addActionListener(this);
p4.setForeground(new Color(0, 0, 235));
p4.setFont(new Font("Dialog", Font.PLAIN, 14));

p4.add(seven);
p4.add(eight);
p4.add(nine);
p4.add(divide);
p4.add(sqrt);
p4.add(four);
p4.add(five);
p4.add(six);
p4.add(multiply);
p4.add(mod);
p4.add(one);
p4.add(two);
p4.add(three);
p4.add(addition);
p4.add(subtract);
p4.add(zero);
p4.add(xOver1);
p4.add(plusOrMinus);
p4.add(decimal);
p4.add(eql);


output.setOpaque(true);
Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
output.setBorder(blackBorder);
output.setBackground(Color.white);
output.setText(" ");
output.setForeground(Color.black);
output.setFont(new Font("Courier", Font.BOLD, 18));
total.setBackground(new Color(255, 255, 128));
total.setForeground(Color.black);
total.setFont(new Font("Courier", Font.BOLD, 14));
p5.add(scrollingArea, BorderLayout.CENTER);
p5.add(output, BorderLayout.SOUTH );

p2.add(p3, BorderLayout.NORTH);
p2.add(p4, BorderLayout.CENTER);

p1.add(p5,BorderLayout.NORTH);
p1.add( p2, BorderLayout.CENTER);
p.setFont(new Font("Helvetica", Font.PLAIN, 6));
p.add(new JLabel(" "), BorderLayout.NORTH );
p.add(new JLabel(" "), BorderLayout.EAST);
p.add(new JLabel(" "), BorderLayout.WEST );
p.add(new JLabel(" "), BorderLayout.SOUTH );

p.add(p1, BorderLayout.CENTER );

return p;
}

}
