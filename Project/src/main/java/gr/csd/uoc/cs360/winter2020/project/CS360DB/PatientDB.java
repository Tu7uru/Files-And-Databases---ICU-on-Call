/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;

import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital.Diagnose;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital.Disease;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital.Examination;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient.Patient;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient.Visit;
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
        List<Patient> patients = new ArrayList<>();

        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM patient;");

            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                Patient pat = new Patient();
                pat.setUsername(res.getString("username"));
                pat.setPatient_id(res.getString("patient_id"));
                pat.setEmail(res.getString("email"));
                pat.setPassword(res.getString("password"));
                pat.setName(res.getString("name"));
                pat.setLastname(res.getString("lastname"));
                pat.setPhone(res.getString("phone"));
                pat.setAddress(res.getString("address"));
                pat.setAmka(res.getString("amka"));
                pat.setInsurance(res.getString("insurance"));
                patients.add(pat);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return patients;
    }

    /**
     * Get patient by id
     *
     * @param patient_id
     * @return Patient
     */
    public static Patient getPatient(String patient_id) throws ClassNotFoundException {

        Statement stmt = null;
        Connection con = null;
        Patient pat = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM patient")
                    .append(" WHERE ")
                    .append(" patient_id = ").append("'").append(patient_id).append("';");


            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {
                pat = new Patient();
                pat.setUsername(res.getString("username"));
                pat.setPatient_id(res.getString("patient_id"));
                pat.setEmail(res.getString("email"));
                pat.setPassword(res.getString("password"));
                pat.setName(res.getString("name"));
                pat.setLastname(res.getString("lastname"));
                pat.setPhone(res.getString("phone"));
                pat.setAddress(res.getString("address"));
                pat.setAmka(res.getString("amka"));
                pat.setInsurance(res.getString("insurance"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return pat;
    }

    public static Patient getPatientbyUsername(String username) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        Patient pat = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM patient")
                    .append(" WHERE ")
                    .append(" username = ").append("'").append(username).append("';");

            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {
                pat = new Patient();
                pat.setUsername(username);
                pat.setPatient_id(res.getString("patient_id"));
                pat.setEmail(res.getString("email"));
                pat.setPassword(res.getString("password"));
                pat.setName(res.getString("name"));
                pat.setLastname(res.getString("lastname"));
                pat.setPhone(res.getString("phone"));
                pat.setAddress(res.getString("address"));
                pat.setAmka(res.getString("amka"));
                pat.setInsurance(res.getString("insurance"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return pat;
    }

    /**
     * Add patient
     */
    public static void addPatient(Patient pat) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();


            query.append("INSERT INTO")
                    .append(" patient (patient_id, name, lastname, phone, "
                            + "address, insurance, amka, username, password, email, employee_id )")
                    .append(" VALUES (")
                    .append("'").append(pat.getPatient_id()).append("',")
                    .append("'").append(pat.getName()).append("',")
                    .append("'").append(pat.getLastname()).append("',")
                    .append("'").append(pat.getPhone()).append("',")
                    .append("'").append(pat.getAddress()).append("',")
                    .append("'").append(pat.getInsurance()).append("',")
                    .append("'").append(pat.getAmka()).append("',")
                    .append("'").append(pat.getUsername()).append("',")
                    .append("'").append(pat.getPassword()).append("',")
                    .append("'").append(pat.getEmail()).append("',")
                    .append("'").append(pat.getEmployee_id()).append("');");
            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

        } catch (SQLException ex) {
            Logger.getLogger(PatientDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
    }

    /**
     * Update patient
     */
    public static void updatePatient(Patient pat) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("UPDATE nurse_cardiologist ")
                    .append(" SET ")
                    .append(" patient_id = ").append("'").append(pat.getPatient_id()).append("',")
                    .append(" name = ").append("'").append(pat.getName()).append("',")
                    .append(" lastname = ").append("'").append(pat.getLastname()).append("',")
                    .append(" phone = ").append("'").append(pat.getPhone()).append("',")
                    .append(" address = ").append("'").append(pat.getAddress()).append("',")
                    .append(" insurance = ").append("'").append(pat.getInsurance()).append("',")
                    .append(" amka = ").append("'").append(pat.getAmka()).append("',")
                    .append(" username = ").append("'").append(pat.getUsername()).append("',")
                    .append(" password = ").append("'").append(pat.getPassword()).append("',")
                    .append(" email = ").append("'").append(pat.getEmail()).append("',")
                    .append(" employee_id = ").append("'").append(pat.getEmployee_id()).append("'")
                    .append(" WHERE patient_id= ").append("'").append(pat.getPatient_id()).append("';");
        }  catch (SQLException ex) {
            Logger.getLogger(PatientDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
    }

    /*
        From here and later on we will implement the relations of the DB.Which are the combination of one or more DB's.
     */
    /**
     * The function below is for procedure of patient being examinated by
     * doctor.
     *
     * In our diagram,this is (diag,meds,exams) SUPERVISED_BY doctor and patient
     * receives     * examination.
     *
     *
     *
     * doctor Assigns Exam is in Doctor.DB
     */
    public static void PatientReceivesExaminationByDoctor(Examination exam, String patient_id, String doc_id, String date, List<String> symptoms) throws ClassNotFoundException {
        if (patient_id == null || patient_id.trim().isEmpty()
                || date == null || date.trim().isEmpty() || symptoms.isEmpty()) {
            return;
        }

        Statement stmt = null;
        Connection con = null;
        String ex_room = exam.getExam_Room();
        String ex_name = exam.getName();

        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            ExamDB.addExam(exam);

            Diagnose diag = new Diagnose(symptoms, DiseaseDB.getDiseaseBySymptoms(symptoms).getName(), exam.getExam_ID(), null);
            //need to implement the find disease!!
            DiagnoseDB.addDiagnose(diag);
            VisitDB.AddUndergo(patient_id, exam.getExam_ID(), date);

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(DoctorDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }
    }

    public static String decideHospitalizationByDisease(String disease) {

        if (disease.equals("flu")) {//gp
            return "released";
        } else if (disease.equals("alzheimer")) {//neuro
            return "released";
        } else if (disease.equals("brain_tumor")) {//surgeon
            return "hospitalized";
        } else if (disease.equals("COVID")) {//gp
            return "released";
        } else if (disease.equals("broken_bone")) {//surgeon
            return "hospitalized";
        } else if (disease.equals("breathing_problems")) {//gp
            return "released";
        } else if (disease.equals("dehydration")) {//aemat
            return "hospitalized";
        } else if (disease.equals("diabetes")) {//aema
            return "released";
        } else if (disease.equals("heart_attack")) {//cardio
            return "hospitalized";
        } else {
            return "not_concluded";
        }
    }

    public static Disease PatientSuffersFrom(List<String> symptoms) throws ClassNotFoundException {
        return DiseaseDB.getDiseaseBySymptoms(symptoms);
    }

    public static void PatientReExamined(Examination exam, String doctor_id, String date, String patient_id) throws ClassNotFoundException {

        if (patient_id == null || patient_id.trim().isEmpty()
                || date == null || date.trim().isEmpty() || doctor_id == null || doctor_id.isEmpty()) {
            return;
        }

        Statement stmt = null;
        Connection con = null;

        String hospitalization = null;

        Visit v = VisitDB.getVisit(patient_id, date);
        Disease patient_dis = PatientSuffersFrom(v.getSymptoms());
        hospitalization = decideHospitalizationByDisease(patient_dis.getName());
        v.setState(hospitalization);

        VisitDB.updateVisit(v);


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
                Logger.getLogger(PatientDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(PatientDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
