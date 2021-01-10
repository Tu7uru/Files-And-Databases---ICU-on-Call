/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;

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
public class ShiftDB {

    public static List<Shift> getShifts() throws ClassNotFoundException {
        List<Shift> shifts = new ArrayList<>();

        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM shift");

            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                Shift shift = new Shift();
                shift.setDate(res.getString("date"));
                shift.setDepartment(res.getString("department"));
                shift.setDoctor_ID(res.getString("doctor_id"));
                shift.setEmployee_ID(res.getString("employee_id"));
                shift.setNurse_ID(res.getString("nurse_id"));
                shift.setType(res.getString("type"));

                shifts.add(shift);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShiftDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return shifts;
    }

    public static Shift getShift(String date) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        Shift shift = null;

        try {

            con = CS360DB.getConnection();

            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("SELECT * FROM shift ")
                    .append(" WHERE ")
                    .append(" date = ").append("'").append(date).append("';");

            stmt.execute(insQuery.toString());

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {
                shift = new Shift();
                shift.setDate(date);
                shift.setDepartment(res.getString("department"));
                shift.setDoctor_ID(res.getString("doctor_id"));
                shift.setEmployee_ID(res.getString("employee_id"));
                shift.setNurse_ID(res.getString("nurse_id"));
                shift.setType(res.getString("type"));
            }
        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(ShiftDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }

        return shift;
    }

    public static void addShift(Shift shift) throws ClassNotFoundException {

        try {
            shift.checkFields();

        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(ShiftDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        Connection con = null;
        try {

            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO ")
                    .append(" shift (date, doctor_id, nurse_id, type, department, employee_id) ")
                    .append(" VALUES (")
                    .append("'").append(shift.getDate()).append("',")
                    .append("'").append(shift.getDoctor_ID()).append("',")
                    .append("'").append(shift.getNurse_ID()).append("',")
                    .append("'").append(shift.getType()).append("',")
                    .append("'").append(shift.getDepartment()).append("',")
                    .append("'").append(shift.getEmployee_ID()).append("');");

            PreparedStatement stmtIns = con.prepareStatement(insQuery.toString());
            stmtIns.executeUpdate();

        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(ShiftDB.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(ShiftDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ShiftDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
