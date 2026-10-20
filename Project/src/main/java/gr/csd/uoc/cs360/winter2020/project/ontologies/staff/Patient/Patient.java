/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient;

import gr.csd.uoc.cs360.winter2020.project.User.User;
import java.util.UUID;

/**
 *
 * @author Tolis
 */
public class Patient implements User {

    private String patient_id;
    private String employee_id;
    private String name;
    private String lastname;
    private String phone;
    private String address;
    private String insurance;
    private String amka;
    private String username;
    private String password;
    private String email;

    public Patient() {
        this.name = "";
        this.lastname = "";
        this.phone = "";
        this.address = "";
        this.insurance = "";
        this.amka = "";
        this.username = "";
        this.password = "";
        this.email = "";
    }

    public Patient(String name,
                   String lastname,
                   String phone,
                   String address,
                   String insurance,
                   String amka,
                   String username,
                   String password,
                   String email) {


        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.insurance = insurance;
        this.amka = amka;
        this.username = username;
        this.password = password;
        this.email = email;

        generateId();
    }

    private void generateId() {
        this.patient_id = UUID.randomUUID().toString();

    }

    @Override
    public boolean checkFields() {
        if (username == null || username.trim().isEmpty() || patient_id == null || patient_id.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_ID) {
        patient_id = patient_ID;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void setUsername(String arg0) {
        this.username = arg0;
    }

    @Override
    public void setPassword(String arg0) {
        this.password = arg0;
    }

    @Override
    public void setEmail(String arg0) {
        this.email = arg0;
    }

    public void setName(String param) {
        this.name = param;
    }

    public String getName() {
        return this.name;
    }

    public void setLastname(String param) {
        this.lastname = param;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setPhone(String param) {

        this.phone = param;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setAddress(String param) {
        this.address = param;
    }

    public String getAddress() {
        return this.address;
    }

    public void setInsurance(String param) {
        this.insurance = param;
    }

    public String getInsurance() {
        return this.insurance;
    }

    public void setAmka(String param) {
        this.amka = param;
    }

    public String getAmka() {
        return this.amka;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }
}
