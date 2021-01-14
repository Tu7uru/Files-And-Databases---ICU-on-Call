/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.Servlet;

import com.google.gson.Gson;
import gr.csd.uoc.cs360.winter2020.project.CS360DB.*;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Doctor.Doctor;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Employee.Employee;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Nurse.Nurse;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient.Patient;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient.Visit;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tolis
 */
@WebServlet(name = "Finder", urlPatterns = {"/Finder"})
public class Finder extends HttpServlet {


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
        System.out.println("#FINDER: IN DO GET");
        String username = request.getParameter("username");
        String type = request.getParameter("type");

        handleRequest(username,type, response);
    }

    private void handleRequest(String username, String type, HttpServletResponse response) {
        try {

            if (type.equals("doctor")) {
                System.out.println("#FINDER: "+username);
                Doctor d = DoctorDB.getDoctorByUsername(username);
                if(d == null) {
                    sendError(response);
                } else {
                    sendSuccess(response,d);
                }
            } else if (type.equals("nurse")) {
                Nurse n = NurseDB.getNurseByUsername(username);
                if(n == null) {
                    sendError(response);
                } else {
                    sendSuccess(response,n);
                }
            } else if (type.equals("patient")) {
                System.out.println("#FINDER: USER IS A PATIENT");
                Patient p = PatientDB.getPatientbyUsername(username);
                if (p == null) {
                    sendError(response);
                } else {
                    sendPatient(response, p);
                }
            } else if(type.equals("employee")){
                Employee e = EmployeeDB.getEmployeebyUsername(username);
                if(e == null) {
                    sendError(response);
                } else {
                    sendSuccess(response,e);
                }
            } else if(type.equals("visit")) {
                Patient p = PatientDB.getPatientbyUsername(username);
                System.out.println("#FINDER: USER REQUESTS A VISIT.");
                if (p == null) {
                    sendError(response);
                } else {
                    sendSuccess(response, p);
                }
            }
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("class not found");
            e.printStackTrace();
        }
    }

    private void sendPatient(HttpServletResponse response, Patient p) throws IOException {
        PrintWriter out = response.getWriter();
        HashMap<String, Object> h = new HashMap<>();
        response.setStatus(200);
        h.put("user", p);
        h.put("responseText", "User found");
        response.setContentType("application/json");
        String json = new Gson().toJson(h);

        out.println(json);
        out.flush();
        out.close();
    }


    private void sendSuccess(HttpServletResponse response, Object p) throws IOException, ClassNotFoundException {
        PrintWriter out = response.getWriter();
        HashMap<String, Object> h = new HashMap<>();


        response.setCharacterEncoding("UTF-8");

        if(p instanceof Patient) {
            StringBuilder html = new StringBuilder();
            List<Visit> visits = VisitDB.getVisits(((Patient) p).getPatient_id());
            System.out.println(visits);
            html.append("<div class='visit'>" +"\n<br><br><table>\n")
                    .append("<tr>\n" +
                            "    <th>ID</th>\n" +
                            "    <th>DATE</th>\n" +
                            "    <th>CURE</th>\n" +
                            "    <th>STATE</th>\n" +
                            "    <th></th>\n" +
                            "    <th></th>\n" +
                            "    <th></th>\n" +
                            "  </tr>\n");
            for (Visit v : visits) {

                html.append("<tr>\n<td>" + v.getPatientID() + "</td>\n")
                        .append("\n<td>" + v.getDate() + "</td>\n")
                        .append("<td>" + v.getCure() + "</td>\n")
                        .append("<td>" + v.getState() + "</td>\n")
                        .append("<td><button type='button' id='prescribe' name='button'><i class='fas fa-lock'></i>Prescribe</button><br><br></td>\n")
                        .append("<td><button type='button' id='assign-exam' name='button'><i class='fas fa-lock'></i>Assign Exam</button><br><br></td>\n")
                        .append("<td><button type='button' id='make-exam' name='button'><i class='fas fa-lock-open'></i>Make Exam</button><br><br></td>\n</tr>\n");
            }
            html.append("</table><br><br><br>")
                    .append("<table>\n<tr>\n<th>DATE</th><th>SYMPTOMS</th></tr>");
            for (Visit v : visits) {
                System.out.println(v);
                for (String s : VisitDB.getVisitSymptoms(v)) {
                    html.append("<tr><td>" + v.getDate() + "</td><td>" + s + "</td><tr>");
                }
            }
            html.append("</table><br><br><br>");

            html.append("</table><br><br><br>")
                    .append("<table>\n<tr>\n<th>DATE</th><th>DISEASES</th></tr>");
            for (Visit v : visits) {
                for (String s : VisitDB.getDiseasesHistory(v)) {
                    html.append("<tr><td>" + v.getDate() + "</td><td>" + s + "</td><tr>");
                }
            }

            html.append("</table><br><br><br></div><br><br><br><br>");

            response.setStatus(200);
            response.setContentType("text/html");
            out.println(html.toString());
        } else {
            h.put("user", p);
            h.put("responseText", "User found");
            response.setContentType("application/json");
            String json = new Gson().toJson(h);

            response.setStatus(207);

            out.println(json);
        }

        out.flush();
        out.close();
    }

    private void sendError(HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();

        response.setStatus(404);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        out.println("USER NOT FOUND");
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
