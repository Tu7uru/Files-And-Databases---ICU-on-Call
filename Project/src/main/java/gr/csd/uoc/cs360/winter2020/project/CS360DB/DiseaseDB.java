/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;

import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital.Disease;
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
public class DiseaseDB {

    public static List<Disease> getDiseases() throws ClassNotFoundException {
        List<Disease> diseases = new ArrayList<>();
        List<String> symptoms = new ArrayList<>();

        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM disease;");

            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                Disease dis = new Disease();
                dis.setName(res.getString("name"));
                dis.setIncubation(res.getString(("incubation")));
                dis.setTransmissibility(res.getString(("transmissibility")));
                dis.setTherapy_Duration(res.getString("therapy_duration"));

                StringBuilder querySymp = new StringBuilder();

                querySymp.append("SELECT * FROM disease_symptoms ")
                        .append(" WHERE ")
                        .append(" name = ").append("'").append(res.getString("name")).append("';");

                stmt.execute(querySymp.toString());

                ResultSet res2 = stmt.getResultSet();
                symptoms.clear();
                while (res2.next() == true) {
                    symptoms.add(res2.getString("symptoms"));//this might have to become array because symptoms is an arraylist.
                }

                dis.setSymptoms(symptoms);

                diseases.add(dis);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiseaseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return diseases;
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
                Logger.getLogger(DiseaseDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DiseaseDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
