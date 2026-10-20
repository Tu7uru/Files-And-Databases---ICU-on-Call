/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;

import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital.Examination;
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
public class ExamDB {

    public static List<Examination> getExams() throws ClassNotFoundException {
        List<Examination> examinations = new ArrayList<>();

        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM examination;");

            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                Examination exam = new Examination();
                exam.setExam_ID(res.getString("exam_id"));
                exam.setNurse_ID(res.getString("nurse_id"));
                exam.setExam_Room(res.getString("exam_room"));
                exam.setName(res.getString("name"));
                exam.setDoctorID(res.getString("doctor_id"));

                examinations.add(exam);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ExamDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return examinations;
    }

    public static Examination getExam(String exam_id) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        Examination exam = null;

        try {

            con = CS360DB.getConnection();

            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("SELECT * FROM examination")
                    .append(" WHERE ")
                    .append(" exam_id = ").append("'").append(exam_id).append("';");

            stmt.execute(insQuery.toString());

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {
                exam = new Examination();
                exam.setExam_ID(exam_id);
                exam.setNurse_ID(res.getString("nurse_id"));
                exam.setExam_Room(res.getString("exam_room"));
                exam.setName(res.getString("name"));
            }
        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(ExamDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }

        return exam;
    }

    public static void addExam(Examination exam) throws ClassNotFoundException {
        try {
            exam.checkFields();

        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(ExamDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        Connection con = null;
        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO ")
                    .append(" examination (exam_id, name, exam_room, nurse_id, doctor_id) ")
                    .append(" VALUES (")
                    .append("'").append(exam.getExam_ID()).append("',")
                    .append("'").append(exam.getName()).append("',")
                    .append("'").append(exam.getExam_Room()).append("',")
                    .append("'").append(exam.getNurse_ID()).append("',")
                    .append("'").append(exam.getDoctorID()).append("');");


            PreparedStatement stmtIns = con.prepareStatement(insQuery.toString());
            stmtIns.executeUpdate();

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(ExamDB.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ExamDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ExamDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
