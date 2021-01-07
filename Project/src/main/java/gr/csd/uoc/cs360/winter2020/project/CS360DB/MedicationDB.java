/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;

import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital.Medication;
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
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedicationDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return medications;
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
