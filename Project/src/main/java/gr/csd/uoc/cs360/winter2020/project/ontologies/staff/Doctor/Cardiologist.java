/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Doctor;

import gr.csd.uoc.cs360.winter2020.project.User.User;

/**
 *
 * @author Tolis
 */
public class Cardiologist implements Doctor {
    private String username = null;
    private String password = null;
    private String email = null;
    private String doctor_id = null;
    private String name = null;
    private String lastname = null;
    private String phone = null;
    private String address = null;

    public Cardiologist(String username,
                        String password,
                        String email,
                        String name,
                        String lastname,
                        String phone,
                        String address
                        ) {
        setUsername(username);

    }

    @Override
    public boolean checkFields() {
        return false;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setPassword(String password) {

    }

    @Override
    public void setEmail(String email) {

    }
}
