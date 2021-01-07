/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital;

import java.util.List;

/**
 *
 * @author Tolis
 */
public class Disease {

    private String Name;
    private List<String> Symptoms;
    private String Transmissibility;
    private String Incubation;
    private String Therapy_Duration;

    public Disease() {

    }

    public Disease(String name, List<String> symptoms, String Transmiss, String incub, String Therapy_Dur) {
        this.Name = name;
        this.Symptoms = symptoms;
        this.Transmissibility = Transmiss;
        this.Incubation = incub;
        this.Therapy_Duration = Therapy_Dur;
    }

    public boolean checkFields() {
        if (Name == null || Name.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public void setName(String param) {
        this.Name = param;
    }

    public String getName() {
        return this.Name;
    }

    public void setSymptoms(List<String> param) {
        this.Symptoms = param;
    }

    public List<String> getSymptoms() {
        return this.Symptoms;
    }

    public void setTransmissibility(String param) {
        this.Transmissibility = param;
    }

    public String getTransmissibility() {
        return this.Transmissibility;
    }

    public void setIncubation(String param) {
        this.Incubation = param;
    }

    public String getIncubation() {
        return this.Incubation;
    }

    public void setTherapy_Duration(String param) {
        this.Therapy_Duration = param;
    }

    public String getTherapy_Duration() {
        return this.Therapy_Duration;
    }


}
