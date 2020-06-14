
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Toolbar extends JPanel implements ActionListener {
    private JButton Hellobtn;
    private JButton goodbyebtn;
    private StringListener textListener;
    //private TextPanel textPanel;
    
    public Toolbar(){
        
        setBorder(BorderFactory.createLineBorder(Color.BLUE));
        
        Hellobtn = new JButton("Hello");
        goodbyebtn = new JButton("Goodbye");
    
        Hellobtn.addActionListener(this);
        goodbyebtn.addActionListener(this);
        
        setLayout(new FlowLayout(FlowLayout.LEFT));
       
        
        add(Hellobtn);
        add(goodbyebtn);
        
   
      
        
            
        

   
    
        
    }
     /** public void setTextPanel(TextPanel textPanel){
          this.textPanel = textPanel;*/
    
    public void setStringListener(StringListener listener){
        this.textListener = listener;
          
          
      }

    @Override
    public void actionPerformed(ActionEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        JButton clicked = (JButton)e.getSource();
        if ( clicked == Hellobtn){
            //System.out.println("Hello");
            //textPanel.appendText("Hello\n");
            if(textListener !=  null){
                textListener.textEmitted("Hello\n");
            }
            
        }
        else if (clicked == goodbyebtn){
          //  System.out.println("Goodbye");
             //textPanel.appendText("Goodbye\n");
            if(textListener !=  null){
                textListener.textEmitted("Goodbye\n");
            }
            
            
        }
    }
    
}
