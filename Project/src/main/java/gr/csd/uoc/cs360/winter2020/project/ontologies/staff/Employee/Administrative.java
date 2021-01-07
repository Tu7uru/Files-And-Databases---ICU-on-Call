/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Employee;

/**
 *
 * @author Tolis
 */
public class Administrative extends Employee {
    String degree_title;

    public Administrative(String name,
                            String lastname,
                            String phone,
                            String address,
                            String department,
                            String degree_title) {
        super(name, lastname, phone, address, department);
        this.degree_title = degree_title;

        generateId();
    }

    public String getDegree_title() {
        return degree_title;
    }

    public void setDegree_title(String degree_title) {
        this.degree_title = degree_title;
    }

}
