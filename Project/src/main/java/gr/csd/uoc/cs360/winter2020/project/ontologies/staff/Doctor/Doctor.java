package gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Doctor;

import gr.csd.uoc.cs360.winter2020.project.User.User;

public interface Doctor extends User{

    public String getDoctor_id();

    public String getName();

    public String getLastname();

    public String getPhone();

    public String getAddress();

    public void setDoctor_id(String doctor_id);

    public void setName(String name);

    public void setLastname(String lastname);

    public void setPhone(String phone);

    public void setAddress(String address);

}
