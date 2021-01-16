/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;

import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Doctor.Doctor;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Employee.Employee;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Nurse.Nurse;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Shift.Shift;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

    public static List<Shift> getShift(String date) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        List<Shift> shifts = null;
        Shift shift = null;

        try {

            con = CS360DB.getConnection();

            stmt = con.createStatement();

            String d_end = date.substring(0, date.length() - 10);
            d_end = d_end + "8 09:00:00";

            System.out.println(date);
            System.out.println(d_end);

            StringBuilder insQuery = new StringBuilder();
            insQuery.append("SELECT * FROM shift ")
                    .append(" WHERE ")
                    .append(" date BETWEEN '").append(date).append("' AND '").append(d_end).append("';");

            stmt.execute(insQuery.toString());

            ResultSet res = stmt.getResultSet();

            shifts = new ArrayList<>();
            while (res.next() == true) {
                shift = new Shift();
                shift.setDate(date);
                shift.setDepartment(res.getString("department"));
                shift.setDoctor_ID(res.getString("doctor_id"));
                shift.setEmployee_ID(res.getString("employee_id"));
                shift.setNurse_ID(res.getString("nurse_id"));
                shift.setType(res.getString("type"));

                shifts.add(shift);
            }
        } catch (SQLException ex) {
            // Log exception
            Logger.getLogger(ShiftDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // close connection
            closeDBConnection(stmt, con);
        }

        return shifts;
    }

    public static void updateShift(Shift shift) throws ClassNotFoundException {
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

            insQuery.append("UPDATE  ")
                    .append(" shift ")
                    .append(" SET ")
                    .append("doctor_id='").append(shift.getDoctor_ID()).append("',")
                    .append("nurse_id='").append(shift.getNurse_ID()).append("',")
                    .append("type='").append(shift.getType()).append("',")
                    .append("department='").append(shift.getDepartment()).append("',")
                    .append("employee_id='").append(shift.getEmployee_ID()).append("';");

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


    /*
        From here and later on we will implement the relations of the DB.Which are the combination of one or more DB's.
     */
    //if two numbers exist withtin that range,return them.
    public static List<Integer> getTwoRandomFromRange(int quantity) {

        List<Integer> rands = new ArrayList<>();
        Random rand = new Random();
        int pos;

        if (quantity > 1) {
            while (rands.size() < 2) {
                pos = rand.nextInt(quantity);
                if (rands.isEmpty()) {
                    rands.add(pos);
                } else if (rands.get(0) != pos) {
                    rands.add(pos);
                }
            }
        } else if (quantity == 1) {
            rands.add(0);
        }

        return rands;
    }

    public static void CreateDayShift(String date) throws ClassNotFoundException, SQLException, InterruptedException {

        String ds = "surgeon,neurologist,haematologist,general_practitioner,cardiologist";
        String ns = "nurse_surgeon,nurse_neurologist,nurse_haematologist,nurse_general_practitioner";
        String es = "employee,administrative,assistant_manager";

        int counter = 0;
        int counter_10 = 0;
        date = date.substring(0, date.length() - 2);
        System.out.println(date);

        String[] doctor_specs = ds.split(",");
        String[] nurse_specs = ns.split(",");
        String[] employee_specs = es.split(",");

        List<Doctor> doctors = null;
        List<Nurse> nurses = null;
        List<Employee> employees = null;

        List<Integer> rands = null;

        for (String spec : doctor_specs) {
            doctors = DoctorDB.getDoctorsBySpec(spec);
            rands = getTwoRandomFromRange(doctors.size());
            if (!rands.isEmpty())//if not empty
            {
                for (int i = 0; i < rands.size(); i++) {//try to add 2 random doctors for shift
                    Shift shift = new Shift();
                    date = date + String.valueOf(counter_10) + String.valueOf(counter);
                    shift.setDate(date);
                    shift.setDepartment(getDepartment(spec));
                    shift.setEmployee_ID("");
                    shift.setNurse_ID("");
                    shift.setType(spec);
                    shift.setDoctor_ID(doctors.get(rands.get(i)).getDoctor_id());//get the id that func twoRandom returned

                    ShiftDB.addShift(shift);
                    date = date.substring(0, date.length() - 2);
                    //Thread.sleep(1000);
                    if (counter == 9) {
                        counter = 0;
                        counter_10++;
                    } else {
                        counter++;
                    }
                }
            }

        }
        for (String spec : nurse_specs) {
            nurses = NurseDB.getNursesBySpecialty(spec);
            rands = getTwoRandomFromRange(nurses.size());

            for (int i = 0; i < rands.size(); i++) {
                Shift shift = new Shift();
                date = date + String.valueOf(counter_10) + String.valueOf(counter);
                shift.setDate(date);
                shift.setDepartment(getDepartment(spec));
                shift.setEmployee_ID("");
                shift.setType(spec);
                shift.setDoctor_ID("");

                shift.setNurse_ID(nurses.get(rands.get(i)).getNurse_id());
                ShiftDB.addShift(shift);
                date = date.substring(0, date.length() - 2);
                if (counter == 9) {
                    counter = 0;
                    counter_10++;
                } else {
                    counter++;
                }
            }

        }

        for (String spec : employee_specs) {
            employees = EmployeeDB.getEmployeesBySpec(spec);
            rands = getTwoRandomFromRange(employees.size());

            for (int i = 0; i < rands.size(); i++) {
                Shift shift = new Shift();
                date = date + String.valueOf(counter_10) + String.valueOf(counter);
                shift.setDate(date);
                shift.setDepartment(getDepartment(spec));
                shift.setNurse_ID("");
                shift.setType(spec);
                shift.setDoctor_ID("");

                shift.setEmployee_ID(employees.get(rands.get(i)).getEmployee_id());
                ShiftDB.addShift(shift);
                date = date.substring(0, date.length() - 2);
                if (counter == 9) {
                    counter = 0;
                    counter_10++;
                } else {
                    counter++;
                }
            }

        }

    }

    public static String getDepartment(String spec) {

        if (spec.equals("surgeon") || spec.equals("nurse_surgeon")) {
            return "surgeries";
        } else if (spec.equals("neurologist") || spec.equals("nurse_neurologist")) {
            return "neurology";
        } else if (spec.equals("haematologist") || spec.equals("nurse_haematologist")) {
            return "haematology";
        } else if (spec.equals("general_practitioner") || spec.equals("nurse_general_practitioner")) {
            return "general_practices";
        } else if (spec.equals("cardiologist")) {
            return "cardiology";
        } else if (spec.equals("employee")) {
            return "employee_office";
        } else if (spec.equals("administrative")) {
            return "administrative_office";
        } else if (spec.equals("assistant_manager")) {
            return "assistant_manager_office";
        } else {
            return "Not Defined";
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
