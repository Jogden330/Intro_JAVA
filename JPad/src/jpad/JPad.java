package jpad;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.awt.MenuShortcut;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author Jonathan Ogden 
 * CSIC 123B
 * 0211330
 * assignment 8&9
 * saving and retreving text
 */

public class JPad extends GUIApp
                  implements ActionListener
{
    // Constructor -------------------------------------
    public JPad(String fname)
    {
        // Construct superclass, initialize fields
        super("JPad - " + fname);
        this.fname = fname;
        
        // Set layout & size ----------------------
        setLayout(new BorderLayout(5, 5));
        Toolkit tk = Toolkit.getDefaultToolkit();
        int w = tk.getScreenSize().width / 2;
        int h = tk.getScreenSize().height / 2;
        setBounds(0, 0, w, h);
        
        // Initialize & place TextArea ---------------- 
        add(ta,   "Center");
        ta.setFont(new Font("Courier", Font.PLAIN, 12));
        
        // Initialize & place status bar, toolbar, menu bar
        status.setBackground(Color.lightGray);
        add(status, "South");
        
        add(toolBar(), "North");
        
        this.setJMenuBar(menuBar());
          
        // Display initial file --------------------------
        readFile();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
    }
    
    /**
     *  Creates ToolBar object
     */
    JPanel toolBar()
    {
        JPanel p = new JPanel();
        p.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        String[] btns = {"New", "Open", "Save", "Save As..."};
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
    
    /**
     *  Creates MenuBar
     */
    JMenuBar menuBar()
    {
        JMenuBar mb = new JMenuBar();
        
        //MenuShortcut skN = new MenuShortcut(KeyEvent.VK_N);
        JMenuItem New = new JMenuItem("New");
        New.setAccelerator(KeyStroke.getKeyStroke(
                  KeyEvent.VK_N, ActionEvent.ALT_MASK));
        //New.setShortcut() ;
        New.addActionListener(this);
        
        JMenuItem Open = new JMenuItem("Open");
        Open.setAccelerator(KeyStroke.getKeyStroke(
                        KeyEvent.VK_O, ActionEvent.ALT_MASK));
        Open.addActionListener(this);
        
        JMenuItem Save = new JMenuItem("Save");
        Save.setAccelerator(KeyStroke.getKeyStroke(
                        KeyEvent.VK_S, ActionEvent.ALT_MASK));
        Save.addActionListener(this);
        
        JMenuItem SaveAs = new JMenuItem("Save As...");
        SaveAs.setAccelerator(KeyStroke.getKeyStroke(
                        KeyEvent.VK_A, ActionEvent.ALT_MASK));
        SaveAs.addActionListener(this);
               
        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setAccelerator(KeyStroke.getKeyStroke(
                        KeyEvent.VK_X, ActionEvent.ALT_MASK));
        Exit.addActionListener(this);
        
        JMenu fm = new JMenu("File");
        fm.setMnemonic(KeyEvent.VK_F);
        fm.add(New);
        fm.add(Open);
        fm.add(Save);
        fm.add(SaveAs);
        fm.addSeparator();
        fm.add(Exit);
        mb.add(fm);
        
        return mb;
    }
    
    /**
     *  Menu, Button handler
     */
    public void actionPerformed(ActionEvent ae)
    {
    	System.out.println(ae.getActionCommand());
    	
        if (ae.getActionCommand().equals("New"))
            newFile();
        else if (ae.getActionCommand().equals("Open"))
            openFile();
        else if (ae.getActionCommand().equals("Save"))
            saveFile();
        else if (ae.getActionCommand().equals("Save As..."))
            saveFileAs();
        else if (ae.getActionCommand().equals("Exit"))
            quitApp();
    }
    
    
    /**
     *  Clears TextArea
     *  Sets fname to Untitled
     */
    private void newFile()
    {
        System.out.println("New File");
        
        fname = "Untitled";
        this.setTitle("JPad - " + fname);
        ta.setText("");
        ta.requestFocus();
        /*
        1. Set fname to "Untitled"
        2. Clear ta
        3. Set focus to ta
        */
    }
    
    /**
     *  Uses FileDialog to get FileName
     *  Sets fname to directory + filename         
     *  Calls readFile()
     */
    private void openFile()
    {
        System.out.println("Open File");
        JFileChooser file = new JFileChooser();
        file.setFileFilter(new TxtFilter());
        file.showOpenDialog(this);
        File f = file.getSelectedFile();
        
        if(f != null)
        {
            
            fname = f.getPath();
            readFile();
            
        }else{
            status.setText("No File Selected");
            ta.requestFocus();
        }
        /*
        1. Open a FileDialog using *.jpad as the mask
        2. If use cancels then print a message and return
        3. Otherwise, set fname to directory+filename,
        4. Call readFile()
        */
    }
    
    /**
     *  Check if file is "Untitled"
     *  Yes? Calls SaveFileAs()
     *  No?  Calls writeFile()
     */
    private void saveFile()
    {
        System.out.println("Save File");
        if("Untitled".equals(fname))
        {
            saveFileAs();
        }else{
            writeFile();
        }
        /*
        1. If fname equals "Untitled" "call saveFileAs()
        2. Otherwise call writeFile()
        */
    }
        
    /**
     *  Use FileDialog to get name
     *  Sets fname variable
     *  Calls writeFile()
     */
    private void saveFileAs()
    {
        System.out.println("Save File As");
             JFileChooser file = new JFileChooser();
        file.setFileFilter(new TxtFilter());
        file.showSaveDialog(this);
        File f = file.getSelectedFile();
        
        
        if(f != null)
        {
            
             String filePath = f.getPath();
            if(!filePath.toLowerCase().endsWith(".txt"))
            {
                f = new File(filePath + ".jpad");
            }
            fname = f.getPath();
           
            System.out.println("Saved");
            writeFile();
            
           
        }else{
             status.setText("No File Selected");
             ta.requestFocus();
        }
        
        /*
        1. Open a FileDialog using *.jpad as the mask
        2. If user cancels then just display message in status line
        3. Otherwise, set fname to chosen name [use directory]
        4. Call writeFile();
        */
    }
    
    /**
     *  Reads current file from fname 
     *  Store result in TextArea
     *  Success/Failure displayed in status
     */
    private void readFile()
    {
        FileInputStream fis = null;
        if(fname == "Untitled")
        {
            ta.setText("");
            ta.requestFocus();
        }else{
            try 
            {
                String input = "";
                int ch;
                fis = new FileInputStream(fname);
                while((ch = fis.read()) != -1)
                {
                   input += (char) ((ch + 128) % 256);
                }
                ta.append(input);
                status.setText("File Read Successfuly");
                fname = fname;
                String filename = new File(fname).getName();
                this.setTitle("JPad - " + filename);
                
            } catch (FileNotFoundException ex)
            {
               status.setText(ex.getMessage());
            } catch (IOException ie) 
            {
                status.setText(ie.getMessage());
            } finally
                {
                try{
                    if(fis == null)
                        fis.close();
                } catch (IOException ie) {
                status.setText(ie.getMessage());
            
            }
        }
            
           
        }
        /*
        1. If fname equals "Untitled" clear ta, return
        2. Else Create a FileInputStream using fname
        3. Read the file
        4. Store the results in ta
        5. Display message in status line 
        */
    }

    /**
     *  Save current contents of TextArea 
     *  to the file named fname.
     *  Success/Failure displayed in status
     */
    private void writeFile()
    {
        FileOutputStream fout = null;
     
        
        try
        {
            String s = ta.getText();
            fout = new FileOutputStream(fname);
            for(int i = 0; i < s.length(); i++)
            {
                char ch = s.charAt(i);
                fout.write( ch + 128 );
            }
            status.setText("File Written Successfully");
            
             String filename = new File(fname).getName();
             this.setTitle("JPad - " + filename);
            
        } catch(Exception ex) {
            status.setText(ex.getMessage());
        
    } finally {
             try{
                    if(fout != null)
                        fout.close();
                } catch (IOException ie) {
                     status.setText(ie.getMessage());
                }
            
        }
        /*
        1. Create a FileOutputStream using fname
        2. Write the contents of the file to disk
        3. Display message in status line
        */
    }
    
    private void quitApp()
    {
        dispose();
        System.exit(0);
    }
    
    // Main Method -------------------------------------
    public static void main(String[] args)
    {
        if (args.length > 0) new JPad(args[0]);
        else                 new JPad("Untitled");
    }
    
    // Attributes --------------------------------------
    private JTextArea ta     = new JTextArea();
    private String   fname  = "";
    private JLabel    status = new JLabel("Ready", Label.LEFT);

 private class TxtFilter extends javax.swing.filechooser.FileFilter
 {

        @Override
        public boolean accept(File file) {
            return file.isDirectory()|| file.getName().toLowerCase().endsWith(".jpad");
        }

        @Override
        public String getDescription() {
            return ".jpad";
        }
    
 }
}