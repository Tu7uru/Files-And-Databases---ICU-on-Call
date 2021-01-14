/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;

import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital.Medication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 *
 * @author Tolis
 */
public class MedicationDB {

    public static List<Medication> getMedications() throws ClassNotFoundException {
        List<Medication> medications = new ArrayList<>();

        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM medication");

            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                Medication med = new Medication();
                med.setDosage(res.getString("dosage"));
                med.setExp_Date(res.getString("exp_date"));
                med.setMed_ID(res.getString("med_id"));
                med.setName(res.getString("name"));
                med.setType(res.getString("type"));
                med.setUse_for(res.getString("use_for"));

                medications.add(med);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicationDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return medications;
    }

    public static Medication getMedication(String med_id) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        Medication med = null;

        try {

            con = CS360DB.getConnection();

            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("SELECT * FROM medication ")
                    .append(" WHERE ")
                    .append(" med_id = ").append("'").append(med_id).append("';");

            stmt.execute(insQuery.toString());

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {
                med = new Medication();
                med.setDosage(res.getString("dosage"));
                med.setExp_Date(res.getString("exp_date"));
                med.setMed_ID(med_id);
                med.setName(res.getString("name"));
                med.setType(res.getString("type"));
                med.setUse_for(res.getString("use_for"));
            }
        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(MedicationDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }

        return med;
    }

    public static String getMedicationId(String type) {
        Statement stmt = null;
        Connection con = null;
        String id = null;


        try {

            con = CS360DB.getConnection();

            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("SELECT med_id FROM medication ")
                    .append(" WHERE ")
                    .append(" use_for = ").append("'").append(type).append("' ORDER BY exp_date;");

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {
                id = res.getString("med_id");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            // Log exception
            Logger.getLogger(MedicationDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }
        return id;
    }

    public static Medication getMedicationByName(String name) throws ClassNotFoundException {
            Statement stmt = null;
            Connection con = null;
            Medication med = null;

            try {
                StringBuilder insQuery = new StringBuilder();

                insQuery.append("SELECT * FROM medication ")
                        .append(" WHERE ")
                        .append(" name = ").append("'").append(name).append("';");


                stmt.execute(insQuery.toString());

                ResultSet res = stmt.getResultSet();



                if (res.next() == true) {
                    med = new Medication();
                    med.setDosage(res.getString("dosage"));
                    med.setExp_Date(res.getString("exp_date"));
                    med.setMed_ID(res.getString("med_id"));
                    med.setName(res.getString("name"));
                    med.setType(res.getString("type"));
                    med.setUse_for(res.getString("use_for"));
                }
        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(MedicationDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }

        return med;
    }

    public static void addMedication(Medication med) throws ClassNotFoundException {

        try {
            med.checkFields();

        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(MedicationDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        Connection con = null;
        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO ")
                    .append(" medication (med_id, name, type, dosage, use_for, exp_date) ")
                    .append(" VALUES (")
                    .append("'").append(med.getMed_ID()).append("',")
                    .append("'").append(med.getName()).append("',")
                    .append("'").append(med.getType()).append("',")
                    .append("'").append(med.getDosage()).append("',")
                    .append("'").append(med.getUse_for()).append("',")
                    .append("DATETIME '").append(med.getExp_Date()).append("');");

            PreparedStatement stmtIns = con.prepareStatement(insQuery.toString());
            stmtIns.executeUpdate();

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(MedicationDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }
    }

    /**
     * Close db connection
     *
     * @param stmt
     * @param con
     */
    private static void closeDBConnection(Statement stmt, Connection con) {
        // Close connection
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(MedicationDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(MedicationDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
