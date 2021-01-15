/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.csd.uoc.cs360.winter2020.project.Servlet;

import com.google.gson.Gson;
import gr.csd.uoc.cs360.winter2020.project.CS360DB.VisitDB;
import gr.csd.uoc.cs360.winter2020.project.ontologies.staff.Patient.Visit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
@WebServlet(name = "VisitServlet", urlPatterns = {"/VisitServlet"})
public class VisitServlet extends HttpServlet {



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
        System.out.println("#VISIT: IN DO POST");

        // !TODO
        // Assign visit to a certain doctor
        BufferedReader body = request.getReader();
        String line;
        HashMap<String, String> h = new HashMap<>();
        List<String> symptoms = new ArrayList<>();
        List<String> diseases = new ArrayList<>();

        while((line = body.readLine())!= null) {
            StringTokenizer tk = new StringTokenizer(line,"=");
            String field = tk.nextToken();
            String value = tk.nextToken();


            if(field.equals("symptoms")) {
                StringTokenizer t = new StringTokenizer(value, ",");
                while(t.hasMoreElements()) {
                    symptoms.add(t.nextToken());
                }
            } else {
                h.put(field, value);
            }

        }

        System.out.println("#VISITDB: " + symptoms.toString());

        // !TODO
        // Create visit with parameters
        Visit v = new Visit(
            h.get("patient_id"),
                h.get("date"),
                "",
                symptoms,
                diseases,
                "",
                "",
                "",
                ""

        );

        //VisitDB.addVisit(v);

        response.setStatus(201);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        HashMap<String, Object> json = new HashMap<>();
        json.put("visit","Visit added successfully");
        out.println(new Gson().toJson(json));

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HashMap<String, String> params = new HashMap<>();
            String line;
            BufferedReader body = request.getReader();

            while((line = body.readLine()) != null) {
                StringTokenizer tk = new StringTokenizer(line,"=");
                params.put(tk.nextToken(), tk.nextToken());
            }

            Visit v = VisitDB.getVisit(params.get("patient_id"), params.get("date"));
            if(v != null) {
                v.setCure(params.get("cure"));
                v.setState(params.get("state"));

                VisitDB.updateVisit(v);
            } else {
                System.out.println("#VISIT: VISIT NOT FOUND IN DB");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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
