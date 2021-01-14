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

    private String diagnose_id = null;
    private String exam_id = null;
    private List<String> symptoms = null;
    private String disease_Name = null;
    private String nurse_id = null;

    public Diagnose() {

        //generateId();
    }

    public Diagnose(List<String> symptoms, String Disease_name, String exam_id, String nurse_id) {

        this.symptoms = symptoms;
        this.disease_Name = Disease_name;
        this.exam_id = exam_id;
        generateId();
    }

    private void generateId() {
        this.diagnose_id = UUID.randomUUID().toString();
    }

    public boolean checkFields() {
        if (this.diagnose_id == null || this.diagnose_id.trim().isEmpty() || this.exam_id == null || this.exam_id.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public void setDiagnoseID(String param) {
        this.diagnose_id = param;
    }

    public String getDiagnoseID() {
        return this.diagnose_id;
    }

    public void setExamID(String param) {
        this.exam_id = param;
    }

    public String getExamID() {
        return this.exam_id;
    }

    public void setSymptoms(List<String> param) {
        this.symptoms = param;
    }

    public List<String> getSymptoms() {
        return this.symptoms;
    }

    public void setDisease_Name(String param) {
        this.disease_Name = param;
    }

    public String getDisease_Name() {
        return this.disease_Name;
    }

}
