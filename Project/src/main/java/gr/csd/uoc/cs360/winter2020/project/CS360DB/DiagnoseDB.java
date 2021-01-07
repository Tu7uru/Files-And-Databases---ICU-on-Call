/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;

import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital.Diagnose;

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
public class DiagnoseDB {
    /**
     * Get all Diagnoses
     *
     * @return List of diagnoses
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
