
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */


public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){

          
            public void run() {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            new MainFrame();
                //JFrame frame = new JFrame("my first app");
            
            }
        });
        
    

    
    }
}
