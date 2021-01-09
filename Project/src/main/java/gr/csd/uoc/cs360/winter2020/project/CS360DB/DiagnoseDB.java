/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;

import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital.Diagnose;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class DiagnoseDB {
    /**
     * Get all Diagnoses
     *
     * @return List of diagnoses
     * @throws java.lang.ClassNotFoundException
     */
    public static List<Diagnose> getDiagnoses() throws ClassNotFoundException {
        List<Diagnose> diagnoses = new ArrayList<>();
        List<String> symptoms = new ArrayList<>();
        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM diagnose;");

            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                Diagnose diag = new Diagnose();
                diag.setDiagnoseID(res.getString("diagnose_id"));
                diag.setDisease_Name(res.getString("disease_name"));
                diag.setExamID(res.getString("exam_id"));
                diag.setNurseID(res.getString("nurse_id"));

                StringBuilder querySymp = new StringBuilder();

                querySymp.append("SELECT * FROM diagnose_symptoms ")
                        .append(" WHERE ")
                        .append(" diagnose_id = ").append("'").append(res.getString("diagnose_id")).append("';");

                stmt.execute(querySymp.toString());

                ResultSet res2 = stmt.getResultSet();
                symptoms.clear();
                while (res2.next() == true) {

                    symptoms.add(res2.getString("symptoms"));//this might have to become array because symptoms is an arraylist.
                }

                diag.setSymptoms(symptoms);

                diagnoses.add(diag);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiagnoseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return diagnoses;
    }

    public static Diagnose getDiagnose(String diagnose_id, String exam_id) throws ClassNotFoundException {

        Statement stmt = null;
        Connection con = null;
        List<String> symptoms = new ArrayList<>();
        Diagnose diag = null;

        try {

            con = CS360DB.getConnection();

            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("SELECT * FROM diagnose ")
                    .append(" WHERE ")
                    .append(" diagnose_id = ").append("'").append(diagnose_id).append("'")
                    .append(" AND exam_id = ").append("'").append(exam_id).append("';");

            stmt.execute(insQuery.toString());

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {
                diag = new Diagnose();
                diag.setDiagnoseID(diagnose_id);
                diag.setExamID(exam_id);
                diag.setDisease_Name(res.getString("disease_name"));
                diag.setNurseID(res.getString("nurse_id"));

                StringBuilder insQuery2 = new StringBuilder();

                insQuery2.append("SELECT * FROM diagnose_symptoms ")
                        .append(" WHERE ")
                        .append(" diagnose_id = ").append("'").append(diagnose_id).append("'")
                        .append(" AND exam_id = ").append("'").append(exam_id).append("';");

                stmt.execute(insQuery2.toString());

                ResultSet res2 = stmt.getResultSet();

                while (res2.next() == true) {
                    symptoms.add(res2.getString("symptoms"));
                }

                diag.setSymptoms(symptoms);

            } else {

                System.out.println("Diagnose with diagnose_id " + diagnose_id + " exam_id " + exam_id + " was not found");

            }

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(DiagnoseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }

        return diag;
    }

    public static void addDiagnose(Diagnose diag) throws ClassNotFoundException {
        try {
            diag.checkFields();

        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(DiagnoseDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        Connection con = null;
        List<String> symptoms = new ArrayList<>();
        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();


            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO ")
                    .append(" diagnose (diagnose_id , exam_id, disease_name, nurse_id) ")
                    .append(" VALUES (")
                    .append("'").append(diag.getDiagnoseID()).append("',")
                    .append("'").append(diag.getExamID()).append("',")
                    .append("'").append(diag.getDisease_Name()).append("',")
                    .append("'").append(diag.getNurseID()).append("');");

            PreparedStatement stmtIns = con.prepareStatement(insQuery.toString());
            stmtIns.executeUpdate();

            StringBuilder insQuery2;

            symptoms = diag.getSymptoms();
            for (String sympt : symptoms) {

                insQuery2 = new StringBuilder();

                insQuery2.append("INSERT INTO ")
                        .append(" diagnose_symptoms (diagnose_id , exam_id, symptoms) ")
                        .append(" VALUES (")
                        .append("'").append(diag.getDiagnoseID()).append("',")
                        .append("'").append(diag.getExamID()).append("',")
                        .append("'").append(sympt).append("');");

                PreparedStatement stmtIns2 = con.prepareStatement(insQuery2.toString());
                stmtIns2.executeUpdate();
            }

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(DiagnoseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }
    }

    //no update diagnose only add new symptom.
    public void addSymptom(String symptom, String exam_id, String diagnose_id) throws ClassNotFoundException {
        if (exam_id == null || exam_id.trim().isEmpty() || diagnose_id == null || diagnose_id.trim().isEmpty()
                || symptom == null || symptom.trim().isEmpty()) {
            return;
        }

        Statement stmt = null;
        Connection con = null;
        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO ")
                    .append(" diagnose_symptoms (diagnose_id , exam_id, symptoms) ")
                    .append(" VALUES (")
                    .append("'").append(diagnose_id).append("',")
                    .append("'").append(exam_id).append("',")
                    .append("'").append(symptom).append("');");

            PreparedStatement stmtIns = con.prepareStatement(insQuery.toString());
            stmtIns.executeUpdate();

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(DiagnoseDB.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(DiagnoseDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DiagnoseDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
