/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;


import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Doctor.Doctor;

import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital.Examination;

import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Nurse.Nurse;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient.Visit;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
        List<String> tables = Arrays.asList(new String[] {"surgeon,neurologist,haematologist,general_practitioner,cardiologist"});
        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            for(String table : tables) {
                StringBuilder query = new StringBuilder();

                query.append("SELECT * FROM " + table + ";");

                stmt.execute(query.toString());

                ResultSet res = stmt.getResultSet();

                while (res.next() == true) {
                    Doctor d = new Doctor();
                    d.setUsername(res.getString("username"));
                    d.setDoctor_id(res.getString("doctor_id"));
                    d.setEmail(res.getString("email"));
                    d.setPassword(res.getString("password"));
                    d.setName(res.getString("name"));
                    d.setLastname(res.getString("lastname"));
                    d.setPhone(res.getString("phone"));
                    d.setAddress(res.getString("address"));
                    d.setSpec(Doctor.fromString(res.getString("type")));
                    doctors.add(d);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return doctors;
    }

    public static List<Doctor> getDoctorsBySpec(String spec) throws ClassNotFoundException
    {
        List<Doctor> doctors = new ArrayList<>();
        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM " + spec + ";");

            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                Doctor d = new Doctor();
                d.setUsername(res.getString("username"));
                d.setDoctor_id(res.getString("doctor_id"));
                d.setEmail(res.getString("email"));
                d.setPassword(res.getString("password"));
                d.setName(res.getString("name"));
                d.setLastname(res.getString("lastname"));
                d.setPhone(res.getString("phone"));
                d.setAddress(res.getString("address"));
                d.setSpec(Doctor.fromString(spec.toLowerCase()));
                doctors.add(d);
            }

         } catch (SQLException ex) {
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return doctors;

    }

    /**
     * Get doctor by username
     *
     * @return Requested doctor
     */
    public static Doctor getDoctorByUsername(String username) throws ClassNotFoundException {
        Doctor doc = null;

        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();
            System.out.println("#DOCTORDB: RETURNING: " + username);
            query.append("SELECT * FROM doctor WHERE username = '" + username + "';");

            stmt.executeQuery(query.toString());

            ResultSet res = stmt.getResultSet();
            if(res.next() == true) {
                doc = new Doctor();
                String s = res.getString("type");
                StringBuilder q = new StringBuilder();
                q.append("SELECT * FROM ")
                        .append(s + " WHERE username='")
                        .append(username + "';");
                stmt.executeQuery(q.toString());
                res = stmt.getResultSet();
                if(res.next() == true) {
                    doc.setUsername(res.getString("username"));
                    doc.setDoctor_id(res.getString("doctor_id"));
                    doc.setEmail(res.getString("email"));
                    doc.setPassword(res.getString("password"));
                    doc.setName(res.getString("name"));
                    doc.setLastname(res.getString("lastname"));
                    doc.setPhone(res.getString("phone"));
                    doc.setAddress(res.getString("address"));
                    doc.setSpec(Doctor.fromString(s));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }


        return doc;
    }

    /**
     * Get doctor by id
     *
     * @return Requested doctor
     */

        public static Doctor getDoctor(String doctor_id) throws ClassNotFoundException {
        Doctor doc = null;

        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM doctor WHERE doctor_id = '" + doctor_id + "';");

            stmt.executeQuery(query.toString());

            ResultSet res = stmt.getResultSet();
            if(res.next() == true) {
                doc = new Doctor();
                String s = res.getString("type");
                StringBuilder q = new StringBuilder();
                q.append("SELECT * FROM ")
                        .append(s + " WHERE doctor_id='")
                        .append(doctor_id + "';");
                stmt.executeQuery(q.toString());
                res = stmt.getResultSet();
                if(res.next() == true) {
                    doc.setUsername(res.getString("username"));
                    doc.setDoctor_id(res.getString("doctor_id"));
                    doc.setEmail(res.getString("email"));
                    doc.setPassword(res.getString("password"));
                    doc.setName(res.getString("name"));
                    doc.setLastname(res.getString("lastname"));
                    doc.setPhone(res.getString("phone"));
                    doc.setAddress(res.getString("address"));
                    doc.setSpec(Doctor.fromString(s));

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
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
                System.out.println("#DOCTORDB: CARDIOLOGIST");
                insertCardiologist(doc);
                break;
            case HAEMATOLOGIST:
                System.out.println("#DOCTORDB: HAEMATOLOGIST");
                insertHaematologist(doc);
                break;
            case GP:
                System.out.println("#DOCTORDB: GP");
                insertGP(doc);
                break;
            case SURGEON:
                System.out.println("#DOCTORDB: SURGEON");
                insertSurgeon(doc);
                break;
            case NEUROLOGIST:
                System.out.println("#DOCTORDB: NEUROLOGIST");
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
                            + "address, username, password, email, employee_id) ")
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

            query.setLength(0);

            query.append("INSERT INTO " +
                    "doctor (username,doctor_id, type) " +
                    " VALUES ('" + doc.getUsername() +"','"+doc.getDoctor_id()+"','neurologist');");

            stmt.execute(query.toString());

            System.out.println("#DB: The member " + doc.getUsername() + "  was successfully added in the database.");

        } catch (SQLException  ex) {
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
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
                            + "address, username, password, email, employee_id) ")
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

            query.setLength(0);

            query.append("INSERT INTO " +
                    "doctor (username,doctor_id, type) " +
                    " VALUES ('" + doc.getUsername() +"','"+doc.getDoctor_id()+"','surgeon');");

            stmt.execute(query.toString());

            System.out.println("#DB: The member " + doc.getUsername() + "  was successfully added in the database.");

        } catch (SQLException  ex) {
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
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
                            + "address, username, password, email, employee_id )")
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
            query.setLength(0);

            query.append("INSERT INTO " +
                    "doctor (username,doctor_id, type) " +
                    " VALUES ('" + doc.getUsername() +"','"+doc.getDoctor_id()+"','general_practitioner');");

            stmt.execute(query.toString());


            System.out.println("#DB: The member " + doc.getUsername() + "  was successfully added in the database.");

        } catch (SQLException  ex) {
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
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
                            + "address, username, password, email, employee_id) ")
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

            query.setLength(0);

            query.append("INSERT INTO " +
                    "doctor (username,doctor_id, type) " +
                    " VALUES ('" + doc.getUsername() +"','"+doc.getDoctor_id()+"','haematologist');");

            stmt.execute(query.toString());

            System.out.println("#DB: The member " + doc.getUsername() + "  was successfully added in the database.");

        } catch (SQLException  ex) {
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
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
                            + "address, username, password, email, employee_id )")
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

            query.setLength(0);

            query.append("INSERT INTO " +
                    "doctor (username,doctor_id, type) " +
                    " VALUES ('" + doc.getUsername() +"','"+doc.getDoctor_id()+"','cardiologist');");

            stmt.execute(query.toString());

            System.out.println("#DB: The member " + doc.getUsername() + "  was successfully added in the database.");


        } catch (SQLException  ex) {
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
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
                    .append(" employee_id = ").append("'").append(doc.getEmployee_id()).append("' ")
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
                    .append(" employee_id = ").append("'").append(doc.getEmployee_id()).append("' ")
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
                        .append(" employee_id = ").append("'").append(doc.getEmployee_id()).append("' ")
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
                        .append(" employee_id = ").append("'").append(doc.getEmployee_id()).append("' ")
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
                        .append(" employee_id = ").append("'").append(doc.getEmployee_id()).append("' ")
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

    /*
        From here and later on we will implement the relations of the DB.Which are the combination of one or more DB's.
    */

    public static void AddOrder(String doctor_id,String exam_id,String nurse_id,String ex_name,String ex_room) throws ClassNotFoundException
    {
        if (doctor_id == null || doctor_id.trim().isEmpty() || nurse_id == null || nurse_id.trim().isEmpty()) {
            return;
        }

        Statement stmt = null;
        Connection con = null;
        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO ")
                    .append(" orders (doctor_id, exam_id, nurse_id,exam_name,exam_room) ")
                    .append(" VALUES (")
                    .append("'").append(doctor_id).append("',")
                    .append("'").append(exam_id).append("',")
                    .append("'").append(nurse_id).append("',")
                    .append("'").append(ex_name).append("',")
                    .append("'").append(ex_room).append("');");

            PreparedStatement stmtIns = con.prepareStatement(insQuery.toString());
            stmtIns.executeUpdate();

            System.out.println("#DB: The order of doctor" + doctor_id + " to  nurse" + nurse_id + "  was successfully added in the database.");

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }

    }


    public static void DoctorOrdersExamFromNurse(String patient_id,String visit_date,String doctor_id,String exam_room,String exam_name) throws ClassNotFoundException
    {
        try {
            if (doctor_id == null || doctor_id.trim().isEmpty()) {
                return;
            }
        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        Connection con = null;
        String nurse_id = null;
        Visit v = VisitDB.getVisit(patient_id, visit_date);
        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            Random rand = new Random();

            String doc_spec = DoctorDB.getDoctor(doctor_id).getSpec().toString();
            List<Nurse> nurses = NurseDB.getNursesBySpecialty(doc_spec);
            if (nurses.size() > 0) {
                nurse_id = nurses.get(rand.nextInt(nurses.size())).getNurse_id();
                v.setNurseID(nurse_id);
                VisitDB.updateVisit(v);
                Examination exam = new Examination(nurse_id, doctor_id, exam_room, exam_name);
                ExamDB.addExam(exam);//add new exam
                AddOrder(doctor_id, exam.getExam_ID(), nurse_id, exam_name, exam_room); //Add assignment to nurse
                NurseDB.ConductsExam(exam.getExam_ID(), patient_id, visit_date);    //Nurse conducts the order and inserts in undergo
            }

        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void Prescribe(String exam_id,String med_id,String date,String doctor_id)
    {

        try {
            if (doctor_id == null || doctor_id.trim().isEmpty() || exam_id==null || exam_id.trim().isEmpty()
                    || med_id == null || med_id.trim().isEmpty() || date == null || date.trim().isEmpty()) {
                return;
            }
        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        Connection con = null;
        String patient_id = null;
        String medicine = null;

        Visit visit = null;

        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO ")
                    .append(" prescribe (exam_id, med_id, date, doctor_id) ")
                    .append(" VALUES (")
                    .append("'").append(exam_id).append("',")
                    .append("'").append(med_id).append("',")
                    .append("DATE '").append(date).append("',")
                    .append("'").append(doctor_id).append("');");

            PreparedStatement stmtIns = con.prepareStatement(insQuery.toString());
            stmtIns.executeUpdate();

            //here we have added the prescription,now we need to update cure of patient.
            //need patient_id,we will take it from relation Undergo.
            patient_id = VisitDB.getUndergoPatient_ID(date, exam_id);
            medicine = MedicationDB.getMedication(med_id).getName();
            visit = VisitDB.getVisit(patient_id, date);

            visit.setCure(medicine);

            //here we have set the cure as the medicine by name and
            //now we will update visit cure.
            System.out.println(visit.getPatientID());
            System.out.println(visit.getCure());
            VisitDB.updateVisit(visit);


            System.out.println("#DB: The prescription of " + MedicationDB.getMedication(med_id)
                    + " for exam id " + exam_id + " was successfully added and updated in the database.");

        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
