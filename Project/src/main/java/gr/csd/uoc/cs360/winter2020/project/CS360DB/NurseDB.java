/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;

import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Nurse.Nurse;
import java.sql.*;
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
public class NurseDB {
    /**
     * Get all doctors
     *
     * @return List of doctors
     */
    public static List<Nurse> getNurses() throws ClassNotFoundException {
        List<Nurse> nurses = new ArrayList<>();

        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM cardiologist,haematologist,surgeon,neurologist,general_pracitioner;");

            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                Nurse nurse = new Nurse();
                nurse.setUsername(res.getString("username"));
                nurse.setNurse_id(res.getString("nurse_id"));
                nurse.setEmail(res.getString("email"));
                nurse.setPassword(res.getString("password"));
                nurse.setName(res.getString("name"));
                nurse.setLastname(res.getString("lastname"));
                nurse.setPhone(res.getString("phone"));
                nurse.setAddress(res.getString("address"));
                nurse.setSpec(Nurse.fromString(res.getString("spec")));
                nurses.add(nurse);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NurseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return nurses;
    }

    public static List<Nurse> getNursesBySpecialty(String specialty) throws ClassNotFoundException
    {
        List<Nurse> nurses = new ArrayList<>();

        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM ").append(specialty).append(";");

            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                Nurse nurse = new Nurse();
                nurse.setUsername(res.getString("username"));
                nurse.setNurse_id(res.getString("nurse_id"));
                nurse.setEmail(res.getString("email"));
                nurse.setPassword(res.getString("password"));
                nurse.setName(res.getString("name"));
                nurse.setLastname(res.getString("lastname"));
                nurse.setPhone(res.getString("phone"));
                nurse.setAddress(res.getString("address"));
                nurse.setSpec(Nurse.fromString(res.getString("spec")));
                nurses.add(nurse);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NurseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return nurses;
    }

    /**
     * Get doctor by username
     *
     * @param username
     * @return Requested doctor
     * @throws java.lang.ClassNotFoundException
     */
    public static Nurse getNurseByUsername(String username) throws ClassNotFoundException {
        Nurse nurse = null;

        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM nurse"
                    + "WHERE username = " + username +";");

            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {
                nurse = new Nurse();

                nurse.setUsername(res.getString("username"));
                nurse.setNurse_id(res.getString("nurse_id"));
                nurse.setEmail(res.getString("email"));
                nurse.setPassword(res.getString("password"));
                nurse.setName(res.getString("name"));
                nurse.setLastname(res.getString("lastname"));
                nurse.setPhone(res.getString("phone"));
                nurse.setAddress(res.getString("address"));
                nurse.setSpec(Nurse.fromString(res.getString("spec")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NurseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return nurse;
    }

    /**
     * Get doctor by id
     *
     * @return Requested doctor
     */
    public static Nurse getNurse(String nurse_id) throws ClassNotFoundException {
        Nurse nurse = null;

        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM nurse_haematologist h, nurse_surgeon s,nurse_neurologist n,nurse_general_pracitioner g"
                    + "WHERE s.nurse_id = " + nurse_id + "OR h.nurse_id = " + nurse_id +"OR n.nurse_id = " + nurse_id + "OR g.nurse_id = " + nurse_id +
                    ";");

            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {

                nurse = new Nurse();

                nurse.setUsername(res.getString("username"));
                nurse.setNurse_id(res.getString("nurse_id"));
                nurse.setEmail(res.getString("email"));
                nurse.setPassword(res.getString("password"));
                nurse.setName(res.getString("name"));
                nurse.setLastname(res.getString("lastname"));
                nurse.setPhone(res.getString("phone"));
                nurse.setAddress(res.getString("address"));
                nurse.setSpec(Nurse.fromString(res.getString("spec")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(NurseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return nurse;
    }

    /**
     * Add nurse
     */
    public static void addNurse(Nurse nurse) throws ClassNotFoundException {

        switch (nurse.getSpec()) {
            case NEUROLOGIST:
                insertNeurologist(nurse);
                break;
            case HAEMATOLOGIST:
                insertHaematologist(nurse);
                break;
            case GP:
                insertGP(nurse);
                break;
            case SURGEON:
                insertSurgeon(nurse);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + nurse.getSpec());
        }

    }

    private static void insertSurgeon(Nurse nurse) throws ClassNotFoundException {
        Connection con = null;
        PreparedStatement stmtIns = null;
        try {
            con = CS360DB.getConnection();
            StringBuilder query = new StringBuilder();


            query.append("INSERT INTO")
                    .append(" nurse_surgeon (nurse_id, name, lastname, phone, "
                            + "address, username, password, email, employee_id) ")
                    .append(" VALUES (")
                    .append("'").append(nurse.getNurse_id()).append("',")
                    .append("'").append(nurse.getName()).append("',")
                    .append("'").append(nurse.getLastname()).append("',")
                    .append("'").append(nurse.getPhone()).append("',")
                    .append("'").append(nurse.getAddress()).append("',")
                    .append("'").append(nurse.getUsername()).append("',")
                    .append("'").append(nurse.getPassword()).append("',")
                    .append("'").append(nurse.getEmail()).append("',")
                    .append("'").append(nurse.getEmployee_id()).append("');");
            stmtIns = con.prepareStatement(query.toString());
            stmtIns.executeUpdate(query.toString());

            ResultSet res = stmtIns.getResultSet();
            
            query.setLength(0);
            query.append("INSERT INTO nurse (username, type)" +
                    "VALUES ('" + nurse.getUsername() +"','surgeon');");

            stmtIns = con.prepareStatement(query.toString());
            stmtIns.executeUpdate(query.toString());
            
            res = stmtIns.getResultSet();

        } catch (SQLException ex) {
            Logger.getLogger(NurseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmtIns, con);
        }
    }

    private static void insertGP(Nurse nurse) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();


            query.append("INSERT INTO")
                    .append(" nurse_general_practitioner (nurse_id, name, lastname, phone, "
                            + "address, username, password, email, employee_id) ")
                    .append(" VALUES (")
                    .append("'").append(nurse.getNurse_id()).append("',")
                    .append("'").append(nurse.getName()).append("',")
                    .append("'").append(nurse.getLastname()).append("',")
                    .append("'").append(nurse.getPhone()).append("',")
                    .append("'").append(nurse.getAddress()).append("',")
                    .append("'").append(nurse.getUsername()).append("',")
                    .append("'").append(nurse.getPassword()).append("',")
                    .append("'").append(nurse.getEmail()).append("',")
                    .append("'").append(nurse.getEmployee_id()).append("');");

            PreparedStatement stmtIns = con.prepareStatement(query.toString());
            stmtIns.executeUpdate();

            query.setLength(0);
            query.append("INSERT INTO nurse (username, type)" +
                    "VALUES ('" + nurse.getUsername() +"','general_practitioner');");

            stmtIns = con.prepareStatement(query.toString());
            stmtIns.executeUpdate(query.toString());

        } catch (SQLException ex) {
            Logger.getLogger(NurseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
    }

    private static void insertHaematologist(Nurse nurse) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();


            query.append("INSERT INTO")
                    .append(" nurse_haematologist (nurse_id, name, lastname, phone, "
                            + "address, username, password, email, employee_id )")
                    .append(" VALUES (")
                    .append("'").append(nurse.getNurse_id()).append("',")
                    .append("'").append(nurse.getName()).append("',")
                    .append("'").append(nurse.getLastname()).append("',")
                    .append("'").append(nurse.getPhone()).append("',")
                    .append("'").append(nurse.getAddress()).append("',")
                    .append("'").append(nurse.getUsername()).append("',")
                    .append("'").append(nurse.getPassword()).append("',")
                    .append("'").append(nurse.getEmail()).append("',")
                    .append("'").append(nurse.getEmployee_id()).append("');");

            PreparedStatement stmtIns = con.prepareStatement(query.toString());
            stmtIns.executeUpdate();

            query.setLength(0);
            query.append("INSERT INTO nurse (username, type)" +
                    "VALUES ('" + nurse.getUsername() +"','haematologist');");

            stmtIns = con.prepareStatement(query.toString());
            stmtIns.executeUpdate(query.toString());


        } catch (SQLException ex) {
            Logger.getLogger(NurseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
    }

    private static void insertNeurologist(Nurse nurse) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();


            query.append("INSERT INTO")
                    .append(" nurse_neurologist (nurse_id, name, lastname, phone, "
                            + "address, username, password, email, employee_id) ")
                    .append(" VALUES (")
                    .append("'").append(nurse.getNurse_id()).append("',")
                    .append("'").append(nurse.getName()).append("',")
                    .append("'").append(nurse.getLastname()).append("',")
                    .append("'").append(nurse.getPhone()).append("',")
                    .append("'").append(nurse.getAddress()).append("',")
                    .append("'").append(nurse.getUsername()).append("',")
                    .append("'").append(nurse.getPassword()).append("',")
                    .append("'").append(nurse.getEmail()).append("',")
                    .append("'").append(nurse.getEmployee_id()).append("');");

            PreparedStatement stmtIns = con.prepareStatement(query.toString());
            stmtIns.executeUpdate();

            query.setLength(0);
            query.append("INSERT INTO nurse (username, type)" +
                    "VALUES ('" + nurse.getUsername() +"','neurologist');");

            stmtIns = con.prepareStatement(query.toString());
            stmtIns.executeUpdate(query.toString());

        } catch (SQLException ex) {
            Logger.getLogger(NurseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
    }

    /**
     * Add doctor
     */
    public static void updateNurse(Nurse nurse) throws ClassNotFoundException {

        switch (nurse.getSpec()) {
            case NEUROLOGIST:
                updateNeurologist(nurse);
                break;
            case HAEMATOLOGIST:
                updateHaematologist(nurse);
                break;
            case GP:
                updateGP(nurse);
                break;
            case SURGEON:
                updateSurgeon(nurse);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + nurse.getSpec());
        }

    }

    private static void updateSurgeon(Nurse nurse) throws ClassNotFoundException {
        // Check that we have all we need
        try {
            nurse.checkFields();

        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(NurseDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        Connection con = null;
        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("UPDATE nurse_surgeon ")
                    .append(" SET ")
                    .append(" nurse_id = ").append("'").append(nurse.getNurse_id()).append("',")
                    .append(" name = ").append("'").append(nurse.getName()).append("',")
                    .append(" lastname = ").append("'").append(nurse.getLastname()).append("',")
                    .append(" phone = ").append("'").append(nurse.getPhone()).append("',")
                    .append(" address = ").append("'").append(nurse.getAddress()).append("',")
                    .append(" username = ").append("'").append(nurse.getUsername()).append("',")
                    .append(" password = ").append("'").append(nurse.getPassword()).append("',")
                    .append(" email = ").append("'").append(nurse.getEmail()).append("',")
                    .append(" employee_id = ").append("'").append(nurse.getEmployee_id()).append("'")
                    .append(" WHERE nurse_id= ").append("'").append(nurse.getNurse_id()).append("';");

            stmt.executeUpdate(insQuery.toString());
            System.out.println("#DB: The member was successfully updated in the database.");

        } catch (SQLException | ClassNotFoundException ex) {
            // Log exception
            Logger.getLogger(NurseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }
    }

    private static void updateGP(Nurse nurse) throws ClassNotFoundException {
        // Check that we have all we need
        try {
            nurse.checkFields();

        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(NurseDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        Connection con = null;
        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("UPDATE nurse_general_practitioner ")
                    .append(" SET ")
                    .append(" nurse_id = ").append("'").append(nurse.getNurse_id()).append("',")
                    .append(" name = ").append("'").append(nurse.getName()).append("',")
                    .append(" lastname = ").append("'").append(nurse.getLastname()).append("',")
                    .append(" phone = ").append("'").append(nurse.getPhone()).append("',")
                    .append(" address = ").append("'").append(nurse.getAddress()).append("',")
                    .append(" username = ").append("'").append(nurse.getUsername()).append("',")
                    .append(" password = ").append("'").append(nurse.getPassword()).append("',")
                    .append(" email = ").append("'").append(nurse.getEmail()).append("',")
                    .append(" employee_id = ").append("'").append(nurse.getEmployee_id()).append("'")
                    .append(" WHERE nurse_id= ").append("'").append(nurse.getNurse_id()).append("';");

            stmt.executeUpdate(insQuery.toString());
            System.out.println("#DB: The member was successfully updated in the database.");

        } catch (SQLException | ClassNotFoundException ex) {
            // Log exception
            Logger.getLogger(NurseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }
    }

    private static void updateHaematologist(Nurse nurse) throws ClassNotFoundException {
        // Check that we have all we need
        try {
            nurse.checkFields();

        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(NurseDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        Connection con = null;
        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("UPDATE nurse_haematologist ")
                    .append(" SET ")
                    .append(" nurse_id = ").append("'").append(nurse.getNurse_id()).append("',")
                    .append(" name = ").append("'").append(nurse.getName()).append("',")
                    .append(" lastname = ").append("'").append(nurse.getLastname()).append("',")
                    .append(" phone = ").append("'").append(nurse.getPhone()).append("',")
                    .append(" address = ").append("'").append(nurse.getAddress()).append("',")
                    .append(" username = ").append("'").append(nurse.getUsername()).append("',")
                    .append(" password = ").append("'").append(nurse.getPassword()).append("',")
                    .append(" email = ").append("'").append(nurse.getEmail()).append("',")
                    .append(" employee_id = ").append("'").append(nurse.getEmployee_id()).append("'")
                    .append(" WHERE nurse_id= ").append("'").append(nurse.getNurse_id()).append("';");

            stmt.executeUpdate(insQuery.toString());
            System.out.println("#DB: The member was successfully updated in the database.");

        } catch (SQLException | ClassNotFoundException ex) {
            // Log exception
            Logger.getLogger(NurseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }
    }

    private static void updateNeurologist(Nurse nurse) throws ClassNotFoundException {
        // Check that we have all we need
        try {
            nurse.checkFields();

        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(NurseDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        Connection con = null;
        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("UPDATE nurse_neurologist ")
                    .append(" SET ")
                    .append(" nurse_id = ").append("'").append(nurse.getNurse_id()).append("',")
                    .append(" name = ").append("'").append(nurse.getName()).append("',")
                    .append(" lastname = ").append("'").append(nurse.getLastname()).append("',")
                    .append(" phone = ").append("'").append(nurse.getPhone()).append("',")
                    .append(" address = ").append("'").append(nurse.getAddress()).append("',")
                    .append(" username = ").append("'").append(nurse.getUsername()).append("',")
                    .append(" password = ").append("'").append(nurse.getPassword()).append("',")
                    .append(" email = ").append("'").append(nurse.getEmail()).append("',")
                    .append(" employee_id = ").append("'").append(nurse.getEmployee_id()).append("'")
                    .append(" WHERE nurse_id= ").append("'").append(nurse.getNurse_id()).append("';");

            stmt.executeUpdate(insQuery.toString());
            System.out.println("#DB: The member was successfully updated in the database.");

        } catch (SQLException | ClassNotFoundException ex) {
            // Log exception
            Logger.getLogger(NurseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }
    }

    /*
        From here and later on we will implement the relations of the DB.Which are the combination of one or more DB's.
     */
    public static void ConductsExam()
    {
        //State/Cure?
        //or result of visit?
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
                Logger.getLogger(NurseDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(NurseDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}