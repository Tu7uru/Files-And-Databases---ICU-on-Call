/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.Servlet;

import gr.csd.uoc.cs360.winter2020.project.CS360DB.PatientDB;
import gr.csd.uoc.cs360.winter2020.project.CS360DB.VisitDB;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient.Patient;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient.Visit;

import java.io.IOException;
import java.io.PrintWriter;
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
        System.out.println("FINDER: IN DO GET");

        try {
            String username = request.getParameter("username");
            System.out.println("username:" + username);
            Patient p = PatientDB.getPatientbyUsername(username);
            System.out.println("proceeding");
            if(p == null) {
                sendError(response);
            } else {
                sendSuccess(response,p);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
            e.printStackTrace();
        }
    }

    private void sendSuccess(HttpServletResponse response, Patient p) throws IOException, ClassNotFoundException {
        PrintWriter out = response.getWriter();
        List<Visit> visits = VisitDB.getVisits(p.getPatient_id());


        response.setStatus(200);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");

        StringBuilder html = new StringBuilder();

        html.append("<div class='visit'><table>\n")
            .append("<tr>\n" +
                "    <th>DATE</th>\n" +
                "    <th>CURE</th>\n" +
                "    <th>STATE</th>\n" +
                "  </tr>\n");
        for(Visit v : visits) {
            html.append("<tr>\n<td>" + v.getDate() + "</td>\n")
                    .append("<td>" + v.getCure() + "</td>\n")
                    .append("<td>" + v.getState() + "</td>\n</tr>\n");
        }
        html.append("</table><br><br><br>")
                .append("<table>\n<tr>\n<th>SYMPTOMS</th></tr>");
        for(Visit v: visits) {
            System.out.println(v.toString());
            for(String s : v.getSymptoms()) {
                html.append("<tr><td>" + s + "</td><tr>");
            }
            break;
        }
        html.append("</table><br><br><br></div>");
        out.println(html.toString());
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
