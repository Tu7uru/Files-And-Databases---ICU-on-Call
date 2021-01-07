/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;

import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Doctor.Doctor;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient.Patient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tolis
 */
public class PatientDB {
    /**
     * Get all patients
     *
     * @return List of doctors
     */
    public static List<Patient> getPatients() throws ClassNotFoundException {
        List<Patient> patiens = new ArrayList<>();

        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM cardiologist,haematologist,surgeon,neurologist,general_pracitioner");

            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            while(res.next() == true) {
                Patient pat = new Patient();
                pat.setUsername(res.getString("username"));
                pat.setPatient_id(res.getString("doctor_id"));
                pat.setEmail(res.getString("email"));
                pat.setPassword(res.getString("password"));
                pat.setName(res.getString("name"));
                pat.setLastname(res.getString("lastname"));
                pat.setPhone(res.getString("phone"));
                pat.setAddress(res.getString("address"));
                pat.setSpec(Doctor.fromString(res.getString("spec")));
                patiens.add(pat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiagnoseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return patiens;
    }
}
