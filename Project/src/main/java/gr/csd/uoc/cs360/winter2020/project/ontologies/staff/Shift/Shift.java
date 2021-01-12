/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Shift;

/**
 *
 * @author kiba-
 */
public class Shift {

    private String date;
    private String doctor_id;
    private String nurse_id;
    private String type;
    private String department;
    private String employee_id;

    public Shift() {

    }

    public Shift(String date, String doctor_id, String nurse_id,
            String type, String department, String employee_id) {
        this.date = date;
        this.doctor_id = doctor_id;
        this.nurse_id = nurse_id;
        this.type = type;
        this.department = department;
        this.employee_id = employee_id;
    }

    public boolean checkFields() {
        if (date == null || date.trim().isEmpty() || doctor_id == null || doctor_id.trim().isEmpty()
                || nurse_id == null || nurse_id.trim().isEmpty() || employee_id == null || employee_id.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public void setDate(String param) {
        this.date = param;
    }

    public String getDate() {
        return this.date;
    }

    public void setDoctor_ID(String param) {
        this.doctor_id = param;
    }

    public String getDoctor_ID() {
        return this.doctor_id;
    }

    public void setNurse_ID(String param) {
        this.nurse_id = param;
    }

    public String getNurse_ID() {
        return this.nurse_id;
    }

    public void setType(String param) {
        this.type = param;
    }

    public String getType() {
        return this.type;
    }

    public void setDepartment(String param) {
        this.department = param;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setEmployee_ID(String param) {
        this.employee_id = param;
    }

    public String getEmployee_ID() {
        return this.employee_id;
    }


}
