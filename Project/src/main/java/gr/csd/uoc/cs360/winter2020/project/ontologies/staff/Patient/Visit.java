/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author Tolis
 */
public class Visit {

    private String Patient_ID;
    private String Date;
    private String Cure;
    private List<String> Symptoms;
    private String Doctor_ID;
    private String Nurse_ID;
    private String Employee_ID;
    private String State;

    public Visit() {

    }

    public Visit(String date, String cure, List<String> symptoms, String doctor_id, String nurse_id,             String employee_id, String state) {

        this.Cure = cure;
        this.Date = date;
        this.Symptoms = symptoms;
        this.Date = date;
        this.Doctor_ID = doctor_id;
        this.Nurse_ID = nurse_id;
        this.Employee_ID = employee_id;

        generateId();
    }

    private void generateId() {
        this.Patient_ID = UUID.randomUUID().toString();

    }

    //not sure but might have to add d_id,n_id,e_id.
    public boolean checkFields() {
        if (Patient_ID == null || Patient_ID.trim().isEmpty()) {
        }
        return true;
    }

    public void setPatientID(String param) {
        this.Patient_ID = param;
    }

    public String getPatientID() {
        return this.Patient_ID;
    }

    public void setDate(String param) {
        this.Date = param;
    }

    public String getDate() {
        return this.Date;
    }

    public void setCure(String param) {
        this.Cure = param;
    }

    public String getCure() {
        return this.Cure;
    }

    public void set(List<String> param) {
        this.Symptoms = param;
    }

    public List<String> get() {
        return this.Symptoms;
    }

    public void setDoctorID(String param) {
        this.Doctor_ID = param;
    }

    public String getDoctorID() {
        return this.Doctor_ID;
    }

    public void setNurseID(String param) {
        this.Nurse_ID = param;
    }

    public String getNurseID() {
        return this.Nurse_ID;
    }

    public void setEmployeeID(String param) {
        this.Employee_ID = param;
    }

    public String getEmployeeID() {
        return this.Employee_ID;
    }

    public void setState(String param) {
        this.State = param;
    }

    public String getState() {
        return this.State;
    }

}
