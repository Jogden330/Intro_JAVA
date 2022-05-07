import java.awt.*;        
import javax.swing.*;


public class FirstApplet extends JApplet {
    Container content;
    JLabel lblname = new JLabel("hello world");
    
    
    public void init(){
        content = getContentPane();
        content.add(lblname);
    
    }
    
    
}
