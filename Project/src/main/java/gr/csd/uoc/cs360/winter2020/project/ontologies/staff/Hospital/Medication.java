/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital;

import java.util.UUID;

/**
 *
 * @author Tolis
 */
public class Medication {

    private String Med_ID;
    private String Name;
    private String Type;
    private String Dosage;
    private String Use_for;
    private String Exp_Date;

    public Medication() {

    }

    public Medication(String name, String type, String dosage, String use_for, String exp_date) {

        this.Name = name;
        this.Type = type;
        this.Dosage = dosage;
        this.Use_for = use_for;
        this.Exp_Date = exp_date;

        generateId();
    }

    private void generateId() {
        this.Med_ID = UUID.randomUUID().toString();

    }

    public boolean checkFields() {

        if (Med_ID == null || Med_ID.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public void setMed_ID(String param) {
        this.Med_ID = param;
    }

    public String getMed_ID() {
        return this.Med_ID;
    }

    public void setName(String param) {
        this.Name = param;
    }

    public String getName() {
        return this.Name;
    }

    public void setType(String param) {
        this.Type = param;
    }

    public String getType() {
        return this.Type;
    }

    public void setDosage(String param) {
        this.Dosage = param;
    }

    public String getDosage() {
        return this.Dosage;
    }

    public void setUse_for(String param) {
        this.Use_for = param;
    }

    public String getUse_for() {
        return this.Use_for;
    }

    public void setExp_Date(String param) {
        this.Exp_Date = param;
    }

    public String getExp_Date() {
        return this.Exp_Date;
    }

}
