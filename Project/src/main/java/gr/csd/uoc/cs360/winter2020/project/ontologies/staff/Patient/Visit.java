/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient;

import java.util.List;

/**
 *
 * @author Tolis
 */
public class Visit {

    private String patient_id = null;
    private String date = null;
    private String cure = null;
    private List<String> symptoms = null;
    private List<String> diseases = null;
    private String doctor_id = null;
    private String nurse_id = null;
    private String employee_id = null;
    private String state = null;

    public Visit() {

    }

    public Visit(String patient_id, String date, String cure, List<String> symptoms, List<String> diseases, String doctor_id, String nurse_id, String employee_id, String state) {

        this.patient_id = patient_id;
        this.cure = cure;
        this.date = date;
        this.symptoms = symptoms;
        this.diseases = diseases;
        this.doctor_id = doctor_id;
        this.nurse_id = nurse_id;
        this.employee_id = employee_id;
        this.state = state;
    }

    //not sure but might have to add d_id,n_id,e_id.
    public boolean checkFields() {
        if (patient_id == null || patient_id.trim().isEmpty() || date == null || date.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public void setPatientID(String param) {
        this.patient_id = param;
    }

    public String getPatientID() {
        return this.patient_id;
    }

    public void setDate(String param) {
        this.date = param;
    }

    public String getDate() {
        return this.date;
    }

    public void setCure(String param) {
        this.cure = param;
    }

    public String getCure() {
        return this.cure;
    }

    public void setSymptoms(List<String> param) {
        this.symptoms = param;
    }

    public List<String> getSymptoms() {
        return this.symptoms;
    }

    public void setDiseasesHistory(List<String> param) {
        this.diseases = param;
    }

    public List<String> getDiseasesHistory() {
        return this.diseases;
    }

    public void setDoctorID(String param) {
        this.doctor_id = param;
    }

    public String getDoctorID() {
        return this.doctor_id;
    }

    public void setNurseID(String param) {
        this.nurse_id = param;
    }

    public String getNurseID() {
        return this.nurse_id;
    }

    public void setEmployeeID(String param) {
        this.employee_id = param;
    }

    public String getEmployeeID() {
        return this.employee_id;
    }

    public void setState(String param) {
        this.state = param;
    }

    public String getState() {
        return this.state;
    }

}
