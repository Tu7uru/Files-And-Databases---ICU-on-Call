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

    private String Patient_ID;
    private String employee_id;
    private String Name;
    private String Lastname;
    private String Phone;
    private String Address;
    private String Insurance;
    private String Amka;
    private String Username;
    private String Password;
    private String Email;

    public Patient() {
        this.Name = "";
        this.Lastname = "";
        this.Phone = "";
        this.Address = "";
        this.Insurance = "";
        this.Amka = "";
        this.Username = "";
        this.Password = "";
        this.Email = "";
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


        this.Name = name;
        this.Lastname = lastname;
        this.Phone = phone;
        this.Address = address;
        this.Insurance = insurance;
        this.Amka = amka;
        this.Username = username;
        this.Password = password;
        this.Email = email;

        generateId();
    }

    private void generateId() {
        this.Patient_ID = UUID.randomUUID().toString();

    }

    @Override
    public boolean checkFields() {
        if (Username == null || Username.trim().isEmpty() || Patient_ID == null || Patient_ID.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public String getPatient_id() {
        return Patient_ID;
    }

    public void setPatient_id(String patient_ID) {
        Patient_ID = patient_ID;
    }

    @Override
    public String getUsername() {
        return this.Username;
    }

    @Override
    public String getPassword() {
        return this.Password;
    }

    @Override
    public String getEmail() {
        return this.Email;
    }

    @Override
    public void setUsername(String arg0) {
        this.Username = arg0;
    }

    @Override
    public void setPassword(String arg0) {
        this.Password = arg0;
    }

    @Override
    public void setEmail(String arg0) {
        this.Email = arg0;
    }

    public void setName(String param) {
        this.Name = param;
    }

    public String getName() {
        return this.Name;
    }

    public void setLastname(String param) {
        this.Lastname = param;
    }

    public String getLastname() {
        return this.Lastname;
    }

    public void setPhone(String param) {

        this.Phone = param;
    }

    public String getPhone() {
        return this.Phone;
    }

    public void setAddress(String param) {
        this.Address = param;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setInsurance(String param) {
        this.Insurance = param;
    }

    public String getInsurance() {
        return this.Insurance;
    }

    public void setAmka(String param) {
        this.Amka = param;
    }

    public String getAmka() {
        return this.Amka;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }
}
