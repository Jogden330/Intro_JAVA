/*
 * @author Jonathan Ogden 
 * CSIC 123B
 * 0211330
 * assignment 14-15
 * using reguler expressions to pars Html and fined palindromes  
 */

package lab.pkg14.pkg15;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab1415 extends JFrame implements ActionListener {

    JFileChooser file = new JFileChooser();
    TextArea taoutput = new TextArea();
    TextArea taPalindromeoutput = new TextArea();
    JButton btn = new JButton("Get A File");

    public Lab1415(String tital, int width, int hight) {
        this.setTitle(tital);
        this.setSize(width, hight);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        taoutput.setColumns(20);
        taoutput.setRows(20);
        add(taoutput, BorderLayout.CENTER);
        taPalindromeoutput.setColumns(15);
        taPalindromeoutput.setRows(20);
        add(taPalindromeoutput, BorderLayout.EAST);
        add(btn, BorderLayout.SOUTH);
        btn.addActionListener(this);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Lab1415 l1415 = new Lab1415("Gui app", 400, 400);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        openFile();
    }

    private void openFile() {
        String path;

        file.setFileFilter(new TxtFilter());
        file.showOpenDialog(this);
        File f = file.getSelectedFile();

        if (f != null) {
            path = f.getPath();
            readFile(path);

        } else {
            System.out.println("No File Selected");

        }
    }

    private void readFile(String path) {

        BufferedReader reader = null;
        if ("".equals(path)) {
            System.out.println("i made it here");
            taoutput.setText("");
            taoutput.requestFocus();
        } else {
            try {
                System.out.println("it is trying to work");
                reader = new BufferedReader(new FileReader(path));
                StringBuilder inputBuilder = new StringBuilder("");
                StringBuilder inputPalindromeBuilder = new StringBuilder("");
                String input;

                Pattern pattern = Pattern.compile("<B>(.+?)\\S</B>");
                Pattern PalindromePattern = Pattern.compile("^(.)(.)\\S\\2\\1", Pattern.CASE_INSENSITIVE);
                Matcher matcher;
                Matcher PalindromeMatcher;


                while ((input = reader.readLine()) != null) {
                    matcher = pattern.matcher(input);
                    while (matcher.find()) {
                        inputBuilder.append(matcher.group(1))
                                .append("\n");


                        PalindromeMatcher = PalindromePattern.matcher(matcher.group(1));

                        while (PalindromeMatcher.find()) {
                            inputPalindromeBuilder.append(PalindromeMatcher.group())
                                    .append("\n");

                        }
                    }

                }

                taoutput.setText(inputBuilder.toString());
                taPalindromeoutput.setText(inputPalindromeBuilder.toString());


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

    private class TxtFilter extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File file) {
            return file.isDirectory() || file.getName().toLowerCase().endsWith(".html");
        }

        @Override
        public String getDescription() {
            return ".html";
        }
    }
}