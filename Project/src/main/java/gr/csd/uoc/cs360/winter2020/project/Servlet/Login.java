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
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Employee.Employee;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Nurse.Nurse;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient.Patient;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tolis
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {


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
        try {
            System.out.println("IN DO GET");
            String type = request.getParameter("type");

            switch (type) {
                case "employee":
                    searchEmployee(request, response);
                    break;
                case "doctor":
                    searchDoctor(request, response);
                    break;
                case "nurse":
                    searchNurse(request, response);
                    break;
                case "patient":
                    searchPatient(request, response);
                    break;
                default:
                    sendError(response);
            }
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void searchPatient(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException {
        Patient p = PatientDB.getPatientbyUsername(request.getParameter("username"));
        System.out.println(p);
        PrintWriter out = response.getWriter();
        if(p == null ) {
            sendError(response);
        } else {
            sendSuccess(p,response,"patient");
        }
    }

    private void searchNurse(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException {
        Nurse p = NurseDB.getNurseByUsername(request.getParameter("username"));
        PrintWriter out = response.getWriter();
        if(p == null ) {
            sendError(response);
        } else {
            sendSuccess(p,response,"nurse");
        }
    }

    private void searchDoctor(HttpServletRequest request, HttpServletResponse response) throws IOException, ClassNotFoundException {
        System.out.println(request.getParameter("username"));
        Doctor p = DoctorDB.getDoctorByUsername(request.getParameter("username"));
        System.out.println(p);
        PrintWriter out = response.getWriter();
        if(p == null ) {
            sendError(response);
        } else {
            sendSuccess(p,response,"doctor");
        }
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, IOException {
        Employee p = EmployeeDB.getEmployeebyUsername(request.getParameter("username"));

        if(p == null ) {
            sendError(response);

        } else {
            sendSuccess(p,response,"employee");

        }
    }

    private void sendSuccess(Doctor p, HttpServletResponse response,String type) throws IOException {
        PrintWriter out = response.getWriter();
        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        HashMap<String, Object> h = new HashMap<>();
        h.put("status", 200);
        h.put("responseText", "User found");
        h.put("user",p);
        h.put("type", type);

        System.out.println("#LOGIN: " + p);

        String json = new Gson().toJson(h);
        out.println(json);
        out.flush();
        out.close();
    }

    private void sendSuccess(Employee p, HttpServletResponse response,String type) throws IOException {
        PrintWriter out = response.getWriter();
        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        HashMap<String, Object> h = new HashMap<>();
        h.put("status", 200);
        h.put("responseText", "User found");
        h.put("user",p);
        h.put("type", type);

        String json = new Gson().toJson(h);
        out.println(json);
        out.flush();
        out.close();
    }

    private void sendSuccess(Patient p, HttpServletResponse response,String type) throws IOException {
        PrintWriter out = response.getWriter();
        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        HashMap<String, Object> h = new HashMap<>();
        h.put("status", 200);
        h.put("responseText", "User found");
        h.put("user",p);
        h.put("type", type);

        String json = new Gson().toJson(h);
        out.println(json);
        out.flush();
        out.close();
    }

    private void sendSuccess(Nurse p, HttpServletResponse response,String type) throws IOException {
        PrintWriter out = response.getWriter();
        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        HashMap<String, Object> h = new HashMap<>();
        h.put("status", 200);
        h.put("responseText", "User found");
        h.put("user",p);
        h.put("type", type);

        String json = new Gson().toJson(h);
        out.println(json);
        out.flush();
        out.close();
    }

    private void sendError(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        response.setStatus(404);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        HashMap<String, Object> h = new HashMap<>();
        h.put("status", 404);
        h.put("responseText", "User not found");

        String json = new Gson().toJson(h);
        out.println(json);
        out.flush();
        out.close();
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
