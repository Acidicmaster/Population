
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class FormPanel extends JPanel{
    
    private JLabel nameLabel;
    private JLabel ocpLabel;
    private JTextField nameTextField;
    private JTextField ocpTextField;
    private JButton okbtn;
    private FormListener formListener;
    private JList ageList;
    private JComboBox employCombo;
    private JCheckBox citizenCheck;
    private JTextField taxField;
    private JLabel taxLabel;
    
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private ButtonGroup genderGroup;
    public FormPanel(){
        Dimension dim = getPreferredSize();
        dim.width = 245;
        setPreferredSize(dim);
        
        nameLabel = new JLabel("Name: ");
        ocpLabel = new JLabel("Occupation: ");
        nameTextField = new JTextField(10);
        ocpTextField = new JTextField(10);
        ageList = new JList();
        employCombo = new JComboBox();
        citizenCheck = new JCheckBox();
        taxField = new JTextField(10);
        taxLabel = new JLabel("Tax Id: ");
        
        //
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        
        
        maleRadio.setSelected(true);
        maleRadio.setActionCommand("Male");
        femaleRadio.setActionCommand("Female");
        /// Setting Riadio bios
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        
        
        // Set Tax Id//
        taxLabel.setEnabled(false);
        taxField.setEnabled(false);
        
        citizenCheck.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                boolean isTicked = citizenCheck.isSelected();
                taxField.setEnabled(isTicked);
                taxLabel.setEnabled(isTicked);
            }
            
            
            
        });
        
        
        ////// setting List Box ////
        
        DefaultListModel ageModel = new DefaultListModel();
        
        nameLabel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
       
        ageModel.addElement(new AgeCategory(0,"Under 18"));
        ageModel.addElement(new AgeCategory(1,"18 - 60"));
        ageModel.addElement(new AgeCategory(2,"Above 60"));
        ageList.setModel(ageModel);
        ageList.setSize(new Dimension(50,50));
       ageList.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
       ageList.setSelectedIndex(1);
       
       ///// Setting Combo Box///////
       
       DefaultComboBoxModel employModel = new DefaultComboBoxModel();
       employModel.addElement("employed");
       employModel.addElement("Self-employed");
       employModel.addElement("Unemployed");
       employCombo.setModel(employModel);
       employCombo.setSelectedIndex(0);
       employCombo.setEditable(true);
       
       
        
        
        okbtn = new JButton("OK");
        okbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String name = nameTextField.getText();
               String occupation = ocpTextField.getText();
               AgeCategory ageCat = (AgeCategory)ageList.getSelectedValue();
               String employCat = (String)employCombo.getSelectedItem();
               String taxId = taxField.getText();
               boolean nigCitizen = citizenCheck.isSelected();
               
               String gender = (String)genderGroup.getSelection().getActionCommand();
               System.out.println(ageCat);
               FormEvent ev = new FormEvent(this,name,occupation,ageCat.getId(),employCat, taxId,nigCitizen, gender);
               
              
               if (formListener != null) {
                   
                   formListener.FormEventOccured(ev);
                   
               }
               
            }
            
        });
        
        
        
        TitledBorder innerBorder = BorderFactory.createTitledBorder("Add Person");
        javax.swing.border.Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
        setBorder(BorderFactory.createCompoundBorder(innerBorder, outerBorder));
        
        
        
       
        LayoutComponents();
        
        
    }
    public void LayoutComponents(){
        
         setLayout(new GridBagLayout());
        
        GridBagConstraints gc = new GridBagConstraints();
        
        
        ////////// First Row///
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 0;
        
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        
        
        add(nameLabel,gc);
        
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        
        add(nameTextField,gc);
        
        ////// Second Row//////
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.1;
        
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(ocpLabel,gc);
        
        gc.gridy = 1;
        gc.gridx = 1;
        
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(ocpTextField,gc);
        
        ////// Third Row//////
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.2;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(new JLabel("Age"),gc);
        
        
        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(ageList,gc);
        
       
        /////// fifth Row /////////////////
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.2;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(new JLabel("Employment:"),gc);
        
        gc.gridx = 1;
        
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        
        add(employCombo,gc);
         /////// Sixth Row /////////////////
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.2;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(new JLabel("Nigerian: "),gc);
        
        gc.gridx = 1;
        
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        
        add(citizenCheck,gc);
        ////// next line/////
        
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.2;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(taxLabel,gc);
        
        gc.gridx = 1;
        
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        
        add(taxField,gc);
        
        ////// Radio Display/////
        
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.05;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(new JLabel("Gender: "),gc);
        
        gc.gridx = 1;
        
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        
        add(maleRadio,gc);
        
        ////// next line/////
        
        gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 0.05;
        
       
        gc.gridx = 1;
        
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        
        add(femaleRadio,gc);
         ////// Next Row/////
         gc.gridy++;
        gc.weightx = 1;
        gc.weighty = 1.0;
    
        gc.gridx = 1;
        
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.insets = new Insets(0,0,0,0);
        add(okbtn,gc);
        
        
        
    }
    public void setFormListener(FormListener listener){
      this.formListener = listener;  
    }
    
    
}
class AgeCategory {
    private int id;
    private String text;
    public AgeCategory(int id, String text){
        this.id = id;
        this.text = text;
    }
    public String toString(){
        return text;
    }
    public int getId(){
        return id;
    }
}