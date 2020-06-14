
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class MainFrame extends JFrame {
    
    
   // private JTextArea textArea;
    private TextPanel textPanel;
    private JButton btn;
    private Toolbar toolbar;
    private FormPanel formPanel;
    
    public MainFrame() {
        
    super("my first App");
    setLayout(new BorderLayout());
    
    textPanel = new TextPanel();
    toolbar = new Toolbar();
    btn = new JButton("GO");
    formPanel = new FormPanel();
    
    setJMenuBar(createMenuBar());
    
    //toolbar.setTextPanel(textPanel);
    toolbar.setStringListener(new StringListener() {

        public void textEmitted(String text) {
         textPanel.appendText(text);
        }
    
    });
    
    formPanel.setFormListener(new FormListener() {
        public void FormEventOccured(FormEvent e) {
            String name = e.getName();
            String occupation = e.getOccupation();
            int ageCat = e.getAgeCategory();
            String employCat = e.getEmploymentCategory();
            textPanel.appendText(name + " : " + occupation + " : " + ageCat +" : "+employCat+"\n");
            
            System.out.println(e.getGender());
        }
    });
    
    
    
    
   /* btn.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent e) {
           //textArea.append("Hello \n");
            textPanel.appendText("hello\n");
        }
    
    
    
    });**/
    add(formPanel, BorderLayout.WEST);
    add(toolbar, BorderLayout.NORTH);
    add(textPanel, BorderLayout.CENTER);
    add(btn, BorderLayout.SOUTH);
        
        
        
        
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    
}

    private JMenuBar createMenuBar() {
         JMenuBar menuBar = new JMenuBar();
        
        
        
        
        JMenu fileMenu = new JMenu("File");
        JMenuItem exportDataItem = new JMenuItem("Ëxportdata...");
        JMenuItem importDataItem = new JMenuItem("Importdata...");
        JMenuItem exit = new JMenuItem("exit");
        
        
        
        fileMenu.add(exportDataItem);
        fileMenu.add(importDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exit);
        
        JMenu windowMenu = new JMenu("Window");
        JMenu showMenu = new JMenu("Show");
        
        JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person form");
        showFormItem.setSelected(true);
        
        showMenu.add(showFormItem);
        windowMenu.add(showMenu);
        

        
        
        menuBar.add(fileMenu);
        menuBar.add(windowMenu);
        
        
        showFormItem.addActionListener(new ActionListener(){

             public void actionPerformed(ActionEvent e) {
                 
                 JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem)e.getSource();
                 formPanel.setVisible(menuItem.isSelected());
                  
             }
            
        });
        
        
        return menuBar;
        
    }
    
}
