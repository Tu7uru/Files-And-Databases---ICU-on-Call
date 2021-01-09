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

    private String med_id = null;
    private String name = null;
    private String type = null;
    private String dosage = null;
    private String use_for = null;
    private String exp_date = null;

    public Medication() {
        //generateId();
    }

    public Medication(String name, String type, String dosage, String use_for, String exp_date) {

        this.name = name;
        this.type = type;
        this.dosage = dosage;
        this.use_for = use_for;
        this.exp_date = exp_date;

        generateId();
    }

    private void generateId() {
        this.med_id = UUID.randomUUID().toString();

    }

    public boolean checkFields() {

        if (med_id == null || med_id.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public void setMed_ID(String param) {
        this.med_id = param;
    }

    public String getMed_ID() {
        return this.med_id;
    }

    public void setName(String param) {
        this.name = param;
    }

    public String getName() {
        return this.name;
    }

    public void setType(String param) {
        this.type = param;
    }

    public String getType() {
        return this.type;
    }

    public void setDosage(String param) {
        this.dosage = param;
    }

    public String getDosage() {
        return this.dosage;
    }

    public void setUse_for(String param) {
        this.use_for = param;
    }

    public String getUse_for() {
        return this.use_for;
    }

    public void setExp_Date(String param) {
        this.exp_date = param;
    }

    public String getExp_Date() {
        return this.exp_date;
    }

}
