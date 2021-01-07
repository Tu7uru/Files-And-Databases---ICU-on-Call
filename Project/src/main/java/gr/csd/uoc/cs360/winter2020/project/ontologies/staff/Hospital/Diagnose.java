/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author Tolis
 */
public class Diagnose {

    private String Diagnose_id;
    private String Exam_id;
    private List<String> Symptoms;
    private String Disease_Name;
    private String Nurse_id;

    public Diagnose() {

    }

    public Diagnose(List<String> symptoms, String Disease_name, String exam_id, String nurse_id) {

        this.Symptoms = symptoms;
        this.Disease_Name = Disease_name;
        this.Exam_id = exam_id;
        this.Nurse_id = nurse_id;
        generateId();
    }

    private void generateId() {
        this.Diagnose_id = UUID.randomUUID().toString();
    }

    public boolean checkFields() {
        if (this.Diagnose_id == null || this.Diagnose_id.trim().isEmpty() || this.Exam_id == null || this.Exam_id.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public void setDiagnoseID(String param) {
        this.Diagnose_id = param;
    }

    public String getDiagnoseID() {
        return this.Diagnose_id;
    }

    public void setExamID(String param) {
        this.Exam_id = param;
    }

    public String getExamID() {
        return this.Exam_id;
    }

    public void setSymptoms(List<String> param) {
        this.Symptoms = param;
    }

    public List<String> getSymptoms() {
        return this.Symptoms;
    }

    public void setDisease_Name(String param) {
        this.Disease_Name = param;
    }

    public String getDisease_Name() {
        return this.Disease_Name;
    }

    public void setNurseID(String param) {
        this.Nurse_id = param;
    }

    public String getNurseID() {
        return this.Nurse_id;
    }

}
