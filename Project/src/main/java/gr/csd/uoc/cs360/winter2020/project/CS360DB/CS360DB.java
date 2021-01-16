/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.CS360DB;

import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Doctor.Doctor;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Employee.Administrative;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Employee.AssistantManager;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Employee.Employee;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital.Disease;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital.Examination;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital.Medication;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Nurse.Nurse;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient.Patient;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient.Visit;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Shift.Shift;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.xml.transform.Result;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

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
    private static String desiredDate = "2021-01-17 21:00:00";
    /**
     * Attempts to establish a database connection Using mariadb
     *
     * @return a connection to the database
     * @throws SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL + ":" + PORT + "/" + DATABASE, UNAME, PASSWD);
    }

    public static void main(String args[]) throws ClassNotFoundException, SQLException, ParseException {

        //creatingTables();
        //__init__();
        //__init_diseases__();
        //__init_medicines__();
        //__clear__();
        //__init_shift__();
        //the Date and time at which you want to execute

        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormatter .parse(desiredDate);

        //Now create the time and schedule it
        Timer timer = new Timer();

        //Use this if you want to execute it once
        timer.schedule(new MyTimeTask(), date);

        //executeQueryOne("2021-01-10 21:00:00");
        //executeQueryTwoPerShift("2021-01-22 21:00:00");
        //executeQueryTwoPerMonth("2021-01-01 21:00:00");
        //executeQueryThree();
        //executeQueryFour("2020-10-10 20:00:00", "2020-10-10 23:00:00");

    }

    private static void __init_diseases__ () throws ClassNotFoundException{
        List<String> symptoms = new ArrayList<>();
        symptoms.add("nausea");
        symptoms.add("headaches");

        Disease d = new Disease(
                "brain_tumor",
                symptoms,
                "unable",
                "120_days",
                ""
        );

        DiseaseDB.addDisease(d);

        symptoms = new ArrayList<>();
        symptoms.add("sneezing");

        Disease d1 = new Disease(
                "flu",
                symptoms,
                "droplets",
                "",
                ""
        );

        DiseaseDB.addDisease(d1);

        symptoms = new ArrayList<>();
        symptoms.add("fever");
        symptoms.add("cough");

        Disease d2 = new Disease(
                "COVID",
                symptoms,
                "2_metres",
                "",
                ""
        );

        DiseaseDB.addDisease(d2);



        Disease d3 = new Disease(
                "broken_bone",
                new ArrayList<String>(),
                "unable",
                "",
                ""
        );

        DiseaseDB.addDisease(d3);

        symptoms = new ArrayList<>();
        symptoms.add("cough");

        Disease d4 = new Disease(
                "breathing_problems",
                symptoms,
                "unable",
                "",
                ""
        );

        DiseaseDB.addDisease(d4);

        symptoms = new ArrayList<>();
        symptoms.add("trouble_walking");
        symptoms.add("trouble_speaking");
        symptoms.add("heart_pain");

        Disease d5 = new Disease(
                "heart_attack",
                symptoms,
                "unable",
                "",
                ""
        );

        DiseaseDB.addDisease(d5);

        symptoms = new ArrayList<>();
        symptoms.add("thirst");
        symptoms.add("weight_loss");

        Disease d6 = new Disease(
                "diabetes",
                symptoms,
                "unable",
                "",
                ""
        );

        DiseaseDB.addDisease(d6);

        symptoms = new ArrayList<>();
        symptoms.add("memory_loss");

        Disease d7 = new Disease(
                "alzheimer",
                symptoms,
                "unable",
                "",
                ""
        );

        DiseaseDB.addDisease(d7);

        symptoms = new ArrayList<>();
        symptoms.add("dry_mouth");

        Disease d8 = new Disease(
                "dehydration",
                symptoms,
                "unable",
                "",
                ""
        );

        DiseaseDB.addDisease(d8);
    }

    private static void __init_medicines__() throws ClassNotFoundException {
        Medication med1 = new Medication("niflamol", "pill", "500mg", "broken_bone", "2022-01-10");
        Medication med2 = new Medication("niflamol", "pill", "1000mg", "broken_bone", "2022-06-10");
        Medication med3 = new Medication("intravenous_fluid", "fluid", "not_specified", "dehydration", "2023-06-12");
        Medication med4 = new Medication("Exelon", "pill", "450mg", "alzheimer", "2022-05-10");
        Medication med5 = new Medication("Exelon", "pill", "900mg", "alzheimer", "2023-10-10");
        Medication med6 = new Medication("pioglitazone", "pill", "450mg", "diabetes", "2021-10-10");
        Medication med7 = new Medication("cardiolip", "pill", "500mg", "heart_attack", "2022-01-20");
        Medication med8 = new Medication("cardiolip", "pill", "850mg", "heart_attack", "2022-03-26");
        Medication med9 = new Medication("pfizer_bionteck_covid19", "needle_vaccine", "0.3ml", "COVID", "2024-05-10");
        Medication med10 = new Medication("cold_n_flu", "pill", "500mg", "flu", "2023-02-10");
        Medication med11 = new Medication("cold_n_flu", "pill", "250mg", "flu", "2023-02-10");
        Medication med12 = new Medication("cold_n_flu", "pill", "1000mg", "flu", "2023-07-07");
        Medication med13 = new Medication("Zithromax", "pill", "250mg", "breathing_problems", "2023-07-07");
        Medication med14 = new Medication("Temozolomide", "intravenously", "not_specified", "brain_tumor", "2021-08-18");

        MedicationDB.addMedication(med1);
        MedicationDB.addMedication(med2);
        MedicationDB.addMedication(med3);
        MedicationDB.addMedication(med4);
        MedicationDB.addMedication(med5);
        MedicationDB.addMedication(med6);
        MedicationDB.addMedication(med7);
        MedicationDB.addMedication(med8);
        MedicationDB.addMedication(med9);
        MedicationDB.addMedication(med10);
        MedicationDB.addMedication(med11);
        MedicationDB.addMedication(med12);
        MedicationDB.addMedication(med13);
        MedicationDB.addMedication(med14);


    }

    private static void __init_shift__() throws ClassNotFoundException {

        for (int i = 0; i < 1; i++) {
            Shift shift = new Shift("2020-10-10 21:00:00", DoctorDB.getDoctors().get(i).getDoctor_id(), "x", "x", "x", "");
            ShiftDB.addShift(shift);
        }

        /*for (int i = 0; i < 4; i++) {
            Shift shift = new Shift("2020-10-10", "x", NurseDB.getNurses().get(i).getNurse_id(), "x", "x", "");
            ShiftDB.addShift(shift);
        }

        for (int i = 0; i < 4; i++) {
            Shift shift = new Shift("2020-10-10", "x", "x", "x", "", EmployeeDB.getEmployees().get(i).getEmployee_id());
            ShiftDB.addShift(shift);
        }*/

    }

    private static void __init__() throws ClassNotFoundException {
        for (int i = 1; i <= 5; i++) {
            Doctor d = new Doctor(
                    "doc" + i,
                    "docdoc",
                    "doc" + i + "@example.com",
                    "doc",
                    "doc",
                    "1234567890",
                    "address z " + i,
                    "",
                    Doctor.Spec.CARDIOLOGIST
            );

            DoctorDB.addDoctor(d);

            Doctor d2 = new Doctor(
                    "doc" + (i + 10),
                    "docdoc",
                    "doc" + (i + 10) + "@example.com",
                    "doc",
                    "doc",
                    "1234567890",
                    "address z " + (i + 10),
                    "",
                    Doctor.Spec.SURGEON
            );

            DoctorDB.addDoctor(d2);

            Doctor d3 = new Doctor(
                    "doc" + (i + 20),
                    "docdoc",
                    "doc" + (i + 20) + "@example.com",
                    "doc",
                    "doc",
                    "1234567890",
                    "address z " + (i + 20),
                    "",
                    Doctor.Spec.NEUROLOGIST
            );

            DoctorDB.addDoctor(d3);

            Doctor d4 = new Doctor(
                    "doc" + (i + 30),
                    "docdoc",
                    "doc" + (i + 30) + "@example.com",
                    "doc",
                    "doc",
                    "1234567890",
                    "address z " + (i + 30),
                    "",
                    Doctor.Spec.GP
            );

            DoctorDB.addDoctor(d4);

            Doctor d5 = new Doctor(
                    "doc" + (i + 40),
                    "docdoc",
                    "doc" + (i + 40) + "@example.com",
                    "doc",
                    "doc",
                    "1234567890",
                    "address z " + (i + 40),
                    "",
                    Doctor.Spec.HAEMATOLOGIST
            );

            DoctorDB.addDoctor(d5);

            //----------------------
            Nurse n = new Nurse(
                    "nurse" + i,
                    "nursenurse",
                    "nurse" + i + "@example.com",
                    "nurse",
                    "nurse",
                    "1234567980",
                    "address y" + i,
                    "",
                    Nurse.Spec.NEUROLOGIST
            );

            NurseDB.addNurse(n);

            Nurse n1 = new Nurse(
                    "nurse" + (i + 10),
                    "nursenurse",
                    "nurse" + (i + 10) + "@example.com",
                    "nurse",
                    "nurse",
                    "1234567980",
                    "address y" + (i + 10),
                    "",
                    Nurse.Spec.GP
            );

            NurseDB.addNurse(n1);

            Nurse n2 = new Nurse(
                    "nurse" + (i + 20),
                    "nursenurse",
                    "nurse" + (i + 20) + "@example.com",
                    "nurse",
                    "nurse",
                    "1234567980",
                    "address y" + (i + 20),
                    "",
                    Nurse.Spec.HAEMATOLOGIST
            );

            NurseDB.addNurse(n2);

            Nurse n3 = new Nurse(
                    "nurse" + (i + 30),
                    "nursenurse",
                    "nurse" + (i + 30) + "@example.com",
                    "nurse",
                    "nurse",
                    "1234567980",
                    "address y" + (i + 30),
                    "",
                    Nurse.Spec.SURGEON
            );

            NurseDB.addNurse(n3);

            //-------------------
            Employee e = new Employee(
                    "empl",
                    "empl",
                    "1234123411",
                    "address x" + i,
                    "dep " + i,
                    "empl" + i,
                    "emplempl",
                    "empl" + i + "@example.com"
            );

            EmployeeDB.addEmployee(e);

            Employee e1 = new Employee(
                    "empl",
                    "empl",
                    "1234123411",
                    "address x" + (i + 10),
                    "dep " + (i + 10),
                    "empl" + (i + 10),
                    "emplempl",
                    "empl" + (i + 10) + "@example.com"
            );

            EmployeeDB.addEmployee(e1);

            Employee e2 = new Employee(
                    "empl",
                    "empl",
                    "1234123411",
                    "address x" + (i + 20),
                    "dep " + (i + 20),
                    "empl" + (i + 20),
                    "emplempl",
                    "empl" + (i + 20) + "@example.com"
            );

            EmployeeDB.addEmployee(e2);

            Employee e3 = new Employee(
                    "empl",
                    "empl",
                    "1234123411",
                    "address x" + (i + 30),
                    "dep " + (i + 30),
                    "empl" + (i + 30),
                    "emplempl",
                    "empl" + (i + 30) + "@example.com"
            );

            EmployeeDB.addEmployee(e3);

            Employee e4 = new Employee(
                    "empl",
                    "empl",
                    "1234123411",
                    "address x" + (i + 40),
                    "dep " + (i + 40),
                    "empl" + (i + 40),
                    "emplempl",
                    "empl" + (i + 40) + "@example.com"
            );

            EmployeeDB.addEmployee(e4);

            Administrative a = new Administrative(
                    "admin",
                    "admin",
                    "0000111111",
                    "address w",
                    "depr1",
                    "admin",
                    "admin",
                    "admin@example.com",
                    "degree"
            );

            EmployeeDB.addAdmin(a);

            AssistantManager an = new AssistantManager(
                    "as",
                    "as",
                    "0011111111",
                    "address w",
                    "depr1",
                    "as" + i,
                    "admin",
                    "as@example.com",
                    "degree"
            );

            EmployeeDB.addAssistantManager(an);

            AssistantManager an2 = new AssistantManager(
                    "as",
                    "as",
                    "0011111111",
                    "address w",
                    "depr1",
                    "as" + (i + 40),
                    "admin",
                    "as@example.com",
                    "degree"
            );

            EmployeeDB.addAssistantManager(an2);

            AssistantManager an3 = new AssistantManager(
                    "as",
                    "as",
                    "0011111111",
                    "address w",
                    "depr1",
                    "as" + (i + 30),
                    "admin",
                    "as@example.com",
                    "degree"
            );

            EmployeeDB.addAssistantManager(an3);

            AssistantManager an4 = new AssistantManager(
                    "as",
                    "as",
                    "0011111111",
                    "address w",
                    "depr1",
                    "as" + (i + 20),
                    "admin",
                    "as@example.com",
                    "degree"
            );

            EmployeeDB.addAssistantManager(an4);

            AssistantManager an5 = new AssistantManager(
                    "as",
                    "as",
                    "0011111111",
                    "address w",
                    "depr1",
                    "as" + (i + 10),
                    "admin",
                    "as@example.com",
                    "degree"
            );

            EmployeeDB.addAssistantManager(an5);

            Patient p = new Patient(
                    "pat",
                    "pat",
                    "1234123443",
                    "address",
                    "1insurance1",
                    "11111111111",
                    "pat" + i,
                    "pat",
                    "pat@example.com"

            );

            PatientDB.addPatient(p);


            List<String> symptoms = Arrays.asList(new String[]{"heart_pain"});
            List<String> diseases = Arrays.asList(new String[] {"cancer"});
            Visit v = new Visit(
                    p.getPatient_id(),
                    "2021-1-10",
                    "",
                    symptoms,
                    diseases,
                    "",
                    "",
                    "",
                    "STABLE"

            );

            VisitDB.addVisit(v);
        }



    }

    private static void __clear__() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL + ":" + PORT + "/" + DATABASE + "?characterEncoding=UTF-8", UNAME, PASSWD);

        Statement stmt = con.createStatement();

        stmt.executeUpdate("DELETE FROM visit;");
        stmt.executeUpdate("DELETE FROM visit_diseases;");
        stmt.executeUpdate("DELETE FROM visit_symptoms;");
        stmt.executeUpdate("DELETE FROM doctor;");
        stmt.executeUpdate("DELETE FROM nurse;");
        stmt.executeUpdate("DELETE FROM cardiologist;");
        stmt.executeUpdate("DELETE FROM neurologist;");
        stmt.executeUpdate("DELETE FROM surgeon;");
        stmt.executeUpdate("DELETE FROM general_practitioner;");
        stmt.executeUpdate("DELETE FROM haematologist;");
        stmt.executeUpdate("DELETE FROM nurse_neurologist;");
        stmt.executeUpdate("DELETE FROM nurse_general_practitioner;");
        stmt.executeUpdate("DELETE FROM nurse_haematologist;");
        stmt.executeUpdate("DELETE FROM nurse_surgeon;");
        stmt.executeUpdate("DELETE FROM orders;");
        stmt.executeUpdate("DELETE FROM employee;");
        stmt.executeUpdate("DELETE FROM patient;");
        stmt.executeUpdate("DELETE FROM visit;");
        stmt.executeUpdate("DELETE FROM shift;");
        stmt.executeUpdate("DELETE FROM medication;");
        stmt.executeUpdate("DELETE FROM examination;");
        stmt.executeUpdate("DELETE FROM supervised_by;");
        stmt.executeUpdate("DELETE FROM prescribe;");
        stmt.executeUpdate("DELETE FROM undergo;");
        stmt.executeUpdate("DELETE FROM diagnose;");
        stmt.executeUpdate("DELETE FROM suffers_from;");
        stmt.executeUpdate("DELETE FROM visit_symptoms;");
        stmt.executeUpdate("DELETE FROM diagnose_symptoms;");
        stmt.executeUpdate("DELETE FROM disease;");
        stmt.executeUpdate("DELETE FROM administrative;");
        stmt.executeUpdate("DELETE FROM assistant_manager;");
        stmt.executeUpdate("DELETE FROM disease_symptoms;");
    }

    public static void creatingTables() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL + ":" + PORT + "/" + DATABASE + "?characterEncoding=UTF-8", UNAME, PASSWD);

        StringBuilder createTable = new StringBuilder();

        //------------------- Creating doctors -------------------//


        createTable.append("CREATE TABLE IF NOT EXISTS cardiologist (" +
                "doctor_id varchar(50), name varchar(20), lastname varchar(20), phone varchar(10), address varchar(40)," +
                "username varchar(15) NOT NULL," +
                "password varchar(15), email varchar(26), employee_id varchar(50)," +
                "PRIMARY KEY(doctor_id, username)" +
                ");");

        Statement stmt = con.createStatement();

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS neurologist (doctor_id varchar(50), name varchar(20)," +
                " lastname varchar(20), phone varchar(10), address varchar(40)," +
                " username varchar(15)," +
                "password varchar(15), email varchar(26), employee_id varchar(50)," +
                "PRIMARY KEY(doctor_id, username)" +
                ");"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS doctor (username varchar(50), doctor_id varchar(50),type varchar(20), PRIMARY KEY(username,doctor_id));"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS general_practitioner (doctor_id varchar(50), name varchar(20), lastname varchar(20), phone varchar(10), address varchar(40), username varchar(15)," +
                "password varchar(15), email varchar(26), employee_id varchar(50),PRIMARY KEY(doctor_id, username));"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS haematologist (doctor_id varchar(50), name varchar(20), lastname varchar(20), phone varchar(10), address varchar(40), username varchar(15)," +
                "password varchar(15), email varchar(26), employee_id varchar(50),PRIMARY KEY(doctor_id, username));"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS surgeon (doctor_id varchar(50), name varchar(20), lastname varchar(20), phone varchar(10), address varchar(40), username varchar(15)," +
                "password varchar(15), email varchar(26), employee_id varchar(50),PRIMARY KEY(doctor_id, username));"));

        stmt.executeUpdate(createTable.toString());

        //---------------------------------------------------------//

        //------------------- Creating nurses -------------------//

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS nurse (username varchar(50), nurse_id varchar(50)" +
                " , type varchar(50)," +
                " PRIMARY KEY(username,nurse_id));"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS nurse_neurologist (nurse_id varchar(50), name varchar(20), lastname varchar(20), phone varchar(10), address varchar(40), username varchar(15)," +
                "password varchar(15), email varchar(26), employee_id varchar(50),PRIMARY KEY(nurse_id, username));"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS nurse_general_practitioner (nurse_id varchar(50), name varchar(20), lastname varchar(20), phone varchar(10), address varchar(40), username varchar(15)," +
                "password varchar(15), email varchar(26), employee_id varchar(50),PRIMARY KEY(nurse_id, username));"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS nurse_haematologist (nurse_id varchar(50), name varchar(20), lastname varchar(20), phone varchar(10), address varchar(40), username varchar(15)," +
                "password varchar(15), email varchar(26), employee_id varchar(50),PRIMARY KEY(nurse_id, username));"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS nurse_surgeon (nurse_id varchar(50), name varchar(20), lastname varchar(20), phone varchar(10), address varchar(40), username varchar(15)," +
                "password varchar(15), email varchar(26), employee_id varchar(50),PRIMARY KEY(nurse_id, username));"));

        stmt.executeUpdate(createTable.toString());


        //---------------------------------------------------------//

        //------------------- Creating employees -------------------//

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS employee (employee_id varchar(50), name varchar(20), lastname varchar(20), phone varchar(10), address varchar(40), " +
                "department varchar(40) ,username varchar(15)," +
                "password varchar(15), email varchar(26),PRIMARY KEY(employee_id, username));"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS administrative (employee_id varchar(50), " +
                "username varchar(15)," +
                "degree_title varchar(26), PRIMARY KEY(employee_id, username));"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS assistant_manager(employee_id varchar(50), " +
                "username varchar(15)," +
                "degree_title varchar(26), PRIMARY KEY(employee_id, username));"));

        stmt.executeUpdate(createTable.toString());

        //---------------------------------------------------------//

        //------------------- Creating patient -------------------//

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS patient (patient_id varchar(50), name varchar(20), lastname varchar(20)," +
                " phone varchar(10), address varchar(40), " +
                "insurance varchar(40),amka varchar(11) ,username varchar(15)," +
                "password varchar(15), email varchar(26),employee_id varchar(50),PRIMARY KEY(patient_id, username));"));

        stmt.executeUpdate(createTable.toString());

        //---------------------------------------------------------//
        //------------------- Creating visit ----------------------//
        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS visit (patient_id varchar(50), " +
                "date DATETIME, cure varchar(40), doctor_id varchar(50), nurse_id varchar(50), employee_id varchar(50), " +
                "state varchar(10)," +
                "PRIMARY KEY(patient_id, date));"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS visit_diseases (" +
                "date DATETIME, " +
                "patient_id varchar(50), diseases varchar(50)," +
                "PRIMARY KEY(patient_id, date,diseases)" +
                ");"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS visit_symptoms (" +
                "patient_id varchar(50), " +
                "date DATETIME, symptoms varchar(50)," +
                "PRIMARY KEY(patient_id, date,symptoms)" +
                ");"));

        stmt.executeUpdate(createTable.toString());
        //---------------------------------------------------------//
        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS shift (" +
 "date DATETIME, doctor_id varchar(50), nurse_id varchar(50),"
                + "type varchar(40), department varchar(40), employee_id varchar(50),"
                + "PRIMARY KEY(date)"
                +                ");"));

        stmt.executeUpdate(createTable.toString());
        //---------------------------------------------------------//


        /*createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS shift (" +
                "date DATE, doctor_id varchar(50), nurse_id varchar(50)," +
                "type varchar(15), department varchar(40), employee_id varchar(50)," +
                "PRIMARY KEY(date)" +
                ");"));

        stmt.executeUpdate(createTable.toString());
*/
        //---------------------------------------------------------//

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS medication (" +
                "med_id varchar(50), name varchar(50), type varchar(15), dosage varchar(15)," +
                "use_for varchar(20), exp_date DATETIME," +
                "PRIMARY KEY(med_id)" +
                ");"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS examination (" +
                "exam_id varchar(50),name varchar(50), exam_room varchar(50), nurse_id varchar(50), doctor_id varchar(50)," +
                "PRIMARY KEY(exam_id)"+
                ") ENGINE = InnoDB;"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS diagnose(" +
                "diagnose_id varchar(50),exam_id varchar(50),disease_name varchar(50), " +
                "nurse_id varchar(50)," +
                "PRIMARY KEY(diagnose_id,exam_id)" +
                ");"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS diagnose_symptoms (" +
                "diagnose_id varchar(50), exam_id varchar(50)," +
                "symptoms varchar(50)," +
                "PRIMARY KEY(diagnose_id,exam_id,symptoms)" +
                ");"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS disease (" +
                "name varchar(50), transmissibility varchar(25)," +
                "incubation varchar(50), therapy_duration varchar(25)," +
                "PRIMARY KEY(name)" +
                ");"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS disease_symptoms (" +
                "name varchar(50), symptoms varchar(50)," +
                "PRIMARY KEY(name,symptoms)" +
                ");"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS supervised_by (" +
                "exam_id varchar(50), med_id varchar(50), doctor_id varchar(50), diagnose_id varchar(50)," +
                "PRIMARY KEY(exam_id)" +
                ");"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS undergo (" +
                "patient_id varchar(50), exam_id varchar(50), date DATETIME, symptoms varchar(50)," +
                "PRIMARY KEY(patient_id, exam_id)" +
                ");"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS suffers_from(" +
                "patient_id varchar(50), disease_name varchar(50)," +
                "PRIMARY KEY(patient_id, disease_name)" +
                ");"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS prescribe ("
                + "exam_id varchar(50), med_id varchar(50),date DATETIME, doctor_id varchar(50),"
                + "PRIMARY KEY(exam_id,med_id)"
                + ");"));

        stmt.executeUpdate(createTable.toString());

        /*        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS prescribe (" +
                "exam_id varchar(50), diagnose_id varchar(50)," +
                "PRIMARY KEY(exam_id)" +
                ");"));

        stmt.executeUpdate(createTable.toString());
*/
        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS orders (exam_id varchar(50)," +
                "doctor_id varchar(50), nurse_id varchar(50),exam_name varchar(50),exam_room varchar(50)," +
                "PRIMARY KEY(exam_id));"));
        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE VIEW employee_to_n_surgeon AS SELECT nurse_id,name,lastname,username,email FROM nurse_surgeon;"));
        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE VIEW employee_to_n_neurologist AS SELECT nurse_id,name,lastname,username,email FROM nurse_neurologist;"));
        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE VIEW employee_to_n_gp AS SELECT nurse_id,name,lastname,username,email FROM nurse_general_practitioner;"));
        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE VIEW employee_to_n_haematologist AS SELECT nurse_id,name,lastname,username,email FROM nurse_haematologist;"));
        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE VIEW employee_to_neurologist AS SELECT doctor_id,name,lastname,username,email FROM neurologist;"));
        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE VIEW employee_to_surgeon AS SELECT doctor_id,name,lastname,username,email FROM surgeon;"));
        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE VIEW employee_to_haematologist AS SELECT doctor_id,name,lastname,username,email FROM haematologist;"));
        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE VIEW employee_to_gp AS SELECT doctor_id,name,lastname,username,email FROM general_practitioner;"));
        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE VIEW employee_to_cardiologist AS SELECT doctor_id,name,lastname,username,email FROM cardiologist;"));
        stmt.executeUpdate(createTable.toString());

    }

    public static String getUserName() {
        return UNAME;
    }

    private static void executeQueryOne(String shift_date) throws SQLException, ClassNotFoundException {
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        StringBuilder q = new StringBuilder();

        StringTokenizer tk = new StringTokenizer(shift_date, " ");
        String day = tk.nextToken();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(day));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        c.add(Calendar.DAY_OF_MONTH, 1);
        String newDate = sdf.format(c.getTime());
        newDate += " 09:00:00";

        q.append("SELECT state,date FROM visit ")
                .append(" WHERE date BETWEEN '" + shift_date)
                .append("' AND '" + newDate + "'; ");

        stmt.execute(q.toString());

        ResultSet res = stmt.getResultSet();
        System.out.println("VISITS BETWEEN " + shift_date + " AND "+ newDate);

        System.out.println("-----------------------------------------" );
        while(res.next() == true) {
            System.out.println("\t" + res.getString("date")+" -> " + res.getString("state"));
            System.out.println("-----------------------------------------" );
        }



    }

    private static void executeQueryTwoPerMonth(String month) throws SQLException, ClassNotFoundException, ParseException {
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        StringBuilder q = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        StringTokenizer tk = new StringTokenizer(month, " ");
        String day = tk.nextToken();
        StringTokenizer tk2 = new StringTokenizer(day, "-");
        String actualDay = tk2.nextToken();
        String actualMonth = tk2.nextToken();


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Calendar c = Calendar.getInstance();

        try {
            c.setTime(sdf.parse(day));
            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String newDate = sdf.format(c.getTime());
        newDate += " 23:59:59";

        answer.append("DISEASES,MEDICATION,EXAMINATIONS FOR MONTH: " + actualMonth +"\n")
                .append("-----------------------------------------\n" );

        q.append("SELECT diseases FROM visit_diseases")
                .append(" WHERE date BETWEEN '" + month + "' AND '" + newDate + "';");

        stmt.execute(q.toString());
        ResultSet res = stmt.getResultSet();

        answer.append("DISEASES\n")
                .append("-----------------------------------------\n" );
        while(res.next() == true) {
            answer.append("\t" + res.getString("diseases") + "\n");
        }
        answer.append("-----------------------------------------\n" );

        q.setLength(0);
        q.append("SELECT name,dosage FROM medication ")
                .append( "WHERE med_id IN ( SELECT med_id FROM prescribe WHERE ")
                .append(" prescribe.date BETWEEN '" + month + "' AND '" + newDate + "');");

        stmt.execute(q.toString());
        res = stmt.getResultSet();

        answer.append("MEDICATIONS\n")
                .append("-----------------------------------------\n" );
        while(res.next() == true) {
            answer.append("\t" + res.getString("name") + "\t|\t" +res.getString("dosage") + "\n");
        }
        answer.append("-----------------------------------------\n" );

        q.setLength(0);
        q.append("SELECT name FROM examination ")
                .append( "WHERE exam_id IN ( SELECT exam_id FROM prescribe WHERE ")
                .append(" prescribe.date BETWEEN '" + month + "' AND '" + newDate + "');");

        stmt.execute(q.toString());
        res = stmt.getResultSet();

        answer.append("EXAMINATIONS\n")
                .append("-----------------------------------------\n" );
        while(res.next() == true) {
            answer.append("\t" + res.getString("name") + "\n");
        }
        answer.append("-----------------------------------------\n" );

        System.out.println(answer.toString());
    }

    private static void executeQueryTwoPerShift(String shift_date) throws SQLException, ClassNotFoundException {
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        StringBuilder q = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        StringTokenizer tk = new StringTokenizer(shift_date, " ");
        String day = tk.nextToken();
        String hour = tk.nextToken();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(day));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        c.add(Calendar.DAY_OF_MONTH, 1);
        String newDate = sdf.format(c.getTime());
        newDate += " 09:00:00";

        answer.append("DISEASES,MEDICATION,EXAMINATIONS FOR SHIFT: " + shift_date +"\n")
                .append("-----------------------------------------\n" );

        q.append("SELECT DISTINCT diseases FROM visit_diseases")
                .append(" WHERE date BETWEEN '" + shift_date + "' AND '" + newDate + "';");

        stmt.execute(q.toString());
        ResultSet res = stmt.getResultSet();

        answer.append("DISEASES\n")
                .append("-----------------------------------------\n" );
        while(res.next() == true) {
            answer.append("\t" +  res.getString("diseases") + "\n");
        }
        answer.append("-----------------------------------------\n" );


        q.setLength(0);
        q.append("SELECT DISTINCT name,dosage FROM medication ")
                .append( "WHERE med_id IN ( SELECT med_id FROM prescribe WHERE ")
                .append(" prescribe.date BETWEEN '" + shift_date + "' AND '" + newDate + "');");

        stmt.execute(q.toString());
        res = stmt.getResultSet();

        answer.append("MEDICATIONS\n")
                .append("-----------------------------------------\n" );
        while(res.next() == true) {
            answer.append("\t" + res.getString("name") +"\t|\t"+res.getString("dosage")+ "\n");
        }
        answer.append("-----------------------------------------\n" );

        q.setLength(0);
        q.append("SELECT DISTINCT name FROM examination ")
                .append( "WHERE exam_id IN ( SELECT exam_id FROM prescribe WHERE ")
                .append(" prescribe.date BETWEEN '" + shift_date + "' AND '" + newDate + "');");

        stmt.execute(q.toString());
        res = stmt.getResultSet();

        answer.append("EXAMINATIONS\n")
                .append("-----------------------------------------\n" );
        while(res.next() == true) {
            answer.append("\t" + res.getString("name") + "\n");
        }
        answer.append("-----------------------------------------\n" );

        System.out.println(answer.toString());
    }

    private static void executeQueryThree()throws SQLException, ClassNotFoundException {
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        StringBuilder q = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        q.append("SELECT COUNT(*) ")
                .append("FROM visit_diseases WHERE diseases='COVID-19'");

        stmt.execute(q.toString());
        answer.append("\t COVID-19 REPORT\n")
                .append("-----------------------------------------\n" );
        ResultSet res = stmt.getResultSet();
        while(res.next() == true) {
            answer.append("Patients with COVID-19:\t"+res.getInt("count(*)") + "\n");
        }
        answer.append("-----------------------------------------\n" );

        q.setLength(0);
        q.append("SELECT name,lastname,phone,address,diseases FROM ")
                .append("patient P, visit_diseases V WHERE P.patient_id = V.patient_id")
                .append(" AND V.patient_id IN ( SELECT patient_id FROM visit_diseases WHERE")
                                .append(" diseases = 'COVID-19');");


        stmt.execute(q.toString());
        ResultSet rs = stmt.getResultSet();

        while(rs.next() == true) {
            answer.append("\t" + rs.getString("name") )
                    .append("\t" + rs.getString("lastname") )
                    .append("\t" + rs.getString("phone") )
                    .append("\t" + rs.getString("address") )
                    .append("\t" + rs.getString("diseases") )
                    .append("\n");
        }
        answer.append("-----------------------------------------\n" );

        System.out.println(answer.toString());
    }

    private static void executeQueryFour(String start, String end) throws SQLException, ClassNotFoundException {
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        StringBuilder q = new StringBuilder();
        StringBuilder e = new StringBuilder();
        StringBuilder n = new StringBuilder();
        StringBuilder d = new StringBuilder();

        q.append("SELECT employee.username, shift.date FROM employee LEFT JOIN shift ON employee.employee_id = shift.employee_id")
                .append(" WHERE date BETWEEN " )
                .append("'" + start + "' AND '" + end + "' ORDER BY employee.username;");

        stmt.execute(q.toString());

        ResultSet res = stmt.getResultSet();

        e.append("EMPLOYEE SHIFTS\n")
                .append("---------------------------\n");
        while(res.next() == true) {
            e.append("\t" + res.getString("employee.username") )
                    .append(" \t->\t" + res.getString("shift.date"))
                    .append("\n");
        }

        e.append("\n---------------------------\n");

        q.setLength(0);
        q.append("SELECT doctor.username, shift.date FROM doctor LEFT JOIN shift ON doctor.doctor_id = shift.doctor_id")
                .append(" WHERE shift.date BETWEEN " )
                .append("'" + start + "' AND '" + end + "' ORDER BY doctor.username;");

        stmt.execute(q.toString());

        res = stmt.getResultSet();

        d.append("DOCTOR SHIFTS\n")
                .append("---------------------------\n");
        while(res.next() == true) {
            d.append("\t" + res.getString("doctor.username"))
                    .append(" \t->\t" + res.getString("shift.date") )
                    .append("\n");
        }

        d.append("\n---------------------------\n");

        q.setLength(0);
        q.append("SELECT nurse.username, shift.date FROM nurse LEFT JOIN shift ON nurse.nurse_id = shift.nurse_id")
                .append(" WHERE shift.date BETWEEN " )
                .append("'" + start + "' AND '" + end + "' ORDER BY nurse.username;");

        stmt.execute(q.toString());

        res = stmt.getResultSet();

        n.append("NURSE SHIFTS\n")
                .append("---------------------------\n");
        while(res.next() == true) {
            n.append("\t" + res.getString("nurse.username"))
                    .append(" \t->\t" + res.getString("shift.date") )
                    .append("\n");
        }

        n.append("\n---------------------------\n");

        System.out.println(e.toString());
        System.out.println(d.toString());
        System.out.println(n.toString());
    }

    private static class MyTimeTask extends TimerTask
    {

        public void run()
        {
            try {
                ShiftDB.CreateDayShift(desiredDate);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException | InterruptedException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
