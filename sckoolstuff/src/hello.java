import java.awt.*;        
import javax.swing.*;


public class hello extends JApplet {
    Container content;
    JLabel lblname = new JLabel("hello world");
    
    
    public void init(){
        content = getContentPane();
        content.add(lblname);
    
    }
    
    
}
