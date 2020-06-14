
import java.util.EventObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class FormEvent extends EventObject {
    private String name;
    private String occupation;
    private int ageCategory;
    private String employCat;
    private String taxId;
    private boolean nigCitizen;
    private String gender;

    public FormEvent(Object source) {
        super(source);
    }
public FormEvent(Object source, String name, String occupation, int ageCat , String employCat, String taxId, boolean nigCitizen, String gender) {
        super(source);
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCat;
        this.employCat = employCat;
        this.taxId = taxId;
        this.nigCitizen = nigCitizen;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public String getTaxId() {
        return taxId;
    }

    public boolean isNigCitizen() {
        return nigCitizen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
    public int getAgeCategory(){
        return ageCategory;
        
    }
    public String getEmploymentCategory(){
        return employCat;
    }

    
}
