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

    private String name = null;
    private List<String> symptoms = null;
    private String transmissibility = null;
    private String incubation = null;
    private String therapy_duration = null;

    public Disease() {

    }

    public Disease(String name, List<String> symptoms, String Transmiss, String incub, String Therapy_Dur) {
        this.name = name;
        this.symptoms = symptoms;
        this.transmissibility = Transmiss;
        this.incubation = incub;
        this.therapy_duration = Therapy_Dur;
    }

    public boolean checkFields() {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public void setName(String param) {
        this.name = param;
    }

    public String getName() {
        return this.name;
    }

    public void setSymptoms(List<String> param) {
        this.symptoms = param;
    }

    public List<String> getSymptoms() {
        return this.symptoms;
    }

    public void setTransmissibility(String param) {
        this.transmissibility = param;
    }

    public String getTransmissibility() {
        return this.transmissibility;
    }

    public void setIncubation(String param) {
        this.incubation = param;
    }

    public String getIncubation() {
        return this.incubation;
    }

    public void setTherapy_Duration(String param) {
        this.therapy_duration = param;
    }

    public String getTherapy_Duration() {
        return this.therapy_duration;
    }


}
