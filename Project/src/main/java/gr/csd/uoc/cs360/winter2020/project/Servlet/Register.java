/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.Servlet;

import com.google.gson.Gson;
import gr.csd.uoc.cs360.winter2020.project.CS360DB.DoctorDB;
import gr.csd.uoc.cs360.winter2020.project.CS360DB.EmployeeDB;
import gr.csd.uoc.cs360.winter2020.project.CS360DB.NurseDB;
import gr.csd.uoc.cs360.winter2020.project.CS360DB.PatientDB;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Doctor.Doctor;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Employee.Administrative;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Employee.AssistantManager;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Employee.Employee;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Nurse.Nurse;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient.Patient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tolis
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            System.out.println("#REGISTER: IN DO POST");
            BufferedReader body = request.getReader();
            String line;
            Object n = null;
            HashMap<String, String> h = new HashMap<>();

            while((line = body.readLine()) != null) {
                StringTokenizer tk = new StringTokenizer(line,"=");
                String field = tk.nextToken();
                String value = tk.nextToken();

               h.put(field,value);
            }

            switch(h.get("type")) {
                case "pat":
                        registerPatient(h, response);

                        break;
                        case "empl":
                            registerEmployee(h, response);
                            break;
                        case "doc":
                            registerDoctor(h, response);
                            break;
                        case "nurse":
                            registerNurse(h, response);
                            break;
                        default:
                            sendError(response);
                            break;
                    }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void registerNurse(HashMap<String, String> h, HttpServletResponse response) throws ClassNotFoundException, IOException {
        Nurse n = new Nurse(
                h.get("username"),
                h.get("password"),
                h.get("email"),
                h.get("firstName"),
                h.get("lastName"),
                h.get("phone"),
                h.get("address"),
                "",
                Nurse.fromString(h.get("spec"))
        );


        NurseDB.addNurse(n);
        response.setStatus(201);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        HashMap<String, Object> jsonHash = new HashMap<>();
        jsonHash.put("user", n);
        jsonHash.put("status", 201);
        jsonHash.put("responseText", "#REGISTER: SUCCESSFULLY ADDED USER INTO NURSES");
        String json = new Gson().toJson(jsonHash);
        out.println(json);

        System.out.println("#REGISTER: USER SUCCESSFULLY ADDED INTO DB");
    }


    private void registerDoctor(HashMap<String, String> h, HttpServletResponse response) throws ClassNotFoundException, IOException {
        Doctor d = new Doctor(
                h.get("username"),
                h.get("password"),
                h.get("email"),
                h.get("firstName"),
                h.get("lastName"),
                h.get("phone"),
                h.get("address"),
                "",
                Doctor.fromString(h.get("spec"))

        );

        DoctorDB.addDoctor(d);
        response.setStatus(201);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        HashMap<String, Object> jsonHash = new HashMap<>();
        jsonHash.put("user", d);
        jsonHash.put("status", 201);
        jsonHash.put("responseText", "#REGISTER: SUCCESSFULLY ADDED USER INTO DOCTORS");
        String json = new Gson().toJson(jsonHash);
        out.println(json);

        System.out.println("#REGISTER: USER SUCCESSFULLY ADDED INTO DB");
    }

    private void registerEmployee(HashMap<String, String> h, HttpServletResponse response) throws ClassNotFoundException, IOException {


        if(h.get("spec").equals("simple")) {
            Employee e = new Employee(
                    h.get("firstName"),
                    h.get("lastName"),
                    h.get("phone"),
                    h.get("address"),
                    h.get("department"),
                    h.get("username"),
                    h.get("password"),
                    h.get("email")

            );

            EmployeeDB.addEmployee(e);
            response.setStatus(201);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();

            HashMap<String, Object> jsonHash = new HashMap<>();
            jsonHash.put("user", e);
            jsonHash.put("status", 201);
            jsonHash.put("responseText", "#REGISTER: SUCCESSFULLY ADDED USER INTO EMPLOYEES");
            String json = new Gson().toJson(jsonHash);
            out.println(json);

        } else if(h.get("spec").equals("assistant")) {
            AssistantManager e = new AssistantManager(
                    h.get("firstName"),
                    h.get("lastName"),
                    h.get("phone"),
                    h.get("address"),
                    h.get("department"),
                    h.get("username"),
                    h.get("password"),
                    h.get("email"),
                    h.get("degree")
            );

            EmployeeDB.addAssistantManager(e);
            response.setStatus(201);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();

            HashMap<String, Object> jsonHash = new HashMap<>();
            jsonHash.put("user", e);
            jsonHash.put("status", 201);
            jsonHash.put("responseText", "#REGISTER: SUCCESSFULLY ADDED USER INTO ASSISTANTS");
            String json = new Gson().toJson(jsonHash);
            out.println(json);

        } else {
            Administrative e = new Administrative(
                    h.get("firstName"),
                    h.get("lastName"),
                    h.get("phone"),
                    h.get("address"),
                    h.get("department"),
                    h.get("username"),
                    h.get("password"),
                    h.get("email"),
                    h.get("degree")
            );

            EmployeeDB.addAdmin(e);
            response.setStatus(201);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            PrintWriter out = response.getWriter();

            HashMap<String, Object> jsonHash = new HashMap<>();
            jsonHash.put("user", e);
            jsonHash.put("status", 201);
            jsonHash.put("responseText", "#REGISTER: SUCCESSFULLY ADDED USER INTO ADMINS");
            String json = new Gson().toJson(jsonHash);
            out.println(json);

        }

        System.out.println("#REGISTER: USER SUCCESSFULLY ADDED INTO DB");
    }

    private void registerPatient(HashMap<String, String> h, HttpServletResponse response) throws ClassNotFoundException, IOException {
        Patient p = new Patient(
                h.get("firstName"),
                h.get("lastName"),
                h.get("phone"),
                h.get("address"),
                h.get("insurance"),
                h.get("amka"),
                h.get("username"),
                h.get("password"),
                h.get("email")
        );

        PatientDB.addPatient(p);

        response.setStatus(201);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        HashMap<String, Object> jsonHash = new HashMap<>();
        jsonHash.put("user", p);
        jsonHash.put("status", 201);
        jsonHash.put("responseText", "#REGISTER: SUCCESSFULLY ADDED USER INTO PATIENTS");
        String json = new Gson().toJson(jsonHash);
        out.println(json);
        System.out.println("#REGISTER: USER SUCCESSFULLY ADDED INTO DB");
    }

    private void sendError(HttpServletResponse response) throws IOException {
        response.setStatus(400);
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        out.println("Error: Cannot register user.");
        out.flush();
        out.close();

    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
