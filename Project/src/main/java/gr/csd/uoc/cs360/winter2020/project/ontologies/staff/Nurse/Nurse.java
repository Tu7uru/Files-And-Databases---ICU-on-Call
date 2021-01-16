package gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Nurse;

import gr.csd.uoc.cs360.winter2020.project.User.User;

import java.util.UUID;

public class Nurse implements User {

    private String username = null;
    private String password = null;
    private String email = null;
    private String nurse_id = null;
    private String employee_id = null;
    private String name = null;
    private String lastname = null;
    private String phone = null;
    private String address = null;
    private Spec spec = null;

    public Nurse() {
        this.username = "";
        this.password = "";
        this.email = "";
        this.name = "";
        this.lastname = "";
        this.phone = "";
        this.address = "";

    }

    public Nurse(String username,
                   String password,
                   String email,
                   String name,
                   String lastname,
                   String phone,
                   String address,
                   String employee_id,
                   Spec spec
    ) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.spec = spec;
        this.employee_id = employee_id;

        generateId();

    }

    private void generateId() {
        setNurse_id(UUID.randomUUID().toString());
    }

    public String getNurse_id() {
        return nurse_id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setNurse_id(String nurse_id) {
        this.nurse_id = nurse_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean checkFields() {
        if(username == null || username.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public enum Spec {
        NEUROLOGIST,
        HAEMATOLOGIST,
        GP,
        SURGEON
    }

    public Spec getSpec() {
        return spec;
    }

    public void setSpec(Spec spec) {
        this.spec = spec;
    }


    public static Spec fromString(String sp) {
        sp = sp.toLowerCase();
        if(sp.equals("neurologist")) {
            return Spec.NEUROLOGIST;
        } else if(sp.equals("general_practitioner") || sp.equals("gp")) {
            return Spec.GP;
        } else if (sp.equals("haematologist")) {
            return Spec.HAEMATOLOGIST;
        } else {
            return  Spec.SURGEON;
        }
    }
}
