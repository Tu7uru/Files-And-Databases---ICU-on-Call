/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;

import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Employee.Administrative;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Employee.AssistantManager;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Employee.Employee;
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
public class EmployeeDB {

    /**
     * Get all employees
     * @return list of employees
     * @throws ClassNotFoundException
     */
    public static List<Employee> getEmployees() throws ClassNotFoundException {
        List<Employee> employees = new ArrayList<>();

        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM employee;");

            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                Employee empl = new Employee();
                empl.setEmployee_id(res.getString("employee_id"));
                empl.setName(res.getString("name"));
                empl.setLastname(res.getString("lastname"));
                empl.setPhone(res.getString("phone"));
                empl.setAddress(res.getString("address"));
                empl.setDepartment(res.getString("department"));
                empl.setUsername(res.getString("username"));
                empl.setPassword(res.getString("password"));
                empl.setEmail(res.getString("email"));
                employees.add(empl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return employees;
    }

    /**
     * Get employee
     *
     * @param username requested employee's usernaem
     * @return employee
     * @throws ClassNotFoundException
     */
    public static Employee getEmployeeByUsername(String username) throws ClassNotFoundException {
        Employee empl = new Employee();

        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM employee,administrative,assistant_manager " +
                    "WHERE username = " + username+";");

            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                empl.setEmployee_id(res.getString("employee_id"));
                empl.setName(res.getString("name"));
                empl.setLastname(res.getString("lastname"));
                empl.setPhone(res.getString("phone"));
                empl.setAddress(res.getString("address"));
                empl.setDepartment(res.getString("department"));
                empl.setUsername(res.getString("username"));
                empl.setPassword(res.getString("password"));
                empl.setEmail(res.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return empl;
    }

    /**
     * Get employee
     *
     * @param empl_id requested employee's id
     * @return employee
     * @throws ClassNotFoundException
     */
    public static Employee getEmployee(String empl_id) throws ClassNotFoundException {
        Employee empl = new Employee();

        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM employee " +
                    "WHERE employee_id = " + empl_id+";");


            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            while (res.next() == true) {
                empl.setEmployee_id(res.getString("employee_id"));
                empl.setName(res.getString("name"));
                empl.setLastname(res.getString("lastname"));
                empl.setPhone(res.getString("phone"));
                empl.setAddress(res.getString("address"));
                empl.setDepartment(res.getString("department"));
                empl.setUsername(res.getString("username"));
                empl.setPassword(res.getString("password"));
                empl.setEmail(res.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return empl;
    }

    public static Employee getEmployeebyUsername(String username) throws ClassNotFoundException {
        Employee empl = null;

        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();

            query.append("SELECT * FROM employee ")
                    .append(" WHERE username = ").append("'").append(username).append("';");

            stmt.execute(query.toString());

            ResultSet res = stmt.getResultSet();

            if (res.next() == true) {

                empl = new Employee();

                empl.setEmployee_id(res.getString("employee_id"));
                empl.setName(res.getString("name"));
                empl.setLastname(res.getString("lastname"));
                empl.setPhone(res.getString("phone"));
                empl.setAddress(res.getString("address"));
                empl.setDepartment(res.getString("department"));
                empl.setUsername(username);
                empl.setPassword(res.getString("password"));
                empl.setEmail(res.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return empl;

    }

    public static List<Employee> getEmployeesBySpec(String spec) throws ClassNotFoundException {
        List<Employee> employees = new ArrayList<>();
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
                Employee emp = new Employee();
                emp.setAddress(res.getString("address"));
                emp.setDepartment(res.getString("department"));
                emp.setEmail(res.getString("email"));
                emp.setEmployee_id(res.getString("employee_id"));
                emp.setLastname(res.getString("lastname"));
                emp.setName(res.getString("name"));
                emp.setPassword(res.getString("password"));
                emp.setUsername(res.getString("username"));
                employees.add(emp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }

        return employees;
    }

    public static void addEmployee(Employee e) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder query = new StringBuilder();


            query.append("INSERT INTO")
                    .append(" employee (employee_id, name, lastname, phone, "
                            + "address, department, username, password, email) ")
                    .append(" VALUES (")
                    .append("'").append(e.getEmployee_id()).append("',")
                    .append("'").append(e.getName()).append("',")
                    .append("'").append(e.getLastname()).append("',")
                    .append("'").append(e.getPhone()).append("',")
                    .append("'").append(e.getAddress()).append("',")
                    .append("'").append(e.getDepartment()).append("',")
                    .append("'").append(e.getUsername()).append("',")
                    .append("'").append(e.getPassword()).append("',")
                    .append("'").append(e.getEmail()).append("');");
            stmt.execute(query.toString());

            System.out.println("#DB: The member " + e.getUsername() + "  was successfully added in the database.");

        } catch (SQLException  ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
    }

    public static void addAdmin(Administrative a) throws ClassNotFoundException {
        Statement stmt = null;
        Statement stmt2 = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();
            stmt2 = con.createStatement();

            StringBuilder query = new StringBuilder();


            query.append("INSERT INTO")
                    .append(" employee (employee_id, name, lastname, phone, "
                            + "address, department, username, password, email) ")
                    .append(" VALUES (")
                    .append("'").append(a.getEmployee_id()).append("',")
                    .append("'").append(a.getName()).append("',")
                    .append("'").append(a.getLastname()).append("',")
                    .append("'").append(a.getPhone()).append("',")
                    .append("'").append(a.getAddress()).append("',")
                    .append("'").append(a.getDepartment()).append("',")
                    .append("'").append(a.getUsername()).append("',")
                    .append("'").append(a.getPassword()).append("',")
                    .append("'").append(a.getEmail()).append("');");
            stmt.execute(query.toString());

            StringBuilder query2 = new StringBuilder();

            query2.append("INSERT INTO")
                    .append(" administrative (employee_id, username, degree_title)" +
                            " VALUES(")
                    .append("'").append(a.getEmployee_id()).append("',")
                    .append("'").append(a.getUsername()).append("',")
                    .append("'").append(a.getDegree_title()).append("');");

            stmt2.execute(query2.toString());

            System.out.println("#DB: The member " + a.getUsername() + "  was successfully added in the database.");

        } catch (SQLException  ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
    }

    public static void addAssistantManager(AssistantManager a) throws ClassNotFoundException {
        Statement stmt = null;
        Statement stmt2 = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();
            stmt2 = con.createStatement();

            StringBuilder query = new StringBuilder();


            query.append("INSERT INTO")
                    .append(" employee (employee_id, name, lastname, phone, "
                            + "address, department, username, password, email)")
                    .append(" VALUES (")
                    .append("'").append(a.getEmployee_id()).append("',")
                    .append("'").append(a.getName()).append("',")
                    .append("'").append(a.getLastname()).append("',")
                    .append("'").append(a.getPhone()).append("',")
                    .append("'").append(a.getAddress()).append("',")
                    .append("'").append(a.getDepartment()).append("',")
                    .append("'").append(a.getUsername()).append("',")
                    .append("'").append(a.getPassword()).append("',")
                    .append("'").append(a.getEmail()).append("');");
            stmt.execute(query.toString());

            StringBuilder query2 = new StringBuilder();

            query2.append("INSERT INTO")
                    .append(" assistant_manager (employee_id, username, degree_title)" +
                            " VALUES(")
                    .append("'").append(a.getEmployee_id()).append("',")
                    .append("'").append(a.getUsername()).append("',")
                    .append("'").append(a.getDegree_title()).append("');");

            stmt2.execute(query2.toString());

            System.out.println("#DB: The member " + a.getUsername() + "  was successfully added in the database.");

        } catch (SQLException  ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeDBConnection(stmt, con);
        }
    }

    public static void updateEmployee(Employee e) throws ClassNotFoundException {
        try {
            e.checkFields();
        } catch (Exception ex) {
            // Log exception
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
        }

        Statement stmt = null;
        Statement stmt2 = null;
        Connection con = null;
        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();
            stmt2 = con.createStatement();

            StringBuilder query = new StringBuilder();
            query.append("UPDATE employee")
                    .append(" SET ")
                    .append("employee_id=").append("'").append(e.getEmployee_id()).append("',")
                    .append("name=").append("'").append(e.getName()).append("',")
                    .append("lastname=").append("'").append(e.getLastname()).append("',")
                    .append("phone=").append("'").append(e.getPhone()).append("',")
                    .append("address=").append("'").append(e.getAddress()).append("',")
                    .append("department=").append("'").append(e.getDepartment()).append("',")
                    .append("username=").append("'").append(e.getUsername()).append("',")
                    .append("password=").append("'").append(e.getPassword()).append("',")
                    .append("email=").append("'").append(e.getEmail()).append("');");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
