/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;


import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Doctor.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tolis
 */
public class DoctorDB {

    /**
     * Get all doctors
     *
     * @return List of doctors
     */
    public static List<Doctor> getDoctors() throws ClassNotFoundException {
        List<Doctor> doctors = new ArrayList<>();

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
                Doctor doc = new Doctor();
                doc.setUsername(res.getString("username"));
                doc.setDoctor_id(res.getString("doctor_id"));
                doc.setEmail(res.getString("email"));
                doc.setPassword(res.getString("password"));
                doc.setName(res.getString("name"));
                doc.setLastname(res.getString("lastname"));
                doc.setPhone(res.getString("phone"));
                doc.setAddress(res.getString("address"));
                doc.setSpec(Doctor.fromString(res.getString("spec")));
                doctors.add(doc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiagnoseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return doctors;
    }

    /**
     * Get doctor by id
     *
     * @return Requested doctor
     */
    public static Doctor getDoctor(String doc_id) throws ClassNotFoundException {
        Doctor doc = new Doctor();

        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT doc FROM cardiologist,haematologist,surgeon,neurologist,general_pracitioner"
                            + "WHERE doctor_id = " + doc_id);

            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            while(res.next() == true) {
                doc.setUsername(res.getString("username"));
                doc.setDoctor_id(res.getString("doctor_id"));
                doc.setEmail(res.getString("email"));
                doc.setPassword(res.getString("password"));
                doc.setName(res.getString("name"));
                doc.setLastname(res.getString("lastname"));
                doc.setPhone(res.getString("phone"));
                doc.setAddress(res.getString("address"));
                doc.setSpec(Doctor.fromString(res.getString("spec")));

            }
        } catch (SQLException ex) {
            Logger.getLogger(DiagnoseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return doc;
    }

    /**
     * Add doctor
     */
    public static void addDoctor(Doctor doc) throws ClassNotFoundException {

        switch(doc.getSpec()) {
            case CARDIOLOGIST:
                insertCardiologist(doc);
                break;
            case HAEMATOLOGIST:
                insertHaematologist(doc);
                break;
            case GP:
                insertGP(doc);
                break;
            case SURGEON:
                insertSurgeon(doc);
                break;
            case NEUROLOGIST:
                insertNeurologist(doc);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + doc.getSpec());
        }

    }

    private static void insertNeurologist(Doctor doc) throws ClassNotFoundException{
        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();


            query.append("INSERT INTO")
                    .append(" neurologist (doctor_id, name, lastname, phone, "
                            + "address, username, password, email, employee_id ")
                    .append(" VALUES (")
                    .append("'").append(doc.getDoctor_id()).append("',")
                    .append("'").append(doc.getName()).append("',")
                    .append("'").append(doc.getLastname()).append("',")
                    .append("'").append(doc.getPhone()).append("',")
                    .append("'").append(doc.getAddress()).append("',")
                    .append("'").append(doc.getUsername()).append("',")
                    .append("'").append(doc.getPassword()).append("',")
                    .append("'").append(doc.getEmail()).append("',")
                    .append("'").append(doc.getEmployee_id()).append("');");
            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();


        } catch (SQLException  ex) {
            Logger.getLogger(DiagnoseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
    }

    private static void insertSurgeon(Doctor doc) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();


            query.append("INSERT INTO")
                    .append(" surgeon (doctor_id, name, lastname, phone, "
                            + "address, username, password, email, employee_id ")
                    .append(" VALUES (")
                    .append("'").append(doc.getDoctor_id()).append("',")
                    .append("'").append(doc.getName()).append("',")
                    .append("'").append(doc.getLastname()).append("',")
                    .append("'").append(doc.getPhone()).append("',")
                    .append("'").append(doc.getAddress()).append("',")
                    .append("'").append(doc.getUsername()).append("',")
                    .append("'").append(doc.getPassword()).append("',")
                    .append("'").append(doc.getEmail()).append("',")
                    .append("'").append(doc.getEmployee_id()).append("');");
            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();


        } catch (SQLException  ex) {
            Logger.getLogger(DiagnoseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
    }

    private static void insertGP(Doctor doc) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();


            query.append("INSERT INTO")
                    .append(" general_practitioner (doctor_id, name, lastname, phone, "
                            + "address, username, password, email, employee_id ")
                    .append(" VALUES (")
                    .append("'").append(doc.getDoctor_id()).append("',")
                    .append("'").append(doc.getName()).append("',")
                    .append("'").append(doc.getLastname()).append("',")
                    .append("'").append(doc.getPhone()).append("',")
                    .append("'").append(doc.getAddress()).append("',")
                    .append("'").append(doc.getUsername()).append("',")
                    .append("'").append(doc.getPassword()).append("',")
                    .append("'").append(doc.getEmail()).append("',")
                    .append("'").append(doc.getEmployee_id()).append("');");
            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();


        } catch (SQLException  ex) {
            Logger.getLogger(DiagnoseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
    }

    private static void insertHaematologist(Doctor doc) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();


            query.append("INSERT INTO")
                    .append(" haematologist (doctor_id, name, lastname, phone, "
                            + "address, username, password, email, employee_id ")
                    .append(" VALUES (")
                    .append("'").append(doc.getDoctor_id()).append("',")
                    .append("'").append(doc.getName()).append("',")
                    .append("'").append(doc.getLastname()).append("',")
                    .append("'").append(doc.getPhone()).append("',")
                    .append("'").append(doc.getAddress()).append("',")
                    .append("'").append(doc.getUsername()).append("',")
                    .append("'").append(doc.getPassword()).append("',")
                    .append("'").append(doc.getEmail()).append("',")
                    .append("'").append(doc.getEmployee_id()).append("');");
            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();


        } catch (SQLException  ex) {
            Logger.getLogger(DiagnoseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
    }

    private static void insertCardiologist(Doctor doc) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();


            query.append("INSERT INTO")
                    .append(" cardiologist (doctor_id, name, lastname, phone, "
                            + "address, username, password, email, employee_id ")
                    .append(" VALUES (")
                    .append("'").append(doc.getDoctor_id()).append("',")
                    .append("'").append(doc.getName()).append("',")
                    .append("'").append(doc.getLastname()).append("',")
                    .append("'").append(doc.getPhone()).append("',")
                    .append("'").append(doc.getAddress()).append("',")
                    .append("'").append(doc.getUsername()).append("',")
                    .append("'").append(doc.getPassword()).append("',")
                    .append("'").append(doc.getEmail()).append("',")
                    .append("'").append(doc.getEmployee_id()).append("');");

            PreparedStatement stmtIns = con.prepareStatement(query.toString());
            stmtIns.executeUpdate();



        } catch (SQLException  ex) {
            Logger.getLogger(DiagnoseDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
    }

    /**
     * Add doctor
     */
    public static void updateDoctor(Doctor doc) throws ClassNotFoundException {

        switch(doc.getSpec()) {
            case CARDIOLOGIST:
                updateCardiologist(doc);
                break;
            case HAEMATOLOGIST:
                updateHaematologist(doc);
                break;
            case GP:
                updateGP(doc);
                break;
            case SURGEON:
                updateSurgeon(doc);
                break;
            case NEUROLOGIST:
                updateNeurologist(doc);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + doc.getSpec());
        }

    }

    private static void updateNeurologist(Doctor doc) throws ClassNotFoundException {
        // Check that we have all we need
        try {
            doc.checkFields();

        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        Connection con = null;
        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("UPDATE neurologist ")
                    .append(" SET ")
                    .append(" doctor_id = ").append("'").append(doc.getDoctor_id()).append("',")
                    .append(" name = ").append("'").append(doc.getName()).append("',")
                    .append(" lastname = ").append("'").append(doc.getLastname()).append("',")
                    .append(" phone = ").append("'").append(doc.getPhone()).append("',")
                    .append(" address = ").append("'").append(doc.getAddress()).append("',")
                    .append(" username = ").append("'").append(doc.getUsername()).append("',")
                    .append(" password = ").append("'").append(doc.getPassword()).append("',")
                    .append(" email = ").append("'").append(doc.getEmail()).append("',")
                    .append(" employee_id = ").append("'").append(doc.getEmployee_id()).append("',")
                    .append(" WHERE doctor_id= ").append("'").append(doc.getDoctor_id()).append("';");

            stmt.executeUpdate(insQuery.toString());
            System.out.println("#DB: The member was successfully updated in the database.");

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }
    }

    private static void updateSurgeon(Doctor doc) throws ClassNotFoundException {
        // Check that we have all we need
        try {
            doc.checkFields();

        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        Connection con = null;
        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("UPDATE surgeon ")
                    .append(" SET ")
                    .append(" doctor_id = ").append("'").append(doc.getDoctor_id()).append("',")
                    .append(" name = ").append("'").append(doc.getName()).append("',")
                    .append(" lastname = ").append("'").append(doc.getLastname()).append("',")
                    .append(" phone = ").append("'").append(doc.getPhone()).append("',")
                    .append(" address = ").append("'").append(doc.getAddress()).append("',")
                    .append(" username = ").append("'").append(doc.getUsername()).append("',")
                    .append(" password = ").append("'").append(doc.getPassword()).append("',")
                    .append(" email = ").append("'").append(doc.getEmail()).append("',")
                    .append(" employee_id = ").append("'").append(doc.getEmployee_id()).append("',")
                    .append(" WHERE doctor_id= ").append("'").append(doc.getDoctor_id()).append("';");

            stmt.executeUpdate(insQuery.toString());
            System.out.println("#DB: The member was successfully updated in the database.");

        } catch (SQLException | ClassNotFoundException ex) {
            // Log exception
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }
    }

    private static void updateGP(Doctor doc) throws ClassNotFoundException {
            // Check that we have all we need
            try {
                doc.checkFields();

            } catch (Exception ex) {
                // Log exception
                Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
            }

            Statement stmt = null;
            Connection con = null;
            try {

                con = CS360DB.getConnection();
                stmt = con.createStatement();

                StringBuilder insQuery = new StringBuilder();

                insQuery.append("UPDATE general_practitioner ")
                        .append(" SET ")
                        .append(" doctor_id = ").append("'").append(doc.getDoctor_id()).append("',")
                        .append(" name = ").append("'").append(doc.getName()).append("',")
                        .append(" lastname = ").append("'").append(doc.getLastname()).append("',")
                        .append(" phone = ").append("'").append(doc.getPhone()).append("',")
                        .append(" address = ").append("'").append(doc.getAddress()).append("',")
                        .append(" username = ").append("'").append(doc.getUsername()).append("',")
                        .append(" password = ").append("'").append(doc.getPassword()).append("',")
                        .append(" email = ").append("'").append(doc.getEmail()).append("',")
                        .append(" employee_id = ").append("'").append(doc.getEmployee_id()).append("',")
                        .append(" WHERE doctor_id= ").append("'").append(doc.getDoctor_id()).append("';");

                stmt.executeUpdate(insQuery.toString());
                System.out.println("#DB: The member was successfully updated in the database.");

            } catch (SQLException | ClassNotFoundException ex) {
                // Log exception
                Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // close connection
                closeDBConnection(stmt, con);
            }
    }

    private static void updateHaematologist(Doctor doc) throws ClassNotFoundException {
            // Check that we have all we need
            try {
                doc.checkFields();

            } catch (Exception ex) {
                // Log exception
                Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
            }

            Statement stmt = null;
            Connection con = null;
            try {

                con = CS360DB.getConnection();
                stmt = con.createStatement();

                StringBuilder insQuery = new StringBuilder();

                insQuery.append("UPDATE haematologist ")
                        .append(" SET ")
                        .append(" doctor_id = ").append("'").append(doc.getDoctor_id()).append("',")
                        .append(" name = ").append("'").append(doc.getName()).append("',")
                        .append(" lastname = ").append("'").append(doc.getLastname()).append("',")
                        .append(" phone = ").append("'").append(doc.getPhone()).append("',")
                        .append(" address = ").append("'").append(doc.getAddress()).append("',")
                        .append(" username = ").append("'").append(doc.getUsername()).append("',")
                        .append(" password = ").append("'").append(doc.getPassword()).append("',")
                        .append(" email = ").append("'").append(doc.getEmail()).append("',")
                        .append(" employee_id = ").append("'").append(doc.getEmployee_id()).append("',")
                        .append(" WHERE doctor_id= ").append("'").append(doc.getDoctor_id()).append("';");

                stmt.executeUpdate(insQuery.toString());
                System.out.println("#DB: The member was successfully updated in the database.");

            } catch (SQLException ex) {
                // Log exception
                Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                // close connection
                closeDBConnection(stmt, con);
            }
    }

    private static void updateCardiologist(Doctor doc) throws ClassNotFoundException {
            // Check that we have all we need
            try {
                doc.checkFields();

            } catch (Exception ex) {
                // Log exception
                Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
            }

            Statement stmt = null;
            Connection con = null;
            try {

                con = CS360DB.getConnection();
                stmt = con.createStatement();

                StringBuilder insQuery = new StringBuilder();

                insQuery.append("UPDATE cardiologist ")
                        .append(" SET ")
                        .append(" doctor_id = ").append("'").append(doc.getDoctor_id()).append("',")
                        .append(" name = ").append("'").append(doc.getName()).append("',")
                        .append(" lastname = ").append("'").append(doc.getLastname()).append("',")
                        .append(" phone = ").append("'").append(doc.getPhone()).append("',")
                        .append(" address = ").append("'").append(doc.getAddress()).append("',")
                        .append(" username = ").append("'").append(doc.getUsername()).append("',")
                        .append(" password = ").append("'").append(doc.getPassword()).append("',")
                        .append(" email = ").append("'").append(doc.getEmail()).append("',")
                        .append(" employee_id = ").append("'").append(doc.getEmployee_id()).append("',")
                        .append(" WHERE doctor_id= ").append("'").append(doc.getDoctor_id()).append("';");

                stmt.executeUpdate(insQuery.toString());
                System.out.println("#DB: The member was successfully updated in the database.");

            } catch (SQLException ex) {
                // Log exception
                Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
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
