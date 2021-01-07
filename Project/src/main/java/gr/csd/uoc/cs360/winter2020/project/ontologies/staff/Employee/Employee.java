/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Employee;

import gr.csd.uoc.cs360.winter2020.project.User.User;

import java.util.UUID;

/**
 *
 * @author Tolis
 */
public class Employee implements User {
    String username;
    String password;
    String email;
    String employee_id;
    String name;
    String lastname;
    String phone;
    String address;
    String department;

    public Employee(String name,
                    String lastname,
                    String phone,
                    String address,
                    String department) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.department = department;

        generateId();

    }

    protected void generateId() {
        this.employee_id = UUID.randomUUID().toString();
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

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
