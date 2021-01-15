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
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Hospital.Medication;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Nurse.Nurse;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient.Patient;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient.Visit;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Shift.Shift;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL + ":" + PORT + "/" + DATABASE, UNAME, PASSWD);
    }

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        //creatingTables();
        __init__();
        //__init_diseases__();
        //__init_meds__();
        /*Shift s = new Shift(
                "2020-01-01",
                "",
                "",
                "",
                "",
                ""
        );

        ShiftDB.addShift(s); */
        //__clear__();
        /*List<String> symptoms = new ArrayList<>();
        symptoms.add("eye pain");
        List<String> diseases = new ArrayList<>();
        diseases.add("cancer");

        Visit v = new Visit(
                "62c2ab31-aa9a-4cb7-ba25-a0be77850303",
                "2020-01-14",
                "medicine",
                symptoms,
                diseases,
                "",
                "",
                "",
                "DANGEROUS"
        );

        VisitDB.addVisit(v);*/
    }


    private static void __init_meds__() throws ClassNotFoundException {
        for (int i = 1; i <= 5; i++) {
            Medication m = new Medication(
                "med#" + i,
                    "vaccine",
                    "500mg",
                    "heart",
                    "2022-01-01 2:55:0" + i
            );

            MedicationDB.addMedication(m);

            Medication m2 = new Medication(
                    "med#" + (i+10),
                    "vaccine",
                    "500mg",
                    "general",
                    "2022-01-01 2:55:" + i
            );

            MedicationDB.addMedication(m2);

            Medication m3 = new Medication(
                    "med#" + (i+20),
                    "vaccine",
                    "500mg",
                    "neurological",
                    "2022-01-01 2:55:" + i
            );

            MedicationDB.addMedication(m3);
        }
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
        symptoms.add("numbness");

        Disease d5 = new Disease(
                "stroke",
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


            List<String> symptoms = Arrays.asList(new String[] {"heart pain"});
            List<String> diseases = Arrays.asList(new String[] {"cancer"});
            Visit v = new Visit(
                    p.getPatient_id(),
                    "2021-1-10",
                    "",
                    symptoms,
                    diseases,
                    null,
                    null,
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
                "date DATE, cure varchar(40), doctor_id varchar(50), nurse_id varchar(50), employee_id varchar(50), " +
                "state varchar(10)," +
                "PRIMARY KEY(patient_id, date));"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS visit_diseases (" +
                "date DATE, " +
                "patient_id varchar(50), diseases varchar(50)," +
                "PRIMARY KEY(patient_id, date,diseases)" +
                ");"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS visit_symptoms (" +
                "patient_id varchar(50), " +
                "date DATE, symptoms varchar(50)," +
                "PRIMARY KEY(patient_id, date,symptoms)" +
                ");"));

        stmt.executeUpdate(createTable.toString());
        //---------------------------------------------------------//
        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS shift (" +
                "date DATE, doctor_id varchar(50), nurse_id varchar(50)," +
                "type varchar(15), department varchar(40), employee_id varchar(50)," +
                "PRIMARY KEY(date)" +
                ");"));

        stmt.executeUpdate(createTable.toString());
        //---------------------------------------------------------//


        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS shift (" +
                "date DATE, doctor_id varchar(50), nurse_id varchar(50)," +
                "type varchar(15), department varchar(40), employee_id varchar(50)," +
                "PRIMARY KEY(date)" +
                ");"));

        stmt.executeUpdate(createTable.toString());

        //---------------------------------------------------------//

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS medication (" +
                "med_id varchar(50), name varchar(50), type varchar(15), dosage varchar(15)," +
                "use_for varchar(20), exp_date DATE," +
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
                "patient_id varchar(50), exam_id varchar(50), date DATE, symptoms varchar(50)," +
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

        createTable.append(("CREATE TABLE IF NOT EXISTS prescribe (" +
                "exam_id varchar(50), med_id varchar(50),date DATE," +
                "PRIMARY KEY(exam_id)" +
                ");"));

        stmt.executeUpdate(createTable.toString());

        createTable.setLength(0);

        createTable.append(("CREATE TABLE IF NOT EXISTS prescribe (" +
                "exam_id varchar(50), diagnose_id varchar(50)," +
                "PRIMARY KEY(exam_id)" +
                ");"));

        stmt.executeUpdate(createTable.toString());

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
}
