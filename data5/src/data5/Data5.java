/*
 * @author Jonathan Ogden 
 * CSIC 211
 * 0211330
 * assignment 5
 * a gui that uses regular expressins to extraced text and place it into a tree  
 */

package data5;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

public class Data5 extends JFrame implements ActionListener {

    AVL<String> avl = new AVL();
    JFileChooser file = new JFileChooser();
    TextArea taoutput = new TextArea();
    JButton btn = new JButton("Get A File");
   /*
     Function: Data5 
     Author: jonatan Ogden
     Description: an constructor used to set a gui 
     Inputs: a string that sets the titial and two ints that set the size of the gui
     Outputs: N/A
     */
    public Data5(String tital, int width, int hight) {
        this.setTitle(tital);
        this.setSize(width, hight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        taoutput.setColumns(20);
        taoutput.setRows(20);
        add(taoutput, BorderLayout.CENTER);


        add(btn, BorderLayout.SOUTH);
        btn.addActionListener(this);
        this.setVisible(true);
    }
   /*
     Function: main
     Author: jonatan Ogden
     Description: a method that calls the Data5 construtor 
     Inputs: N/A
     Outputs: N/A
     */
    public static void main(String[] args) {
        Data5 D5 = new Data5("Gui app", 400, 400);
    }
       /*
     Function: actionPerformed
     Author: jonatan Ogden
     Description: a method that calls the openFile mehtod when an ation is preformenf
     Inputs: an ActionEvent that is activated by the user
     Outputs: N/A
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        openFile();
    }
   /*
     Function: openFile
     Author: jonatan Ogden
     Description: a method that fineds a file to be opend by calling a JFileChooser
     Inputs: N/a
     Outputs: N/A
     */
    private void openFile() {
        String path;

        file.setFileFilter(new Data5.TxtFilter());
        file.showOpenDialog(this);
        File f = file.getSelectedFile();

        if (f != null) {
            path = f.getPath();
            readFile(path);

        } else {
            System.out.println("No File Selected");

        }
    }
   /*
     Function: openFile
     Author: jonatan Ogden
     Description: a method that that extracts text and puts it on a tree
     Inputs: a string that is the path to the file to be read from
     Outputs: N/A
     */
    private void readFile(String path) {

        BufferedReader reader = null;
        if ("".equals(path)) {

            taoutput.setText("");
            taoutput.requestFocus();
        } else {
            try {

                reader = new BufferedReader(new FileReader(path));

                String input;

                Pattern pattern = Pattern.compile("([A-Za-z//']{2,20})");

                Matcher matcher;


                while ((input = reader.readLine()) != null) {
                    matcher = pattern.matcher(input);
                    while (matcher.find()) {
                        if (!avl.contains(this.strAscii(matcher.group(1).trim()))) {
                            avl.insert(this.strAscii(matcher.group(1).trim()), matcher.group(1).trim());
                        }

                    }
                }

                showTree(avl.getRoot());



                reader.close();
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ie) {
                System.out.println(ie.getMessage());
            } finally {
                try {
                    if (reader == null) {
                        reader.close();
                    }
                } catch (IOException ie) {
                    System.out.println(ie.getMessage());
                }

            }
        }

    }   
    /*
     Function: strAscii
     Author: jonatan Ogden
     Description: terns a string into an int so that a tree can easaly sourt it
     Inputs: a string to be converted
     Outputs:an int that represents the combined ascii value of a string
     */
    private int strAscii(String s) {

        int ascii = 0;
        for (int i = 0; i < s.length(); i++) {
            ascii += (int) s.charAt(i);
        }
        return ascii;
    }
   /*
     Function: showTree
     Author: jonatan Ogden
     Description: a method that sets the contents of a tree to a TextArea
     Inputs: a node that is the starting positon on a tree
     Outputs:N/a
     */
    public void showTree(node n) {
        if (n != null) {
            this.taoutput.append(" " + n.getInfo() + " " + n.getNumb() + "\n");
            showTree(n.getLeft());
            showTree(n.getRight());
        }
    }
 /*
     Function: TxtFilter
     Author: jonatan Ogden
     Description: a class that filters the files able to be chossen
     Inputs: a string that is the path to the file to be read from
     Outputs: N/A
     */
    private class TxtFilter extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File file) {
            return file.isDirectory() || file.getName().toLowerCase().endsWith(".txt");
        }

        @Override
        public String getDescription() {
            return ".txt";
        }
    }


}