/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;

import java.sql.*;

/**
 *
 * @author Apostolos
 */
public class CS360DB {
    private static final String URL = "jdbc:mysql://localhost";
    private static final String DATABASE = "CS360";
    private static final int PORT = 3306;
    private static String UNAME = new String("root");
    private static String PASSWD = new String("");

    /**
     * Attempts to establish a database connection Using mariadb
     *
     * @return a connection to the database
     * @throws SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(URL + ":" + PORT + "/" + DATABASE, UNAME, PASSWD);
    }
}
