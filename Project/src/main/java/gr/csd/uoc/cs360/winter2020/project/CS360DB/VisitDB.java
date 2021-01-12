/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;

import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Doctor.Doctor;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient.Patient;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient.Visit;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Shift.Shift;
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
public class VisitDB {

    public static List<Visit> getVisits() throws ClassNotFoundException {
        List<Visit> visits = new ArrayList<>();
        List<String> symptoms = new ArrayList<>();
        List<String> diseases = new ArrayList<>();

        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM visit");

            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                Visit visit = new Visit();
                visit.setCure(res.getString("cure"));
                visit.setDate(res.getString("date"));
                visit.setDoctorID(res.getString("doctor_id"));
                visit.setEmployeeID(res.getString("employee_id"));
                visit.setNurseID(res.getString("nurse_id"));
                visit.setPatientID(res.getString("patient_id"));
                visit.setState(res.getString("state"));

                StringBuilder insQuery2 = new StringBuilder();

                insQuery2.append("SELECT * FROM visit_symptoms ")
                        .append(" WHERE ")
                        .append(" date = ").append("'").append(res.getString("date")).append("'")
                        .append(" AND doctor_id = ").append("'").append(res.getString("doctor_id")).append("'")
                        .append(" AND patient_id = ").append("'").append(res.getString("patient_id")).append("';");

                stmt.execute(insQuery2.toString());

                ResultSet res2 = stmt.getResultSet();

                symptoms.clear();
                while (res2.next() == true) {
                    symptoms.add(res2.getString("symptoms"));
                }

                visit.setSymptoms(symptoms);

                StringBuilder insQuery3 = new StringBuilder();

                insQuery3.append("SELECT * FROM visit_diseases ")
                        .append(" WHERE ")
                        .append(" visit_date = ").append("'").append(res.getString("date")).append("'")
                        .append(" AND doctor_id = ").append("'").append(res.getString("doctor_id")).append("'")
                        .append(" AND patient_id = ").append("'").append(res.getString("patient_id")).append("';");

                stmt.execute(insQuery3.toString());

                ResultSet res3 = stmt.getResultSet();

                diseases.clear();
                while (res3.next() == true) {
                    diseases.add(res3.getString("diseases"));
                }
                visit.setDiseasesHistory(diseases);

                visits.add(visit);
            }

            }catch (SQLException ex) {
            Logger.getLogger(VisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            closeDBConnection(stmt, con);
        }

            return visits;
    }
    public static List<Visit> getVisits(String patient_id) throws ClassNotFoundException {
        List<Visit> visits = new ArrayList<>();

        List<String> diseases = new ArrayList<>();
        Statement stmt = null;
        Connection con = null;
        try {

            con = CS360DB.getConnection();

            stmt = con.createStatement();

            StringBuilder q = new StringBuilder();

            q.append("SELECT * FROM visit ")
                    .append("WHERE patient_id= ").append("'").append(patient_id).append("';");

            stmt.executeQuery(q.toString());
            ResultSet res = stmt.getResultSet();
            while(res.next() == true) {

                Visit v = new Visit();
                System.out.println(v.getDate());
                v.setPatientID(res.getString("patient_id"));
                v.setDate(res.getString("date"));
                v.setCure(res.getString("cure"));
                v.setDoctorID(res.getString("doctor_id"));
                v.setNurseID(res.getString("nurse_id"));
                v.setState(res.getString("state"));
                v.setEmployeeID(res.getString("employee_id"));
                visits.add(v);

                StringBuilder insQuery2 = new StringBuilder();

                insQuery2.append("SELECT symptoms FROM visit_symptoms ")
                        .append(" WHERE ")
                        .append(" patient_id = ").append("'").append(patient_id).append("';");

                Statement stmt2 = con.createStatement();

                stmt2.execute(insQuery2.toString());

                ResultSet res2 = stmt2.getResultSet();
                while(res2.next() == true) {

                    String s = res2.getString("symptoms");
                    v.addSymptom(s);
                }

                /*insQuery2.setLength(0);

                insQuery2.append("SELECT * FROM visit_diseases ")
                        .append(" WHERE ")
                        .append(" patient_id = ").append("'").append(patient_id).append("';");

                stmt.execute(insQuery2.toString());

                res2 = stmt.getResultSet();
                while(res2.next() == true) {
                    String s = new String();
                    s = res2.getString("diseases");
                    diseases.add(s);

                }*/

                //v.setDiseasesHistory(diseases);

            }
        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(VisitDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }

        return visits;
    }

    public static Visit getVisit(String patient_id, String date, String doctor_id) throws ClassNotFoundException {

        Statement stmt = null;
        Connection con = null;
        Visit visit = null;
        List<String> symptoms = new ArrayList<>();
        List<String> diseases = new ArrayList<>();

        try {

            con = CS360DB.getConnection();

            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("SELECT * FROM visit ")
                    .append(" WHERE ")
                    .append(" date = ").append("'").append(date).append("'")
                    .append(" AND doctor_id = ").append("'").append(doctor_id).append("'")
                    .append(" AND patient_id = ").append("'").append(patient_id).append("';");

            stmt.execute(insQuery.toString());

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {
                visit = new Visit();
                visit.setCure(res.getString("cure"));
                visit.setDate(res.getString("date"));
                visit.setDoctorID(res.getString("doctor_id"));
                visit.setEmployeeID(res.getString("employee_id"));
                visit.setNurseID(res.getString("nurse_id"));
                visit.setPatientID(patient_id);
                visit.setState(res.getString("state"));

                StringBuilder insQuery2 = new StringBuilder();

                insQuery2.append("SELECT * FROM visit_symptoms ")
                        .append(" WHERE ")
                        .append(" patient_id = ").append("'").append(patient_id).append("'")
                        .append(" AND doctor_id = ").append("'").append(doctor_id).append("'")
                        .append(" AND date = ").append("'").append(date).append("';");

                stmt.execute(insQuery2.toString());

                ResultSet res2 = stmt.getResultSet();

                symptoms.clear();
                while (res2.next() == true) {
                    symptoms.add(res2.getString("symptoms"));
                }

                visit.setSymptoms(symptoms);

                StringBuilder insQuery3 = new StringBuilder();

                insQuery3.append("SELECT * FROM visit_diseases")
                        .append(" WHERE ")
                        .append(" patient_id = ").append("'").append(patient_id).append("'")
                        .append(" AND doctor_id = ").append("'").append(doctor_id).append("'")
                        .append(" AND visit_date = ").append("'").append(date).append("';");

                stmt.execute(insQuery3.toString());

                ResultSet res3 = stmt.getResultSet();

                diseases.clear();
                while (res3.next() == true) {
                    diseases.add(res3.getString("diseases"));
                }

                visit.setDiseasesHistory(diseases);


            }
        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(VisitDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }

        return visit;

    }

    public static void addVisit(Visit visit) throws ClassNotFoundException {

        try {
            visit.checkFields();

        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(VisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        Connection con = null;
        List<String> symptoms;
        List<String> diseases;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO ")
                    .append(" visit (patient_id, date, cure, doctor_id, nurse_id, employee_id, state) ")
                    .append(" VALUES (")
                    .append("'").append(visit.getPatientID()).append("',")
                    .append("DATE '").append(visit.getDate()).append("',")
                    .append("'").append(visit.getCure()).append("',")
                    .append("'").append(visit.getDoctorID()).append("',")
                    .append("'").append(visit.getNurseID()).append("',")
                    .append("'").append(visit.getEmployeeID()).append("',")
                    .append("'").append(visit.getState()).append("');");

            PreparedStatement stmtIns = con.prepareStatement(insQuery.toString());
            stmtIns.executeUpdate();

            StringBuilder insQuery2;

            diseases = visit.getDiseasesHistory();
            for (String dis : diseases) {
                insQuery2 = new StringBuilder();

                insQuery2.append("INSERT INTO ")
                        .append(" visit_diseases (visit_date, doctor_id, patient_id, diseases) ")
                        .append(" VALUES (")
                        .append("'").append(visit.getDate()).append("',")
                        .append("'").append(visit.getDoctorID()).append("',")
                        .append("'").append(visit.getPatientID()).append("',")
                        .append("DATE '").append(visit.getDate()).append("',")
                        .append("'").append(dis).append("');");

                PreparedStatement stmtIns2 = con.prepareStatement(insQuery2.toString());
                stmtIns2.executeUpdate();
            }

            StringBuilder insQuery3;

            symptoms = visit.getSymptoms();
            for (String sympt : symptoms) {
                insQuery3 = new StringBuilder();

                insQuery3.append("INSERT INTO ")
                        .append(" visit_symptoms (patient_id, date, symptoms, doctor_id) ")
                        .append(" VALUES (")
                        .append("'").append(visit.getPatientID()).append("',")
                        .append("DATE '").append(visit.getDate()).append("',")
                        .append("'").append(sympt).append("',")
                        .append("'").append(visit.getDoctorID()).append("');");
                PreparedStatement stmtIns3 = con.prepareStatement(insQuery3.toString());
                stmtIns3.executeUpdate();
            }

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(VisitDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }
    }

        /**
         * Close db connection
         *
         */
    public static void addSymptom(String patient_id, String date, String symptom, String doctor_id) throws ClassNotFoundException {

        if (patient_id == null || patient_id.trim().isEmpty() || date == null || date.trim().isEmpty()
                || symptom == null || symptom.trim().isEmpty() || doctor_id == null || doctor_id.trim().isEmpty()) {
            return;
        }

        Statement stmt = null;
        Connection con = null;
        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO ")
                    .append(" visit_symptoms (patient_id, date, symptoms, doctor_id) ")
                    .append(" VALUES (")
                    .append("'").append(patient_id).append("',")
                    .append("DATE '").append(date).append("',")
                    .append("'").append(symptom).append("',")
                    .append("'").append(doctor_id).append("');");

            PreparedStatement stmtIns = con.prepareStatement(insQuery.toString());
            stmtIns.executeUpdate();

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(VisitDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }

    }

    public static void addHistoryDisease(String visit_date, String patient_id, String doctor_id, String disease) throws ClassNotFoundException {

        if (patient_id == null || patient_id.trim().isEmpty() || visit_date == null || visit_date.trim().isEmpty()
                || disease == null || disease.trim().isEmpty() || doctor_id == null || doctor_id.trim().isEmpty()) {
            return;
        }

        Statement stmt = null;
        Connection con = null;

        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO ")
                    .append(" visit_diseases (visit_date, doctor_id, patient_id, diseases) ")
                    .append(" VALUES (")
                    .append("DATE '").append(visit_date).append("',")
                    .append("'").append(doctor_id).append("',")
                    .append("'").append(patient_id).append("',")
                    .append("'").append(disease).append("');");

            PreparedStatement stmtIns = con.prepareStatement(insQuery.toString());
            stmtIns.executeUpdate();

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(VisitDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }

    }

    public static void updateVisit(Visit visit) throws ClassNotFoundException {

        try {
            visit.checkFields();

        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(VisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        Connection con = null;
        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("UPDATE visit ")
                    .append(" SET ")
                    .append(" state = ").append("'").append(visit.getState()).append("'")
                    .append(" WHERE patient_id = ").append("'").append(visit.getPatientID()).append("' ")
                    .append(" AND doctor_id = ").append("'").append(visit.getDoctorID()).append("' ")
                    .append(" AND date = ").append("'").append(visit.getDate()).append("';");

            stmt.executeUpdate(insQuery.toString());
            System.out.println("#DB: The entry visit was successfully updated in the database.");

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(VisitDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }
    }

    /*
        From here and later on we will implement the relations of the DB.Which are the combination of one or more DB's.
     */
    public static void VisitTEP(Patient pat, Visit visit) throws ClassNotFoundException {

        try {
            visit.checkFields();
            pat.checkFields();

        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(VisitDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        Connection con = null;
        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            Patient patient = PatientDB.getPatient(pat.getPatient_id());

            if (patient != null) {
                /*just show the patient*/
            } else {
                PatientDB.addPatient(pat);
            }

            //Visit need doc to be set and mplampla
            //VisitDB.addVisit(visit);
            List<String> symptoms = visit.getSymptoms();
            List<Shift> shifts = ShiftDB.getShift(visit.getDate());
            if (symptoms.contains("heart")) {

                for (Shift shift : shifts) {
                    if (DoctorDB.getDoctor((shift.getDoctor_ID())).getSpec().equals(Doctor.Spec.CARDIOLOGIST)) {
                        visit.setDoctorID(shift.getDoctor_ID());
                        visit.setNurseID(shift.getNurse_ID());
                        visit.setEmployeeID(shift.getEmployee_ID());
                        //date is set from the servlet
                        //symptoms are set from the servlet
                        //diseases history is alreadey set or is set in the servlet
                        //cure is set after exam and diagnose
                        visit.setState("in progress");
                        visit.setPatientID(pat.getPatient_id());
                        break;
                    }
                }
            } else if (symptoms.contains("damaged nerves")) {

                for (Shift shift : shifts) {
                    if (DoctorDB.getDoctor((shift.getDoctor_ID())).getSpec().equals(Doctor.Spec.NEUROLOGIST)) {
                        visit.setDoctorID(shift.getDoctor_ID());
                        visit.setNurseID(shift.getNurse_ID());
                        visit.setEmployeeID(shift.getEmployee_ID());
                        //date is set from the servlet
                        //symptoms are set from the servlet
                        //diseases history is alreadey set or is set in the servlet
                        //cure is set after exam and diagnose
                        visit.setState("in progress");
                        visit.setPatientID(pat.getPatient_id());
                        break;
                    }
                }
            } else if (symptoms.contains("cough") || symptoms.contains("cold") || symptoms.contains("headache") || symptoms.contains("high temperature")) {
                for (Shift shift : shifts) {
                    if (DoctorDB.getDoctor((shift.getDoctor_ID())).getSpec().equals(Doctor.Spec.GP)) {
                        visit.setDoctorID(shift.getDoctor_ID());
                        visit.setNurseID(shift.getNurse_ID());
                        visit.setEmployeeID(shift.getEmployee_ID());
                        //date is set from the servlet
                        //symptoms are set from the servlet
                        //diseases history is alreadey set or is set in the servlet
                        //cure is set after exam and diagnose
                        visit.setState("in progress");
                        visit.setPatientID(pat.getPatient_id());
                        break;
                    }
                }
            } else if (symptoms.contains("weight loss") || symptoms.contains("weakness") || symptoms.contains("fatigue")) {
                for (Shift shift : shifts) {
                    if (DoctorDB.getDoctor((shift.getDoctor_ID())).getSpec().equals(Doctor.Spec.HAEMATOLOGIST)) {
                        visit.setDoctorID(shift.getDoctor_ID());
                        visit.setNurseID(shift.getNurse_ID());
                        visit.setEmployeeID(shift.getEmployee_ID());
                        //date is set from the servlet
                        //symptoms are set from the servlet
                        //diseases history is alreadey set or is set in the servlet + we add the new one after we find the cure.
                        //cure is set after exam and diagnose
                        visit.setState("in progress");
                        visit.setPatientID(pat.getPatient_id());
                        break;
                    }
                }

            } else if (symptoms.contains("tumor") || symptoms.contains("internal bleeding") || symptoms.contains("seizure") || symptoms.contains("bleeding")) {

                for (Shift shift : shifts) {
                    if (DoctorDB.getDoctor((shift.getDoctor_ID())).getSpec().equals(Doctor.Spec.SURGEON)) {
                        visit.setDoctorID(shift.getDoctor_ID());
                        visit.setNurseID(shift.getNurse_ID());
                        visit.setEmployeeID(shift.getEmployee_ID());
                        //date is set from the servlet
                        //symptoms are set from the servlet
                        //diseases history is alreadey set or is set in the servlet
                        //cure is set after exam and diagnose
                        visit.setState("in progress");
                        visit.setPatientID(pat.getPatient_id());
                        break;
                    }
                }
            }

            VisitDB.addVisit(visit);

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(VisitDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }


    }

    private static void closeDBConnection(Statement stmt, Connection con) {
        // Close connection
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(VisitDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(VisitDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
