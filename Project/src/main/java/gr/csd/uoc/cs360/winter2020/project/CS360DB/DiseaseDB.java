/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;

import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital.Disease;
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

    public static Disease getDiseaseByName(String name) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        List<String> symptoms = new ArrayList<>();
        Disease dis = null;

        try {

            con = CS360DB.getConnection();

            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("SELECT * FROM disease ")
                    .append(" WHERE ")
                    .append(" name = ").append("'").append(name).append("';");

            stmt.execute(insQuery.toString());

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {

                dis = new Disease();
                dis.setName(name);
                dis.setIncubation(res.getString("incubation"));
                dis.setTherapy_Duration(res.getString("therapy_duration"));
                dis.setTransmissibility(res.getString("transmissibility"));

                StringBuilder insQuery2 = new StringBuilder();

                insQuery2.append("SELECT * FROM disease_symptoms ")
                        .append(" WHERE ")
                        .append(" name = ").append("'").append(name).append("';");

                stmt.execute(insQuery2.toString());

                ResultSet res2 = stmt.getResultSet();

                while (res2.next() == true) {
                    symptoms.add(res2.getString("symptoms"));
                }

                dis.setSymptoms(symptoms);

            }

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(DiseaseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }

        return dis;
    }

    public static Disease getDiseaseBySymptoms(List<String> Symptoms) throws ClassNotFoundException {

        Statement stmt = null;
        Connection con = null;
        List<String> symptoms = new ArrayList<>();
        Disease dis = null;

        if (symptoms.isEmpty()) {
            return null;
        }

        try {

            con = CS360DB.getConnection();

            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("SELECT name FROM disease_symptoms ")
                    .append(" WHERE ");

            for (String symptom : Symptoms) {

                insQuery.append(" systoms = ").append("'").append(name).append("';");
            }

//notfinitopatsyptom
            stmt.execute(insQuery.toString());

            ResultSet res2 = stmt.getResultSet();

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(DiseaseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }
    }
    public static void addDisease(Disease dis) throws ClassNotFoundException {
        try {
            dis.checkFields();

        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(DiseaseDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        Connection con = null;
        List<String> symptoms;
        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO ")
                    .append(" disease (name, transmissibility, incubation, therapy_duration) ")
                    .append(" VALUES (")
                    .append("'").append(dis.getName()).append("',")
                    .append("'").append(dis.getTransmissibility()).append("',")
                    .append("'").append(dis.getIncubation()).append("',")
                    .append("'").append(dis.getTherapy_Duration()).append("');");

            PreparedStatement stmtIns = con.prepareStatement(insQuery.toString());
            stmtIns.executeUpdate();

            StringBuilder insQuery2;

            symptoms = dis.getSymptoms();
            for (String sympt : symptoms) {

                insQuery2 = new StringBuilder();

                insQuery2.append("INSERT INTO ")
                        .append(" disease_symptoms (name, symptoms) ")
                        .append(" VALUES (")
                        .append("'").append(dis.getName()).append("',")
                        .append("'").append(sympt).append("');");

                PreparedStatement stmtIns2 = con.prepareStatement(insQuery2.toString());
                stmtIns2.executeUpdate();
            }

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(DiseaseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }

    }

    public void addSymptom(String name, String symptom) throws ClassNotFoundException {
        if (name == null || name.trim().isEmpty() || symptom == null || symptom.trim().isEmpty()) {
            return;
        }

        Statement stmt = null;
        Connection con = null;
        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO ")
                    .append(" disease_symptoms (name, symptoms) ")
                    .append(" VALUES (")
                    .append("'").append(name).append("',")
                    .append("'").append(symptom).append("');");

            PreparedStatement stmtIns = con.prepareStatement(insQuery.toString());
            stmtIns.executeUpdate();

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(DiseaseDB.class.getName()).log(Level.SEVERE, null, ex);
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
