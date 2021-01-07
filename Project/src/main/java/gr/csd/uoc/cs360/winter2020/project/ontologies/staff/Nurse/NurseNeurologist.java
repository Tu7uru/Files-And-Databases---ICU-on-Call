/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Nurse;

import java.util.UUID;

/**
 *
 * @author Tolis
 */
public class NurseNeurologist implements Nurse{

    private String username = null;
    private String password = null;
    private String email = null;
    private String nurse_id = null;
    private String name = null;
    private String lastname = null;
    private String phone = null;
    private String address = null;

    public NurseNeurologist(String username,
                   String password,
                   String email,
                   String name,
                   String lastname,
                   String phone,
                   String address
    ) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;

        generateId();

    }

    private void generateId() {
        setNurse_id(UUID.randomUUID().toString());
    }


    @Override
    public String getNurse_id() {
        return nurse_id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLastname() {
        return lastname;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setNurse_id(String nurse_id) {
        this.nurse_id = nurse_id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean checkFields() {
        if(username == null || username.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

}