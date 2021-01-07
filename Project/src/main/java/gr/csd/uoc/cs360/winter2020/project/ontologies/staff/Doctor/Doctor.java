package gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Doctor;

import gr.csd.uoc.cs360.winter2020.project.User.User;

import java.util.UUID;

public class Doctor implements User{

    private String username = null;
    private String password = null;
    private String email = null;
    private String doctor_id = null;
    private String name = null;
    private String lastname = null;
    private String phone = null;
    private String address = null;
    private Specialization spec = null;

    public Doctor() {
        this.username = "";
        this.password = "";
        this.email = "";
        this.name = "";
        this.lastname = "";
        this.phone = "";
        this.address = "";

        generateId();
    }

    public Doctor(String username,
              String password,
              String email,
              String name,
              String lastname,
              String phone,
              String address,
              Specialization spec
    ) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.spec = spec;

        generateId();

    }

    private void generateId() {
        setDoctor_id(UUID.randomUUID().toString());
    }


    @Override
    public boolean checkFields() {
        if (username == null || username.trim().isEmpty() || doctor_id == null || doctor_id.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    public Specialization getSpec() {
        return spec;
    }

    public void setSpec(Specialization spec) {
        this.spec = spec;
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

    public String getDoctor_id() {
        return doctor_id;
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

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
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

    enum Specialization {
        CARDIOLOGIST,
        HAEMATOLOGIST,
        GP,
        SURGEON,
        NEUROLOGIST
    }
}

